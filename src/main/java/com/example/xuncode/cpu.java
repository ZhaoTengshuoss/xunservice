package com.example.xuncode;





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Properties;

import xn.model.Cpu_model;





public class cpu {
	
	 static Cpu_model cpu_model=new Cpu_model();
	 public Cpu_model recpu() throws Exception {
		 init_cpuInfo();
		 getCpuuserage();
		 cpu_model.setThreads(getCpuPro("ps -eLf"));//线程数
		 cpu_model.setLosfnum(getCpuPro("lsof"));//句柄数
			return cpu_model;
		}
	 
	 public int getCpuPro(String command) throws Exception {
		java.lang.Process process = null;
//		int sum=1;
		int processor=1;
		int sum=0;
		int losfnum=0;
		boolean flag=false;
		boolean flag2=false;
		Properties prop = System.getProperties();
		// 获取操作系统名称
		String os = prop.getProperty("os.name");
		if (os != null && os.toLowerCase().indexOf("linux") > -1) {
			// 1.适应与linux

			BufferedReader reader = null;
			// 显示所有进程
			
			process = Runtime.getRuntime().exec(command);
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			
			
			while ((line = reader.readLine())!=null) {
				if(line.startsWith("processor")) {//进程数,cpu个数

				processor++;

				}
				if("ps -eLf".contentEquals(command))//线程数
				{
					sum++;
					flag=true;
				}
				if("lsof".contentEquals(command))//句柄数
				{
					losfnum++;
					flag2=true;
				}
				if(line.startsWith("Threads")) {//top -H

					String cpu1[]=line.split(":");
					String cpu_Info[]=cpu1[1].split(",");
					cpu_Info[0]=cpu_Info[0].replace(" ", "");
					cpu_Info[1]=cpu_Info[1].replace(" ", "");
					cpu_Info[2]=cpu_Info[2].replace(" ", "");
					cpu_Info[3]=cpu_Info[3].replace(" ", "");
					cpu_Info[4]=cpu_Info[4].replace(" ", "");
					processor=Integer.parseInt(cpu_Info[0].substring(0, cpu_Info[0].length()-5));

					}
				
			}
		}
		if(flag)
		{
			processor=sum;
		}
		if(flag2)
		{
			processor=losfnum;
		}
		return processor;
	}
	 public Cpu_model getCpuPro_init(String command) throws Exception {
			java.lang.Process process = null;
//			int sum=1;
			int processor=0;
			Cpu_model cpu =new Cpu_model();
			Properties prop = System.getProperties();
			// 获取操作系统名称
			String os = prop.getProperty("os.name");
			if (os != null && os.toLowerCase().indexOf("linux") > -1) {
				// 1.适应与linux

				BufferedReader reader = null;
				// 显示所有进程
				process = Runtime.getRuntime().exec(command);
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line = null;
				while ((line = reader.readLine())!=null) {
					if(line.startsWith("model name"))//型号名称
					{
						String cpu1[]=line.split(":");
						String cpu_Info[]=cpu1[1].split(",");
						cpu.setModel_name(cpu_Info[0]);
					
	
					}
					
					if(line.startsWith("processor")) {//进程数,cpu个数
					processor++;
					}
					
					
				}
			}
			cpu.setProcessor(processor);
			return cpu;
		}
	public static Cpu_model getl_cpu(String command) throws Exception{
		
		Cpu_model cpu = new Cpu_model();
		java.lang.Process process = null;
		int sockets=1;
		String l1d_cache="";
		String l1i_cache="";
		String l2_cache="";
		String l3_cache="";
		Properties prop = System.getProperties();
		// 获取操作系统名称
		String os = prop.getProperty("os.name");
		if (os != null && os.toLowerCase().indexOf("linux") > -1) {
			// 1.适应与linux

			BufferedReader reader = null;
			// 显示所有进程
			
			process = Runtime.getRuntime().exec(command);
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String line = null;
			
			while ((line = reader.readLine())!=null) {
				if(line.startsWith("Socket("))//物理cpu的个数
				{
					String cpu1[]=line.split(":");
					cpu1[1]=cpu1[1].replace(" ", "");
					sockets=Integer.parseInt(cpu1[1]);
					cpu.setSockets(sockets);

				}
				if(line.startsWith("L1d cache"))
				{
					String cpu1[]=line.split(":");
					cpu1[1]=cpu1[1].replace(" ", "");
					l1d_cache=cpu1[1];
					cpu.setL1d_cache(l1d_cache);

				}
				if(line.startsWith("L1i cache"))
				{
					String cpu1[]=line.split(":");
					cpu1[1]=cpu1[1].replace(" ", "");
					l1i_cache=cpu1[1];
					cpu.setL1i_cache(l1i_cache);

				}
				if(line.startsWith("L2 cache"))
				{
					String cpu1[]=line.split(":");
					cpu1[1]=cpu1[1].replace(" ", "");
					l2_cache=cpu1[1];
					cpu.setL2_cache(l2_cache);

				}
				if(line.startsWith("L3 cache"))
				{
					String cpu1[]=line.split(":");
					cpu1[1]=cpu1[1].replace(" ", "");
					l3_cache=cpu1[1];
					cpu.setL3_cache(l3_cache);

				}
				if(line.startsWith("CPU MHz:"))//CPU的实际使用主频
				{
					String cpu1[]=line.split(":");
					String cpu_Info[]=cpu1[1].split(",");
					cpu_Info[0]=cpu_Info[0].replace(" ", "");

					double cpu_Mhz=0;
					BigDecimal b = new BigDecimal(Double.parseDouble(cpu_Info[0])/1000);
					cpu_Mhz = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					cpu.setCpu_MHz(cpu_Mhz);;
					
				}
				

			}
		}

		
		return cpu;
	}

