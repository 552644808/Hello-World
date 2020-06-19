package shixun;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import shixun.Login;
public class Main extends JFrame {

	private JPanel contentPane;
	JButton activitybtn;
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("主功能区");
		setBounds(100, 100, 525, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("用户名：");
		usernameLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel.setBounds(101, 10,65, 28);
		contentPane.add(usernameLabel);
		
		JLabel usernameLabel_1 = new JLabel(Login.username);
		usernameLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		usernameLabel_1.setBounds(194, 10, 154, 28);
		contentPane.add(usernameLabel_1);
		
		JButton PersonalCenterButton = new JButton("个人中心");
		PersonalCenterButton.setBounds(39, 68, 108, 41);
		
		PersonalCenterButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Userinfo();
			}
		});
		contentPane.add(PersonalCenterButton);

		JButton cultured = new JButton("志愿文化");
		cultured.setBounds(194, 68, 108, 41);
		cultured.addActionListener(e -> {
			new culture();
		});
		contentPane.add(cultured);
		
		 activitybtn = new JButton("志愿活动");
		activitybtn.setBounds(343, 68, 108, 41);
		activitybtn.addActionListener(e -> {
			new Activity();
		});
		contentPane.add(activitybtn);
		
		JButton btnNewButton_3 = new JButton("志愿风采");
		btnNewButton_3.setBounds(39, 180, 108, 41);
		btnNewButton_3.addActionListener(e -> {
			new fengcai();
			
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("志愿服务交流");
		btnNewButton_4.setBounds(194, 180, 108, 41);
		btnNewButton_4.addActionListener(e->{
			new Talk();
		});
		contentPane.add(btnNewButton_4);
		
		setVisible(true);
	}
}
