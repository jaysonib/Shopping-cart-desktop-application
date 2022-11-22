import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DatabaseConnection.ConnectToDatabase;
import mdlaf.utils.MaterialColors;

public class CompanyPanel extends JPanel{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public String[] getData() {
		String s1[] = new String[6];
		
		ConnectToDatabase db = new ConnectToDatabase();
		db.connectionDatabase();
		CallableStatement cstmt = null;
		try {
			String tot = "{call Company_Retrive()}";
			cstmt = db.cn.prepareCall(tot);
			ResultSet rs = cstmt.executeQuery();
			while(rs.next()) {
				s1[0] = rs.getString("company_name");
				s1[1] = rs.getString("service_charge_value");
				s1[2] = rs.getString("vat_charge_value");
				s1[3] = rs.getString("address");
				s1[4] = rs.getString("phone");
				s1[5] = rs.getString("country");
			}
		}catch(SQLException e) {
			System.out.println("There might be some error...");
		}
		db.disconnectDatabase();
		
		return s1;
	}
	
	public CompanyPanel() {
		//when company menu is clicked 
		setLayout(null);
		setBounds(0,0,screenSize.width-200,screenSize.height-70);
		
		
		//label : which gives the purpose of panel
		JLabel lb1 = new JLabel("Manage Company Information");
		lb1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,35));
		lb1.setBounds(10,0,600,100);
		add(lb1);
		
		String[] datavalue = getData();
		
		
		//label and textfield for company name
		JLabel lb2 = new JLabel("Company Name");
		lb2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb2.setBounds(50,195,200,40);
		add(lb2);
		JTextField jtf2 = new JTextField();
		jtf2.setBackground(MaterialColors.RED_200);		
		jtf2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf2.setBounds(250,200,300,40);
		jtf2.setForeground(Color.GRAY);
		jtf2.setText(datavalue[0]);
		add(jtf2);
		
		//label and textfield for charge amount in %
		JLabel lb3 = new JLabel("Charge Amount(%)");
		lb3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb3.setBounds(50,245,200,40);
		add(lb3);
		JTextField jtf3 = new JTextField();
		jtf3.setBackground(MaterialColors.RED_200);
		jtf3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf3.setBounds(250,250,300,40);
		jtf3.setText(datavalue[1]);
		jtf3.setForeground(Color.gray);
		add(jtf3);
		
		//textfield for Vat Charge(%)
		JLabel lb4 = new JLabel("Vat Charge(%)");
		lb4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb4.setBounds(50,295,200,40);
		add(lb4);
		JTextField jtf4 = new JTextField();
		jtf4.setBackground(MaterialColors.RED_200);
		jtf4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf4.setBounds(250,300,300,40);
		jtf4.setForeground(Color.gray);
		jtf4.setText(datavalue[2]);
		add(jtf4);
		
		//textfield for address
		JLabel lb5 = new JLabel("Address");
		lb5.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb5.setBounds(50,345,200,40);
		add(lb5);
		JTextField jtf5 = new JTextField();
		jtf5.setBackground(MaterialColors.RED_200);
		jtf5.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf5.setBounds(250,350,300,40);
		jtf5.setForeground(Color.gray);
		jtf5.setText(datavalue[3]);
		add(jtf5);
		
		//textfield for Phone
		JLabel lb6 = new JLabel("Phone");
		lb6.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb6.setBounds(50,395,200,40);
		add(lb6);
		JTextField jtf6 = new JTextField();
		jtf6.setBackground(MaterialColors.RED_200);
		jtf6.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf6.setBounds(250,400,300,40);
		jtf6.setForeground(Color.gray);
		jtf6.setText(datavalue[4]);
		add(jtf6);
		
		//textfield for Country
		JLabel lb7 = new JLabel("Country");
		lb7.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb7.setBounds(50,445,200,40);
		add(lb7);
		JTextField jtf7 = new JTextField();
		jtf7.setBackground(MaterialColors.RED_200);
		jtf7.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf7.setBounds(250,450,300,40);
		jtf7.setForeground(Color.gray);
		jtf7.setText(datavalue[5]);
		add(jtf7);
		
		//button to save all changes
		JButton button1 = new JButton("Save Changes");
		button1.setBounds(50,550,200,50);
		button1.setBackground(MaterialColors.GREEN_100);
		button1.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button1.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				button1.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				button1.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button1.setBackground(MaterialColors.GREEN_200);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button1.setBackground(MaterialColors.GREEN_200);
				if(jtf2.getText().equals(null) ||jtf3.getText().equals(null) ||jtf4.getText().equals(null) ||jtf5.getText().equals(null) ||jtf6.getText().equals(null) ||jtf7.getText().equals(null) ) {
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button1), 
							"Please fill up all details");					
				}
				else {
					ConnectToDatabase db = new ConnectToDatabase();
					db.connectionDatabase();
					CallableStatement cstmt = null;
					try {
						String tot = "{call CompanyUpdate(?,?,?,?,?,?,?)}";
						cstmt = db.cn.prepareCall(tot);
						cstmt.setString("@NAME", jtf2.getText());
						cstmt.setString("@SERVICE_VAL", jtf3.getText());
						cstmt.setString("@VAT_VAL", jtf4.getText());
						cstmt.setString("@ADR", jtf5.getText());
						cstmt.setString("@PHONE", jtf6.getText());
						cstmt.setString("@COUNTRY", jtf7.getText());
						cstmt.setString("@NAME1", datavalue[0]);
						cstmt.execute();
						
						JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button1), 
								"Value Edited successfully");					
							
					}catch(SQLException e) {
						System.out.println("There might be some error...");
					}
					db.disconnectDatabase();
				}
			}
		});
		add(button1);
	}	
}
