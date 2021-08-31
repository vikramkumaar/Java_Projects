import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddStudent_Page{
	private JFrame Fr3 = new JFrame("Forth");
	 JTextField name, mail, Id, dte, mob, year,sem; 
	 JPasswordField pswd;
	
	public AddStudent_Page()
	{
		Fr3 = new JFrame();
		Fr3.setTitle("Attendance Management System");
		ImageIcon icon = new ImageIcon("student-portal-logo.jpg");
		Fr3.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("F3_2.png");
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
		name.setBounds(150,75,220,30);
		name.setOpaque(false); // for textfield background 
		name.setBackground(new Color(0,0,0,0)); 
		name.setForeground(Color.WHITE);
		name.setBorder(BorderFactory.createLineBorder(clr));
		name.setFont(fnt);
		name.setCaretColor(Color.WHITE); // For Cursur color
		Fr3.add(name);
		
		 Id = new JTextField();
		Id.setBounds(150,107,220,30);
		Id.setOpaque(false); // for textfield background 
		Id.setBackground(new Color(0,0,0,0)); 
		Id.setForeground(Color.WHITE);
		Id.setBorder(BorderFactory.createLineBorder(clr));
		Id.setFont(fnt);
		Id.setCaretColor(Color.WHITE); // For Cursur color
		Fr3.add(Id);
		
		mail = new JTextField();
		mail.setBounds(150,139,220,30);
		mail.setOpaque(false); // for textfield background 
		mail.setBackground(new Color(0,0,0,0)); 
		mail.setForeground(Color.WHITE);
		mail.setBorder(BorderFactory.createLineBorder(clr));
		mail.setFont(fnt);
		mail.setCaretColor(Color.WHITE); // For Cursur color
		Fr3.add(mail);
		
		 //TextField for Password....
		pswd = new JPasswordField();
		pswd.setBounds(150,174,220,30);
		pswd.setBackground(clr);
		pswd.setOpaque(false); // for textfield background 
		pswd.setBackground(new Color(0,0,0,0));
		pswd.setForeground(Color.WHITE);
		pswd.setBorder(BorderFactory.createLineBorder(clr));
		pswd.setFont(fnt);
		pswd.setCaretColor(Color.WHITE);
		Fr3.add(pswd);
		
		mob = new JTextField();
		mob.setBounds(150,209,220,30);
		mob.setOpaque(false); // for textfield background 
		mob.setBackground(new Color(0,0,0,0)); 
		mob.setForeground(Color.WHITE);
		mob.setBorder(BorderFactory.createLineBorder(clr));
		mob.setFont(fnt);
		mob.setCaretColor(Color.WHITE); // For Cursur color
		Fr3.add(mob);
		
		dte = new JTextField();
		dte.setBounds(150,240,220,30);
		dte.setOpaque(false); // for textfield background 
		dte.setBackground(new Color(0,0,0,0)); 
		dte.setForeground(Color.WHITE);
		dte.setBorder(BorderFactory.createLineBorder(clr));
		dte.setFont(fnt);
		dte.setCaretColor(Color.WHITE); // For Cursur color
		Fr3.add(dte);
		
		JRadioButton male = new JRadioButton("Male");
		male.setBounds(150,282,100,30);
		male.setOpaque(false);
		male.setBackground(clr);
		male.setFont(fnt);
		male.setForeground(Color.WHITE);
		Fr3.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setBounds(250,282,100,30);
		female.setOpaque(false);
		female.setBackground(clr);
		female.setFont(fnt);
		female.setForeground(Color.WHITE);
		Fr3.add(female);
		
		ButtonGroup g = new ButtonGroup();
		g.add(male);
		g.add(female);
		
		
		
		year = new JTextField();
		year.setBounds(505,82,220,30);
		year.setOpaque(false); // for textfield background 
		year.setBackground(clr); 
		year.setForeground(new Color(255,255,255));
		year.setBorder(BorderFactory.createLineBorder(clr));
		year.setFont(fnt);
		year.setCaretColor(Color.WHITE); // For Cursur color
		Fr3.add(year);
		
		String[] mo = {"--Select--","Software Engineering","Computer Science","Mathematics", "Electrical Engineering", "BBA", "Eductaion", "BS Accounting"};
		JComboBox month = new JComboBox(mo);
		month.setBounds(505,118,225,35);
		Fr3.add(month);
		
		
		sem = new JTextField();
		sem.setBounds(505,155,220,30);
		sem.setOpaque(false); // for textfield background 
		sem.setBackground(clr); 
		sem.setForeground(new Color(255,255,255));
		sem.setBorder(BorderFactory.createLineBorder(clr));
		sem.setFont(fnt);
		sem.setCaretColor(Color.WHITE); // For Cursur color
		Fr3.add(sem);
		
		JButton sbm = new JButton("Submit");
		sbm.setBounds(420,250,90,30);
		Font fnt2 = new Font("Microsoft Himalaya", Font.BOLD, 25 );
		sbm.setFont(fnt2);
		Fr3.add(sbm);
		sbm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				Connection con = null;
				Statement st  = null;
				ResultSet rs = null;
				String value = "";
				if(male.isSelected())
				{
					value = male.getText();
				}
				else
				{
					value = female.getText();
				}			
				String val1 = month.getSelectedItem().toString();
				
				try
				{
				
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						con = DriverManager.getConnection("jdbc:ucanaccess://StudentData.accdb");
						st = con.createStatement();
						
						//rs = st.executeQuery("SELECT * FROM StudentTable");
						
						if(name.getText().trim().isEmpty() || Id.getText().trim().isEmpty() ||  mail.getText().trim().isEmpty() || pswd.getText().trim().isEmpty() || sem.getText().trim().isEmpty() || dte.getText().trim().isEmpty() || mob.getText().trim().isEmpty() || value.trim().isEmpty() || val1.trim().isEmpty() || year.getText().trim().isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Incomplete Data");
						}
						else
						{
						String sql = "insert into Student_Data "
						+" (fname, id, email, pswd, mobile, dob, gen, yr, depart, semseter)"
						+" values('"+name.getText()+"','"+Id.getText()+"','"+mail.getText()+"','"+pswd.getText()
						+"','"+mob.getText()+"','"+dte.getText()+"','"+value+"','"+year.getText()+"', '"+val1+"','"+sem.getText()+"')";
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
		cen.setBounds(633,250,90,30);
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
		home.setBounds(590,23,90,30);
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
			Id.setText(null);
			mail.setText(null);
			pswd.setText(null);
			mob.setText(null);
			dte.setText(null);
			year.setText(null);
			sem.setText(null);
		}
}