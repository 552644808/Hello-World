package shixun;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class fengcai extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fengcai frame = new fengcai();
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
	public fengcai() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 638, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label = new JLabel("风采文章展示：");
		Label.setFont(new Font("宋体", Font.PLAIN, 14));
		Label.setBounds(46, 26, 118, 28);
		contentPane.add(Label);
		
		JLabel Label_1 = new JLabel("热评：");
		Label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		Label_1.setBounds(46, 230, 118, 28);
		contentPane.add(Label_1);
		
		JLabel Label_2 = new JLabel("评论：");
		Label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		Label_2.setBounds(46, 322, 118, 28);
		contentPane.add(Label_2);
		
		JTextArea textPane = new JTextArea();
		textPane.setText("冯华超老师：只是想为家乡做一点力所能及的贡献\n政法学院党员教师冯华超在得知家乡新野县人民医院向社会发布医用物资接受社会捐赠公告后，第一时间联系高中同学，发起爱心捐赠活动。短短半天时间，共筹集爱心捐款6000元，通过各种渠道购买了50大桶84消毒液捐给新野县人民医院，缓解了医院消毒物资急缺的状况。他说：“作为一名工作在外地的游子，我只是想为家乡做一点力所能及的贡献。”");
		textPane.setBounds(174, 33, 316, 186);
		textPane.setLineWrap(true);
		contentPane.add(textPane);
		
		JTextArea textPane_1 = new JTextArea();
		textPane_1.setText("感动！");
		textPane_1.setBounds(174, 232, 316, 82);
		contentPane.add(textPane_1);
		
		JTextArea textPane_2 = new JTextArea();
		textPane_2.setBounds(174, 324, 316, 82);
		contentPane.add(textPane_2);
		
		JButton returnmain = new JButton("返回");
		returnmain.setFont(new Font("宋体", Font.PLAIN, 14));
		returnmain.setBounds(46, 416, 130, 33);
		returnmain.addActionListener(e->{
			dispose();
		});
		contentPane.add(returnmain);
		
		JButton returnmain_1 = new JButton("发表");
		returnmain_1.setFont(new Font("宋体", Font.PLAIN, 14));
		returnmain_1.setBounds(194, 416, 130, 33);
		contentPane.add(returnmain_1);
		
		JButton returnmain_2 = new JButton("投稿");
		returnmain_2.setFont(new Font("宋体", Font.PLAIN, 14));
		returnmain_2.setBounds(334, 416, 130, 33);
		contentPane.add(returnmain_2);
	}
}
