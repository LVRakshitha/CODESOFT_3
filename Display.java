import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
public class Display extends JFrame implements ActionListener {

	JLabel l1;
	JTable table;
	JScrollPane jsp;
	JTextField t1;
	JButton search,update,back;
	
	Display(String Stdusn){
		
		getContentPane().setBackground(Color.white);
//		getContentPane().setForeground(Color.white);
		setLayout(null);
		
		l1 = new JLabel("Search student by USN ");
		l1.setFont(new Font("serif",Font.PLAIN,20));
		l1.setBounds(30,50,200,30);
		add(l1);
		
		t1 = new JTextField(20);
		t1.setBounds(30,100,150,30);
		add(t1);
		
		search = new JButton("Search");
		search.setBounds(200,100,100,30);
		search.setBackground(Color.black);
		search.setForeground(Color.white);
		add(search);
		search.addActionListener(this);
		
		update = new JButton("Update");
		update.setBounds(320,100,100,30);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		add(update);
		update.addActionListener(this);
		
		back = new JButton("back");
		back.setBounds(440,100,100,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		table = new JTable();
		table.setFont(new Font("serif",Font.PLAIN,15));
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("Select * from student");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		jsp = new JScrollPane(table);
		jsp.setBounds(0,180,800,400);
		add(jsp);
		
		setSize(800,500);
		setLocation(400,150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Display("");

	}

	public void actionPerformed(ActionEvent e) {
		String usn = t1.getText();
		if(e.getSource()==search) {
			try {
				conn c = new conn();
				String query = "select * from student where USN = '"+usn+"' ";
				
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(e.getSource()==update) {
			setVisible(false);
			new Update(usn);
			
		}else if(e.getSource()==back) {
			setVisible(false);
			new Home();
		}
	}

}
