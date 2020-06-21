package shixun;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.mooc.jdbcUtil.jdbcUtil;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Changeuser extends JFrame {

	private JScrollPane contentPane;
	JTable studentTable;
int row=0;//用户表的列和行
int q=0;
int p=0;
    Connection conn;
	Statement stam;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Changeuser frame = new Changeuser();
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
	public Changeuser() {
		setBounds(100, 100, 509, 419);
		getContentPane().setLayout(null);
		contentPane=new JScrollPane();
		contentPane.setBounds(10, 42, 473, 260);
		getContentPane().add(contentPane);
	    Object column[]={"用户名","密码","性别","年龄","个人说明","年级"};
		

		

        try {
			conn=jdbcUtil.getConnection();//获取数据库连接
			stam= (Statement) conn.createStatement();  //创建sql语句执行对象
			//编写sql语句
			String sql="select * from account order by biaohao asc";
		    //执行sql语句
			System.out.println(sql);
			ResultSet rs=stam.executeQuery(sql);
			while(rs.next()) {
				row++;//记录数
			}
			rs.beforeFirst();
			Object data[][]=new Object[row][6];
			studentTable = new JTable(data, column);
			if(rs.next()) {
				for (int i = 0; i < row; i++) {
					
						data[i][0]=rs.getString("username");
						data[i][1]=rs.getString("password");
						data[i][2]=rs.getString("sex");
						data[i][3]=rs.getInt("age");
						data[i][4]=rs.getString("biaoqian");
						data[i][5]=rs.getString("grade");
//						if(i!=row-1)
						rs.next();
				}

			}		
		}catch (Exception e0) {
			e0.printStackTrace();
		}finally {
			jdbcUtil.result(conn, stam);
		}
        contentPane.setViewportView(studentTable);
        
        JLabel usernameLabel = new JLabel("可以在此窗口修改数据");
        usernameLabel.setFont(new Font("宋体", Font.PLAIN, 14));
        usernameLabel.setBounds(127, 10, 169, 28);
        getContentPane().add(usernameLabel);
        
        JButton change = new JButton("保存");
        change.setBounds(169, 312, 116, 39);
        change.addActionListener(e->{
        	 try {
     			conn=jdbcUtil.getConnection();//获取数据库连接
     			stam= (Statement) conn.createStatement();  //创建sql语句执行对象
     			
     			
     			for (int i = 0; i < row; i++) {
     				
     				q=Integer.parseInt(studentTable.getValueAt(i,3).toString());
     				p=i+1;
     				String sql = "update account set username=? ,password=? ,sex=? ,age="+q+" ,biaoqian=? ,grade=? where biaohao= "+p;
    				//编写sql语句
         			PreparedStatement stmt = (PreparedStatement) conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
    						ResultSet.CONCUR_READ_ONLY);
					for (int j = 0; j < 3; j++) {
						
						stmt.setString(j+1,String.valueOf(studentTable.getValueAt(i, j)));
						
					}
					
					for (int j = 4; j < 6; j++) {
						
						stmt.setString(j,String.valueOf(studentTable.getValueAt(i, j)));
						
					}
					
					
					stmt.executeUpdate();
				}
     			
     		    //执行sql语句
//     			System.out.println(sql);
     			
     			
     			
     		}
        	 catch (Exception e0) {
     			e0.printStackTrace();
     			System.out.println("修改完毕，但可能有一些异常row："+row);
     		}
        	 finally {
     			jdbcUtil.result(conn, stam);
     		}
        });
        getContentPane().add(change);
        setVisible(true);
	}
}
