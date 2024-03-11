import java.awt.Color;
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	
	JTextField untxt,pwdtxt;
	
	Login(){
		
		getContentPane().setBackground(Color.yellow);
		setLayout(null);
		
		JLabel username = new JLabel("Username");
		username.setBounds(40, 20, 100, 30);
		username.setFont(new Font("Serif",Font.PLAIN,16));
		add(username);
		
		untxt = new JTextField(10);
		untxt.setBounds(150,20,150,30);
		add(untxt);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(40, 70, 100, 30);
		pass.setFont(new Font("Serif",Font.PLAIN,16));
		add(pass);
		
		pwdtxt = new JTextField(10);
		pwdtxt.setBounds(150,70,150,30);
		add(pwdtxt);
		
		JButton login = new JButton("Login");
		login.setBounds(40,130,100,30);
		login.setBackground(Color.green);
		login.setFont(new Font("Times new Romen",Font.BOLD,16));
		login.setForeground(Color.white);
		add(login);
		login.addActionListener(this);
		setBounds(400,200,500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Login();

	}

	public void actionPerformed(ActionEvent e) {
		try {
			String uname,passwd;
			uname = untxt.getText();
			passwd = pwdtxt.getText();
			
			conn c = new conn();
			String query = "select * from login where username= '"+uname+"' and password = '"+passwd+"'";
			
			ResultSet rs = c.s.executeQuery(query);
			
			if(rs.next()) {
				setVisible(false);
				new Home();
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Username or Password");
				setVisible(false);
			}
			
		}catch(Exception ae) {
			ae.printStackTrace();
		}
		
		
	}

}
