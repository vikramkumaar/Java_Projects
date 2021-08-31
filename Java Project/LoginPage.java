import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LoginPage {
	private JFrame Fr1 = new JFrame("Attendance Management System");
	
	public LoginPage() {
	
		ImageIcon icon = new ImageIcon("student-portal-logo.jpg");
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
		
		
		JButton af = new JButton("Add Faculty");
		af.setBounds(470,95,90,29);
		Font fnt2 = new Font("Microsoft Himalaya", Font.BOLD, 22 );
		af.setBorder(BorderFactory.createLineBorder(clr));
		af.setFont(fnt2);
		af.setForeground(new Color(255,255,255));
		af.setOpaque(false); // for textfield background 
		af.setBackground(new Color(0,0,0,0));
		Fr1.getContentPane().add(af);
		af.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					Fr1.dispose();
				//System.out.println("Called");
				new AddFaculty_Page();
				}catch(Exception ex){}
			}
		});
		
		JButton B2 = new JButton("Add Student");
		B2.setBounds(578,98,90,29);
		B2.setBorder(BorderFactory.createLineBorder(clr));
		B2.setFont(fnt2);
		B2.setForeground(new Color(255,255,255));
		B2.setOpaque(false); // for textfield background 
		B2.setBackground(new Color(0,0,0,0));
		Fr1.add(B2);
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					
				//System.out.println("Called");
				//System.out.println("Called");
				new AddStudent_Page();
				Fr1.dispose();
				}catch(Exception ex){}
			}
		});
		
		JButton B3 = new JButton("Add Subject");
		B3.setBounds(418,178,90,29);
		B3.setBorder(BorderFactory.createLineBorder(clr));
		B3.setFont(fnt2);
		B3.setForeground(new Color(255,255,255));
		B3.setOpaque(false); // for textfield background 
		B3.setBackground(new Color(0,0,0,0));
		Fr1.add(B3);
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					
				//System.out.println("Called");
				new Subject_Page();
				Fr1.dispose();
				}catch(Exception ex){}
			}
			
		});
		
		JButton B4 = new JButton("Close");
		B4.setBounds(522,178,90,29);
		B4.setBorder(BorderFactory.createLineBorder(clr));
		B4.setFont(fnt2);
		B4.setForeground(new Color(255,255,255));
		B4.setOpaque(false); // for textfield background 
		B4.setBackground(new Color(0,0,0,0));
		Fr1.add(B4);
		B4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Fr1.dispose();
			}
		});
		
		JButton B5 = new JButton("LogOut");
		B5.setBounds(629,178,90,30);
		B5.setBorder(BorderFactory.createLineBorder(clr));
		B5.setFont(fnt2);
		B5.setForeground(new Color(255,255,255));
		B5.setOpaque(false); // for textfield background 
		B5.setBackground(new Color(0,0,0,0));
		Fr1.getContentPane().add(B5);
		B5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				new MainPage();
				Fr1.dispose();
			}
		});
		
		Fr1.add(l1);
		
		Fr1.setResizable(false);
	}
}