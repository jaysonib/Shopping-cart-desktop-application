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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DatabaseConnection.ConnectToDatabase;
import mdlaf.components.combobox.MaterialComboBoxUI;
import mdlaf.components.panel.MaterialPanelUI;
import mdlaf.utils.MaterialColors;



public class CustomJFrame1 extends JFrame{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel contentPane;
	
	
	public String[] getData(String s1) {
		int size = 0;
		
		ConnectToDatabase db = new ConnectToDatabase();
		db.connectionDatabase();
		CallableStatement cstmt = null;
		try {
			String tot = "";
			if(s1.equals("Color")) {
				tot = "{call ColorCount()}";
			}else if(s1.equals("Size")) {
				tot = "{call SizeCount()}";
			}else if(s1.equals("Brands")) {
				tot = "{call BrandsTotal()}";
			}else if(s1.equals("Catagory")) {
				tot = "{call CatagoryTotal()}";
			}else if(s1.equals("Store")) {
				tot = "{call StoresCount()}";
			}
			cstmt = db.cn.prepareCall(tot);
			ResultSet rs = cstmt.executeQuery();
			while(rs.next()) {
				size++;
			}
		}catch(SQLException e) {
			
		}
		String s2[] = new String[size+1];
		try {
			String tot = "";
			if(s1.equals("Color")) {
				tot = "{call ColorCount()}";
				s2[0] = "Select Color";
			}else if(s1.equals("Size")) {
				tot = "{call SizeCount()}";
				s2[0] = "Select Size";
			}else if(s1.equals("Brands")) {
				tot = "{call BrandsRetrive()}";
				s2[0] = "Select Brands";
			}else if(s1.equals("Catagory")) {
				tot = "{call Catagory_Retrive()}";
				s2[0] = "Select Catagory";
			}else if(s1.equals("Store")) {
				tot = "{call StoresRetrive()}";
				s2[0] = "Select Store";
			}			cstmt = db.cn.prepareCall(tot);
			ResultSet rs = cstmt.executeQuery();
			int i=1;			
			while(rs.next()) {
				s2[i] = rs.getString("name");
				i++;
			}
		}catch(SQLException e) {
			
		}
		db.disconnectDatabase();
		
		return s2;
	}
	
