import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Change_PW{
	private JFrame Fr5 = new JFrame("Attendance Management System");
	private JPasswordField pas1, pas2;
	private JTextField ID;
	Connection con = null;
	Statement st  = null;
	ResultSet rs = null;
	PreparedStatement ps=null;
	
	public Change_PW() {
	
		ImageIcon icon = new ImageIcon("student-portal-logo.jpg");
		Fr5.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("T4_1.png");
		JLabel L1 = new JLabel(imag);
		L1.setBounds(0, 0, 749, 335);
		Fr5.setLayout(null);
		Fr5.setBounds(100, 200, 764, 374);
		Fr5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fr5.setVisible(true);
		
		Color clr = new Color(0,0,0,0);
		Font fnt3 = new Font("Microsoft Himalaya", Font.BOLD, 25 );
		
		ID = new JTextField();
		ID.setBounds(311,90,220,30);
		ID.setBackground(clr);
		ID.setOpaque(false); // for textfield background 
		ID.setBackground(new Color(0,0,0,0));
		ID.setForeground(Color.WHITE);
		ID.setBorder(BorderFactory.createLineBorder(clr));
		ID.setFont(fnt3);
		ID.setCaretColor(Color.WHITE);
		Fr5.add(ID);
		
		pas1 = new JPasswordField();
		pas1.setBounds(311,128,220,30);
		pas1.setBackground(clr);
		pas1.setOpaque(false); // for textfield background 
		pas1.setBackground(new Color(0,0,0,0));
		pas1.setForeground(Color.WHITE);
		pas1.setBorder(BorderFactory.createLineBorder(clr));
		pas1.setFont(fnt3);
		pas1.setCaretColor(Color.WHITE);
		Fr5.add(pas1);
		
		pas2 = new JPasswordField();
		pas2.setBounds(311,166,220,30);
		pas2.setBackground(clr);
		pas2.setOpaque(false); // for textfield background 
		pas2.setBackground(new Color(0,0,0,0));
		pas2.setForeground(Color.WHITE);
		pas2.setBorder(BorderFactory.createLineBorder(clr));
		pas2.setFont(fnt3);
		pas2.setCaretColor(Color.WHITE);
		Fr5.add(pas2);
		
		
		JButton cls1 = new JButton("Close");
		cls1.setBounds(444,215,90,31);
		cls1.setFont(fnt3);
		Fr5.add(cls1);
		cls1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					Fr5.dispose();
				}catch(Exception ex){}	
			}
		});
		
		JButton sub = new JButton("Update");
		sub.setBounds(144,215,90,31);
		sub.setFont(fnt3);
		Fr5.add(sub);
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				//System.out.println("p1 ="+p1+",  p3 ="+p3+", iD ="+iD);
				try
				{
						
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						con = DriverManager.getConnection("jdbc:ucanaccess://TeacherData.accdb");
						String p1 = pas1.getText(), iD = ID.getText(), p2="";
						String p3 = pas2.getText();
						st = con.createStatement();
						rs = st.executeQuery("SELECT * FROM Teacher_Data");
						
						while(rs.next())
						{
							p2 = rs.getString(2);
							if(p1.equals(p2))
							{
								ps = con.prepareStatement("UPDATE Teacher_Data SET password = ? where id="+iD);
								ps.setString(2,p3);
								ps.executeUpdate();
								JOptionPane.showMessageDialog(null,"Password Changed");
							}	
						}
				}catch(Exception ex){/* JOptionPane.showMessageDialog(null,"Please check your Password Again");*/ }
			}
		});
		
		JButton home = new JButton("Home");
		home.setBounds(585,30,90,30);
		Font fnt5 = new Font("Microsoft Himalaya", Font.BOLD, 30 );
		home.setBorder(BorderFactory.createLineBorder(clr));
		home.setFont(fnt5);
		home.setForeground(new Color(255,255,255));
		home.setOpaque(false); // for textfield background 
		home.setBackground(new Color(0,0,0,0));
		Fr5.add(home);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
				Fr5.dispose();
				new Faculty_Login();
				}catch(Exception ex){}
			}
		});
		Fr5.add(L1);
		Fr5.setResizable(false);
	
	}
}