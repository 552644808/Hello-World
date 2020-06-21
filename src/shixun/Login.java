package shixun;

import com.mooc.jdbcUtil.jdbcUtil;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.mooc.jdbcUtil.jdbcUtil.getConnection;

/**
 * 用户登录
 * 使用本文件启动
 *
 */
public class Login extends JFrame{
	private JPanel contentPane;
	private JButton btn1,btn2,btn3;
	private JTextField userName;
	private JPasswordField password;
	public static String username;
	public static String sex;
	public static int age;
	public static String biaoqian;
	public static String grade;


	Connection conn;
	Statement seam;
	
	public Login() {
		
	     setTitle("登录窗口");  //设置窗体标题
		int LOGIN_HEIGTH = 400;
		int LOGIN_WIDTH = 400;
		setBounds(100, 50, LOGIN_WIDTH, LOGIN_HEIGTH);  //设置窗体坐标以及打下
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置窗体可关闭
		 setResizable(true);  //设置窗体大小不可以改变
		 //设置窗体标题图标
//		 setIconImage(
//			Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/log.jpg"))	 	 
//				 );
		contentPane = new JPanel();
//		 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   	 setContentPane(contentPane);
		 contentPane.setLayout(null);	 
		 //账号标签
		JLabel label1 = new JLabel("账号");
		 label1.setBounds(80,76, 54, 28);
		 add(label1);
		 
		 
		 //密码标签
		JLabel label2 = new JLabel("密码");
		 label2.setBounds(80, 135, 54, 28);
//		 label2.setIcon(new ImageIcon(Login.class.getResource("/images/psw.png")));
		 contentPane.add(label2);
	
         //账号输入框
		 userName=new JTextField();
		 userName.setBounds(139, 80, 161, 25);
		 contentPane.add(userName);
		 
		 //密码输入框
		 password=new JPasswordField();
		 password.setBounds(139, 140, 161, 25);
		 
	     contentPane.add(password);
//	     password.getRootPane().setDefaultButton(btn1);
	     
	     JLabel loginerror=new JLabel("");
	     loginerror.setBounds(160, 170, 100, 25);
	     contentPane.add(loginerror);
	     //按钮—登录
	     btn1=new JButton("登   录");
	     btn1.setBounds(95, 210, 80, 23);
	     contentPane.add(btn1);
//	     btn1.setIcon(new ImageIcon(Login.class.getResource("/images/btn1.png")));
	     
	     ActionListener btn1click = e -> {
			 if(e.getSource()==btn1) {
				 try {
					 conn= getConnection();//获取数据库连接
					 seam = conn.createStatement();  //创建sql语句执行对象
					 //编写sql语句
					 String sql="select * from account where username='"+userName.getText()+"'  and password='"+String.valueOf(password.getPassword())+"'     ";
					 //执行sql语句
//							System.out.println(sql);
//							System.out.println(userName.getText());
					 ResultSet rs= seam.executeQuery(sql);//把sql语句的结果集放在rs中
//							System.out.println(rs);
					 if(rs.next()) {
						 username=userName.getText();//设置静态全局变量
						 sex=rs.getString("sex");
						 age=rs.getInt("age");
						 biaoqian=rs.getString("biaoqian");
						 grade=rs.getString("grade");
						 System.out.println(sex);
					 dispose();//关闭当前窗口
					 new Main();
					 }
					 loginerror.setText("用户名或密码错误");
				 }catch (Exception e0) {
					 e0.printStackTrace();
				 }finally {
					 jdbcUtil.result(conn, seam);

				 }
			 }
		 };
			KeyListener pwlistener = new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()==KeyEvent.VK_ENTER)
					{
						try {
							conn= getConnection();//获取数据库连接
							seam = conn.createStatement();  //创建sql语句执行对象
							//编写sql语句
							String sql="select * from account where username= '"+userName.getText()+"' and password= '"+String.valueOf(password.getPassword())+"';";
						    //执行sql语句
							System.out.println(sql);
							System.out.println(userName.getText());
							ResultSet rs= seam.executeQuery(sql);
							System.out.println(rs);
							if(rs.next()) {
								username=userName.getText();
								sex=rs.getString(3);
								age=rs.getInt("age");
								biaoqian=rs.getString("biaoqian");
								grade=rs.getString("grade");
						    dispose();//关闭当前窗口							
							new Main();
							}	
							loginerror.setText("用户名或密码错误");
						}catch (Exception e0) {
							e0.printStackTrace();
						}finally {
							jdbcUtil.result(conn, seam);
							
						}
					}
				}
			};
			password.addKeyListener(pwlistener);
			btn1.addActionListener(btn1click);
			
		     
	     //按钮—退出
	     btn2=new JButton("退  出");
	     btn2.setBounds(210, 210, 80, 23);
//	     btn2.setIcon( new ImageIcon(Login.class.getResource("/images/exit.png")));
	     btn2.addActionListener(e -> {
			 if(e.getSource()==btn2) {
				 dispose();
			 }
		 });
	     contentPane.add(btn2);     
	     //按钮-注册
	     btn3=new JButton("注        册");
	     btn3.setBounds(95,240,200, 23);
//	     btn3.setIcon(new ImageIcon(Login.class.getResource("/images/regier.png")));
	     btn3.addActionListener(e -> {
			  dispose();//关闭登录窗体
			 new Register().addMan(); // 打开注册窗体
		 });
	     contentPane.add(btn3);
	     //按钮 “管理员登录”
	     JButton btn4 = new JButton("我是管理员");
	     btn4.setBounds(95, 270, 200, 23);
	     btn4.addActionListener(e->{
	    	 new Changeuser();
	     });
	     contentPane.add(btn4);
		 setVisible(true);    //设置窗体可见
//		 password.requestFocusInWindow();
	}
		
	public static void main(String[] args) {
		new Login();
	}	
		
	
}