	//method for suggestion text in jtextfield with two args :  JTextField and String
	public void method1(JTextField tf,String s) {
		tf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if(tf.getText().isEmpty()) {
					tf.setText(s);
					tf.setForeground(Color.gray);
				}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if(tf.getText().equals(s)) {
					tf.setText(null);
					tf.setForeground(Color.gray);
				}
			}
		});
	}
	
	public CustomJFrame1(String s0,String s1,String s2,String s3,String s41,String s42,String s5,String s6,String s7,String s8) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,0,screenSize.width-200,screenSize.height-70);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ImageIcon icon1 = new ImageIcon("delete1.png");
		ImageIcon icon2 = new ImageIcon("delete2.png");
		JButton close = new JButton();
		close.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				close.setIcon(icon1);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				close.setIcon(icon1);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				close.setIcon(icon1);	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				close.setIcon(icon2);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				close.setIcon(icon2);
				dispose();
			}
		});
		close.setIcon(icon1);
		close.setBounds(screenSize.width-250,0,50,50);
		add(close);
		
		
		JLabel lb1 = new JLabel("Edit Product");
		lb1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,35));
		lb1.setBounds(10,0,600,100);
		add(lb1);

		
		
		
		//label and textfield for product name
		JTextField jtf2 = new JTextField();
		jtf2.setBackground(MaterialColors.RED_200);		
		jtf2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf2.setBounds(50,250,300,40);
		jtf2.setForeground(Color.GRAY);
		jtf2.setText(s0);
		method1(jtf2,"Product Name");
		
		add(jtf2);
		//label and textfield for product price
		
		JTextField jtf3 = new JTextField();
		jtf3.setBackground(MaterialColors.RED_200);
		jtf3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf3.setBounds(550,250,300,40);
		jtf3.setText(s1);
		jtf3.setForeground(Color.gray);
		method1(jtf3,"Product Price");
		add(jtf3);
		
		//label and textfield for product quantity
		JTextField jtf4 = new JTextField();
		jtf4.setBackground(MaterialColors.RED_200);
		jtf4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf4.setBounds(50,300,300,40);
		jtf4.setForeground(Color.gray);
		jtf4.setText(s2);
		method1(jtf4,"Product Quantity");
		add(jtf4);

		JTextField jtf5 = new JTextField();
		jtf5.setBackground(MaterialColors.RED_200);
		jtf5.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf5.setBounds(550,300,300,40);
		jtf5.setForeground(Color.gray);
		jtf5.setText(s3);
		method1(jtf5,"Product Description");
		add(jtf5);
		
		//label and textfield for product color
		
		/*String jtf6value[] = {"",""};
		JComboBox jtf6 = new JComboBox(jtf6value);*/
		String tf61[] = getData("Color");
		System.out.println(tf61.length);
		JComboBox jtf6 = new JComboBox(tf61);
		jtf6.setBackground(MaterialColors.RED_200);
		jtf6.setSelectedItem(s41);
		jtf6.setBounds(50,350,300,40);
		add(jtf6);
		
		//label and textfield for product size

		String tf71[] = getData("Size");
		JComboBox jtf7 = new JComboBox(tf71);
		jtf7.setBackground(MaterialColors.RED_200);
		jtf7.setBounds(550,350,300,40);
		jtf7.setSelectedItem(s42);
		add(jtf7);
		
		//label and textfield for product brands

		String tf81[] = getData("Brands");
		JComboBox jtf8 = new JComboBox(tf81);
		jtf8.setBackground(MaterialColors.RED_200);
		jtf8.setBounds(50,400,300,40);
		jtf8.setSelectedItem(s5);
		add(jtf8);
		
		//label and textfield for product catagory
		String tf91[] = getData("Catagory");
		JComboBox jtf9 = new JComboBox(tf91);
		jtf9.setBackground(MaterialColors.RED_200);
		jtf9.setSelectedItem(s6);
		jtf9.setBounds(550,400,300,40);
		add(jtf9);
		
		//label and textfield which shows all stores which contains this product
		String tf10[] = getData("Store");
		JComboBox jtf10 = new JComboBox(tf10);
		jtf10.setBackground(MaterialColors.RED_200);
		jtf10.setBounds(50,450,300,40);
		jtf10.setSelectedItem(s7);
		add(jtf10);
		
		//label and combobox field which shows the availability of the product

		String[] items = {"Availability","YES","NO"};
		JComboBox jtf11 = new JComboBox(items);
		jtf11.setBackground(MaterialColors.GRAY_300);
		jtf11.setBounds(550,450,120,40);
		jtf11.setSelectedItem(s8);
		add(jtf11);
		
		//button to save all changes
		JButton button1 = new JButton("Save Changes");
		button1.setBounds(50,500,200,50);
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
				
				ConnectToDatabase db = new ConnectToDatabase();
				db.connectionDatabase();
				try {
					CallableStatement cstmt = null;

					String name = jtf2.getText();
					String price = jtf3.getText();
					String qty = jtf4.getText();
					String description = jtf5.getText();
					String a_id= jtf6.getSelectedItem()+" "+jtf7.getSelectedItem();
					String brands = jtf8.getSelectedItem().toString();
					String catagory = jtf9.getSelectedItem().toString();
					String store = jtf10.getSelectedIndex()+"";
					String availability = jtf11.getSelectedIndex()+"";
					
					if(name.equals(null) || price.equals(null) || a_id.equals("Select Color Select Size") || qty.equals(null) || description.equals(null) || brands.equals("Select Brands") || catagory.equals("Select Catagory") || store.equals("Select Store") || availability.equals("0") ) {
						
						JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button1), 
								"Please fill all the fields");
					}else {
						String insert = "{call ProductsEdit(?,?,?,?,?,?,?,?,?,?)}";
						cstmt = db.cn.prepareCall(insert);
						cstmt.setString("@NAME", name);
						cstmt.setString("@PRICE", price);
						cstmt.setString("@QTY", qty);
						cstmt.setString("@DESCRIPTION", description);
						cstmt.setString("@A_ID", a_id);
						cstmt.setString("@B_ID", brands);
						cstmt.setString("@C_ID", catagory);
						cstmt.setString("@S_ID", store);
						cstmt.setString("@AVAILABILITY", availability);
						cstmt.setString("@NAME1", s0);
						cstmt.execute();

						JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button1), 
								"Product successfully edited  to the database");
						
					}
				}catch(SQLException e) {
					
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button1), 
							"There might be some error with database");
				}
				db.disconnectDatabase();			
			}
		});
		add(button1);
		
		
		
		MaterialComboBoxUI.createUI(jtf11);
		

		
		
		
	}
}
