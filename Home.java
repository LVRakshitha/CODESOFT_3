import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener{
	
	JButton add,dis,update,del;
	
	Home(){
		setSize(800,400);
		setLocation(250,100);
		setVisible(true);
		setLayout(null);
		setBackground(Color.black);
		
		JLabel heading = new JLabel("STudent Management System");
		heading.setBounds(100,20,800,40);
		heading.setFont(new Font("Algerian",Font.PLAIN,40));
		add(heading);
		
		 add = new JButton("Add Students");
		add.setBounds(100,100,180,40);
		add.setFont(new Font("serif",Font.PLAIN,15));
		add.setForeground(Color.white);
		add.setBackground(Color.black);
		add(add);
		
		 dis = new JButton("Display");
		dis.setBounds(100,170,180,40);
		dis.setFont(new Font("serif",Font.PLAIN,15));
		dis.setForeground(Color.white);
		dis.setBackground(Color.black);
		add(dis);
		
		 update = new JButton("Update");
		update.setBounds(310,100,180,40);
		update.setFont(new Font("serif",Font.PLAIN,15));
		update.setForeground(Color.white);
		update.setBackground(Color.black);
		add(update);
		
		 del = new JButton("Delete");
		del.setBounds(310,170,180,40);
		del.setFont(new Font("serif",Font.PLAIN,15));
		del.setForeground(Color.white);
		del.setBackground(Color.black);
		add(del);
		
		add.addActionListener(this);
		dis.addActionListener(this);
		update.addActionListener(this);
		del.addActionListener(this);
		
	}
	

	public static void main(String[] args) {
		new Home();
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
			setVisible(false);
			new AddStudent();
		}
		else if(e.getSource()==dis) {
			setVisible(false);
			new Display("");
			
		}else if(e.getSource()==update) {
			setVisible(false);
			new Update("");
			
		}else if(e.getSource()==del) {
			setVisible(false);
			new Delete();
		}
	}

}
