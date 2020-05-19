package com.example.xunservice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.xuncode.Net;
import com.example.xuncode.NetStat;
import com.example.xuncode.NetUsage;
import com.example.xuncode.application;
import com.example.xuncode.cipan;
import com.example.xuncode.cpu;
import com.example.xuncode.process;
import com.example.xuncode.processModel;
import com.example.xuncode.processPropertiesApp;
import com.example.xuncode.save;
import com.example.xunservice.RunTask;

import xn.model.Cipan_model;
import xn.model.Cpu_model;
import xn.model.Savemodel;
import xn.model.x_Net;
@SpringBootApplication
public class XunserviceApplication1  {
	
	private static List<Integer> values_save;// 保存接受的数据容器
	private static List<Integer> values_cpu;// 保存接受的数据容器
	private static List<Integer> values_cipan;// 保存接受的数据容器
	private static List<Integer> values_net;// 保存接受的数据容器
	private static final int MAX_VALUE = 100;// 接受到的数据最大值
	private static final int MAX_COUNT_OF_VALUES = 50;// 最多保存数据的个数
	/**
	 * Launch the application.
	 */
	private  int FREAME_X = 249;
	private  int FREAME_Y = 50;
	private  int FREAME_WIDTH = 700;// 横
	private int FREAME_HEIGHT = 250;// 纵
	// 原点坐标
	private  int Origin_X = FREAME_X + 50;//100
	private  int Origin_Y = FREAME_Y + FREAME_HEIGHT - 30;//270
	// X,Y轴终点坐标
	private  int XAxis_X = FREAME_X + FREAME_WIDTH - 30;//720
	private  int XAxis_Y = Origin_Y;//270
	private  int YAxis_X = Origin_X;//100
	private  int YAxis_Y = FREAME_Y + 110;//80
	// X轴上的时间分度值（1分度=40像素）
	private  int TIME_INTERVAL = 30;
	// Y轴上值
	private  int PRESS_INTERVAL = 10;
	private  int FREAME_X_S = 243;
	private  int	 FREAME_Y_S = 50;
	private  int	 FREAME_WIDTH_S = 550;// 横
	private  int	 FREAME_HEIGHT_S = 250;// 纵
	// 原点坐标
	private  int	 Origin_X_S = FREAME_X_S + 50;//100
	private  int	 Origin_Y_S = FREAME_Y_S + FREAME_HEIGHT_S - 30;//270
	// X,Y轴终点坐标
	private  int	XAxis_X_S = FREAME_X_S + FREAME_WIDTH_S - 30;//720
	private  int	 XAxis_Y_S = Origin_Y_S;//270
	private  int	 YAxis_X_S = Origin_X_S;//100
	private  int	 YAxis_Y_S= FREAME_Y_S + 110;//80
	// X轴上的时间分度值（1分度=40像素）
	private  int	 TIME_INTERVAL_S = 30;
	// Y轴上值
	private  int	PRESS_INTERVAL_S = 10;
	private  int	 FREAME_X_Ci = 243;
	private  int	 FREAME_Y_Ci = 50;
	private  int	 FREAME_WIDTH_Ci = 550;// 横
	private  int	 FREAME_HEIGHT_Ci = 250;// 纵
	// 原点坐标
	private  int	 Origin_X_Ci = FREAME_X_Ci + 50;//100
	private  int	 Origin_Y_Ci = FREAME_Y_Ci + FREAME_HEIGHT_Ci - 30;//270
 
	// X,Y轴终点坐标
	private  int	XAxis_X_Ci = FREAME_X_Ci + FREAME_WIDTH_Ci - 30;//720
	private  int	 XAxis_Y_Ci = Origin_Y_Ci;//270
	private  int	 YAxis_X_Ci = Origin_X_Ci;//100
	private  int	 YAxis_Y_Ci= FREAME_Y_Ci + 110;//80
	// X轴上的时间分度值（1分度=40像素）
	private  int	 TIME_INTERVAL_Ci = 30;
	// Y轴上值
	private  int	PRESS_INTERVAL_Ci = 10;
	private  int FREAME_X_Net = 243;
	private  int FREAME_Y_Net = 50;
	private  int FREAME_WIDTH_Net= 550;// 横
	private  int FREAME_HEIGHT_Net = 250;// 纵
	// 原点坐标
	private  int Origin_X_Net = FREAME_X_Net + 50;//100
	private  int Origin_Y_Net = FREAME_Y_Net + FREAME_HEIGHT_Net - 30;//270
	// X,Y轴终点坐标
	private  int XAxis_X_Net = FREAME_X_Net + FREAME_WIDTH_Net - 30;//720
	private  int XAxis_Y_Net = Origin_Y_Net;//270
	private  int YAxis_X_Net = Origin_X_Net;//100
	private  int YAxis_Y_Net= FREAME_Y_Net + 110;//80
	// X轴上的时间分度值（1分度=40像素）
	private  int TIME_INTERVAL_Net = 30;
	// Y轴上值
	private  int PRESS_INTERVAL_Net = 10;
	 JLabel save_size = new JLabel();
	 	JLabel save_Usage = new JLabel();
		JLabel swap_use = new JLabel();
		JLabel Buffers1 = new JLabel();
		JLabel Cached1= new JLabel();
		JLabel swap_no_use = new JLabel();
	 JLabel all_no_use= new JLabel();
		JLabel send = new JLabel();
	JLabel receive = new JLabel();
		JLabel DNS = new JLabel();
		JLabel IPV4 = new JLabel();
	JLabel IPV6 = new JLabel();
	 JLabel label_1 = new JLabel();
	 JLabel cpuUsage = new JLabel();
	 JLabel Process = new JLabel();
		JLabel Threads = new JLabel();
	JLabel losf = new JLabel();
		JLabel cputime = new JLabel();
	public  void updatesave(Savemodel s)throws Exception
	{
		save_size.setText(String.format("%.2f", s.getNeicunall()/1024)+"GB");
		save_Usage.setText(String.format("%.2f",s.getNeicunuse()/1024)+"GB");
		swap_use.setText(s.getSwap_use()+"MB");
		Buffers1.setText(s.getBuffers1()+"MB");
		Cached1.setText(s.getCached1()+"MB");
		swap_no_use.setText(s.getSwap_all()-s.getSwap_use()+"MB");
		all_no_use.setText(s.getNeicunall()-s.getNeicunuse()+"MB");
		save_size.invalidate();
		save_Usage.invalidate();
		swap_use.invalidate();
		Buffers1.invalidate();
		Cached1.invalidate();
		swap_no_use.invalidate();
		all_no_use.invalidate();

	}
	
	
	 JLabel Cipan_speed = new JLabel();
	 JLabel Cipan_size = new JLabel();
	public  void updatecipan(String speed) throws Exception
	{
		if("0 MB/秒".contentEquals(speed))
		{
			speed="";
		}
		String size=cipan.recipan().getCipan_size();
		if("0".contentEquals(cipan.recipan().getCipan_size()))
		{
			size="";
			
		}
		Cipan_speed.setText(speed);
		Cipan_size.setText(size);
		Cipan_speed.invalidate();
		Cipan_size.invalidate();
		
		
	}
	public void updateNet(x_Net ne)
	{
		
    	
		send.setText(String.format("%.2f",ne.getSendrate())+"kbps");
		receive.setText(String.format("%.2f",ne.getReceiverate())+"kbps");
		DNS.setText(ne.getDNS());
		IPV4.setText(ne.getIPV4());
		IPV6.setText(ne.getIPV6());
		send.invalidate();
		receive.invalidate();
		DNS.invalidate();
		IPV4.invalidate();
		IPV6.invalidate();
	}
	
	public  void updateCpu(Cpu_model c) 
	{
		label_1.setText(c.getModel_name());
		cpuUsage.setText(c.getCpuUsage()+"%");
		Process.setText(c.getAllprocess()+"");
		Threads.setText(c.getThreads()+"");
		
		losf.setText(c.getLosfnum()+"");
		cputime.setText(c.getCPUtime());
		
		losf.invalidate();
		cputime.invalidate();
		Threads.invalidate();
		Process.invalidate();
		cpuUsage.invalidate();
		label_1.invalidate();
	}
	public static void addValue_save(int value) {
		// 循环的使用一个接受数据的空间
		if (values_save.size() > MAX_COUNT_OF_VALUES) {
			values_save.remove(0);
		}
		values_save.add(value);
	}
	public static void addValue_cpu(int value) {
		// 循环的使用一个接受数据的空间
		if (values_cpu.size() > MAX_COUNT_OF_VALUES) {
			values_cpu.remove(0);
		}
		values_cpu.add(value);
	}
	public static void addValue_cipan(int value) {
		// 循环的使用一个接受数据的空间
		if (values_cipan.size() > MAX_COUNT_OF_VALUES) {
			values_cipan.remove(0);
		}
		values_cipan.add(value);
	}
	public static void addValue_net(int value) {
		// 循环的使用一个接受数据的空间
		if (values_net.size() > MAX_COUNT_OF_VALUES) {
			values_net.remove(0);
		}
		values_net.add(value);
	}
	class MyCanvas_cipan extends JPanel {
		private static final long serialVersionUID = 1L;
		 
		public void paintComponent(Graphics g) {
			Graphics2D g2D = (Graphics2D) g;
			Color c2 = new Color(255, 255, 255);
			this.setBackground(c2);
			Color c = new Color(95,208,87);
			g.setColor(c);
			super.paintComponent(g);
 
			// 绘制平滑点的曲线
			g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			int w = XAxis_X_Ci;// 起始点
			int xDelta = w / MAX_COUNT_OF_VALUES;//12.4--620/50
			int length = values_cipan.size() - 20;
		
			for (int i = 0; i < length - 1; ++i) {
				g2D.drawLine(xDelta * (MAX_COUNT_OF_VALUES - length + i)+7, values_cipan.get(i),
						xDelta * (MAX_COUNT_OF_VALUES - length + i+1)+7, values_cipan.get(i + 1));
			}
			
			// 画X轴上的时间刻度（从坐标轴原点起，每隔TIME_INTERVAL(时间分度)像素画一时间点，到X轴终点止）
			Color c4 = new Color(2, 2, 125);
			g.setColor(Color.BLACK);
			// X轴刻度依次变化情况
			for (int i = Origin_X_Ci, j = 0; i < XAxis_X_Ci; i += TIME_INTERVAL_Ci, j += TIME_INTERVAL_Ci) {//设置x轴刻度的值
				if(j==FREAME_WIDTH_Ci-100)
				{
					g.drawString(" " + 0, i - 10, Origin_Y_Ci + 20);
				}
				if(i==Origin_X_Ci) {
				g.drawString("30秒" , i - 10, Origin_Y_Ci + 20);
				}
			}
			g.drawString("磁盘读取速度", YAxis_X_Ci - 5, YAxis_Y_Ci - 5);// 血压刻度小箭头值
		
			// 画网格线
			Color c3 = new Color(180, 245, 175);
			g.setColor(c3);
			// 坐标内部横线
			int o=0;
			for (int i = Origin_Y_Ci; i > YAxis_Y_Ci; i -= PRESS_INTERVAL_Ci) {//Origin_Y：270 YAxis_Y：80 PRESS_INTERVAL：15 
				g.drawLine(Origin_X_Ci, i, Origin_X_Ci + 15 * TIME_INTERVAL_Ci, i);//TIME_INTERVAL：25 Origin_X：100  Origin_X：
				o++;
//				
			}
			
			
			// 坐标内部竖线
			for (int i = Origin_X_Ci; i < XAxis_X_Ci; i += TIME_INTERVAL_Ci) {//TIME_INTERVAL：25  XAxis_X：620
				g.drawLine(i, Origin_Y_Ci, i, Origin_Y_Ci - 10 * PRESS_INTERVAL_Ci);
			}
 
		}
	}
	class MyCanvas_net extends JPanel {
		private static final long serialVersionUID = 1L;
		 
