import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class AddStudent extends JFrame implements ActionListener{
	JButton back,add;
	JTextField t1,t2,t3,t5,t6,t7;
	JComboBox t4;
	JLabel l1,l2,l3,l4,l5,l6;
	AddStudent(){
		 getContentPane().setBackground(Color.yellow);
	     setLayout(null);
	     
	     setSize(500,600);
	     setLocation(500,150);
	     setVisible(true);
	     
	     JLabel heading = new JLabel("Add Student Details");
	     heading.setFont(new Font("Algerian",Font.PLAIN,30));
	     heading.setBounds(90,30,400,50);
	     add(heading);
	     
	      l1 = new JLabel("Name");
	     l1.setFont(new Font("serif",Font.PLAIN,20));
	     l1.setBounds(110,150,200,20);
	     add(l1);
	     
	      t1 = new JTextField(20);
	     t1.setBackground(Color.lightGray);
	     t1.setBounds(220,150,150,20);
	     add(t1);
	     
	      l2 = new JLabel("USN");
	     l2.setFont(new Font("serif",Font.PLAIN,20));
	     l2.setBounds(110,190,200,20);
	     add(l2);
	     
	      t2 = new JTextField(20);
	     t2.setBackground(Color.lightGray);
	     t2.setBounds(220,190,150,20);
	     add(t2);
	     
	      l3 = new JLabel("Sem");
	     l3.setFont(new Font("serif",Font.PLAIN,20));
	     l3.setBounds(110,230,200,20);
	     add(l3);
	     
	      t3 = new JTextField(20);
	     t3.setBackground(Color.lightGray);
	     t3.setBounds(220,230,150,20);
	     add(t3);
     
	     l4 = new JLabel("Branch");
	     l4.setFont(new Font("serif",Font.PLAIN,20));
	     l4.setBounds(110,270,200,20);
	     add(l4);
	     
	     
	     String bch[] = {"CSE","ISE","ECE","EEE","ME","CV"};
	      t4 = new JComboBox(bch);
	     t4.setBounds(220,270,150,20);
	     add(t4);
	     
//	     JTextField t4 = new JTextField(20);
//	     t4.setBackground(Color.lightGray);
//	     t4.setBounds(220,270,150,20);
//	     add(t4);
//	     
	      l5 = new JLabel("Email");
	     l5.setFont(new Font("serif",Font.PLAIN,20));
	     l5.setBounds(110,320,200,20);
	     add(l5);
	     
	      t5 = new JTextField(20);
	     t5.setBackground(Color.lightGray);
	     t5.setBounds(220,320,150,20);
	     add(t5);
	     
	      l6 = new JLabel("Contact");
	     l6.setFont(new Font("serif",Font.PLAIN,20));
	     l6.setBounds(110,360,200,20);
	     add(l6);
	     
	      t6 = new JTextField(20);
	     t6.setBackground(Color.lightGray);
	     t6.setBounds(220,360,150,20);
	     add(t6);
	     
	      add = new JButton("Add Student");
	     add.setBounds(110,420,150,40);
	     add.setForeground(Color.white);
		add.setBackground(Color.MAGENTA);
		
	     add(add);
	     
	      back = new JButton("Back");
	     back.setBounds(290,420,150,40);
	     back.setForeground(Color.white);
	     back.setBackground(Color.MAGENTA);
	     add(back);
	     
	     add.addActionListener(this);
	     back.addActionListener(this);

	     
	}

	public static void main(String[] args) {
		new AddStudent();
		
		

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== add) {
			String name,usn,sem,branch,email,contact;
			
			name = t1.getText();
			usn = t2.getText();
			sem = t3.getText();
			branch = (String) t4.getSelectedItem();
			email = t5.getText();
			contact = t6.getText();
			
			
			try {
				conn c = new conn();
				String query = "insert into student values ('"+name+"', '"+usn+"','"+sem+"','"+branch+"','"+email+"','"+contact+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Detailes added Successfully");
				setVisible(false);
				new Home();
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}else {
			setVisible(false);
			new Home();
		}
		
	}

}
