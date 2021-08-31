import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Faculty_Login {
	private JFrame Fr5 = new JFrame("Attendance Management System");
	
	public Faculty_Login() {
	
		ImageIcon icon = new ImageIcon("student-portal-logo.jpg");
		Fr5.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("T11.png");
		JLabel L1 = new JLabel(imag);
		L1.setBounds(0, 0, 749, 335);
		Fr5.setLayout(null);
		Fr5.setBounds(100, 200, 764, 374);
		Fr5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fr5.setVisible(true);
		
		
		Color clr = new Color(0,0,0,0);
		Font fnt3 = new Font("Microsoft Himalaya", Font.BOLD, 25 );
		
		JButton ave = new JButton("Change PW");
		ave.setBounds(535,185,90,30);
		ave.setFont(fnt3);
		ave.setBorder(BorderFactory.createLineBorder(clr));
		ave.setForeground(new Color(255,255,255));
		ave.setOpaque(false); // for textfield background 
		ave.setBackground(clr);
		Fr5.add(ave);
		ave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				System.out.println("Called");
				new Change_PW();
				Fr5.dispose();
			}
		});

		
		JButton LO = new JButton("Logout");
		LO.setBounds(427,225,90,30);
		LO.setFont(fnt3);
		LO.setBorder(BorderFactory.createLineBorder(clr));
		LO.setForeground(new Color(255,255,255));
		LO.setOpaque(false); // for textfield background 
		LO.setBackground(clr);
		Fr5.add(LO);
		LO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				new MainPage();
				Fr5.dispose();
			}
		});
		
		
		JButton cls1 = new JButton("Close");
		cls1.setBounds(317,267,90,30);
		cls1.setFont(fnt3);
		cls1.setBorder(BorderFactory.createLineBorder(clr));
		cls1.setForeground(new Color(255,255,255));
		cls1.setOpaque(false); // for textfield background 
		cls1.setBackground(clr);
		Fr5.add(cls1);
		cls1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					Fr5.dispose();
				}catch(Exception ex){}	
			}
		});
	
	
		JButton atten = new JButton("Attendance");
		atten.setBounds(632,143,100,30);
		atten.setBorder(BorderFactory.createLineBorder(clr));
		atten.setFont(fnt3);
		atten.setForeground(new Color(255,255,255));
		atten.setOpaque(false); // for textfield background 
		atten.setBackground(clr);
		atten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//System.out.println("Inside atten button");
				Fr5.dispose();
				new Attendance();
			}
		});
		Fr5.add(atten);
		
		Fr5.add(L1);
	
	}
}