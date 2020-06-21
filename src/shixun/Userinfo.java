package shixun;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mooc.jdbcUtil.jdbcUtil;

import javax.swing.JButton;

public class Userinfo extends JFrame {

	private JPanel contentPane;
	Object data[][] = new Object[1][3];
	Object column[] = { "性别", "年龄", "个人说明" };
	Connection conn;
	Statement stam;
	private JTextField usernameLabel_1_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userinfo frame = new Userinfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Userinfo() {
		setBounds(100, 100, 450, 300);
		setTitle("个人资料");
		contentPane = new JPanel();
		contentPane.setLayout(null);
		getContentPane().add(contentPane);
		JLabel usernameLabel = new JLabel("用户名：");
		usernameLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel.setBounds(86, 10, 65, 28);
		contentPane.add(usernameLabel);

		JLabel usernameLabel_1 = new JLabel(Login.username);
		usernameLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_1.setBounds(174, 10, 154, 28);
		contentPane.add(usernameLabel_1);

		JLabel usernameLabel_2 = new JLabel("年龄");
		usernameLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_2.setBounds(86, 86, 65, 28);
		contentPane.add(usernameLabel_2);

		JLabel usernameLabel_3 = new JLabel("个人说明");
		usernameLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_3.setBounds(86, 162, 65, 28);
		contentPane.add(usernameLabel_3);

		JLabel usernameLabel_4 = new JLabel("性别");
		usernameLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_4.setBounds(86, 48, 65, 28);
		contentPane.add(usernameLabel_4);

		JTextField usernameLabel_1_1 = new JTextField(Login.sex);
		usernameLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_1_1.setBounds(174, 48, 154, 28);
		contentPane.add(usernameLabel_1_1);

		JTextField usernameLabel_1_2 = new JTextField(String.valueOf(Login.age));
		usernameLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_1_2.setBounds(174, 86, 154, 28);
		contentPane.add(usernameLabel_1_2);

		JTextField usernameLabel_1_3 = new JTextField(Login.biaoqian);
		usernameLabel_1_3.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_1_3.setBounds(174, 162, 154, 28);
		contentPane.add(usernameLabel_1_3);

		JButton change = new JButton("修改");
		change.setBounds(143, 204, 93, 23);
		contentPane.add(change);
		
		JLabel usernameLabel_3_1 = new JLabel("年级");
		usernameLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_3_1.setBounds(86, 124, 65, 28);
		contentPane.add(usernameLabel_3_1);
		
		usernameLabel_1_4 = new JTextField(Login.grade);
		usernameLabel_1_4.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_1_4.setBounds(174, 124, 154, 28);
		contentPane.add(usernameLabel_1_4);
		change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = jdbcUtil.getConnection();
					String sql = "update account set sex=? where username=?";
					String sql1 = "update account set age=? where username=?";
					String sql2 = "update account set biaoqian=? where username=?";
					String sql3 = "update account set grade=? where username=?";
					PreparedStatement stmt = (PreparedStatement) conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					PreparedStatement stmt1 = (PreparedStatement) conn.prepareCall(sql1,
							ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					PreparedStatement stmt2 = (PreparedStatement) conn.prepareCall(sql2,
							ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					PreparedStatement stmt3 = (PreparedStatement) conn.prepareCall(sql3,
							ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					stmt.setString(1, usernameLabel_1_1.getText());
					stmt.setString(2, Login.username);
					stmt.executeUpdate();
					stmt1.setString(1, usernameLabel_1_2.getText());
					stmt1.setString(2, Login.username);
					stmt1.executeUpdate();
					stmt2.setString(1, usernameLabel_1_3.getText());
					stmt2.setString(2, Login.username);
					stmt2.executeUpdate();
					stmt3.setString(1, usernameLabel_1_4.getText());
					stmt3.setString(2, Login.username);
					stmt3.executeUpdate();
					conn.close();
					stmt.close();
					stmt1.close();
					stmt2.close();
					stmt3.close();
					Login.age=Integer.valueOf(usernameLabel_1_2.getText());
					Login.sex=usernameLabel_1_1.getText();
					Login.biaoqian=usernameLabel_1_3.getText();
					Login.grade=usernameLabel_1_4.getText();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		setVisible(true);
	}
}
