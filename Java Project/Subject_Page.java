import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Subject_Page{
	
	private JFrame Fr4 = new JFrame("Attendance Management System");
	JTextField yr, sem1, sub1, sub2, sub3, sub4, sub5;
	
	public Subject_Page(){
	
		
		ImageIcon icon = new ImageIcon("student-portal-logo.jpg");
		Fr4.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("F3_3.png");
		JLabel l2 = new JLabel(imag);
		l2.setBounds(0, 0, 749, 335);
		Fr4.setLayout(null);
		Fr4.setBounds(100, 200, 764, 374);
		Fr4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fr4.setVisible(true);
		
		Color clr = new Color(0,0,0,0);
		Font fnt = new Font("Microsoft Himalaya", Font.PLAIN, 28);
		
		//TextField for Username...
		yr = new JTextField();
		yr.setBounds(150,69,220,30);
		yr.setOpaque(false); // for textfield background 
		yr.setBackground(clr); 
		yr.setForeground(Color.WHITE);
		yr.setBorder(BorderFactory.createLineBorder(clr));
		yr.setFont(fnt);
		yr.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(yr);
		
		sem1 = new JTextField();
		sem1.setBounds(150,99,220,30);
		sem1.setOpaque(false); // for textfield background 
		sem1.setBackground(clr); 
		sem1.setForeground(Color.WHITE);
		sem1.setBorder(BorderFactory.createLineBorder(clr));
		sem1.setFont(fnt);
		sem1.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(sem1);
		
		
		sub1 = new JTextField();
		sub1.setBounds(150,133,220,30);
		sub1.setOpaque(false); // for textfield background 
		sub1.setBackground(clr); 
		sub1.setForeground(Color.WHITE);
		sub1.setBorder(BorderFactory.createLineBorder(clr));
		sub1.setFont(fnt);
		sub1.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(sub1);
		
		sub2 = new JTextField();
		sub2.setBounds(150,166,220,30);
		sub2.setOpaque(false); // for textfield background 
		sub2.setBackground(clr); 
		sub2.setForeground(Color.WHITE);
		sub2.setBorder(BorderFactory.createLineBorder(clr));
		sub2.setFont(fnt);
		sub2.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(sub2);
		
		sub3 = new JTextField();
		sub3.setBounds(150,202,220,30);
		sub3.setOpaque(false); // for textfield background 
		sub3.setBackground(clr); 
		sub3.setForeground(Color.WHITE);
		sub3.setBorder(BorderFactory.createLineBorder(clr));
		sub3.setFont(fnt);
		sub3.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(sub3);
		
		sub4 = new JTextField();
		sub4.setBounds(150,236,220,30);
		sub4.setOpaque(false); // for textfield background 
		sub4.setBackground(clr); 
		sub4.setForeground(Color.WHITE);
		sub4.setBorder(BorderFactory.createLineBorder(clr));
		sub4.setFont(fnt);
		sub4.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(sub4);
		
		sub5 = new JTextField();
		sub5.setBounds(150,273,220,30);
		sub5.setOpaque(false); // for textfield background 
		sub5.setBackground(clr); 
		sub5.setForeground(Color.WHITE);
		sub5.setBorder(BorderFactory.createLineBorder(clr));
		sub5.setFont(fnt);
		sub5.setCaretColor(Color.WHITE); // For Cursur color
		Fr4.add(sub5);
		
		JButton sbm = new JButton("Save");
		sbm.setBounds(437,215,90,30);
		Font fnt2 = new Font("Microsoft Himalaya", Font.BOLD, 25 );
		sbm.setFont(fnt2);
		Fr4.add(sbm);
		sbm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				Connection con = null;
				Statement st  = null;
				ResultSet rs = null;
				try
				{
				
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						con = DriverManager.getConnection("jdbc:ucanaccess://SubjectsData.accdb");
						st = con.createStatement();

						
						if(yr.getText().trim().isEmpty() || sem1.getText().trim().isEmpty() ||  sub1.getText().trim().isEmpty() || sub2.getText().trim().isEmpty() || sub3.getText().trim().isEmpty() || sub4.getText().trim().isEmpty() || sub5.getText().trim().isEmpty() )
						{
							JOptionPane.showMessageDialog(null, "Incomplete Data");
						}
						else
						{
						String sql = "insert into Subjects_Data "
						+" ( yr, Sems, Subj1, Subj2, Subj3, Subj4, Subj5)"
						+" values('"+yr.getText()+"','"+sem1.getText()+"','"+sub1.getText()+"','"+sub2.getText()
						+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
						int ans = st.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Saved Data");
						clearField();
						}
						
				}
		     	catch(Exception ex)
		     	{
					//ex.printStackTrace()
					JOptionPane.showMessageDialog(null, "Subjects exist in this year");
				}			
		     	}
		});
		
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
	
	void clearField()
		{
			yr.setText(null);
			sem1.setText(null);
			sub1.setText(null);
			sub2.setText(null);
			sub3.setText(null);
			sub4.setText(null);
			sub5.setText(null);
		}
}