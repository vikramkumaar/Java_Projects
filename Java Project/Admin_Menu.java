import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Admin_Menu
{
	static JTextField name; 
	static JPasswordField pswd;
	static JButton B1, B2, B3, B4, B5;
	static JFrame Fr1; 
	public Admin_Menu()
	{
		Fr1 = new JFrame();
		Fr1.setTitle("Attendance Management System");
		ImageIcon icon = new ImageIcon("student-portal-logo.png");
		Fr1.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("F2.png");
		JLabel l1 = new JLabel(imag);
		l1.setBounds(0, 0, 749, 335);
		Fr1.setLayout(null);
		Fr1.setBounds(100, 200, 764, 374);
		Fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fr1.setVisible(true);

		Color clr = new Color(0,0,0,0);
		Font fnt = new Font("Microsoft Himalaya", Font.PLAIN, 28);
		
		
		B1 = new JButton("Add Faculty");
		B1.setBounds(480,95,90,28);
		Font fnt2 = new Font("Microsoft Himalaya", Font.BOLD, 22 );
		B1.setBorder(BorderFactory.createLineBorder(clr));
		B1.setFont(fnt2);
		B1.setForeground(new Color(255,255,255));
		B1.setOpaque(false); // for textfield background 
		B1.setBackground(new Color(0,0,0,0));
		Fr1.add(B1);
		//B1.addActionListener(this);
		
		B2 = new JButton("Add Student");
		B2.setBounds(590,95,90,28);
		B2.setBorder(BorderFactory.createLineBorder(clr));
		B2.setFont(fnt2);
		B2.setForeground(new Color(255,255,255));
		B2.setOpaque(false); // for textfield background 
		B2.setBackground(new Color(0,0,0,0));
		Fr1.add(B2);
		//B1.addActionListener(this);
		
		B3 = new JButton("Add Subject");
		B3.setBounds(423,178,90,28);
		B3.setBorder(BorderFactory.createLineBorder(clr));
		B3.setFont(fnt2);
		B3.setForeground(new Color(255,255,255));
		B3.setOpaque(false); // for textfield background 
		B3.setBackground(new Color(0,0,0,0));
		Fr1.add(B3);
		//B1.addActionListener(this);
		
		B4 = new JButton("Home");
		B4.setBounds(533,178,90,28);
		B4.setBorder(BorderFactory.createLineBorder(clr));
		B4.setFont(fnt2);
		B4.setForeground(new Color(255,255,255));
		B4.setOpaque(false); // for textfield background 
		B4.setBackground(new Color(0,0,0,0));
		Fr1.add(B4);
		//B1.addActionListener(this);
		
		B5 = new JButton("LogOut");
		B5.setBounds(643,178,90,28);
		B5.setBorder(BorderFactory.createLineBorder(clr));
		B5.setFont(fnt2);
		B5.setForeground(new Color(255,255,255));
		B5.setOpaque(false); // for textfield background 
		B5.setBackground(new Color(0,0,0,0));
		Fr1.add(B5);
		//B1.addActionListener(this);
		
		Fr1.add(l1);
		
		Fr1.setResizable(false);
	}
}

class eventHandler implements ActionListener{
	public void actionPerformed(ActionEvent ae)
	{
		
		/*if(ae.getSource()==Admin)
		{
			String ID="051-180017";
			String pw="12345";
			String user_name = name.getText();
			String pass_word = pswd.getText();
			if(user_name.equals("051-18-0017") && pass_word.equals("12345"))
			{
				F1.setBackground(Color.GREEN);
				F1.remove(wrn);
			}
			else
			{
				F1.setBackground(Color.GREEN);
				wrn.setBounds(80,360,300,50);
				wrn.setFont(f1);
			}
		}*/
	}
}	