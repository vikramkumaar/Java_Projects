import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class StudentLogin {
	private JFrame Fr3 = new JFrame("Attendance Management System");
	
	public StudentLogin(String iD) {
	
		ImageIcon icon = new ImageIcon("student-portal-logo.jpg");
		Fr3.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("S1.png");
		JLabel l1 = new JLabel(imag);
		l1.setBounds(0, 0, 749, 335);
		Fr3.setLayout(null);
		Fr3.setBounds(100, 200, 764, 374);
		Fr3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fr3.setVisible(true);
		
		Color clr = new Color(0,0,0,0);
		Font fnt = new Font("Microsoft Himalaya", Font.PLAIN, 28);
		
		
		JButton atten = new JButton("Attendance");
		atten.setBounds(30,85,90,30);
		Font fnt5 = new Font("Microsoft Himalaya", Font.BOLD, 25 );
		atten.setBorder(BorderFactory.createLineBorder(clr));
		atten.setFont(fnt5);
		atten.setForeground(new Color(255,255,255));
		atten.setOpaque(false); // for textfield background 
		atten.setBackground(new Color(0,0,0,0));
		Fr3.add(atten);
		atten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				try{ 
				System.out.println("Okay");
				Fr3.dispose();
				new ViewAttendance(iD);
				}catch(Exception ex){}
			}
		});
		
		JButton sub = new JButton("Subjects");
		sub.setBounds(132,85,90,30);
		sub.setBorder(BorderFactory.createLineBorder(clr));
		sub.setFont(fnt5);
		sub.setForeground(new Color(255,255,255));
		sub.setOpaque(false); // for textfield background 
		sub.setBackground(new Color(0,0,0,0));
		Fr3.add(sub);
		/*home..addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Fr3.dispose();
				new LoginPage();
			}
		});*/
		
		JButton cps = new JButton("Change PW");
		cps.setBounds(78,168,100,30);
		cps.setFont(fnt5);
		cps.setBorder(BorderFactory.createLineBorder(clr));
		cps.setForeground(new Color(255,255,255));
		cps.setOpaque(false); // for textfield background 
		cps.setBackground(clr);
		Fr3.add(cps);
		cps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
				System.out.println("Called");
				new Change_PW_2();
				Fr3.dispose();
				}catch(Exception ex){}
			}
		});
		
		JButton clo = new JButton("Close");
		clo.setBounds(29,248,90,30);
		clo.setFont(fnt5);
		clo.setBorder(BorderFactory.createLineBorder(clr));
		clo.setForeground(new Color(255,255,255));
		clo.setOpaque(false); // for textfield background 
		clo.setBackground(clr);
		Fr3.add(clo);
		clo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					Fr3.dispose();
				}catch(Exception ex){}	
			}
		});
		
		JButton B5 = new JButton("Logout");
		B5.setBounds(130,248,100,30);
		B5.setBorder(BorderFactory.createLineBorder(clr));
		B5.setFont(fnt5);
		B5.setForeground(new Color(255,255,255));
		B5.setOpaque(false); // for textfield background 
		B5.setBackground(new Color(0,0,0,0));
		Fr3.getContentPane().add(B5);
		B5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					Fr3.dispose();
				new MainPage();
				
				}catch(Exception ex){}
			}
		});
		
		Fr3.add(l1);
		
		Fr3.setResizable(false);
	}
}