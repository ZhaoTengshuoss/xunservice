package com.example.xuncode;





import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.io.StringWriter;

import xn.model.x_Net;





/** 
 * 采集网络带宽使用率 
 */  

public class NetUsage {
	private static NetUsage INSTANCE = new NetUsage();  
	private static x_Net net=new x_Net();
   // private final static float TotalBandwidth = 1000;   //网口带宽,Mbps  这里需要替换为自己的带宽

    public NetUsage(){  

    }  

    public static NetUsage getInstance(){  
        return INSTANCE;  
    }  

    /** 
     * @Purpose:采集网络带宽使用率 
     * @param args 
     * @return float,网络带宽使用率,小于1 
     */  
    public static float get() {  
      
        float netUsage = 0.0f;  
        Process pro1,pro2;  
        Runtime r = Runtime.getRuntime();  
        try {  
            String command = "cat /proc/net/dev";  
            //第一次采集流量数据  
            long startTime = System.currentTimeMillis();  
            pro1 = r.exec(command);  
            BufferedReader in1 = new BufferedReader(new InputStreamReader(pro1.getInputStream()));  
            String line = null;  
            long inSize1 = 0, outSize1 = 0;  
            while((line=in1.readLine()) != null){     
                line = line.trim();  
                if(line.startsWith("eth0")){  
                    String[] temp = line.split("\\s+");
                    //这里可能因为不同操作系统 展示的结果不同，导致下标不同，
                    //|bytes    packets errs drop fifo frame compressed multicast
                    //自己对照 cat /proc/net/dev 该指令执行后展示出的结构 找到Receive bytes 是数组里第几个元素，替换下标即可
                    inSize1 = Long.parseLong(temp[1]); //Receive bytes,单位为Byte  
                    outSize1 = Long.parseLong(temp[9]);             //Transmit bytes,单位为Byte  
                    break;  
                }                 
            }     
            in1.close();  
            pro1.destroy();  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                StringWriter sw = new StringWriter();  
                e.printStackTrace(new PrintWriter(sw));  
                System.out.println("NetUsage休眠时发生InterruptedException. " + e.getMessage());  
            }  
            //第二次采集流量数据  
            long endTime = System.currentTimeMillis();  
            pro2 = r.exec(command);  
            BufferedReader in2 = new BufferedReader(new InputStreamReader(pro2.getInputStream()));  
            long inSize2 = 0 ,outSize2 = 0;  
            while((line=in2.readLine()) != null){     
                line = line.trim();  
                if(line.startsWith("eth0")){
                    String[] temp = line.split("\\s+");
                    //这里数组下标也需要修改 
                    inSize2 = Long.parseLong(temp[1]);  
                    outSize2 = Long.parseLong(temp[9]);  
                    break;  
                }                 
            }  
            if(inSize1 != 0 && outSize1 !=0 && inSize2 != 0 && outSize2 !=0){  
                float interval = (float)(endTime - startTime)/1000;  
               
                //网口传输速度,单位为bps  
                float curRate = (float)(inSize2 - inSize1 + outSize2 - outSize1)*8/(1000*interval);  
                //net send 
                float sendRate=(float)(inSize2 - inSize1)*8/(1000*interval);
                //net receive
                float receiveRate=(float)(outSize2 - outSize1)*8/(1000*interval);
                net.setSendrate(sendRate);
                net.setReceiverate(receiveRate);
                if(curRate>100)
                {
                	curRate=100;
                }
               if(curRate<0)
                {
                	curRate=1;
                }
                net.setSpeed(curRate);


            }                 
            in2.close();  
            pro2.destroy();  
        } catch (IOException e) {  
            StringWriter sw = new StringWriter();  
            e.printStackTrace(new PrintWriter(sw));  
        }     
        return netUsage;  
    }
    public static x_Net return_net()
    {
    	get();
    	ipv4();
    	ipv6();
    	DNS();
    	return net;
    }
    //ipv4
    public static String ipv4()
    {
    	String ipv4 = null;
    	Process pro1;  
        Runtime r = Runtime.getRuntime();  
        
        try {  
            String command = "ifconfig";  
            pro1 = r.exec(command);  
            BufferedReader in1 = new BufferedReader(new InputStreamReader(pro1.getInputStream()));  
            String line = null;  
            while((line=in1.readLine()) != null){     
                line = line.trim();  
                if(line.startsWith("inet")){  
                	String[] temp = line.split("\\s+");
                    ipv4=temp[1].split(":")[1];
                    net.setIPV4(ipv4);
                    break;  
                }            
            }
            in1.close();  
            pro1.destroy(); 
        } catch (IOException e) {  
            StringWriter sw = new StringWriter();  
            e.printStackTrace(new PrintWriter(sw));  
        } 
             
    	return ipv4;
    }
    public static String ipv6()
    {
    	String ipv6 = null;
    	Process pro1;  
        Runtime r = Runtime.getRuntime();  
       
        try {  
            String command = "ifconfig";  
            pro1 = r.exec(command);  
            BufferedReader in1 = new BufferedReader(new InputStreamReader(pro1.getInputStream()));  
            String line = null;  
            while((line=in1.readLine()) != null){     
                line = line.trim();  
                if(line.startsWith("inet6")){  
                	String[] temp = line.split("\\s+");
                    ipv6=temp[2];
                    net.setIPV6(ipv6);
                    break;  
                }           
               
            }
            in1.close();  
            pro1.destroy(); 
        } catch (IOException e) {  
            StringWriter sw = new StringWriter();  
            e.printStackTrace(new PrintWriter(sw));  
        } 
             
    	return ipv6;
    }
    //DNS
	
    public static String DNS()
    {
    	String dns= null;
    	Process pro1;  
        Runtime r = Runtime.getRuntime();  
       
        try {  
            String command = "cat /etc/resolv.conf";  
            pro1 = r.exec(command);  
            BufferedReader in1 = new BufferedReader(new InputStreamReader(pro1.getInputStream()));  
            String line = null;  
            while((line=in1.readLine()) != null){     
                line = line.trim();  
                if(line.startsWith("nameserver")){  
                	
                	String[] temp = line.split("\\s+");
                    dns=temp[1];
                    net.setDNS(dns);
                    break;  
                }           
               
            }
            in1.close();  
            pro1.destroy(); 
        } catch (IOException e) {  
            StringWriter sw = new StringWriter();  
            e.printStackTrace(new PrintWriter(sw));  
        } 
             
    	return dns;
    }
    
    
    /** 
     * @param args 
     * @throws InterruptedException  
     */  
    public static void main(String[] args) throws InterruptedException {  
    	return_net();
	
    }  

}