		public void paintComponent(Graphics g) {
			Graphics2D g2D = (Graphics2D) g;
			Color c2 = new Color(255, 255, 255);
			this.setBackground(c2);
			Color c = new Color(214, 140, 140);
			g.setColor(c);
			super.paintComponent(g);
 
			// 绘制平滑点的曲线
			g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			int w = XAxis_X_Net;// 起始点
			int xDelta = w / MAX_COUNT_OF_VALUES;//12.4--620/50
			int length = values_net.size() - 20;
			for (int i = 0; i < length - 1; ++i) {
				g2D.drawLine(xDelta * (MAX_COUNT_OF_VALUES - length + i)+7, values_net.get(i),
						xDelta * (MAX_COUNT_OF_VALUES - length + i+1)+7, values_net.get(i + 1));
			}
			
			// 画X轴上的时间刻度（从坐标轴原点起，每隔TIME_INTERVAL(时间分度)像素画一时间点，到X轴终点止）
			Color c4 = new Color(2, 2, 125);
			g.setColor(Color.BLACK);
			// X轴刻度依次变化情况
			for (int i = Origin_X_Net, j = 0; i < XAxis_X_Net; i += TIME_INTERVAL_Net, j += TIME_INTERVAL_Net) {//设置x轴刻度的值
				if(j==FREAME_WIDTH_Net-100)
				{
					g.drawString(" " + 0, i - 10, Origin_Y_Net + 20);
				}
				if(i==Origin_X_Net) {
				g.drawString("30秒" , i - 10, Origin_Y_Net + 20);
				}
			}
			g.drawString("网口速度", YAxis_X_Net - 5, YAxis_Y_Net - 5);// 血压刻度小箭头值
		
			// 画网格线
			Color c3 = new Color(200,164,164);
			g.setColor(c3);
			// 坐标内部横线
			int o=0;
			for (int i = Origin_Y_Net; i > YAxis_Y_Net; i -= PRESS_INTERVAL_Net) {//Origin_Y：270 YAxis_Y：80 PRESS_INTERVAL：15 
				g.drawLine(Origin_X_Net, i, Origin_X_Net + 15 * TIME_INTERVAL_Net, i);//TIME_INTERVAL：25 Origin_X：100  Origin_X：
				o++;
//				
			}
			
			
			// 坐标内部竖线
			for (int i = Origin_X_Net; i < XAxis_X_Net; i += TIME_INTERVAL_Net) {//TIME_INTERVAL：25  XAxis_X：620
				g.drawLine(i, Origin_Y_Net, i, Origin_Y_Net - 10 * PRESS_INTERVAL_Net);
			}
 
		}
	}
	class MyCanvas_neicun extends JPanel {
		
		private static final long serialVersionUID = 1L;
 
		public void paintComponent(Graphics g) {
			Graphics2D g2D = (Graphics2D) g;
			Color c2 = new Color(255, 255, 255);
			this.setBackground(c2);
			Color c = new Color(165, 76, 181);
			g.setColor(c);
			super.paintComponent(g);
			
			// 绘制平滑点的曲线
			g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			int w = XAxis_X_S;// 起始点
			int xDelta = w / MAX_COUNT_OF_VALUES;//12.4--620/50
			int length = values_save.size() - 20;
			for (int i = 0; i < length - 1; ++i) {
				g2D.drawLine(xDelta * (MAX_COUNT_OF_VALUES - length + i)+7, values_save.get(i),
						xDelta * (MAX_COUNT_OF_VALUES - length + i+1)+7, values_save.get(i + 1));
			}
			
			// 画X轴上的时间刻度（从坐标轴原点起，每隔TIME_INTERVAL(时间分度)像素画一时间点，到X轴终点止）
			Color c4 = new Color(2, 2, 125);
			g.setColor(Color.BLACK);
			// X轴刻度依次变化情况
			for (int i = Origin_X_S, j = 0; i < XAxis_X_S; i += TIME_INTERVAL_S, j += TIME_INTERVAL_S) {//设置x轴刻度的值
				if(j==FREAME_WIDTH_S-100)
				{
					g.drawString(" " + 0, i - 10, Origin_Y_S + 20);
				}
				if(i==Origin_X_S) {
				g.drawString("30秒" , i - 10, Origin_Y_S + 20);
				}
			}
			g.drawString("内存使用率", YAxis_X_S - 5, YAxis_Y_S - 5);// 血压刻度小箭头值
		
			// 画网格线
			Color c3 = new Color(201, 176, 206);
			g.setColor(c3);
			// 坐标内部横线
			int o=0;
			for (int i = Origin_Y_S; i > YAxis_Y_S; i -= PRESS_INTERVAL_S) {//Origin_Y：270 YAxis_Y：80 PRESS_INTERVAL：15 
				g.drawLine(Origin_X_S, i, Origin_X_S + 15 * TIME_INTERVAL_S, i);//TIME_INTERVAL：25 Origin_X：100  Origin_X：
				o++;
//				
			}
			// 坐标内部竖线
			for (int i = Origin_X_S; i < XAxis_X_S; i += TIME_INTERVAL_S) {//TIME_INTERVAL：25  XAxis_X：620
				g.drawLine(i, Origin_Y_S, i, Origin_Y_S - 10 * PRESS_INTERVAL_S);
			}
 
		}
	}
	class MyCanvas extends JPanel {
		private static final long serialVersionUID = 1L;
		public void paintComponent(Graphics g) {
			
			Graphics2D g2D = (Graphics2D) g;
			Color c2 = new Color(255, 255, 255);
			this.setBackground(c2);
			Color c = new Color(36, 36, 251);
			g.setColor(c);
			super.paintComponent(g);
 
			// 绘制平滑点的曲线
			g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			int w = XAxis_X;// 起始点
			int xDelta = w / MAX_COUNT_OF_VALUES;//12.4--620/50
			int length = values_cpu.size() - 17;
			for (int i = 0; i < length - 1; ++i) {
				g2D.drawLine(xDelta * (MAX_COUNT_OF_VALUES - length + i+1), values_cpu.get(i),
						xDelta * (MAX_COUNT_OF_VALUES - length + i+1+1), values_cpu.get(i + 1));//
			}
			
			// 画X轴上的时间刻度（从坐标轴原点起，每隔TIME_INTERVAL(时间分度)像素画一时间点，到X轴终点止）
			Color c4 = new Color(2, 2, 125);
			g.setColor(Color.BLACK);
			// X轴刻度依次变化情况
			for (int i = Origin_X, j = 0; i < XAxis_X; i += TIME_INTERVAL, j += TIME_INTERVAL) {//设置x轴刻度的值
				if(j==600)
				{
					g.drawString(" " + 0, i - 10, Origin_Y + 20);
				}
				if(i==Origin_X) {
				g.drawString("60秒" , i - 10, Origin_Y + 20);
				}
			}
			g.drawString("%利用率(100%)", YAxis_X - 5, YAxis_Y - 5);// 血压刻度小箭头值
		
			// 画网格线
			Color c3 = new Color(207, 207, 249);
			g.setColor(c3);
			// 坐标内部横线
			int o=0;
			for (int i = Origin_Y; i > YAxis_Y; i -= PRESS_INTERVAL) {//Origin_Y：270 YAxis_Y：80 PRESS_INTERVAL：15 
				g.drawLine(Origin_X, i, Origin_X + 20 * TIME_INTERVAL, i);//TIME_INTERVAL：25 Origin_X：100  Origin_X：
				o++;
//				
			}
			
			
			// 坐标内部竖线
			for (int i = Origin_X; i < XAxis_X; i += TIME_INTERVAL) {//TIME_INTERVAL：25  XAxis_X：620
				g.drawLine(i, Origin_Y, i, Origin_Y - 10 * PRESS_INTERVAL);
			}
 
		}
	}
	
