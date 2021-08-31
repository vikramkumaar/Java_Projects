import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Attendance_Save{
	private JFrame Fr5 = new JFrame("Attendance Management System");
	
	public Attendance_Save(String y, String s, String b, int ts) {
	
		ImageIcon icon = new ImageIcon("student-portal-logo.jpg");
		Fr5.setIconImage(icon.getImage());
		ImageIcon imag = new ImageIcon("T3_1.png");
		JLabel L1 = new JLabel(imag);
		L1.setBounds(0, 0, 749, 335);
		Fr5.setLayout(null);
		Fr5.setBounds(100, 200, 764, 374);
		Fr5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fr5.setVisible(true);
		
		Color clr = new Color(0,0,0,0);
		Font fnt5 = new Font("Microsoft Himalaya", Font.BOLD, 30 );
		Font fnt3 = new Font("Microsoft Himalaya", Font.BOLD, 25 );
		
		JPanel jp = new JPanel();
		jp.setBackground(clr);
		jp.setOpaque(false);
		jp.setBounds(122,73,502,204);
		
		JLabel dete = new JLabel();
		dete.setBounds(340,42,120,30);
		dete.setOpaque(false); // for textfield background 
		dete.setBackground(new Color(0,0,0,0)); 
		dete.setForeground(Color.WHITE);
		dete.setBorder(BorderFactory.createLineBorder(clr));
		dete.setFont(fnt5);
		Fr5.add(dete);
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dete.setText(sdf.format(d));
		JTable table = new JTable();
		JScrollPane sp = new JScrollPane(table);
		
		try
		{			
					
					
					sp.setPreferredSize(new Dimension(502,202));
					jp.add(sp);
					DefaultTableModel model = new DefaultTableModel()
					{
					public Class<?> getColumnClass(int column)
					{
						switch (column)
						{
							case 0 : return Integer.class;
							case 1 : return String.class;
							case 2 : return String.class;
							case 3 : return String.class;
							case 4 : return Boolean.class;
							default: return String.class;
						}

					}
					};

				table.setModel(model);
				
				model.addColumn("S.no");
				model.addColumn("Name");
				model.addColumn("ID");
				model.addColumn("Date");
				model.addColumn("Attendance");
				
						Connection con = null;
						Statement st  = null;
						ResultSet rs = null;
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						con = DriverManager.getConnection("jdbc:ucanaccess://StudentData.accdb");
						st = con.createStatement();
						rs = st.executeQuery("SELECT * FROM Student_Data");
						
							int i=0;
							while(rs.next()){
						
							if((rs.getString(8).equals(y)) && (rs.getString(9).equals(b)) && (rs.getString(10).equals(s)))
								{
									model.addRow(new Object[0]);
									model.setValueAt((i+1), i,0);
									model.setValueAt( rs.getString(1), i,1);
									model.setValueAt( rs.getString(2), i, 2);
									model.setValueAt(dete.getText(),i, 3);
									model.setValueAt(false, i , 4);
									i++;
										
								} 
							}
			
		}catch(Exception ex){}
		Fr5.add(jp);
		
		JButton cls1 = new JButton("Close");
		cls1.setBounds(523,287,100,31);
		cls1.setFont(fnt3);
		Fr5.add(cls1);
		cls1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					Fr5.dispose();
				}catch(Exception ex){}	
			}
		});
		
		JButton sub = new JButton("Save");
		sub.setBounds(130,287,100,31);
		sub.setFont(fnt3);
		sub.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Fr5.add(sub);
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				
				Connection cn = null;
				Statement stt  = null;
				ResultSet rs = null;
				
				try
				{
					
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						cn = DriverManager.getConnection("jdbc:ucanaccess://Attendance.accdb");
						stt = cn.createStatement();
					for (int i = 0; i < table.getRowCount(); i++) 
					{
						Boolean chked = Boolean.valueOf(table.getValueAt(i, 4).toString());
						String nm = String.valueOf(table.getValueAt(i, 2).toString());
						String di = String.valueOf(table.getValueAt(i, 1).toString());
						String dt = String.valueOf(table.getValueAt(i, 3).toString());
						String p = "Present", a = "Absent";
					
						if (chked) 
						{
							String sql = "insert into A_D"
							+" (id, sname, dete, atten) "
							+" values('"+String.valueOf(table.getValueAt(i, 1).toString())+"','"+String.valueOf(table.getValueAt(i, 2).toString())+"','"+String.valueOf(table.getValueAt(i, 3).toString())+"','presnet')";
							int ans = stt.executeUpdate(sql);
							//JOptionPane.showMessageDialog(null, "Saved Data");
							//System.out.println(di+" "+nm+" "+dt+" "+p);
						}
						else
						{
							String spl = "insert into A_D"
							+" (id, sname, dete, atten)"
							+" values('"+String.valueOf(table.getValueAt(i, 1).toString())+"','"+String.valueOf(table.getValueAt(i, 2).toString())+"','"+String.valueOf(table.getValueAt(i, 3).toString())+"','absent')";
							int ans = stt.executeUpdate(spl);
							//System.out.println(di+" "+nm+" "+dt+" "+a);
						}
					}
					JOptionPane.showMessageDialog(null, "Data Saved");
				}catch(Exception ex){ JOptionPane.showMessageDialog(null, "Data not Saved"); }
			}
		});
		
		JButton home = new JButton("Home");
		home.setBounds(585,35,90,30);
		home.setBorder(BorderFactory.createLineBorder(clr));
		home.setFont(fnt5);
		home.setForeground(new Color(255,255,255));
		home.setOpaque(false); // for textfield background 
		home.setBackground(clr);
		Fr5.add(home);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Fr5.dispose();
				new Faculty_Login();
			}
		});
		
		/*JLabel dete = new JLabel();
		dete.setBounds(340,42,120,30);
		dete.setOpaque(false); // for textfield background 
		dete.setBackground(new Color(0,0,0,0)); 
		dete.setForeground(Color.WHITE);
		dete.setBorder(BorderFactory.createLineBorder(clr));
		dete.setFont(fnt5);
		//dete.setCaretColor(Color.WHITE); // For Cursur color
		Fr5.add(dete);
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dete.setText(sdf.format(d));*/
		
		Fr5.add(home);
		Fr5.add(L1);
	
	}
}