import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Splash extends JFrame implements ActionListener {

    Splash() {
        getContentPane().setBackground(Color.gray);
        setLayout(null);

        JLabel head = new JLabel("STUDENT MANAGEMENT SYSTEM");
        head.setBounds(100, 50, 800, 40);
        head.setFont(new Font("Algerian", Font.PLAIN, 50));

        setBounds(250, 100, 1000, 350);
        setVisible(true);

        add(head);

        try {
//          
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton clickhere = new JButton("NEXT");
        clickhere.setBounds(400, 140, 100, 50);
        clickhere.setBackground(Color.black);
        clickhere.setFont(new Font("Times new Roman", Font.BOLD, 16));
        clickhere.setForeground(Color.white);
        clickhere.addActionListener(this);
        add(clickhere);
    }

    public static void main(String[] args) {
        new Splash();
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}