	public JPanel setsave() throws Exception
	{
		JPanel panelPerformance=new MyCanvas_neicun();
		panelPerformance.setBackground(Color.WHITE);
		ImageIcon iconXingn= new ImageIcon(XunserviceApplication1.class.getResource("/static/img/xingneng.png"));
        iconXingn.setImage(((ImageIcon) iconXingn).getImage().getScaledInstance(20, 20, 5));
		tabbedPane.addTab("性能", iconXingn, panelPerformance, null);
		panelPerformance.setLayout(null);
		Savemodel s=new Savemodel();
		save save1=new save();
		s=save1.getsave_Usage("free -m");
		JLabel label1 = new JLabel("\u5185\u5B58");
		label1.setForeground(Color.BLACK);
		label1.setBounds(197, 12, 119, 69);
		label1.setFont(new Font("Dialog", Font.BOLD, 50));
		
		panelPerformance.add(label1);

		 save_size = new JLabel(String.format("%.2f", s.getNeicunall()/1024)+"GB");
		save_size.setBounds(885, 41, 361, 30);
		save_size.setFont(new Font("Dialog", Font.PLAIN, 21));
		panelPerformance.add(save_size);
		
		JLabel label2 = new JLabel("\u4F7F\u7528\u4E2D(\u7CFB\u7EDF)");
		label2.setFont(new Font("宋体", Font.BOLD, 20));
		label2.setBounds(197, 401, 169, 60);
		label2.setEnabled(false);
		panelPerformance.add(label2);
		
		JLabel lblSwap = new JLabel("Swap\u4F7F\u7528\u4E2D");
		lblSwap.setFont(new Font("宋体", Font.BOLD, 20));
		lblSwap.setBounds(680, 397, 161, 69);
		lblSwap.setEnabled(false);
		panelPerformance.add(lblSwap);
		
		JLabel lblCached = new JLabel("cached(\u7F13\u5B58)");
		lblCached.setFont(new Font("宋体", Font.BOLD, 20));
		lblCached.setBounds(197, 557, 153, 46);
		lblCached.setEnabled(false);
		panelPerformance.add(lblCached);
		
		JLabel lblBuffers = new JLabel("buffers(\u7F13\u51B2)");
		lblBuffers.setFont(new Font("宋体", Font.BOLD, 20));
		lblBuffers.setBounds(408, 557, 169, 46);
		lblBuffers.setEnabled(false);
		panelPerformance.add(lblBuffers);
		
		 save_Usage = new JLabel(String.format("%.2f",s.getNeicunuse()/1024)+"GB");
		 save_Usage.setFont(new Font("宋体", Font.BOLD, 19));
		save_Usage.setBounds(197, 478, 77, 25);
		panelPerformance.add(save_Usage);
		
		swap_use = new JLabel(s.getSwap_use()+"MB");
		swap_use.setFont(new Font("宋体", Font.BOLD, 19));
		swap_use.setBounds(690, 485, 90, 25);
		panelPerformance.add(swap_use);
		
		 Buffers1 = new JLabel(s.getBuffers1()+"MB");
		 Buffers1.setFont(new Font("宋体", Font.BOLD, 18));
			Buffers1.setBounds(408, 616, 77, 25);
		panelPerformance.add(Buffers1);
		
		 Cached1 = new JLabel(s.getCached1()+"MB");
		 Cached1.setFont(new Font("宋体", Font.BOLD, 18));
			Cached1.setBounds(197, 616, 89, 25);
		panelPerformance.add(Cached1);
		
		JLabel all_free = new JLabel("\u53EF\u7528");
		all_free.setFont(new Font("宋体", Font.BOLD, 20));
		all_free.setEnabled(false);
		all_free.setBounds(408, 403, 106, 58);
		panelPerformance.add(all_free);
		
		JLabel swap_free = new JLabel("\u53EF\u7528");
		swap_free.setFont(new Font("宋体", Font.BOLD, 20));
		swap_free.setEnabled(false);
		swap_free.setBounds(900, 407, 169, 48);
		panelPerformance.add(swap_free);
		
		swap_no_use = new JLabel(s.getSwap_all()-s.getSwap_use()+"MB");
		swap_no_use.setFont(new Font("宋体", Font.BOLD, 19));
		swap_no_use.setBounds(905, 485, 89, 25);
		panelPerformance.add(swap_no_use);
		
		all_no_use = new JLabel(s.getNeicunall()-s.getNeicunuse()+"MB");
		all_no_use.setFont(new Font("宋体", Font.BOLD, 19));
		all_no_use.setBounds(408, 478, 89, 28);
		panelPerformance.add(all_no_use);
		return panelPerformance;

	}
	public JPanel setcipan() throws Exception
	{
		JPanel panelPerformance=new MyCanvas_cipan();
		panelPerformance.setBackground(Color.WHITE);
		ImageIcon iconXingn= new ImageIcon(XunserviceApplication1.class.getResource("/static/img/xingneng.png"));
        iconXingn.setImage(((ImageIcon) iconXingn).getImage().getScaledInstance(20, 20, 5));
		tabbedPane.addTab("性能", iconXingn, panelPerformance, null);
		panelPerformance.setLayout(null);
		Cipan_model ci=cipan.recipan();
		JLabel label1 = new JLabel("\u78C1\u76D8");
		label1.setBounds(197, 13, 119, 69);
		label1.setFont(new Font("Dialog", Font.BOLD, 50));
		
		panelPerformance.add(label1);
		
		JLabel label2 = new JLabel("\u8BFB\u53D6\u901F\u5EA6");
		label2.setFont(new Font("宋体", Font.BOLD, 20));
		label2.setBounds(255, 401, 119, 64);
		label2.setEnabled(false);
		panelPerformance.add(label2);
		
		JLabel lblSwap = new JLabel("\u5BB9\u91CF");
		lblSwap.setFont(new Font("宋体", Font.BOLD, 20));
		lblSwap.setBounds(679, 403, 98, 60);
		lblSwap.setEnabled(false);
		panelPerformance.add(lblSwap);
		String speed="";
	
		if(ci.getSpeed()=="0 MB/秒")
		{
			speed="";
		}
		else
		{
			speed=ci.getSpeed();
		}
		
		Cipan_speed = new JLabel(speed);
		Cipan_speed.setFont(new Font("宋体", Font.BOLD, 19));
		Cipan_speed.setBounds(255, 494, 255, 46);
		
		panelPerformance.add(Cipan_speed);
		
		String size="";
		if(ci.getCipan_size()=="0")
		{
			size="";
		}
		else
		{
			size=ci.getCipan_size();
		}
		
		Cipan_size = new JLabel(size);
		Cipan_size.setFont(new Font("宋体", Font.BOLD, 19));
		Cipan_size.setBounds(687, 494, 77, 25);
		panelPerformance.add(Cipan_size);
		return panelPerformance;
	}
	public JPanel setnet() {
		JPanel panelPerformance=new MyCanvas_net();//new MyCanvas_net();
		panelPerformance.setBackground(Color.WHITE);
		ImageIcon iconXingn= new ImageIcon(XunserviceApplication1.class.getResource("/static/img/xingneng.png"));
        iconXingn.setImage(((ImageIcon) iconXingn).getImage().getScaledInstance(20, 20, 5));
		tabbedPane.addTab("性能", iconXingn, panelPerformance, null);
		panelPerformance.setLayout(null);
		
		JLabel label1 = new JLabel("\u7F51\u7EDC");
		label1.setBounds(197, 13, 119, 69);
		label1.setFont(new Font("Dialog", Font.BOLD, 50));
		panelPerformance.add(label1);
		
		NetUsage n= new NetUsage();
    	x_Net ne=n.return_net();
    	
		JLabel label2 = new JLabel("\u53D1\u9001");
		label2.setFont(new Font("Dialog", Font.BOLD, 20));
		label2.setBounds(228, 380, 92, 60);
		label2.setEnabled(false);
		panelPerformance.add(label2);
		
		JLabel lblSwap = new JLabel("\u63A5\u6536");
		lblSwap.setFont(new Font("宋体", Font.BOLD, 20));
		lblSwap.setBounds(219, 542, 77, 49);
		lblSwap.setEnabled(false);
		panelPerformance.add(lblSwap);
		
	   send = new JLabel(String.format("%.2f",ne.getSendrate())+"kbps");
		send.setFont(new Font("宋体", Font.BOLD, 19));
		send.setBounds(228, 453, 239, 60);
		panelPerformance.add(send);
		
		 receive = new JLabel(String.format("%.2f",ne.getReceiverate())+"kbps");
		 receive.setFont(new Font("宋体", Font.BOLD, 20));
			receive.setBounds(228, 604, 239, 60);
			panelPerformance.add(receive);
			
		JLabel lblNewLabel_4 = new JLabel("DNS\u540D\u79F0\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_4.setEnabled(false);
		lblNewLabel_4.setBounds(589, 391, 127, 39);
		panelPerformance.add(lblNewLabel_4);
		
		DNS = new JLabel(ne.getDNS());
		DNS.setFont(new Font("宋体", Font.BOLD, 19));
		DNS.setBounds(730, 386, 226, 49);
		panelPerformance.add(DNS);
		
		JLabel lblNewLabel_6 = new JLabel("IPV4\u5730\u5740:");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_6.setEnabled(false);
		lblNewLabel_6.setBounds(589, 513, 119, 33);
		panelPerformance.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("IPV6\u5730\u5740:");
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_7.setEnabled(false);
		lblNewLabel_7.setBounds(589, 608, 127, 39);
		panelPerformance.add(lblNewLabel_7);
		
		IPV4 = new JLabel(ne.getIPV4());
		IPV4.setFont(new Font("宋体", Font.BOLD, 19));
		IPV4.setBounds(730, 490, 239, 49);
		panelPerformance.add(IPV4);
		
		IPV6 = new JLabel(ne.getIPV6());
		IPV6.setFont(new Font("宋体", Font.BOLD, 19));
		IPV6.setBounds(730, 608, 310, 39);
		panelPerformance.add(IPV6);
		return panelPerformance;
	}
	public JPanel setCpu()
	{
		JPanel panelPerformance = new MyCanvas();//MyCanvas
		panelPerformance.setBackground(Color.WHITE);
		ImageIcon iconXingn= new ImageIcon(XunserviceApplication1.class.getResource("/static/img/xingneng.png"));
        iconXingn.setImage(((ImageIcon) iconXingn).getImage().getScaledInstance(20, 20, 5));
		tabbedPane.addTab("性能", iconXingn, panelPerformance, null);
		panelPerformance.setLayout(null);
		cpu cpu = new cpu();
		Cpu_model c=new Cpu_model();
		try {
			 c=cpu.recpu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel label = new JLabel("CPU");
		label.setBounds(197, 13, 119, 69);
		label.setFont(new Font("Dialog", Font.BOLD, 50));
		panelPerformance.add(label);
		
		label_1 = new JLabel(c.getModel_name());
		label_1.setBounds(630, 49, 550, 33);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 21));
		panelPerformance.add(label_1);
		
		JLabel label_2 = new JLabel("\u4F7F\u7528\u7387");
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(243, 344, 103, 33);
		label_2.setEnabled(false);
		panelPerformance.add(label_2);
		
		JLabel label_3 = new JLabel("\u8FDB\u7A0B");
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setBounds(249, 480, 58, 24);
		label_3.setEnabled(false);
		panelPerformance.add(label_3);
		
		JLabel label_4 = new JLabel("\u6B63\u5E38\u8FD0\u4F5C\u65F6\u95F4");
		label_4.setFont(new Font("宋体", Font.BOLD, 20));
		label_4.setBounds(255, 588, 187, 33);
		label_4.setEnabled(false);
		panelPerformance.add(label_4);
		
		
		JLabel label_5 = new JLabel("\u7EBF\u7A0B");
		label_5.setFont(new Font("宋体", Font.BOLD, 20));
		label_5.setBounds(381, 482, 61, 22);
		label_5.setEnabled(false);
		panelPerformance.add(label_5);
		
		JLabel label_6 = new JLabel("\u53E5\u67C4");
		label_6.setFont(new Font("宋体", Font.BOLD, 19));
		label_6.setBounds(510, 482, 58, 22);
		label_6.setEnabled(false);
		panelPerformance.add(label_6);
		
		 cpuUsage = new JLabel(c.getCpuUsage()+"%");
		 cpuUsage.setFont(new Font("宋体", Font.BOLD, 19));
			cpuUsage.setBounds(253, 407, 93, 41);
			panelPerformance.add(cpuUsage);
		
		 Process = new JLabel(c.getAllprocess()+"");
		Process.setBounds(278, 528, 77, 25);
		Process.setFont(new Font("宋体", Font.BOLD, 19));
		Process.setBounds(255, 517, 77, 25);
		panelPerformance.add(Process);
		
		 Threads = new JLabel(c.getThreads()+"");
		 Threads.setFont(new Font("宋体", Font.BOLD, 19));
			Threads.setBounds(381, 528, 77, 25);
			panelPerformance.add(Threads);
		
		 losf = new JLabel(c.getLosfnum()+"");
		 losf.setFont(new Font("宋体", Font.BOLD, 19));
			losf.setBounds(510, 528, 77, 25);
			panelPerformance.add(losf);
		
		 cputime = new JLabel(c.getCPUtime());
		 cputime.setFont(new Font("宋体", Font.BOLD, 19));
			cputime.setBounds(250, 643, 77, 25);
			panelPerformance.add(cputime);
		
		JLabel label_8 = new JLabel("\u57FA\u51C6\u901F\u5EA6\uFF1A");
		label_8.setFont(new Font("宋体", Font.BOLD, 20));
		label_8.setEnabled(false);
		label_8.setBounds(747, 340, 119, 41);
		panelPerformance.add(label_8);
		
		JLabel speed = new JLabel(c.getCpu_MHz()+"GHZ");
		speed.setFont(new Font("宋体", Font.BOLD, 20));
		speed.setBounds(976, 350, 153, 27);
		panelPerformance.add(speed);
		
		JLabel label_7 = new JLabel("\u7269\u7406\u5904\u7406\u5668\uFF1A");
		label_7.setFont(new Font("宋体", Font.BOLD, 20));
		label_7.setEnabled(false);
		label_7.setBounds(747, 414, 202, 27);
		panelPerformance.add(label_7);
		
		JLabel processor = new JLabel(c.getProcessor()+"");
		processor.setFont(new Font("宋体", Font.BOLD, 20));
		processor.setBounds(976, 417, 77, 25);
		panelPerformance.add(processor);
		
		JLabel label_10 = new JLabel("\u903B\u8F91\u5904\u7406\u5668\uFF1A");
		label_10.setFont(new Font("宋体", Font.BOLD, 20));
		label_10.setEnabled(false);
		label_10.setBounds(747, 472, 202, 41);
		panelPerformance.add(label_10);
		
		JLabel core = new JLabel(c.getSockets()+"");
		core.setFont(new Font("宋体", Font.BOLD, 19));
		core.setBounds(976, 480, 77, 25);
		panelPerformance.add(core);
		
		JLabel label_9 = new JLabel("L1cache\u7F13\u51B2\uFF1A");
		label_9.setFont(new Font("宋体", Font.BOLD, 20));
		label_9.setEnabled(false);
		label_9.setBounds(747, 524, 202, 33);
		panelPerformance.add(label_9);
		
		JLabel L1 = new JLabel(c.getL1d_cache());
		L1.setFont(new Font("宋体", Font.BOLD, 19));
		L1.setBounds(976, 517, 77, 25);
		panelPerformance.add(L1);
		
		JLabel label_11 = new JLabel("L2\u7F13\u5B58");
		label_11.setFont(new Font("宋体", Font.BOLD, 20));
		label_11.setEnabled(false);
		label_11.setBounds(757, 592, 77, 25);
		panelPerformance.add(label_11);
		
		JLabel L2 = new JLabel(c.getL2_cache());
		L2.setFont(new Font("宋体", Font.BOLD, 19));
		L2.setBounds(976, 592, 77, 25);
		panelPerformance.add(L2);
		
		
		JLabel label_14 = new JLabel("L3\u7F13\u5B58");
		label_14.setFont(new Font("宋体", Font.BOLD, 20));
		label_14.setEnabled(false);
		label_14.setBounds(757, 643, 77, 25);
		panelPerformance.add(label_14);
		
		JLabel L3 = new JLabel(c.getL3_cache());
		L3.setFont(new Font("宋体", Font.BOLD, 19));
		L3.setBounds(976, 641, 77, 25);
		panelPerformance.add(L3);
		
		return panelPerformance;
	}
	
	
	private static int rate = 10000;
	public static JFrame frame=new JFrame();
	private static JTable tableNet = new JTable();
	private static JTable tableProcess = new JTable();
	private static JTable tableApplication = new JTable();
	private static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private static JPanel panelProcess = new JPanel(new BorderLayout());
	private static JPanel panelApplication = new JPanel(new BorderLayout());
	private static JPanel panelNet = new JPanel(new BorderLayout());
	static boolean isbai = true;
	static boolean isUpdate = true;// 是否更新：当鼠标左键按下后不再更新进程，当过去5秒后继续更新
	static int focusedRowIndex = -1;// table mouse row number
	static JPopupMenu m_popupMenuProcess = new JPopupMenu();// 弹出式菜单、右键菜单
	static JPopupMenu m_popupMenuApplication = new JPopupMenu();// 弹出式菜单、右键菜单
	static JPopupMenu m_popupMenuNet = new JPopupMenu();// 弹出式菜单、右键菜单
	static XunserviceApplication1 window = new XunserviceApplication1();;
	static List<processModel> processs = new ArrayList<processModel>();;
	static List<processModel> applications = new ArrayList<processModel>();
	static List<Net> nets = new ArrayList<Net>();
	static boolean restart = false;//
	static double maxCPU;
	static double maxMemory ;
	static double maxCPU1;
	static double maxMemory1 ;
	static Color selectColor=new Color(240,240,240);

