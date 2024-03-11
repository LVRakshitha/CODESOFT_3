import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class Delete extends JFrame implements ActionListener{
	Choice usn;
	JButton btn,back;
	JLabel t6,t2,t3,t4,t5;
	Delete(){
		getContentPane().setBackground(Color.yellow);
		setLayout(null);
		
		JLabel heading = new JLabel("Delete Student Details");
		heading.setBounds(80,20,400,100);
		heading.setFont(new Font("Algerian",Font.PLAIN,30));
		add(heading);
		
		JLabel l1 = new JLabel("USN");
		l1.setBounds(90,140,60,30);
		l1.setFont(new Font("serif",Font.PLAIN,20));
		add(l1);
	
		usn = new Choice();
		usn.setBounds(190,140,160,50);
		usn.setBackground(Color.black);
		usn.setForeground(Color.white);
		add(usn);
		
		
		try {
			
			conn c = new conn();
			String query = "select * from student";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				usn.add(rs.getString("USN"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel l2 = new JLabel("Name");
		l2.setBounds(90,180,80,30);
		l2.setFont(new Font("serif",Font.PLAIN,20));
		add(l2);
		
		 t2 = new JLabel();
		t2.setBounds(190,180,280,30);
		t2.setFont(new Font("serif",Font.PLAIN,20));
		add(t2);
		
		JLabel l3 = new JLabel("Sem");
		l3.setBounds(90,220,80,30);
		l3.setFont(new Font("serif",Font.PLAIN,20));
		add(l3);
		
		 t3 = new JLabel();
		t3.setBounds(190,220,280,30);
		t3.setFont(new Font("serif",Font.PLAIN,20));
		add(t3);
		
		
		JLabel l4 = new JLabel("Branch");
		l4.setBounds(90,260,80,30);
		l4.setFont(new Font("serif",Font.PLAIN,20));
		add(l4);
		
		 t4 = new JLabel();
		t4.setBounds(190,260,280,30);
		t4.setFont(new Font("serif",Font.PLAIN,20));
		add(t4);
		
		JLabel l5 = new JLabel("Email");
		l5.setBounds(90,300,80,30);
		l5.setFont(new Font("serif",Font.PLAIN,20));
		add(l5);
		
		 t5 = new JLabel();
		t5.setBounds(190,300,340,30);
		t5.setFont(new Font("serif",Font.PLAIN,20));
		add(t5);
		
		JLabel l6 = new JLabel("Contact");
		l6.setBounds(90,340,80,30);
		l6.setFont(new Font("serif",Font.PLAIN,20));
		add(l6);
		
		 t6 = new JLabel();
		t6.setBounds(190,340,280,30);
		t6.setFont(new Font("serif",Font.PLAIN,20));
		add(t6);
		
		try {
			
			conn c = new conn();
			String query = "select * from student where USN = '"+usn.getSelectedItem()+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
//				usn.add(rs.getString("USN"));
				t2.setText(rs.getString("Name"));
				t3.setText(rs.getString("Sem"));
				t4.setText(rs.getString("Branch"));
				t5.setText(rs.getString("Email"));
				t6.setText(rs.getString("Contact"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		usn.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent ie) {
				
				try {
					
					conn c = new conn();
					String query = "select * from student where USN = '"+usn.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(query);
					while(rs.next()) {
//						usn.add(rs.getString("USN"));
						t2.setText(rs.getString("Name"));
						t3.setText(rs.getString("Sem"));
						t4.setText(rs.getString("Branch"));
						t5.setText(rs.getString("Email"));
						t6.setText(rs.getString("Contact"));
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btn = new JButton("Delete");
		btn.setBounds(90,390,100,30);
		btn.setBackground(Color.black);
		btn.setForeground(Color.white);
		add(btn);
		btn.addActionListener(this);
		
		back = new JButton("back");
		back.setBounds(210,390,100,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		setSize(600,520);
		setLocation(450,150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Delete();

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btn) {
		try {
			conn c = new conn();
			String query = "delete from student where USN = '"+usn.getSelectedItem()+"'";
			c.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Student details deleted successfully");
			setVisible(false);
			new Home();
			
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		}else if(e.getSource()==back) {
			setVisible(false);
			new Home();
		}
		
	}

}
