import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddFaculty_Page{
	private JFrame Fr3 = new JFrame("Attendance Management System");
	JTextField name, email, id, dep, mob;
	JPasswordField pswd;
	
	public AddFaculty_Page(){
		
		ImageIcon icon = new ImageIcon("student-portal-logo.jpg");
		Fr3.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("F3_1.png");
		JLabel l1 = new JLabel(imag);
		l1.setBounds(0, 0, 749, 335);
		Fr3.setLayout(null);
		Fr3.setBounds(100, 200, 764, 374);
		Fr3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fr3.setVisible(true);
		
		Color clr = new Color(0,0,0,0);
		Font fnt = new Font("Microsoft Himalaya", Font.PLAIN, 28);
		
		//TextField for Username...
		name = new JTextField();
		name.setBounds(230,81,220,30);
		name.setOpaque(false); // for textfield background 
		name.setBackground(new Color(0,0,0,0)); 
		name.setForeground(Color.WHITE);
		name.setBorder(BorderFactory.createLineBorder(clr));
		name.setFont(fnt);
		name.setCaretColor(Color.WHITE); // For Cursur color
		Fr3.add(name);
		
		 //TextField for Password....
		pswd = new JPasswordField();
		pswd.setBounds(230,112,220,30);
		pswd.setBackground(clr);
		pswd.setOpaque(false); // for textfield background 
		pswd.setBackground(new Color(0,0,0,0));
		pswd.setForeground(Color.WHITE);
		pswd.setBorder(BorderFactory.createLineBorder(clr));
		pswd.setFont(fnt);
		pswd.setCaretColor(Color.WHITE);
		Fr3.add(pswd);
		
		email = new JTextField();
		email.setBounds(230,144,220,30);
		email.setOpaque(false); // for textfield background 
		email.setBackground(new Color(0,0,0,0)); 
		email.setForeground(Color.WHITE);
		email.setBorder(BorderFactory.createLineBorder(clr));
		email.setFont(fnt);
		email.setCaretColor(Color.WHITE); // For Cursur color
		Fr3.add(email);
		
		id = new JTextField();
		id.setBounds(230,176,220,30);
		id.setOpaque(false); // for textfield background 
		id.setBackground(new Color(0,0,0,0)); 
		id.setForeground(Color.WHITE);
		id.setBorder(BorderFactory.createLineBorder(clr));
		id.setFont(fnt);
		id.setCaretColor(Color.WHITE); // For Cursur color
		Fr3.add(id);
		
		dep = new JTextField();
		dep.setBounds(230,207,220,30);
		dep.setOpaque(false); // for textfield background 
		dep.setBackground(new Color(0,0,0,0)); 
		dep.setForeground(Color.WHITE);
		dep.setBorder(BorderFactory.createLineBorder(clr));
		dep.setFont(fnt);
		dep.setCaretColor(Color.WHITE); // For Cursur color
		Fr3.add(dep);
		
		mob = new JTextField();
		mob.setBounds(230,238,220,30);
		mob.setOpaque(false); // for textfield background 
		mob.setBackground(new Color(0,0,0,0)); 
		mob.setForeground(Color.WHITE);
		mob.setBorder(BorderFactory.createLineBorder(clr));
		mob.setFont(fnt);
		mob.setCaretColor(Color.WHITE); // For Cursur color
		Fr3.add(mob);
		
		JButton sbm = new JButton("Submit");
		sbm.setBounds(111,278,90,30);
		Font fnt2 = new Font("Microsoft Himalaya", Font.BOLD, 25 );
		sbm.setFont(fnt2);
		Fr3.add(sbm);
		sbm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				Connection con = null;
				Statement st  = null;
				ResultSet rs = null;
				try
				{
				
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						con = DriverManager.getConnection("jdbc:ucanaccess://TeacherData.accdb");
						st = con.createStatement();
						
						//rs = st.executeQuery("SELECT * FROM StudentTable");
						
						if(name.getText().trim().isEmpty() || id.getText().trim().isEmpty() ||  email.getText().trim().isEmpty() || pswd.getText().trim().isEmpty() || mob.getText().trim().isEmpty() )
						{
							JOptionPane.showMessageDialog(null, "Incomplete Data");
						}
						else
						{
						String sql = "insert into Teacher_Data "
						+" (Tname, password, email, id, Dep, mobile)"
						+" values('"+name.getText()+"','"+pswd.getText()+"','"+email.getText()+"','"+id.getText()
						+"','"+dep.getText()+"','"+mob.getText()+"')";
						int ans = st.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Saved Data");
						clearField();
						}
						
				}
		     	catch(Exception ex)
		     	{
					//ex.printStackTrace()
					JOptionPane.showMessageDialog(null, "Use different Id");
				}			
		     	}
		});
		
		JButton cen = new JButton("Close");
		cen.setBounds(375,280,90,30);
		cen.setFont(fnt2);
		Fr3.add(cen);
		cen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					Fr3.dispose();
				}catch(Exception ex){}	
			}
		});
	
	
		JButton home = new JButton("Home");
		home.setBounds(586,24,90,30);
		Font fnt5 = new Font("Microsoft Himalaya", Font.BOLD, 30 );
		home.setBorder(BorderFactory.createLineBorder(clr));
		home.setFont(fnt5);
		home.setForeground(new Color(255,255,255));
		home.setOpaque(false); // for textfield background 
		home.setBackground(new Color(0,0,0,0));
		Fr3.getContentPane().add(home);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					Fr3.dispose();
					new LoginPage();
				}catch(Exception ex){}
			}
		});
		
		Fr3.add(l1);
		Fr3.setResizable(false);
	}
	
	 void clearField()
		{
			name.setText(null);
			pswd.setText(null);
			email.setText(null);
			id.setText(null);
			dep.setText(null);
			mob.setText(null);
		}
}
