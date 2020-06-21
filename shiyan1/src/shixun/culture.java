package shixun;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class culture extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					culture frame = new culture();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public culture() {
		setBounds(300,150,466,544);;
		setTitle("志愿文化");
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel TitleLabel = new JLabel("志愿文化知识");
		TitleLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		TitleLabel.setBounds(150, 31, 238, 57);
		contentPane.add(TitleLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 98, 357, 317);
		contentPane.add(scrollPane);
		
		JTextArea textPane = new JTextArea();
		textPane.setFont(new Font("宋体", Font.PLAIN, 15));
		textPane.setText("“志愿者”、“志愿服务”、“志愿文化”都是舶来品。在不同的政治、经济、文化背景与社会变迁下，理解都很不一样。但这并不妨碍人们在对“志愿精神”、“志愿者文化”的体认上达成共识：“自愿”、“无偿”、“奉献”、“有利于社会发展”总是其核心内涵。也正是这些核心观念，成就了“志愿者文化”对于全人类的意义。\r\n" + 
				"近些年来，随着国际交往的日益频繁，“志愿者文化”除了其本身的文化承载外，还成了一个国家、一个组织的“软实力”。如同正在崛起中的我们逐步感受到的，一个国家能否被世界认同，其文化价值能否获得其他文明、国家、民族的认同非常重要。因为，一个国家的文化价值体系承载着一个国家、一个民族对于生命个体最根本的思考与关怀。志愿者精神就是这种文化价值的表达。从上世纪末以来，我国一直向非洲以及其他一些国家、地区派遣国际志愿者，就体现了我们国家正在国际事务中承担着自己的责任。 ");
		scrollPane.setViewportView(textPane);
		JScrollBar sBar = scrollPane.getVerticalScrollBar();
		sBar.setValue(0);
		textPane.setLineWrap(true);
		textPane.setWrapStyleWord(true);
		
		JButton subButton = new JButton("投稿");
		subButton.setFont(new Font("宋体", Font.PLAIN, 14));
		subButton.setBounds(59, 425, 130, 33);
		contentPane.add(subButton);
		
		JButton abandonButton = new JButton("返回");
		abandonButton.setFont(new Font("宋体", Font.PLAIN, 14));
		abandonButton.setBounds(229, 425, 130, 33);
		abandonButton.addActionListener(e -> {
			// TODO Auto-generated method stub
			dispose();
		});
		contentPane.add(abandonButton);
		setVisible(true);
	}
}