	public void init_cpuInfo() throws Exception
	{
		Cpu_model cpu =new Cpu_model();
		int Sockets_num=0;
		cpu=getl_cpu("lscpu");
		Sockets_num=cpu.getSockets();
		cpu_model=cpu;
		cpu=getCpuPro_init("cat /proc/cpuinfo");
		cpu_model.setModel_name(cpu.getModel_name());;//以前:getCpuPro_init("cat /proc/cpuinfo |grep processor |uniq")
		cpu_model.setProcessor(cpu.getProcessor());
	}
	
	
	
	
public static int getCpuuserage() throws Exception {
		
		
		java.lang.Process process = null;
		
		int userage=0;
		boolean flag=true;
			Properties prop = System.getProperties();
			// 获取操作系统名称
			int sum=0;
			String os = prop.getProperty("os.name");
			if (os != null && os.toLowerCase().indexOf("linux") > -1) {
				// 1.适应与linux

				BufferedReader reader = null;
				// 显示所有进程
				//"名称","PID","优先级","状态","用户名","cpu","内存","磁盘","网络","描述"
				process = Runtime.getRuntime().exec("top -b");//top -b -n 1
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

				String line = null;
				
				while (flag) {
			
			       line = reader.readLine();
					if(line!=null) {
					if(line.startsWith("top"))
					{
						String cpu1[]=line.split("-");
						String cpu_Info[]=cpu1[1].split(",");
						
						cpu_Info[0]=cpu_Info[0].replace(" ", "");
						cpu_model.setCPUtime(cpu_Info[0].substring(10, cpu_Info[0].length()));
					
					}
					if(line.startsWith("Tasks"))
					{
						String cpu1[]=line.split(":");
						String cpu_Info[]=cpu1[1].split(",");
						cpu_Info[0]=cpu_Info[0].replace(" ", "");
						cpu_Info[1]=cpu_Info[1].replace(" ", "");
						cpu_Info[2]=cpu_Info[2].replace(" ", "");
						cpu_Info[3]=cpu_Info[3].replace(" ", "");
						cpu_Info[4]=cpu_Info[4].replace(" ", "");
						cpu_model.setAllprocess(Integer.parseInt(cpu_Info[0].substring(0, cpu_Info[0].length()-5)));
					}
					if(line.startsWith("%Cpu(s)"))
					{
						String cpu1[]=line.split(":");
						String cpu_Info[]=cpu1[1].split(",");
						cpu_Info[3]=cpu_Info[3].replace(" ", "");
						double cpuUsage=Double.parseDouble(cpu_Info[3].substring(0, cpu_Info[3].length()-2));
						cpuUsage=100-cpuUsage;
						BigDecimal b = new BigDecimal(cpuUsage);
						cpuUsage = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
						userage=(int)cpuUsage;
						cpu_model.setCpuUsage(cpuUsage);
						
						sum++;
					}
					if(line.startsWith("KiB Mem"))
					{
						String cpu1[]=line.split(":");
						String cpu_Info[]=cpu1[1].split(",");
						
						cpu_Info[0]=cpu_Info[0].replace(" ", "");
						cpu_Info[1]=cpu_Info[1].replace(" ", "");
						int total=Integer.parseInt(cpu_Info[0].substring(0, cpu_Info[0].length()-5));
						int use=Integer.parseInt(cpu_Info[1].substring(0, cpu_Info[1].length()-4));
						BigDecimal b1 = new BigDecimal((double)use/total);
						double KiBUsage = b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
						userage=(int)(KiBUsage*100);
						cpu_model.setCpuUsage(KiBUsage*100);
					}
					}
					if(sum==1)
					{
						flag=false;	
					}
				}	
				
			}
			return userage;
	}
	

	public static void main(String[] args) throws Exception {
	}
    
}