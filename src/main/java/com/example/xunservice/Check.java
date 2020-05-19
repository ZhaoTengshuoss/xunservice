package com.example.xunservice;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
public class Check {
	// 得到显示器屏幕的宽高
    public int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    public int height = Toolkit.getDefaultToolkit().getScreenSize().height;
 // 定义窗体的宽高
    public int windowsWedth = 450;
    public int windowsHeight = 230;
	public static JFrame frameSe;
	private JPasswordField passwordField = new JPasswordField();
	private JPasswordField passwordField_1 = new JPasswordField();
	public static String passwd="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Check window = new Check();
					window.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	/**
	 * Initialize the contents of the frame.
	 */
	 public void initialize() {
		 try {
		 frameSe =new JFrame();
		 frameSe.setVisible(true);
		 frameSe.setTitle("授权");
		frameSe.setBounds(100, 100, 450, 230);
		frameSe.setSize(450, 230);
		frameSe.setAlwaysOnTop(true);
		frameSe.setBounds((width - windowsWedth) / 2,
                (height - windowsHeight) / 2, windowsWedth, windowsHeight);
		//frameSe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSe.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0,450, 225);
		frameSe.getContentPane().add(panel);
		//this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("确认密码");
		lblNewLabel.setBounds(50, 100, 80, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton button = new JButton("重置");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				passwordField.setText("");
				passwordField_1.setText("");
			}
		});
		button.setBounds(107, 157, 80, 29);
		panel.add(button);
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label = new JLabel("本机密码");
		label.setBounds(50, 60, 80, 22);
		panel.add(label);
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setLabelFor(passwordField);
		
		JButton button_1 = new JButton("提交");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				passwd =passwordField.getText().trim(); 
				String repasswd = passwordField_1.getText().trim();
				if (passwd == null) {
					JOptionPane.showMessageDialog(null, "请输入密码！", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else if (passwd.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入密码！", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else if (repasswd == null) {
					JOptionPane.showMessageDialog(null, "请重新输入密码！", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else if (repasswd.equals("")) {
					JOptionPane.showMessageDialog(null, "请重新输入密码！", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else if (!passwd.equals(repasswd)) {
					JOptionPane.showMessageDialog(null, "重新输入密码不正确！", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String cmds[] = {"/bin/bash", "-c","echo " + passwd + " | sudo -S fdisk -l"};
					String line=null;
					try {
						java.lang.Process process = Runtime.getRuntime().exec(cmds);
						InputStreamReader ir = new InputStreamReader(process.getInputStream());      
						LineNumberReader input = new LineNumberReader(ir);   
						line = input.readLine();
						line=input.readLine();
					} catch (IOException e2) {
						e2.printStackTrace();
					} 
					
					if(line==null)
					{
						JOptionPane.showMessageDialog(null, "密码输入不正确！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
					
					try {
						
						JOptionPane.showMessageDialog(null, "授权成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					    frameSe.setVisible(false);
						//System.exit(0);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(264, 157, 80, 29);
		panel.add(button_1);
		
		passwordField.setBounds(140, 60, 250, 25);
		passwordField.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(140, 100, 250, 25);
		passwordField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(passwordField_1);	
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,e.getMessage(), "错误信息",JOptionPane.ERROR_MESSAGE);  
				
			}
		JLabel lable=new JLabel("输入系统密码即代表授予我们获得系统的权限！");
		lable.setFont(new Font("宋体", Font.PLAIN, 20));
		
	}
		
}