	public void initxineng() throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int count = 0;
		String speed="";
		x_Net ne=new x_Net();
		
		while (true) {
				try {
					// 设置暂停的时间 5 秒
					count++;
					
					 Savemodel s=new Savemodel();
					  save sa=new save();
					  s=sa.getsave_Usage("free -m");
					  cpu cpu1 = new cpu();
						Cpu_model c=new Cpu_model();
						c=cpu1.recpu();
					  addValue_cpu(( 100-(int)(c.getCpuUsage()))+170);		
					  addValue_save(( 100-((int)(s.getAll_nei_result()))+170));//控制值的范围
						ne=NetUsage.return_net();
					  speed=cipan.recipan().getSpeed();
					addValue_cipan(((100-(int)(Double.parseDouble(speed.replace(" MB/秒", ""))/10)+170)));//控制值的范围
					addValue_net((100-(int)(ne.getSpeed()))+171);
					   updatesave(s);
						updatecipan(speed);
						updateCpu(c);
						 updateNet(ne);
						  frame.repaint();
						  Thread.sleep(200);
						 // System.out.println(sdf.format(new Date()) + "--循环执行第" + count + "次");
							
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		
	}

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(XunserviceApplication1.class, args);
		values_cpu = Collections.synchronizedList(new ArrayList<Integer>());
    	values_save = Collections.synchronizedList(new ArrayList<Integer>());// 防止引起线程异常
		values_net = Collections.synchronizedList(new ArrayList<Integer>());// 防止引起线程异常
		values_cipan = Collections.synchronizedList(new ArrayList<Integer>());// 防止引起线程异常
		
		
		XunserviceApplication1 xun=new  XunserviceApplication1();
		
		xun.initialize();
	
		EventQueue.invokeLater(new Runnable() {		
			@Override
			public void run() {
				try {
					
				frame.setVisible(true);
				Check window = new Check();
				window.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
				
		xun.initxineng();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int count = 0;
		
		while (true) {

			if (isUpdate == true) {
				try {
					Thread.sleep(rate);
					// 设置暂停的时间 5 秒
					count++;
					
					updateNetTable();
					updateProcessTable();
					updateApplicationTable();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}
	
	public static void diaoyong() {
		while (true) {

			if (isUpdate == true) {
				try {
					Thread.sleep(rate);
					// 设置暂停的时间 5 秒
					updateNetTable();
					updateProcessTable();
					updateApplicationTable();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	public  void initialize() throws Exception {
	
		frame.setFont(new Font("宋体",Font.PLAIN,20));
		Toolkit tool = frame.getToolkit(); // 得到一个Toolkit对象
		Image myimage = tool.getImage("logo1.jpg"); // 由tool获取图像
		frame.setIconImage(myimage);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// width and height
		frame.getContentPane().setBounds(new Rectangle(0, 0, 1300, 800));
		frame.setSize(1300, 800);
		frame.setBounds(100, 100, 1300, 800);
		// end size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// frame.setResizable(false);
		Container contentPane = frame.getContentPane();
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("1 2 3 ");
		menuBar.setFont(new Font("宋体",Font.PLAIN,20));
		menuBar.setBounds(0, 0, 1300, 22);
		JMenu[] menus = new JMenu[] { new JMenu("文件"), new JMenu("查看")};
		for (int i = 0; i < menus.length; i++) {
			menus[i].setFont(new Font("宋体",Font.PLAIN,20));
			menuBar.add(menus[i]);
			menus[i].setForeground(new Color(50, 50, 50));
		}
		menuBar.setBackground(new Color(255, 255, 255));
		menus[0].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent m) {
				menus[0].setSelected(true);
				menus[0].doClick();
			}
		});
		menus[1].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent m) {
				menus[1].setSelected(true);
				menus[1].doClick();
			}
		});

		JMenuItem item1 = new JMenuItem("     运行新任务    ");
		item1.setFont(new Font("宋体", Font.PLAIN, 20)
);
		/**** 运行新任务 ***/
		item1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {

				RunTask window = new RunTask();
				// taskFra.setVisible(true);
				window.setVisible(true);

			}

		});
		JMenuItem item3 = new JMenuItem("     获取权限   ");
		item3.setFont(new Font("宋体",Font.PLAIN,20));
		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame f=Check.frameSe; 
				Check c=new Check();
			
				c.initialize();//输入密码，将密码写入文件
			}
		});
		/**** 运行新任务 ***/

		JMenuItem item2 = new JMenuItem("     退出   ");
		item2.setFont(new Font("宋体",Font.PLAIN,20));
		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		item2.setFont(new Font("宋体",Font.PLAIN,20));
		menus[0].add(item1);
		menus[0].add(item3);
		menus[0].add(item2);

		JMenuItem itemOn = new JMenuItem("     立刻刷新    ");
		itemOn.setFont(new Font("宋体", Font.PLAIN, 20)
);
		itemOn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				restart = true;
				updateNetTable();

				updateProcessTable();

				updateApplicationTable();

			}
		});
		JMenu itemRate = new JMenu("     速度   ");
		itemRate.setFont(new Font("宋体", Font.PLAIN, 20));

		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButtonMenuItem itemHigh = new JRadioButtonMenuItem("      高  ", false);
		itemHigh.setSize(20, 20);
		itemHigh.setFont(new Font("宋体", Font.PLAIN, 20));
		JRadioButtonMenuItem itemMid = new JRadioButtonMenuItem("      中   ", true);
		itemMid.setFont(new Font("宋体", Font.PLAIN, 20));
		JRadioButtonMenuItem itemLow = new JRadioButtonMenuItem("      低    ", false);
		itemLow.setFont(new Font("宋体", Font.PLAIN, 20));
		JRadioButtonMenuItem itemStop = new JRadioButtonMenuItem("    已暂停    ", false);
		itemStop.setFont(new Font("宋体", Font.PLAIN, 20));
		buttonGroup.add(itemHigh);
		buttonGroup.add(itemStop);
		buttonGroup.add(itemMid);
		buttonGroup.add(itemLow);
		itemRate.add(itemHigh);
		itemRate.add(itemMid);
		itemRate.add(itemLow);
		itemRate.add(itemStop);
		itemHigh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				isUpdate = true;
				rate = 9000;
			}
		});
		itemMid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				isUpdate = true;
				rate = 10000;
			}
		});
		itemLow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				isUpdate = true;
				rate = 11000;
			}
		});
		itemStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				isUpdate = false;
			}
		});
		itemRate.setFont(new Font("宋体",Font.PLAIN,20));
		menus[1].add(itemOn);
		menus[1].add(itemRate);

		frame.getContentPane().add(menuBar);

		tabbedPane.setBounds(0, 23, frame.getWidth(), frame.getHeight());

		// 23
		tabbedPane.setFont(new Font("宋体",Font.PLAIN,20));
		tabbedPane.setBackground(Color.white);
		frame.getContentPane().add(tabbedPane);
		// add label
		JLabel lblNewLabel = new JLabel("1");
		// add panel

		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.setFont(new Font("宋体", Font.PLAIN, 20));
		// 表头（列名）
		/**** 进程 **/
		try {
		panelProcess.setFont(new Font("宋体", Font.PLAIN, 20));
		// 表头（列名）
		String[] ProcesscolumnNames = { "", "名称", "PID", "优先级", "状态", "用户名", "cpu", "内存" };
  	// 创建一个表格，指定所有行数据 和 表头
	
		DefaultTableModel model1 = new DefaultTableModel(ProcesscolumnNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableProcess = new JTable(model1);
		tableProcess.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TableModel tableModel1 = tableProcess.getModel();
		

		// "名称","PID","优先级","状态","用户名","cpu","内存","描述"

		processs = process.Getprocess();
		int i = 0;

		for (processModel p : processs) {

			Object[] arr = new Object[8];
			ImageIcon icon = new ImageIcon(findPicturePath(p.getName()));
			icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			arr[0] = icon;
			arr[1] = p.getName();
			arr[2] = p.getPID();
			arr[3] = p.getPrio();
			arr[4] = returnStat(p.getState());
			arr[5] = p.getUser();
			arr[6] = Double.toString(p.getB_cpu()) + "%";
			if (isbai == true) {
				arr[7] = Double.toString(p.getB_memory()) + "%";
			} else {
				arr[7] = p.getMemory();
			}

			i++;
			// 添加数据到表格
			((DefaultTableModel) tableModel1).addRow(arr);

		}

		
	    tableProcess.setShowGrid(false);
		tableProcess.setRowHeight(35);// 设置表格行宽
		tableProcess.invalidate();
		// JTable对象添加点击事件
		tableProcess.addMouseListener(new java.awt.event.MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				jTable1MouseClicked(evt);

			}

		});

		JTableHeader head1 = tableProcess.getTableHeader(); // 创建表格标题对象
		head1.setFont(new Font("宋体",Font.BOLD,20));// 设置表格字体
		head1.setPreferredSize(new Dimension(head1.getWidth(), 55));
		head1.setBackground(Color.white);

		tableProcess.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableProcess.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableProcess.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableProcess.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableProcess.getColumnModel().getColumn(4).setPreferredWidth(150);
		tableProcess.getColumnModel().getColumn(5).setPreferredWidth(150);
		tableProcess.getColumnModel().getColumn(6).setPreferredWidth(150);
		tableProcess.getColumnModel().getColumn(7).setPreferredWidth(150);
		tableProcess.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		maxCPU = getMaxB_CPU(processs);
		maxMemory = getMaxB_menory(processs);
		
		try {
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
						boolean hasFocus, int row, int column) {
	            	setFont(new Font("宋体",Font.PLAIN,20));
					setIcon(null);
					setBorder(null);
					setHorizontalAlignment(JLabel.CENTER);
					if (value instanceof ImageIcon) {
						setIcon((Icon) value);
						setText("");
					} else if (value instanceof String)
						setText((String) value);
					else
						setText("");
					if (column == 5) {

						// error
						String state = processs.get(row).getUser();
						// size 12 index 12

						if (state.equals("root")) {
							setBackground(new Color(190, 200, 240));
						} else {
							setBackground(new Color(210, 220, 240));
						}
					} else if (column == 6) {

						double b_cpu = processs.get(row).getB_cpu();
						if (b_cpu == maxCPU) {
							setBackground(new java.awt.Color(255, 127, 80));
						} else if (b_cpu != 0) {
							setBackground(new java.awt.Color(255, 220, 190));
						} else {
							setBackground(new java.awt.Color(255, 240, 210));
						}
					} else if (column == 7) {

						double b_mem = processs.get(row).getB_memory();
						if (b_mem == maxMemory) {
							setBackground(new java.awt.Color(240, 128, 128));
						} else if (b_mem != 0) {
							setBackground(new java.awt.Color(255, 220, 190));
						} else {
							setBackground(new java.awt.Color(255, 240, 210));
						}
					} else {
						setBackground(new java.awt.Color(255, 255, 255));
						
					}
					return this;
				}
			};
			for (int i1 = 0; i1 < 8; i1++) {
				tableProcess.getColumn(ProcesscolumnNames[i1]).setCellRenderer(tcr);
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		tableProcess.setSelectionBackground(new Color(0));

		// 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
		panelProcess.add(tableProcess.getTableHeader(), BorderLayout.NORTH);
		// 把表格内容 添加到容器中心
		panelProcess.add(tableProcess, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane(panelProcess);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		ImageIcon iconJincheng = new ImageIcon(XunserviceApplication1.class.getResource("/static/img/jincheng.png"));
		iconJincheng.setImage(((ImageIcon) iconJincheng).getImage().getScaledInstance(20, 20, 5));
		tabbedPane.addTab("进程", iconJincheng, scrollPane, null);
		
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model1);
		tableProcess.setRowSorter(sorter);
		ProcesscreatePopupMenu();// 创建鼠标点击事件
		}catch(Exception e) {
			System.out.println("由于计算机性能造成的延迟，我们很抱歉。");
		}
		/****性能 **/
		JPanel panel_1 = new JPanel();
		ImageIcon iconXingn= new ImageIcon(XunserviceApplication1.class.getResource("/static/img/xingneng.png"));
        iconXingn.setImage(((ImageIcon) iconXingn).getImage().getScaledInstance(20, 20, 5));
		tabbedPane.addTab("性能", iconXingn,panel_1 , null);
		panel_1.setLayout(null);
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_1.setBounds(0, 0, 1267, 681);
		panel_1.add(tabbedPane_1);
		
		tabbedPane_1.setFont(new Font("楷体", Font.PLAIN, 40));
		
		JPanel panel = setCpu();
		panel.setToolTipText("CPU活动");
		tabbedPane_1.addTab("CPU", null, panel, null);
		JPanel panel_2 = setsave();
		panel_2.setToolTipText("内存信息");
		tabbedPane_1.addTab("内存", null, panel_2, null);
		panel_2.setLayout(null);
		

		JPanel panel_3 = setcipan();
		panel_3.setToolTipText("磁盘信息");
		tabbedPane_1.addTab("磁盘", null, panel_3,null);
		
		JPanel panel_4 =setnet();
		panel_4.setToolTipText("网络信息");
		tabbedPane_1.addTab("网络", null, panel_4, null);
		/**** 应用 **/

		panelApplication.setFont(new Font("宋体",Font.PLAIN,20));
		// 表头（列名）
		String[] ApplicationcolumnNames = { "", "名称", "PID", "优先级", "状态", "用户名", "cpu", "内存" };

		// 创建一个表格，指定所有行数据 和 表头
		DefaultTableModel model3 = new DefaultTableModel(ApplicationcolumnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableApplication = new JTable(model3);
		tableApplication.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TableModel tableModel3 = tableApplication.getModel();
		// "名称","PID","优先级","状态","用户名","cpu","内存","描述"
		applications = application.readFiles();
		int j=0;
		for (processModel p : applications) {
			Object[] arr = new Object[8];
			ImageIcon icon = new ImageIcon(findPicturePath(p.getName()));
			icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			arr[0] = icon;
			arr[1] = p.getName();
			arr[2] = p.getPID();
			arr[3] = p.getPrio();
			arr[4] = returnStat(p.getState());
			arr[5] = p.getUser();
			arr[6] = Double.toString(p.getB_cpu()) + "%";
			if (isbai == true) {
				arr[7] = Double.toString(p.getB_memory()) + "%";
			} else {
				arr[7] = p.getMemory();
			}

			j++;
			// 添加数据到表格
			((DefaultTableModel) tableModel3).addRow(arr);

		}

		tableApplication.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableApplication.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableApplication.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableApplication.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableApplication.getColumnModel().getColumn(4).setPreferredWidth(150);
		tableApplication.getColumnModel().getColumn(5).setPreferredWidth(150);
		tableApplication.getColumnModel().getColumn(6).setPreferredWidth(150);
		tableApplication.getColumnModel().getColumn(7).setPreferredWidth(150);
		tableApplication.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// JTable对象添加点击事件
		tableApplication.addMouseListener(new java.awt.event.MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				ApplicationjTable1MouseClicked(evt);
			}

		});

		JTableHeader head3 = tableApplication.getTableHeader(); // 创建表格标题对象

		head3.setFont(new Font("宋体",Font.BOLD,20));// 设置表格字体
		head3.setPreferredSize(new Dimension(head3.getWidth(), 55));
		head3.setBackground(Color.white);

		tableApplication.setRowHeight(35);// 设置表格行宽
		tableApplication.invalidate();

		maxCPU1 = getMaxB_CPU(applications);
		maxMemory1 = getMaxB_menory(applications);
		try {
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
						boolean hasFocus, int row, int column) {
					setIcon(null);
					setBorder(null);
					setFont(new Font("宋体",Font.PLAIN,20));
					setHorizontalAlignment(JLabel.CENTER);
					if (value instanceof ImageIcon) {
						setIcon((Icon) value);
						setText("");
					} else if (value instanceof String)
						setText((String) value);
					else
						setText("");
					if (column == 5) {

						String state = applications.get(row).getUser();
						if (state.equals("root")) {
							setBackground(new Color(190, 200, 240));
						} else {
							setBackground(new Color(210, 220, 240));
						}
					} else if (column == 6) {

						double b_cpu = applications.get(row).getB_cpu();
						if (b_cpu == maxCPU1) {
							setBackground(new java.awt.Color(255, 127, 80));
						} else if (b_cpu != 0) {
							setBackground(new java.awt.Color(255, 220, 190));
						} else {
							setBackground(new java.awt.Color(255, 240, 210));
						}
					} else if (column == 7) {

						double b_mem = applications.get(row).getB_memory();
						if (b_mem == maxMemory1) {
							setBackground(new java.awt.Color(240, 128, 128));
						} else if (b_mem != 0) {
							setBackground(new java.awt.Color(255, 220, 190));
						} else {
							setBackground(new java.awt.Color(255, 240, 210));
						}
					} else {

						setBackground(new Color(255, 255, 255));
					}
					return this;
				}
			};
			for (int i1 = 0; i1 < 8; i1++) {
				tableApplication.getColumn(ApplicationcolumnNames[i1]).setCellRenderer(tcr);
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		tableApplication.setGridColor(Color.white);

		// 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
		panelApplication.add(tableApplication.getTableHeader(), BorderLayout.NORTH);
		panelApplication.add(new JScrollPane(tableApplication));
		// 把表格内容 添加到容器中心
		panelApplication.add(tableApplication, BorderLayout.CENTER);
		JScrollPane scrollApp = new JScrollPane(panelApplication);
		contentPane.add(scrollApp, BorderLayout.CENTER);
		ImageIcon iconYingyong = new ImageIcon(XunserviceApplication1.class.getResource("/static/img/yingyong.png"));
		iconYingyong.setImage(((ImageIcon) iconYingyong).getImage().getScaledInstance(20, 20, 5));
		tabbedPane.addTab("应用", iconYingyong, scrollApp, null);

		RowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(model3);
		tableApplication.setRowSorter(sorter3);
		ApplicationcreatePopupMenu();
		/**** 应用 **/
		// 联网

		
		String[] NetcolumnNames = { "", "PID", "进程名", "发送量", "接受量", "本地地址","连接地址"};

		// 创建一个表格，指定所有行数据 和 表头
		DefaultTableModel model2 = new DefaultTableModel(NetcolumnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		
		tableNet = new JTable(model2);
		tableNet.setGridColor(Color.white);
		tableNet.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableNet.setRowHeight(35);// 设置表格行宽
		TableModel tableModel2 = tableNet.getModel();
	
		nets = NetStat.getInstance().getNetStat();
		for (Net member : nets) {
			Object[] arr = new Object[7];
			ImageIcon icon = new ImageIcon(findPicturePath(member.getNetName()));
			icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			arr[0] = icon;
			arr[1] = member.getNetPid();
			arr[2] = member.getNetName();
			arr[3] = member.getReceive();
			arr[4] = member.getSend();
			arr[5] = member.getHost();
			arr[6]=member.getForeign();
			((DefaultTableModel) tableModel2).addRow(arr);
			// 添加数据到表格
		}

		tableNet.getColumnModel().getColumn(0).setPreferredWidth(1);
		tableNet.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableNet.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableNet.getColumnModel().getColumn(3).setPreferredWidth(20);
		tableNet.getColumnModel().getColumn(4).setPreferredWidth(20);
		tableNet.getColumnModel().getColumn(5).setPreferredWidth(100);
		tableNet.getColumnModel().getColumn(6).setPreferredWidth(200);
		tableNet.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// JTable对象添加点击事件
		tableNet.addMouseListener(new java.awt.event.MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				NetjTable1MouseClicked(evt);

			}

		});

		// 更新表格
		JTableHeader head = tableNet.getTableHeader(); // 创建表格标题对象
		head.setFont(new Font("宋体",Font.BOLD,20));// 设置表格字体
		head.setPreferredSize(new Dimension(head.getWidth(), 55));
		head.setBackground(Color.white);

		RowSorter<TableModel> sorterNet = new TableRowSorter<TableModel>(model2);
		tableNet.setRowSorter(sorterNet);

		tableNet.invalidate();
		panelNet.setFont(new Font("宋体",Font.PLAIN,20));
		// 表头（列名）
		try {
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
						boolean hasFocus, int row, int column) {
					setIcon(null);
					setBorder(null);
					setFont(new Font("宋体",Font.PLAIN,20));
					setHorizontalAlignment(JLabel.CENTER);
					if (value instanceof ImageIcon) {
						setIcon((Icon) value);
						setText("");
					} else if (value instanceof String)
						setText((String) value);
					else
						setText("");

					if (column == 3) {

						String recive = nets.get(row).getReceive();
						if (!recive.equals("0")) {
							setBackground(new java.awt.Color(255, 220, 190));
						} else {
							setBackground(new java.awt.Color(255, 240, 210));
						}
					} else if (column == 4) {

						String send = nets.get(row).getSend();
						if (!send.equals("0")) {
							setBackground(new java.awt.Color(255, 220, 190));
						} else {
							setBackground(new java.awt.Color(255, 240, 210));
						}
					} else {

						setBackground(new Color(255, 255, 255));
					}
					return this;
				}
			};
			for (int i1 = 0; i1 < 8; i1++) {
				tableNet.getColumn(NetcolumnNames[i1]).setCellRenderer(tcr);
			}

		} catch (Exception e) {
			e.getStackTrace();
		}


		// 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
		// add scroll
		// 产生一个带滚动条的面板
		// 将带滚动条的面板添加入窗口中

		JScrollPane scrollNet = new JScrollPane(panelNet);
		contentPane.add(scrollNet, BorderLayout.CENTER);
		panelNet.add(tableNet.getTableHeader(), BorderLayout.NORTH);
		// 把表格内容 添加到容器中心
		panelNet.add(tableNet, BorderLayout.CENTER);
		ImageIcon iconLianwang = new ImageIcon(XunserviceApplication1.class.getResource("/static/img/lianwang.png"));
		iconLianwang.setImage(((ImageIcon) iconLianwang).getImage().getScaledInstance(20, 20, 5));
		tabbedPane.addTab("联网", iconLianwang, scrollNet, null);
		NetcreatePopupMenu();// 创建鼠标点击事件
	}

	/*** 联网 **/
	// table点击事件

	private static void NetjTable1MouseClicked(java.awt.event.MouseEvent evt) {

		NetmouseRightButtonClick(evt);

	}

	// 鼠标右键点击事件

	private static void NetmouseRightButtonClick(java.awt.event.MouseEvent evt) {

		if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
			focusedRowIndex = tableNet.rowAtPoint(evt.getPoint());
			try {
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
	 
					public Component getTableCellRendererComponent(JTable table,
							Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						setFont(new Font("宋体",Font.PLAIN,20));
						setIcon(null);
						setBorder(null);
						setHorizontalAlignment(JLabel.CENTER);
						if (value instanceof ImageIcon) {
							setIcon((Icon) value);
							setText("");
						} else if (value instanceof String) {
							setText((String) value);
						}else {
							setText("");
						}

						if (row == focusedRowIndex) {
							setBackground(selectColor);
							
						}else {		
							if (column == 3) {

								String recive = nets.get(row).getReceive();
								if (!recive.equals("0")) {
									setBackground(new java.awt.Color(255, 220, 190));
								} else {
									setBackground(new java.awt.Color(255, 240, 210));
								}
							} else if (column == 4) {

								String send = nets.get(row).getSend();
								if (!send.equals("0")) {
									setBackground(new java.awt.Color(255, 220, 190));
								} else {
									setBackground(new java.awt.Color(255, 240, 210));
								}
							} else {

								setBackground(new Color(255, 255, 255));
							}
						}
	 
						
						return this;
					}
				};
				
				int columnCount = tableNet.getColumnCount();
				for (int i = 0; i < columnCount; i++) {
					tableNet.getColumn(tableNet.getColumnName(i)).setCellRenderer(tcr);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// 判断是否为鼠标的BUTTON3按钮，BUTTON3为鼠标右键

		else if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {

			// 通过点击位置找到点击为表格中的行

			focusedRowIndex = tableNet.rowAtPoint(evt.getPoint());

			// 将表格所选项设为当前右键点击的行

			tableNet.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);

			// 弹出菜单
			m_popupMenuNet.show(tableNet, evt.getX(), evt.getY());

		}

	}

	// 创建鼠标点击事件
	private static void NetcreatePopupMenu() {

		m_popupMenuNet.setFont(new Font("宋体", Font.PLAIN, 20)
);

		JMenuItem MenuItem0 = new JMenuItem();
		MenuItem0.setFont(new Font("宋体", Font.PLAIN, 20)
);
		MenuItem0.setText("  结束任务  ");

		JMenuItem MenuItem6 = new JMenuItem();
		MenuItem6.setText("  属性  ");
		MenuItem6.setFont(new Font("宋体", Font.PLAIN, 20)
);
		m_popupMenuNet.add(MenuItem0);

		m_popupMenuNet.add(MenuItem6);

		MenuItem0.addActionListener(new java.awt.event.ActionListener() {// 结束进程

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isUpdate = false;
				// 该操作需要做的事
				String pid = nets.get(focusedRowIndex).getNetPid();
				application.Killprocess(pid);
				window.updateNetTable();
				isUpdate = true;// 操作完成，继续更新

			}
		});

		MenuItem6.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isUpdate = false;
				// 该操作需要做的事
				String pid = nets.get(focusedRowIndex).getNetPid();
				String name = nets.get(focusedRowIndex).getNetName();

				JFrame properties = new processPropertiesApp(name, pid);
				properties.setVisible(true);// 设置界面为可以显示

				isUpdate = true;// 操作完成，继续更新

			}

		});

	}

	public static void updateNetTable() {
		TableModel tableModel = tableNet.getModel();
		int rows = tableNet.getRowCount();// get table rows

		while (rows >= 1) {// if update not update finish,continue delete rows
			((DefaultTableModel) tableModel).removeRow(0);// rowIndex是要删除的行序号
			rows = tableNet.getRowCount();// get table rows
		}
		nets = NetStat.getInstance().getNetStat();

		for (Net member : nets) {
			Object[] arr = new Object[7];
			ImageIcon icon = new ImageIcon(findPicturePath(member.getNetName()));
			icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			arr[0] = icon;
			arr[1] = member.getNetPid();
			arr[2] = member.getNetName();
			arr[3] = member.getReceive();
			arr[4] = member.getSend();
			arr[5] = member.getHost();
			arr[6]=member.getForeign();
			((DefaultTableModel) tableModel).addRow(arr);
			// 添加数据到表格
		}
		// 更新表格
		tableNet.invalidate();
	}

	/*** 联网 **/
	/*** 进程 ***/
	public static void updateProcessTable() {

		TableModel tableModel = tableProcess.getModel();
		int rows = tableProcess.getRowCount();// get table rows
		while (rows >= 1) {// if update not update finish,continue delete rows
			((DefaultTableModel) tableModel).removeRow(0);// rowIndex是要删除的行序号
			rows = tableProcess.getRowCount();// get table rows
		}
		processs = process.Getprocess();
		int i = 0;

		for (processModel p : processs) {
			if (restart == true) {
				restart = false;
				break;
			}
			i++;
			Object[] arr = new Object[8];
			ImageIcon icon = new ImageIcon(findPicturePath(p.getName()));
			icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			arr[0] = icon;
			arr[1] = p.getName();
			arr[2] = p.getPID();
			arr[3] = p.getPrio();
			arr[4] = returnStat(p.getState());
			arr[5] = p.getUser();
			arr[6] = Double.toString(p.getB_cpu()) + "%";
			if (isbai == true) {
				arr[7] = Double.toString(p.getB_memory()) + "%";
			} else {
				arr[7] = p.getMemory();
			}
			// 添加数据到表格
			((DefaultTableModel) tableModel).addRow(arr);

		}
		// 更新表格
		tableProcess.invalidate();

	}
	// table点击事件

	private static void jTable1MouseClicked(java.awt.event.MouseEvent evt) {

		mouseRightButtonClick(evt);

	}

	// 鼠标右键点击事件

	private static void mouseRightButtonClick(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
			focusedRowIndex = tableProcess.rowAtPoint(evt.getPoint());
			try {
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
	 
					public Component getTableCellRendererComponent(JTable table,
							Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						setFont(new Font("宋体",Font.PLAIN,20));
						setIcon(null);
						setBorder(null);
						setHorizontalAlignment(JLabel.CENTER);
						if (value instanceof ImageIcon) {
							setIcon((Icon) value);
							setText("");
						} else if (value instanceof String) {
							setText((String) value);
						}else {
							setText("");
						}

						if (row == focusedRowIndex) {
							setBackground(selectColor);
							
						}else {		
							if (column == 5) {

								// error
								String state = processs.get(row).getUser();
								// size 12 index 12

								if (state.equals("root")) {
									setBackground(new Color(190, 200, 240));
								} else {
									setBackground(new Color(210, 220, 240));
								}
							} else if (column == 6) {

								double b_cpu = processs.get(row).getB_cpu();
								if (b_cpu == maxCPU) {
									setBackground(new java.awt.Color(255, 127, 80));
								} else if (b_cpu != 0) {
									setBackground(new java.awt.Color(255, 220, 190));
								} else {
									setBackground(new java.awt.Color(255, 240, 210));
								}
							} else if (column == 7) {

								double b_mem = processs.get(row).getB_memory();
								if (b_mem == maxMemory) {
									setBackground(new java.awt.Color(240, 128, 128));
								} else if (b_mem != 0) {
									setBackground(new java.awt.Color(255, 220, 190));
								} else {
									setBackground(new java.awt.Color(255, 240, 210));
								}
							} else {
								setBackground(new java.awt.Color(255, 255, 255));
								
							}
						}
	 
						
						return this;
					}
				};
				
				int columnCount = tableProcess.getColumnCount();
				for (int i = 0; i < columnCount; i++) {
					tableProcess.getColumn(tableProcess.getColumnName(i)).setCellRenderer(tcr);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		// 判断是否为鼠标的BUTTON3按钮，BUTTON3为鼠标右键

		if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {

			// 通过点击位置找到点击为表格中的行

			focusedRowIndex = tableProcess.rowAtPoint(evt.getPoint());

			// 将表格所选项设为当前右键点击的行

			tableProcess.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);

			// 弹出菜单
			m_popupMenuProcess.show(tableProcess, evt.getX(), evt.getY());

		}

	}

	public void mousePressed(MouseEvent e) {
		
		if (e.getButton() == MouseEvent.BUTTON1) {
		
			int selIndex = tableProcess.rowAtPoint(e.getPoint());
			
			try {
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
	 
					public Component getTableCellRendererComponent(JTable table,
							Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						if (row == selIndex) {
							setBackground(new Color(255,0,0));
							
						}
	 
						return super.getTableCellRendererComponent(table, value,
								isSelected, hasFocus, row, column);
					}
				};
				
				int columnCount = tableProcess.getColumnCount();
				for (int i = 0; i < columnCount; i++) {
					tableProcess.getColumn(tableProcess.getColumnName(i)).setCellRenderer(tcr);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			
			int selIndex = tableProcess.rowAtPoint(e.getPoint());

		}
	}

	// 创建鼠标点击事件
	private static void ProcesscreatePopupMenu() {
		m_popupMenuProcess.setFont(new Font("宋体", Font.PLAIN, 20)
);

		JMenuItem MenuItem0 = new JMenuItem();
		MenuItem0.setText("  结束进程  ");
		MenuItem0.setFont(new Font("宋体", Font.PLAIN, 20)
);
		JMenuItem MenuItem1 = new JMenuItem();
		MenuItem1.setText("  结束进程树  ");
		MenuItem1.setFont(new Font("宋体", Font.PLAIN, 20)
);
		JMenu MenuItem2 = new JMenu();

		/*** 设置优先级 ***/
		MenuItem2.setText("  设置优先级  ");
		// Linux系统进程的优先级取值：-20 到 19，数越大优先级越低。
		MenuItem2.setFont(new Font("宋体", Font.PLAIN, 20)
);
		JMenuItem m3 = new JMenuItem();
		m3.setFont(new Font("宋体", Font.PLAIN, 20)
);
		JMenuItem m4 = new JMenuItem();
		m4.setFont(new Font("宋体",Font.PLAIN,20));
		JMenuItem m5 = new JMenuItem();
		m5.setFont(new Font("宋体", Font.PLAIN, 20)
);
		JLabel showVal = new JLabel();
		showVal.setFont(new Font("宋体",Font.PLAIN,20));
		// 定义一个监听器，用于监听所有滑动条
		ChangeListener listener;
		listener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				isUpdate = false;// 操作完成，继续更新
				// 取出滑动条的值，并在文本中显示出来
				JSlider source = (JSlider) event.getSource();
				String prio = processs.get(focusedRowIndex).getPrio();
				source.setValue(Integer.valueOf(prio));
				showVal.setText("当前的值为：" + source.getValue());
				String pid = processs.get(focusedRowIndex).getPID();
				process.updatePrio(pid, source.getValue());
				isUpdate = true;// 操作完成，继续更新
			}
		};

		JSlider slider = new JSlider(-20, 19);
		// 设置绘制刻度
		slider.setPaintTicks(true);
		// 设置主、次刻度的间距
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		// 设置绘制刻度标签，默认绘制数值刻度标签
		slider.setPaintLabels(true);

		slider.addChangeListener(listener);
		JLabel t = new JLabel("值越大，优先级越低，值越小，优先级越大");
		t.setFont(new Font("宋体",Font.PLAIN,14));
		m3.add(t);
		m4.add(slider);
		m4.setPreferredSize(new Dimension(340, 70));
		showVal.setText("当前的值为：");

		showVal.setVisible(true);
		m5.add(showVal);
		MenuItem2.add(m3);
		MenuItem2.add(m4);
		MenuItem2.add(m5);

		/*** 设置优先级 end ***/
		/*** 设置设置资源 ***/
		JRadioButtonMenuItem j1 = new JRadioButtonMenuItem();
		j1.setText("值");
		j1.setFont(new Font("宋体", Font.PLAIN, 14)
);
		JRadioButtonMenuItem j2 = new JRadioButtonMenuItem();
		j2.setText("百分比");
		j2.setFont(new Font("宋体", Font.PLAIN, 20)
);
		if (isbai == true) {
			j2.setSelected(true);
		} else {
			j1.setSelected(true);
		}
		// 定义一个监听器，用于监听所有滑动条
		ChangeListener listener2;
		listener2 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				isUpdate = false;
				// 取出滑动条的值，并在文本中显示出来

				if (event.getSource() == j1) {
					j2.setSelected(false);
					isbai = false;
					window.updateProcessTable();
					isUpdate = true;// 操作完成，继续更新

				} else {
					j1.setSelected(false);
					isbai = true;
					window.updateProcessTable();
					isUpdate = true;// 操作完成，继续更新

				}
			}

		};
		JMenu MenuItem3 = new JMenu("  内存  ");
		MenuItem3.setFont(new Font("宋体", Font.PLAIN, 20)
);
		MenuItem3.add(j1);
		MenuItem3.add(j2);
		j1.addChangeListener(listener2);
		j2.addChangeListener(listener2);
		/*** 设置设置资源 end ***/
		JMenuItem MenuItem5 = new JMenuItem();
		MenuItem5.setText("  打开文件所在位置  ");
		MenuItem5.setFont(new Font("宋体", Font.PLAIN, 20)
);
		JMenuItem MenuItem6 = new JMenuItem();
		MenuItem6.setText("  属性  ");
		MenuItem6.setFont(new Font("宋体", Font.PLAIN, 20)
);
		m_popupMenuProcess.add(MenuItem0);
		m_popupMenuProcess.add(MenuItem1);
		m_popupMenuProcess.add(MenuItem2);
		m_popupMenuProcess.add(MenuItem3);
		m_popupMenuProcess.add(MenuItem5);
		m_popupMenuProcess.add(MenuItem6);

		MenuItem0.addActionListener(new java.awt.event.ActionListener() {// 结束进程

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isUpdate = false;

				// 该操作需要做的事
				String pid = processs.get(focusedRowIndex).getPID();
				process.Killprocess(pid);
				window.updateProcessTable();
				isUpdate = true;// 操作完成，继续更新

			}

		});
		MenuItem1.addActionListener(new java.awt.event.ActionListener() {// 结束进程树

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isUpdate = false;
				// 该操作需要做的事
				String pid = processs.get(focusedRowIndex).getPID();
				process.killProcessTree(pid);
				window.updateProcessTable();
				isUpdate = true;// 操作完成，继续更新

			}

		});
		MenuItem2.addActionListener(new java.awt.event.ActionListener() {// 结束进程树

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isUpdate = false;
				// 该操作需要做的事
				String prio = processs.get(focusedRowIndex).getPrio();
				slider.setValue(Integer.valueOf(prio));
				window.updateProcessTable();
				isUpdate = true;// 操作完成，继续更新

			}

		});

		MenuItem5.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isUpdate = false;
				// 该操作需要做的事
				String pid = processs.get(focusedRowIndex).getPID();
				String path = process.findExePath(pid);
				File file = new File(path);
				if (!file.exists()) {
					JOptionPane.showMessageDialog(null, "该文件不存在！！", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					try {
						java.awt.Desktop.getDesktop().open(file.getParentFile());
						// Exception in thread "AWT-EventQueue-0" java.lang.IllegalArgumentException:
						// The file: 5308 lrwxrwxrwx 1 root root 0 Jun 9 04:32 /proc/7 doesn't exist.
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				window.updateProcessTable();
				isUpdate = true;// 操作完成，继续更新

			}

		});

		MenuItem6.addActionListener(new java.awt.event.ActionListener() {// 结束进程树

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isUpdate = false;
				// 该操作需要做的事
				String pid = processs.get(focusedRowIndex).getPID();
				String name = processs.get(focusedRowIndex).getName();

				JFrame properties = new processPropertiesApp(name, pid);
				properties.setVisible(true);// 设置界面为可以显示

				isUpdate = true;// 操作完成，继续更新

			}

		});

	}

	/*** 进程 ****/

	/**** 应用 *****/

	// table点击事件

	private static void ApplicationjTable1MouseClicked(java.awt.event.MouseEvent evt) {

		ApplicationmouseRightButtonClick(evt);

	}

	// 鼠标右键点击事件

	private static void ApplicationmouseRightButtonClick(java.awt.event.MouseEvent evt) {

		if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
			focusedRowIndex = tableApplication.rowAtPoint(evt.getPoint());
			try {
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
	 
					public Component getTableCellRendererComponent(JTable table,
							Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						setFont(new Font("宋体",Font.PLAIN,20));
						setIcon(null);
						setBorder(null);
						setHorizontalAlignment(JLabel.CENTER);
						if (value instanceof ImageIcon) {
							setIcon((Icon) value);
							setText("");
						} else if (value instanceof String) {
							setText((String) value);
						}else {
							setText("");
						}

						if (row == focusedRowIndex) {
							setBackground(selectColor);
							
						}else {		
							if (column == 5) {

								String state = applications.get(row).getUser();
								if (state.equals("root")) {
									setBackground(new Color(190, 200, 240));
								} else {
									setBackground(new Color(210, 220, 240));
								}
							} else if (column == 6) {

								double b_cpu = applications.get(row).getB_cpu();
								if (b_cpu == maxCPU1) {
									setBackground(new java.awt.Color(255, 127, 80));
								} else if (b_cpu != 0) {
									setBackground(new java.awt.Color(255, 220, 190));
								} else {
									setBackground(new java.awt.Color(255, 240, 210));
								}
							} else if (column == 7) {

								double b_mem = applications.get(row).getB_memory();
								if (b_mem == maxMemory1) {
									setBackground(new java.awt.Color(240, 128, 128));
								} else if (b_mem != 0) {
									setBackground(new java.awt.Color(255, 220, 190));
								} else {
									setBackground(new java.awt.Color(255, 240, 210));
								}
							} else {

								setBackground(new Color(255, 255, 255));
							}
						}
	 
						
						return this;
					}
};
				
				int columnCount = tableApplication.getColumnCount();
				for (int i = 0; i < columnCount; i++) {
					tableApplication.getColumn(tableApplication.getColumnName(i)).setCellRenderer(tcr);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
			
		// 判断是否为鼠标的BUTTON3按钮，BUTTON3为鼠标右键
		if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {

			// 通过点击位置找到点击为表格中的行

			focusedRowIndex = tableApplication.rowAtPoint(evt.getPoint());
			// 将表格所选项设为当前右键点击的行

			tableApplication.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);

			// 弹出菜单
			m_popupMenuApplication.show(tableApplication, evt.getX(), evt.getY());

		}

	}

	public static void updateApplicationTable() {
		TableModel tableModel = tableApplication.getModel();
		int rows = tableApplication.getRowCount();// get table rows

		while (rows >= 1) {// if update not update finish,continue delete rows
			((DefaultTableModel) tableModel).removeRow(0);// rowIndex是要删除的行序号
			rows = tableApplication.getRowCount();// get table rows
		}
		processs = application.readFiles();

		for (processModel p : processs) {
			Object[] arr = new Object[8];
			ImageIcon icon = new ImageIcon(findPicturePath(p.getName()));
			icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			arr[0] = icon;
			arr[1] = p.getName();
			arr[2] = p.getPID();
			arr[3] = p.getPrio();
			arr[4] = returnStat(p.getState());
			arr[5] = p.getUser();
			arr[6] = Double.toString(p.getB_cpu()) + "%";
			if (isbai == true) {
				arr[7] = Double.toString(p.getB_memory()) + "%";
			} else {
				arr[7] = p.getMemory();
			}

			// 添加数据到表格
			((DefaultTableModel) tableModel).addRow(arr);

		}
		// 更新表格
		tableApplication.invalidate();
	}

	// 创建鼠标点击事件
	private static void ApplicationcreatePopupMenu() {
		m_popupMenuApplication.setFont(new Font("宋体", Font.PLAIN, 20)
);

		JMenuItem MenuItem0 = new JMenuItem();
		MenuItem0.setFont(new Font("宋体", Font.PLAIN, 20)
);
		MenuItem0.setText("  结束任务  ");
		/*** 设置设置资源 ***/
		JRadioButtonMenuItem j1 = new JRadioButtonMenuItem();
		j1.setFont(new Font("宋体", Font.PLAIN, 20));
		j1.setText("值");
		JRadioButtonMenuItem j2 = new JRadioButtonMenuItem();
		j2.setFont(new Font("宋体", Font.PLAIN, 20));
		j2.setText("百分比");
		if (isbai == true) {
			j2.setSelected(true);
		} else {
			j1.setSelected(true);
		}
		// 定义一个监听器，用于监听所有滑动条
		ChangeListener listener2;
		listener2 = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				isUpdate = false;
				// 取出滑动条的值，并在文本中显示出来

				if (event.getSource() == j1) {
					j2.setSelected(false);
					isbai = false;
					window.updateApplicationTable();
					isUpdate = true;// 操作完成，继续更新

				} else {
					j1.setSelected(false);
					isbai = true;
					window.updateApplicationTable();
					isUpdate = true;// 操作完成，继续更新

				}
			}

		};
		JMenu MenuItem3 = new JMenu("  内存  ");
		MenuItem3.setFont(new Font("宋体", Font.PLAIN, 20));

		MenuItem3.add(j1);
		MenuItem3.add(j2);
		j1.addChangeListener(listener2);
		j2.addChangeListener(listener2);
		/*** 设置设置资源 end ***/
		JMenuItem MenuItem5 = new JMenuItem();
		MenuItem5.setText("  打开文件所在位置  ");
		MenuItem5.setFont(new Font("宋体", Font.PLAIN, 20)
);
		JMenuItem MenuItem6 = new JMenuItem();
		MenuItem6.setText("  属性  ");
		MenuItem6.setFont(new Font("宋体", Font.PLAIN, 20)
);
		m_popupMenuApplication.add(MenuItem0);
		m_popupMenuApplication.add(MenuItem3);
		m_popupMenuApplication.add(MenuItem5);
		m_popupMenuApplication.add(MenuItem6);

		MenuItem0.addActionListener(new java.awt.event.ActionListener() {// 结束进程

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isUpdate = false;
				// 该操作需要做的事
				String pid = processs.get(focusedRowIndex).getPID();
				application.Killprocess(pid);
				window.updateApplicationTable();
				isUpdate = true;// 操作完成，继续更新

			}
		});

		MenuItem5.addActionListener(new java.awt.event.ActionListener() {// 结束进程树

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isUpdate = false;
				// 该操作需要做的事
				String pid = processs.get(focusedRowIndex).getPID();
				String path = application.findExePath(pid);

				File file = new File(path);

				try {
					java.awt.Desktop.getDesktop().open(file.getParentFile());
				} catch (IOException e) {
					window.updateApplicationTable();
					isUpdate = true;// 操作完成，继续更新

				}
			}
		});

		MenuItem6.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isUpdate = false;
				// 该操作需要做的事
				String pid = processs.get(focusedRowIndex).getPID();
				String name = processs.get(focusedRowIndex).getName();

				JFrame properties = new processPropertiesApp(name, pid);
				properties.setVisible(true);// 设置界面为可以显示

				isUpdate = true;// 操作完成，继续更新

			}

		});

	}

	/**** 应用 *****/

	/**** 根据进程名称找出图片路径 ***/
	public static String findPicturePath(String name) {
		Runtime runtime = Runtime.getRuntime();
		List<String> tasklist = new ArrayList<String>();
		java.lang.Process process = null;
		List<processModel> processs = new ArrayList<processModel>();
		String path = "";
		try {
			/*
			 * 
			 * 自适应执行查询进程列表命令
			 * 
			 */
			Properties prop = System.getProperties();
			// 获取操作系统名称
			boolean is = false;
			String os = prop.getProperty("os.name");
			if (os != null && os.toLowerCase().indexOf("linux") > -1) {
				// 1.适应与linux

				BufferedReader reader = null;
				// 显示所有进程
				// "名称","PID","优先级","状态","用户名","cpu","内存","磁盘","网络","描述"
				process = Runtime.getRuntime().exec("locate /usr/share/app-install/icons/" + name + ".png");
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line = null;

				while ((line = reader.readLine()) != null) {

					path = line;

				}

				if (path.equals("")) {

					path = "/usr/share/app-install/icons/applications-other.png";

				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return path;

	}

	/**** 根据进程名称找出图片路径 ***/

	public static double getMaxB_CPU(List<processModel> process) {
		double max = 0;
		for (processModel p : process) {
			if (p.getB_cpu() > max) {
				max = p.getB_cpu();
			}
		}
		return max;

	}

	public static double getMaxB_menory(List<processModel> process) {
		double max = 0;
		for (processModel p : process) {
			if (p.getB_memory() > max) {
				max = p.getB_memory();
			}
		}
		return max;

	}

	public static Icon returnStat(String old) {
		ImageIcon icon;

		try {
			if (old.equals("D")) {
				icon = new ImageIcon(XunserviceApplication1.class.getResource("/static/img/yunxing2.png"));
				icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
				return icon;
			} else if (old.equals("R")) {
				icon = new ImageIcon(XunserviceApplication1.class.getResource("/static/img/yunxing.png"));
				icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
				return icon;
			} else if (old.equals("S")) {
				icon = new ImageIcon(XunserviceApplication1.class.getResource("/static/img/sleep.png"));
				icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
				return icon;
			} else if (old.equals("T")) {
				icon = new ImageIcon(XunserviceApplication1.class.getResource("/static/img/zanting.png"));
				icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
				return icon;
			} else if (old.equals("Z")) {
				
				icon = new ImageIcon(XunserviceApplication1.class.getResource("/static/img/jiangshi.png"));
				icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
				return icon;
			} else {
				
				icon = new ImageIcon(XunserviceApplication1.class.getResource("/static/img/sleep.png"));
				icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
				return icon;
			}

		} catch (Exception e) {

			// 后面的xiaoai.jpg直接粘贴到eclipse的src目录下或者netbeans的源包目录下

			icon = new ImageIcon(XunserviceApplication1.class.getResource("/static/img/sleep.png"));
			icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			return icon;
		}
	}

}
