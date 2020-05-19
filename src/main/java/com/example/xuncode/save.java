package com.example.xuncode;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Properties;
import xn.model.Savemodel;
public class save {//neicun

	public Savemodel  getsave_Usage(String command) throws Exception {
		
		java.lang.Process process = null;
		double neicunall=0;
		double neicunuse=0;
		double all_nei_result=0;
		Properties prop = System.getProperties();
		// 获取操作系统名称
		String os = prop.getProperty("os.name");
		Savemodel s_model= new Savemodel();
		if (os != null && os.toLowerCase().indexOf("linux") > -1) {
			// 1.适应与linux

			BufferedReader reader = null;
			// 显示所有进程
			
			process = Runtime.getRuntime().exec(command);
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
		
			while ((line = reader.readLine())!=null) {
				/**
				 * 
				 * 
				 * free -h
             				total       used       free     shared    buffers     cached
				Mem:          2.1G       2.0G        94M        22M       2.2M       113M
				-/+ buffers/cache:       1.9G       210M
				Swap:         1.0G       671M       350M
				 * 
				 * 
				 * */

				if(line.startsWith("Mem:")&&command.contentEquals("free -m"))
				{
					String re[]=line.split("       ");
					
					neicunall=Double.parseDouble(re[1].replace(" ", ""));
					s_model.setNeicunall(Integer.parseInt(re[1].replace(" ", "")));
					s_model.setShared1(Double.parseDouble(re[4].replace(" ", "")));
					s_model.setBuffers1(Double.parseDouble(re[5].replace(" ", "")));
					s_model.setCached1(Double.parseDouble(re[6].replace(" ", "")));
			}
				if(line.startsWith("-/+ buffers/cache:")&&command.contentEquals("free -m"))
				{
				
					String re[]=line.split(":");
					String r2[]=re[1].trim().split("\\s+");
					neicunuse=Double.parseDouble(r2[0]);
					s_model.setNeicunuse(Double.parseDouble(r2[0]));
					
				}
				if(line.startsWith("Swap:")&&command.contentEquals("free -m"))
				{
				
					
					String re[]=line.split("       ");
					double swap_all=Double.parseDouble(re[1].replace(" ", ""));
					double swap_use=Double.parseDouble(re[2].replace(" ", ""));
					
					double swap_nei_result=0;
					s_model.setSwap_all(swap_all);
					s_model.setSwap_use(swap_use);
					s_model.setSwap_nei_result(swap_nei_result);
					BigDecimal b = new BigDecimal(swap_use/swap_all);
					swap_nei_result = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
						}
			}
		}
		s_model.setNeicunuse(neicunuse);
		s_model.setNeicunall(neicunall);
		BigDecimal b = new BigDecimal(neicunuse/neicunall);
		all_nei_result = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	    s_model.setNeicunuse(neicunuse);
		s_model.setNeicunall(neicunall);
		s_model.setAll_nei_result(all_nei_result*100);
		
		return s_model;
	}


	public static void main(String[] args) throws Exception {
	
		
	}
    
}
