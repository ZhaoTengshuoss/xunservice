package com.example.xuncode;

import java.io.File;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Properties;


import com.example.xunservice.Check;

import xn.model.Cipan_model;


public class cipan { 
	static Cipan_model ci_pan=new Cipan_model();
	private static void runCmds2(String[] cmds) throws IOException, InterruptedException   
	{      
		
		java.lang.Process process = Runtime.getRuntime().exec(cmds);      
		InputStreamReader ir = new InputStreamReader(process.getInputStream());      
		LineNumberReader input = new LineNumberReader(ir);      
		String line;  
		int count=0;
		
		while((line = input.readLine()) != null)      
		{       
			count++;
			if(count==3) {
			String re[]=line.split("=");
     		re[1]=re[1].replace("sec", "秒").replaceFirst(" ", "");
			ci_pan.setSpeed(re[1]);
			break;
			}
		}
		
	}


	private static String runCmds(String[] cmds) throws IOException, InterruptedException   
	{    
		String runcmds_result="";
	
		java.lang.Process process = Runtime.getRuntime().exec(cmds);      
		InputStreamReader ir = new InputStreamReader(process.getInputStream());      
		LineNumberReader input = new LineNumberReader(ir);      
		String line;  
		while((line = input.readLine()) != null)      
		{         
			if(line.startsWith("Disk")) {
				
				
				String re[]=line.split(",");
				String cipan_size[]=re[0].split(":");
				runcmds_result=cipan_size[0].replace("Disk ", "").replace(":", "");
				ci_pan.setCipan_size(cipan_size[1].replace(" ", ""));
				ci_pan.setCipan_name(cipan_size[0].replace("Disk ", ""));
				break;
			}
			     
		}	
		return runcmds_result;
	}
	public static Cipan_model recipan() throws Exception {

		String password=Check.passwd;
		String sudocmd="echo "+password;
		if(!"".contentEquals(password))
		{
		getneicun("fdisk -l",sudocmd);
		}
		else
		{
			ci_pan.setCipan_name("");
			ci_pan.setCipan_size("0");
			ci_pan.setSpeed("0 MB/秒");
		}
		return ci_pan;
	}
	
	

	//判断文件是否存在
			public static boolean isFile() {
				try
				{
					File testFile=new File(Check.class.getResource("/static/file/").getPath()+"passwd.txt");
					if(testFile.exists())
					{
					return true;
					}
					else
					{
						return false;
					}
				}catch(Exception e)
				{
				return false;
				}
			}

	//public static String sudocmd="echo "+password;
	
	public static int getneicun(String command,String sudocmd) throws Exception {//磁盘大小
		
		int processor=0;
		
		Properties prop = System.getProperties();
		// 获取操作系统名称
		String os = prop.getProperty("os.name");

		if (os != null && os.toLowerCase().indexOf("linux") > -1) {
			// 1.适应与linux

			LineNumberReader reader = null;
			// 显示所有进程
			//sudocmd="echo "+DesUtil.decrypt(readFile());
			String cmds[] = {"/bin/bash", "-c", sudocmd +" | sudo -S "+ command};
			String road=  runCmds(cmds) ;
			
			String cmds2[] = {"/bin/bash", "-c", sudocmd +" | sudo -S  hdparm -t "+road};
			runCmds2(cmds2);
		}
		return processor;
	}
	
	public static void main(String[] args) throws Exception {		
		//cipan.getneicun("fdisk -m","");
	}
    
}