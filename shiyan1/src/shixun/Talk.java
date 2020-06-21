package shixun;

import static com.mooc.jdbcUtil.jdbcUtil.getConnection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mooc.jdbcUtil.jdbcUtil;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Talk extends JFrame {

	private JPanel contentPane;
	Connection conn;
	Statement seam;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Talk frame = new Talk();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Talk() {
		setBounds(100, 100, 596, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 560, 309);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		
		textArea.setLineWrap(true);
		try {
			conn = getConnection();//获取数据库连接
			seam = conn.createStatement();  //创建sql语句执行对象
			 //编写sql语句
			 String sql="select * FROM talk order by id";
			 ResultSet rs= seam.executeQuery(sql);
			 while(rs.next()) {
			 textArea.append(rs.getString("speaker")+"："+rs.getString("Text")+"\n——————\n");
			 }
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally {
			 jdbcUtil.result(conn, seam);
		 }
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 329, 461, 125);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_1);
		
		JButton btnNewButton = new JButton("发表");
		btnNewButton.addActionListener(e->{
			try {
				conn = getConnection();//获取数据库连接
				seam = conn.createStatement();  //创建sql语句执行对象
				 //编写sql语句
				 String sql="insert into talk (speaker,Text) values('"+Login.username+"','"+textArea_1.getText()+"')";
				 seam.executeUpdate(sql);
				 textArea.setText("");
				 sql="select * FROM talk order by id";
				 ResultSet rs= seam.executeQuery(sql);
				 while(rs.next()) {
				 textArea.append(rs.getString("speaker")+"："+rs.getString("Text")+"\n——————\n");
				 }
				 
			} catch (Exception e2) {
				e2.printStackTrace();
			}finally {
				 jdbcUtil.result(conn, seam);
			 }
		});
		btnNewButton.setBounds(493, 359, 77, 51);
		contentPane.add(btnNewButton);
		
		JButton returnmain = new JButton("返回");
		returnmain.setFont(new Font("宋体", Font.PLAIN, 14));
		returnmain.addActionListener(e->{
			dispose();
		});
		returnmain.setBounds(164, 464, 130, 33);
		contentPane.add(returnmain);
		
		
		setVisible(true);
	}
}
