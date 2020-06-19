package shixun;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mooc.jdbcUtil.jdbcUtil;

/**
 * 用户注册
 * 
 * @author 大南海
 *
 */

public class Register extends JFrame {

	private int LOGIN_WIDTH = 360;
	private int LOGIN_HEIGTH = 350;
	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField password;
	private JButton btn3, btn4;
	private JLabel label3, label4;
	Connection conn;
	Statement stam;

	public void addMan() {

		setTitle("注册");
//		setTitle("增删改查");
		setBounds(100, 50, LOGIN_WIDTH, LOGIN_HEIGTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		// 设置窗体标题图标
		/**
		 * 添加一个面板容器到窗体中
		 */
		contentPane = new JPanel();
//		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 账号标签
		label3 = new JLabel("账号");
		label3.setBounds(80, 76, 54, 28);
		contentPane.add(label3);

		// 密码标签
		label4 = new JLabel("密码");
		label4.setBounds(80, 135, 54, 28);
		contentPane.add(label4);

		// 账号输入框
		userName = new JTextField();
		userName.setBounds(139, 80, 161, 25);
		contentPane.add(userName);

		// 密码输入框
		password = new JPasswordField();
		password.setBounds(139, 140, 161, 25);

		contentPane.add(password);

		btn3 = new JButton("登   录");
		btn3.setBounds(95, 210, 80, 23);
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == btn3) {

					try {

						// 加载数据库驱动
						conn = jdbcUtil.getConnection();
						// 创建执行sql语句的对象
						stam = conn.createStatement();
						String sql="select * from account";
						ResultSet rs=stam.executeQuery(sql);
						int num=0;
						while(rs.next())num++;
						// 编写sql语句
						sql = "insert into account(username,password,biaohao) values('" + userName.getText() + "','" + String.valueOf(password.getPassword()) + "',num)";
						// 执行sql语句
						stam.execute(sql);
						JOptionPane.showMessageDialog(null, "注册成功!");
						dispose(); // 关闭注册窗体
						new Login(); // 打开登录窗体
						stam.execute("select * from mysql.account;");

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "注册失败!");
						e1.printStackTrace();
					} finally {
						jdbcUtil.result(conn, stam);
					}

				}

			}
		});

		contentPane.add(btn3);

		btn4 = new JButton("退  出");
		btn4.setBounds(210, 210, 80, 23);
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == btn4) {

					dispose();
				}

			}
		});

		contentPane.add(btn4);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Register().addMan();
	}

}