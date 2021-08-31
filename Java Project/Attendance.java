import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Attendance{
	private JFrame Fr5 = new JFrame("Attendance Management System");
	
	public Attendance() {
	
		ImageIcon icon = new ImageIcon("student-portal-logo.jpg");
		Fr5.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("T2.png");
		JLabel L1 = new JLabel(imag);
		L1.setBounds(0, 0, 749, 335);
		Fr5.setLayout(null);
		Fr5.setBounds(100, 200, 764, 374);
		Fr5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fr5.setVisible(true);
		
		
		String[] yr = {"--Select--","1st","2nd", "3rd", "4th"};
		JComboBox year = new JComboBox(yr);
		year.setBounds(355,100,180,31);
		Fr5.add(year);
		
		String[] bra = {"--Select--","Computer Science","Mathematics", "Electrical Engineering", "BBA", "Eductaion", "English", "Physics", "Chemistry", "Biology", "BS Accounting", "Software Engineering"};
		JComboBox branch = new JComboBox(bra);
		branch.setBounds(355,142,180,31);
		Fr5.add(branch);
		
		String[] sm = {"--Select--","1st","2nd","3rd","4th","5th","6th","7th","8th"};
		JComboBox semster = new JComboBox(sm);
		semster.setBounds(355,184,180,31);
		Fr5.add(semster);
		
		Color clr = new Color(0,0,0,0);
		Font fnt3 = new Font("Microsoft Himalaya", Font.BOLD, 25 );
		
		JButton cls1 = new JButton("Close");
		cls1.setBounds(435,235,100,31);
		cls1.setFont(fnt3);
		Fr5.add(cls1);
		cls1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					Fr5.dispose();
				}catch(Exception ex){}	
			}
		});
		
		JButton sub = new JButton("Submit");
		sub.setBounds(220,237,100,31);
		sub.setFont(fnt3);
		Fr5.add(sub);
		sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				Connection con = null;
				Statement st  = null;
				ResultSet rs = null;
				try
				{
						String v1 = year.getSelectedItem().toString();
						String v2 = semster.getSelectedItem().toString();
						String v3 = branch.getSelectedItem().toString();
				
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						con = DriverManager.getConnection("jdbc:ucanaccess://StudentData.accdb");
						st = con.createStatement();
						int conut=0, b=0;
						rs = st.executeQuery("SELECT * FROM Student_Data");
						while(rs.next())
						{
							if((rs.getString(8).equals(v1)) && (rs.getString(9).equals(v3)) && (rs.getString(10).equals(v2)))
							{	
								conut++;
								b=1;	
							}
						}
						if(b==0)
						{
							JOptionPane.showMessageDialog(null, "Not exist data");
						}
						else
						{
								JOptionPane.showMessageDialog(null, "Submitted.");
								Fr5.dispose();
								
								new Attendance_Save(v1, v2, v3, conut);
								//System.out.println("Thank God");
						}	
						System.out.println(conut);	
		    	 }
		     	catch(Exception ex){}
			}
		});
		
		
		
		JButton home = new JButton("Home");
		home.setBounds(585,55,90,30);
		Font fnt5 = new Font("Microsoft Himalaya", Font.BOLD, 30 );
		home.setBorder(BorderFactory.createLineBorder(clr));
		home.setFont(fnt5);
		home.setForeground(new Color(255,255,255));
		home.setOpaque(false); // for textfield background 
		home.setBackground(new Color(0,0,0,0));
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Fr5.dispose();
				new Faculty_Login();
			}
		});
		Fr5.add(home);
		Fr5.add(L1);
	
	}
}