package shixun;

import static com.mooc.jdbcUtil.jdbcUtil.getConnection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mooc.jdbcUtil.jdbcUtil;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Activity extends JFrame {

	private JPanel contentPane;
	private JTextField actname;
	private JTextField start;
	private JTextField end;
	private JTextField textField_3;
	int activitynum;
	Connection conn;
	Statement seam;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Activity frame = new Activity();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Activity() {
		setBounds(100, 100, 537, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("活动");
		JPanel pan1=new JPanel();
		JPanel pan2=new JPanel();
		JPanel pan3=new JPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.insertTab("活动1", null, pan1, null, 0);
		pan1.setLayout(null);
		
		JLabel usernameLabel_3 = new JLabel("活动名称");
		usernameLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_3.setBounds(10, 10, 65, 28);
		pan1.add(usernameLabel_3);
		
		JLabel usernameLabel_3_1 = new JLabel("简介");
		usernameLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_3_1.setBounds(10, 48, 65, 28);
		pan1.add(usernameLabel_3_1);
		
		JLabel usernameLabel_3_2 = new JLabel("开始时间");
		usernameLabel_3_2.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_3_2.setBounds(10, 165, 65, 28);
		pan1.add(usernameLabel_3_2);
		
		JLabel usernameLabel_3_3 = new JLabel("截止时间");
		usernameLabel_3_3.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_3_3.setBounds(10, 203, 65, 28);
		pan1.add(usernameLabel_3_3);
		
		JLabel usernameLabel_3_4 = new JLabel("报名要求");
		usernameLabel_3_4.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_3_4.setBounds(10, 241, 65, 28);
		pan1.add(usernameLabel_3_4);
		
		actname = new JTextField((String) null);
		actname.setEnabled(false);
		actname.setFont(new Font("宋体", Font.PLAIN, 14));
		actname.setBounds(137, 14, 154, 28);
		pan1.add(actname);
		
		start = new JTextField((String) null);
		start.setEnabled(false);
		start.setFont(new Font("宋体", Font.PLAIN, 14));
		start.setBounds(137, 169, 154, 28);
		pan1.add(start);
		
		end = new JTextField((String) null);
		end.setEnabled(false);
		end.setFont(new Font("宋体", Font.PLAIN, 14));
		end.setBounds(137, 207, 154, 28);
		pan1.add(end);
		
		textField_3 = new JTextField("限大一新生参加");
		textField_3.setEnabled(false);
		textField_3.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_3.setBounds(137, 245, 154, 28);
		pan1.add(textField_3);
		
		JTextPane jianjie = new JTextPane();
		jianjie.setText("");
		jianjie.setEnabled(false);
		jianjie.setBounds(137, 55, 154, 104);
		pan1.add(jianjie);
		tabbedPane.insertTab("活动2", null, pan2, null, 1);
		tabbedPane.insertTab("活动3", null, pan3, null, 2);
		tabbedPane.setBounds(10, 10, 475, 284);
		
		try {
			 conn= getConnection();//获取数据库连接
			 seam = conn.createStatement();  //创建sql语句执行对象
			 //编写sql语句
			 String sql="select * FROM activity";
			 ResultSet rs= seam.executeQuery(sql);//把sql语句的结果集放在rs中
			 while(rs.next())activitynum++;
			 rs.beforeFirst();
					System.out.println(activitynum);
			 JPanel pan[] = new JPanel[activitynum];
//			 for (int i = 0; i < pan.length; i++) {
//				pan[i]=new JPanel();
//				pan[i].setLayout(null);
//				pan[i].add(usernameLabel_3);
//				 pan[i].add(usernameLabel_3_1);
//				 pan[i].add(usernameLabel_3_2);
//				 pan[i].add(usernameLabel_3_3);
//				 pan[i].add(usernameLabel_3_4);
//				 pan[i].add(actname);
//				 pan[i].add(jianjie);
//				 pan[i].add(start);
//				 pan[i].add(end);
//				 tabbedPane.insertTab("活动"+(i+1), null, pan[i], null, i);
//			}
			 if(rs.next()) {
				 actname.setText(rs.getString("Title"));//设置静态全局变量
				 jianjie.setText(rs.getString("jianjie"));
				 start.setText(String.valueOf(rs.getDate("StartTime")));
				 end.setText(String.valueOf(rs.getDate("EndTime")));
			 
			 }
		 }catch (Exception e0) {
			 e0.printStackTrace();
		 }finally {
			 jdbcUtil.result(conn, seam);

		 }
		contentPane.add(tabbedPane);
		
		JButton takepartin = new JButton("报名");
		takepartin.setFont(new Font("宋体", Font.PLAIN, 14));
		takepartin.setBounds(100, 360, 130, 33);
		contentPane.add(takepartin);
		
		JButton returnmain = new JButton("返回");
		returnmain.setFont(new Font("宋体", Font.PLAIN, 14));
		returnmain.setBounds(252, 360, 130, 33);
		returnmain.addActionListener(e->{
			dispose();
		});
		
		
		contentPane.add(returnmain);
		
		setVisible(true);
	}
}
