import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.util.Date;

public class ViewAttendance{
	private JFrame Fr5 = new JFrame("Attendance Management System");
	private JTextField dte;
	
	public ViewAttendance(String ID){
	
		ImageIcon icon = new ImageIcon("student-portal-logo.jpg");
		Fr5.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("S3.png");
		JLabel L1 = new JLabel(imag);
		L1.setBounds(0, 0, 749, 335);
		Fr5.setLayout(null);
		Fr5.setBounds(100, 200, 764, 374);
		Fr5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fr5.setVisible(true);
		
		Color clr = new Color(0,0,0,0);
		Font fnt3 = new Font("Microsoft Himalaya", Font.BOLD, 25 );
		
		dte = new JTextField();
		dte.setBounds(300,93,220,30);
		dte.setBackground(clr);
		dte.setOpaque(false); // for textfield background 
		dte.setBackground(new Color(0,0,0,0));
		dte.setForeground(Color.WHITE);
		dte.setBorder(BorderFactory.createLineBorder(clr));
		dte.setFont(fnt3);
		dte.setCaretColor(Color.WHITE);
		Fr5.add(dte);
		
		
		JButton cls1 = new JButton("Close");
		cls1.setBounds(580,290,90,32);
		cls1.setFont(fnt3);
		Fr5.add(cls1);
		cls1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					Fr5.dispose();
				}catch(Exception ex){}	
			}
		});
		
		
		JPanel jp = new JPanel();
		jp.setBackground(clr);
		jp.setOpaque(false);
		jp.setBounds(110,170,590,110);
		JTable table = new JTable();
		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(502,102));
		jp.add(sp);
		
		//System.out.println(ID);
		JButton sub = new JButton("Search");
		sub.setBounds(245,135,95,32);
		sub.setFont(fnt3);
		Fr5.add(sub);
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				String dt = dte.getText();
				try
				{
					
					DefaultTableModel model = new DefaultTableModel()
					{
					public Class<?> getColumnClass(int column)
					{
						switch (column)
						{
							case 0 : return String.class;
							case 1 : return String.class;
							case 2 : return String.class;
							case 3 : return String.class;
							default: return String.class;
						}

					}
					};

				table.setModel(model);
				
				model.addColumn("ID");
				model.addColumn("Name");
				model.addColumn("Date");
				model.addColumn("Attendance");
				
						Connection con = null;
						Statement st  = null;
						ResultSet rs = null;
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						con = DriverManager.getConnection("jdbc:ucanaccess://Attendance.accdb");
						st = con.createStatement();
						rs = st.executeQuery("SELECT * FROM A_D");
					//	System.out.println(dt);
							int i=0;
							while(rs.next()){
							//System.out.println(rs.getString(2)+" "+rs.getString(3));
							if((rs.getString(2).equals(ID)) && (rs.getString(3).equals(dt)))
								{
									
									model.addRow(new Object[0]);
									model.setValueAt(rs.getString(2), i,0);
									model.setValueAt( rs.getString(1), i,1);
									model.setValueAt( rs.getString(3), i, 2);
									model.setValueAt(rs.getString(4),i, 3);
									i++;
										
								} 
							}
							
		}catch(Exception ex){}
			}
		});
		Fr5.add(jp);
		
		JButton home = new JButton("Home");
		home.setBounds(585,40,90,30);
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
					new StudentLogin(ID);
				}catch(Exception ex){}
			}
		});
		Fr5.add(L1);
		Fr5.setResizable(false);
	
	}
}