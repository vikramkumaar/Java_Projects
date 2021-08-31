import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener
{
	Container c;
	static JTextField name; 
	static JPasswordField pswd;
	static JButton B1, Admin, std, tchr;
	static JFrame F1; 
	MyFrame()
	{
		c = this.getContentPane();
		c.setLayout(null);
		
		Color clr = new Color(0,0,0,0);
		Font fnt = new Font("Microsoft Himalaya", Font.PLAIN, 28);
		
		//TextField for Username...
		name = new JTextField();
		name.setBounds(248,70,98,30);
		name.setOpaque(false); // for textfield background 
		name.setBackground(new Color(0,0,0,0)); 
		name.setForeground(Color.WHITE);
		name.setBorder(BorderFactory.createLineBorder(clr));
		name.setFont(fnt);
		name.setCaretColor(Color.WHITE); // For Cursur color
		c.add(name);
		
		//TextField for Password....
		pswd = new JPasswordField();
		pswd.setBounds(250,93,95,30);
		pswd.setBackground(clr);
		pswd.setOpaque(false); // for textfield background 
		pswd.setBackground(new Color(0,0,0,0));
		pswd.setForeground(Color.WHITE);
		pswd.setBorder(BorderFactory.createLineBorder(clr));
		pswd.setFont(fnt);
		pswd.setCaretColor(Color.WHITE);
		c.add(pswd);
		
		
		B1 = new JButton("LOGIN");
		B1.setBounds(230,126,90,28);
		Font fnt2 = new Font("Microsoft Himalaya", Font.BOLD, 20 );
		B1.setBorder(BorderFactory.createLineBorder(clr));
		B1.setFont(fnt2);
		B1.setForeground(new Color(255,255,255));
		B1.setOpaque(false); // for textfield background 
		B1.setBackground(new Color(0,0,0,0));
		c.add(B1);
		//B1.addActionListener(this);
		
		//F1.add(l1);
		
		Admin = new JButton("Admin");
		Admin.setBounds(640,220,90,27);
		Font fnt3 = new Font("Microsoft Himalaya", Font.BOLD, 28 );
		Admin.setBorder(BorderFactory.createLineBorder(clr));
		Admin.setFont(fnt3);
		Admin.setForeground(new Color(255,255,255));
		Admin.setOpaque(false); // for textfield background 
		Admin.setBackground(new Color(0,0,0,0));
		c.add(Admin);
		
		//eventHandler obj = new eventHandler(name, pswd);
		Admin.addActionListener(this);
		
		tchr = new JButton("Faculty");
		tchr.setBounds(640,255,90,27);
		Font fnt4 = new Font("Microsoft Himalaya", Font.BOLD, 28 );
		tchr.setBorder(BorderFactory.createLineBorder(clr));
		tchr.setFont(fnt4);
		tchr.setForeground(new Color(255,255,255));
		tchr.setOpaque(false); // for textfield background 
		tchr.setBackground(new Color(0,0,0,0));
		c.add(tchr);
		
		std = new JButton("Student");
		std.setBounds(640,295,90,27);
		Font fnt5 = new Font("Microsoft Himalaya", Font.BOLD, 28 );
		std.setBorder(BorderFactory.createLineBorder(clr));
		std.setFont(fnt5);
		std.setForeground(new Color(255,255,255));
		std.setOpaque(false); // for textfield background 
		std.setBackground(new Color(0,0,0,0));
		c.add(std);
		
		/*btn1 = new JButton("Red");
		btn1.setBounds(100,50,90,50);
		
		btn2 = new JButton("Yellow");
		btn2.setBounds(200,50,90,50);
		
		c.add(btn1);
		c.add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);*/
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==Admin)
		{
			String user_name = name.getText();
			String pass_word = pswd.getText();
			
			try
		    {
				if(user_name.equals("051-18-0017") && pass_word.equals("12345"))
				{
				//JOptionPane.showMessageDialog(F1,"You are successfully login");
				
				Admin_Menu AM = new Admin_Menu();
			//AM.menuPage();
				AM.setVisible(true);
			//c.dispose();
				}
				
				else
				{
				JOptionPane.showMessageDialog(F1,"You are not successfully login");
				}
			}
		    catch(Exception ex)
		    {
		    }
			
		}
	}
}

public class LoginForm
{
	public static void main(String abc[])
	{
		MyFrame fram = new MyFrame();
		fram.setVisible(true);
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fram.setTitle("Student Portal");
		ImageIcon icon = new ImageIcon("student-portal-logo.png");
		fram.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("F1.png");
		JLabel l1 = new JLabel(imag);
		l1.setBounds(0, 0, 749, 335);
		fram.setLayout(null);
		fram.setBounds(100, 200, 764, 374);
		fram.add(l1);
		
		fram.setResizable(false);
	}
}