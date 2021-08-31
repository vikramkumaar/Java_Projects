import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SubjectPage {
	
	private JFrame Fr4 = new JFrame("Second");
	
	public SubjectPage(){
	
		/*f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,300);
		f.setVisible(true);*/
		
		//Fr1.setTitle("Attendance Management System");
		ImageIcon icon = new ImageIcon("student-portal-logo.png");
		Fr4.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("F5.png");
		JLabel l2 = new JLabel(imag);
		l2.setBounds(0, 0, 749, 335);
		Fr4.setLayout(null);
		Fr4.setBounds(100, 200, 764, 374);
		Fr4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fr4.setVisible(true);
		
		Color clr = new Color(0,0,0,0);
		Font fnt = new Font("Microsoft Himalaya", Font.PLAIN, 28);
		
		//TextField for Username...
		JTextField yr = new JTextField();
		yr.setBounds(150,69,220,30);
		yr.setOpaque(false); // for textfield background 
		yr.setBackground(clr); 
		yr.setForeground(Color.WHITE);
		yr.setBorder(BorderFactory.createLineBorder(clr));
		yr.setFont(fnt);
		yr.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(yr);
		
		JTextField sem1 = new JTextField();
		sem1.setBounds(150,99,220,30);
		sem1.setOpaque(false); // for textfield background 
		sem1.setBackground(clr); 
		sem1.setForeground(Color.WHITE);
		sem1.setBorder(BorderFactory.createLineBorder(clr));
		sem1.setFont(fnt);
		sem1.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(sem1);
		
		
		JTextField sub1 = new JTextField();
		sub1.setBounds(150,132,220,30);
		sub1.setOpaque(false); // for textfield background 
		sub1.setBackground(clr); 
		sub1.setForeground(Color.WHITE);
		sub1.setBorder(BorderFactory.createLineBorder(clr));
		sub1.setFont(fnt);
		sub1.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(sub1);
		
		JTextField sub2 = new JTextField();
		sub2.setBounds(150,165,220,30);
		sub2.setOpaque(false); // for textfield background 
		sub2.setBackground(clr); 
		sub2.setForeground(Color.WHITE);
		sub2.setBorder(BorderFactory.createLineBorder(clr));
		sub2.setFont(fnt);
		sub2.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(sub2);
		
		JTextField sub3 = new JTextField();
		sub3.setBounds(150,201,220,30);
		sub3.setOpaque(false); // for textfield background 
		sub3.setBackground(clr); 
		sub3.setForeground(Color.WHITE);
		sub3.setBorder(BorderFactory.createLineBorder(clr));
		sub3.setFont(fnt);
		sub3.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(sub3);
		
		JTextField sub4 = new JTextField();
		sub4.setBounds(150,235,220,30);
		sub4.setOpaque(false); // for textfield background 
		sub4.setBackground(clr); 
		sub4.setForeground(Color.WHITE);
		sub4.setBorder(BorderFactory.createLineBorder(clr));
		sub4.setFont(fnt);
		sub4.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(sub4);
		
		JTextField sub5 = new JTextField();
		sub5.setBounds(150,272,220,30);
		sub5.setOpaque(false); // for textfield background 
		sub5.setBackground(clr); 
		sub5.setForeground(Color.WHITE);
		sub5.setBorder(BorderFactory.createLineBorder(clr));
		sub5.setFont(fnt);
		sub5.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(sub5);
		
		JButton sbm = new JButton("Submit");
		sbm.setBounds(435,215,90,30);
		Font fnt2 = new Font("Microsoft Himalaya", Font.BOLD, 25 );
		sbm.setFont(fnt2);
		Fr4.add(sbm);
		
		JButton cen = new JButton("Close");
		cen.setBounds(635,215,90,30);
		cen.setFont(fnt2);
		Fr4.add(cen);
		cen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					Fr4.dispose();
				}catch(Exception ex){}	
			}
		});
	
	
		JButton home = new JButton("Home");
		home.setBounds(585,23,90,30);
		Font fnt5 = new Font("Microsoft Himalaya", Font.BOLD, 30 );
		home.setBorder(BorderFactory.createLineBorder(clr));
		home.setFont(fnt5);
		home.setForeground(new Color(255,255,255));
		home.setOpaque(false); // for textfield background 
		home.setBackground(new Color(0,0,0,0));
		Fr4.add(home);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Fr4.dispose();
				new LoginPage();
			}
		});
		
		Fr4.add(l2);
		Fr4.setResizable(false);
		
	}
}