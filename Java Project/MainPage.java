import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MainPage{
	private JFrame F1 = new JFrame("LoginPage");
	private JButton admin = new JButton("Admin");
	private JButton fac = new JButton("Faculty");
	private JButton stdt = new JButton("Student");
	
	public MainPage(){
	
		
		F1.setTitle("Attendance Management System");
		ImageIcon icon = new ImageIcon("student-portal-logo.jpg");
		F1.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("MF1.png");
		JLabel l1 = new JLabel(imag);
		l1.setBounds(0, 0, 749, 335);
		F1.setLayout(null);
		F1.setBounds(100, 200, 764, 374);
		F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F1.setVisible(true);;
		
		Color clr = new Color(0,0,0,0);
		Font fnt = new Font("Microsoft Himalaya", Font.PLAIN, 28);
		
		//TextField for Username...
		JTextField name = new JTextField();
		name.setBounds(232,80,98,30);
		name.setOpaque(false); // for textfield background 
		name.setBackground(new Color(0,0,0,0)); 
		name.setForeground(Color.WHITE);
		name.setBorder(BorderFactory.createLineBorder(clr));
		name.setFont(fnt);
		name.setCaretColor(Color.WHITE); // For Cursur color
		F1.add(name);
		
		//TextField for Password....
		JPasswordField pswd = new JPasswordField();
		pswd.setBounds(233,111,95,30);
		pswd.setBackground(clr);
		pswd.setOpaque(false); // for textfield background 
		pswd.setBackground(new Color(0,0,0,0));
		pswd.setForeground(Color.WHITE);
		pswd.setBorder(BorderFactory.createLineBorder(clr));
		pswd.setFont(fnt);
		pswd.setCaretColor(Color.WHITE);
		F1.add(pswd);
		
		
		admin.setBounds(517,190,90,30);
		Font fnt3 = new Font("Microsoft Himalaya", Font.BOLD, 28 );
		admin.setBorder(BorderFactory.createLineBorder(clr));
		admin.setFont(fnt3);
		admin.setForeground(new Color(255,255,255));
		admin.setOpaque(false); // for textfield background 
		admin.setBackground(new Color(0,0,0,0));
		F1.getContentPane().add(admin);
		
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				String name1 = name.getText();
				String pass = pswd.getText();
				if(name1.equals("vik") && pass.equals("123"))
				{
						try{
							JOptionPane.showMessageDialog(null, "Succefully login.");
							F1.dispose();
							new LoginPage();
						   }
					    catch(Exception ex){}
				}
				else if(name.getText().trim().isEmpty() || pswd.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Something is unfilled");
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Invalid ID or Password", "Invalid", JOptionPane.INFORMATION_MESSAGE);
				}
		}
		});
		
		fac.setBounds(620,190,90,30);
		fac.setBorder(BorderFactory.createLineBorder(clr));
		fac.setFont(fnt3);
		fac.setForeground(new Color(255,255,255));
		fac.setOpaque(false); // for textfield background 
		fac.setBackground(new Color(0,0,0,0));
		F1.getContentPane().add(fac);
		
		fac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				String name1 = name.getText();
				String pass = pswd.getText();
				
				Connection con = null;
				Statement st  = null;
				ResultSet rs = null;
				try
				{
						String iD ="";
						String ps ="";
				
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						con = DriverManager.getConnection("jdbc:ucanaccess://TeacherData.accdb");
						st = con.createStatement();
						rs = st.executeQuery("SELECT * FROM Teacher_Data");
						while(rs.next())
						{
							iD = rs.getString(4);
							ps = rs.getString(2);
							
							if( pass.equals(ps) && name1.equals(iD) )
							{
								JOptionPane.showMessageDialog(null, "Succefully login.");
								F1.dispose();
								new Faculty_Login();
							}
							else if(name.getText().trim().isEmpty() || pswd.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Something is unfilled");
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Invalid ID or Password", "Invalid", JOptionPane.INFORMATION_MESSAGE);
				}
						}
				rs.close();		
						
				}catch(Exception ex){JOptionPane.showMessageDialog(null, "Invalid ID or Password", "Invalid", JOptionPane.INFORMATION_MESSAGE);}
			
		}
		});
		
		stdt.setBounds(568,280,90,30);
		stdt.setBorder(BorderFactory.createLineBorder(clr));
		stdt.setFont(fnt3);
		stdt.setForeground(new Color(255,255,255));
		stdt.setOpaque(false); // for textfield background 
		stdt.setBackground(new Color(0,0,0,0));
		F1.getContentPane().add(stdt);
		stdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				String name1 = name.getText();
				String pass = pswd.getText();
				
				Connection con = null;
				Statement st  = null;
				ResultSet rs = null;
				try
				{
						String iD ="";
						String ps ="";
				
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						con = DriverManager.getConnection("jdbc:ucanaccess://StudentData.accdb");
						st = con.createStatement();
						rs = st.executeQuery("SELECT * FROM Student_Data");
						while(rs.next())
						{
							iD = rs.getString(2);
							ps = rs.getString(4);
							
							if( pass.equals(ps) && name1.equals(iD) )
							{
								JOptionPane.showMessageDialog(null, "Succefully login.");
								F1.dispose();
								new StudentLogin(iD);
							}
						}
						
				}catch(Exception ex){JOptionPane.showMessageDialog(null, "Invalid ID or Password", "Invalid", JOptionPane.INFORMATION_MESSAGE);}
			
		}
		});
		
		JButton clo = new JButton("Exit");
		clo.setBounds(31,37,90,30);
		clo.setFont(fnt3);
		clo.setBorder(BorderFactory.createLineBorder(clr));
		clo.setForeground(new Color(255,255,255));
		clo.setOpaque(false); // for textfield background 
		clo.setBackground(clr);
		F1.add(clo);
		clo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae)
			{
				F1.dispose();
			}
		});
		
		
		F1.add(l1);
		F1.setResizable(false);
	}
	
	public static void main(String[] args) {
		new MainPage();
	}
}