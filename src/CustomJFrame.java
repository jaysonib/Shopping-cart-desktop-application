import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DatabaseConnection.ConnectToDatabase;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.components.combobox.MaterialComboBoxUI;
import mdlaf.components.label.MaterialLabelUI;
import mdlaf.components.panel.MaterialPanelUI;
import mdlaf.components.textfield.MaterialTextFieldUI;
import mdlaf.utils.MaterialColors;

public class CustomJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CustomJFrame(String s1,String s2, String s3) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		close.setBounds(500,15,50,50);
		
		JLabel l = new JLabel(s3);
		l.setBounds(10,0,400,80);
		l.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
		
		JLabel l1 = new JLabel(s1);
		l1.setBounds(10,70,170,60);
		
		
		JTextField tf1 = new JTextField();
		tf1.setToolTipText(s1);
		tf1.setBackground(MaterialColors.RED_200);
		tf1.setBounds(190,70,250,40);
		
		
		JLabel l2 = new JLabel(s2);
		l2.setBounds(10,160,170,60);
		String status[] = {"Active","Not Active"};
		JComboBox jcb1 = new JComboBox(status);
		jcb1.setBounds(190,175,250,30);
		
		String temp = new String(s3);
		
		JButton button  = new JButton("SUBMIT");
		button.setBounds(160,250,200,30);
		button.setBackground(MaterialColors.GREEN_100);
		button.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_200);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_200);
				if(tf1.getText().length() == 0) {
				}else {
					ConnectToDatabase db = new ConnectToDatabase();
					db.connectionDatabase();
					try {
						CallableStatement cstmt = null;
						String name = tf1.getText();
						int value = jcb1.getSelectedIndex();
						String insert = "";
						//Check the submit button from the Brands panel 
						if(temp.equals("Add Brands")) {
							insert += "{call BrandsInsert(?,?)}";	
						}else if(temp.equals("Add Catagory")) { 
							insert += "{call CatagoryInsert(?,?)}";	
						}else if(temp.equals("Add Store")) {
							insert += "{call StoresInsert(?,?)}";
						}else if(temp.equals("Add Attributes")) {  
							insert += "{call AttributesInsert(?,?)}";
						}
						cstmt = db.cn.prepareCall(insert);
						cstmt.setString("@NAME", name);
						cstmt.setString("@STATUS", value+"");
						cstmt.execute();
					}catch(SQLException e) {
						System.out.println("There might be some error..");
					}
					db.disconnectDatabase();
					dispose();
				}
			}
		});

		
		add(close);
		add(l);
		add(l1);
		add(l2);
		add(tf1);
		add(jcb1);
		add(button);
		
		MaterialButtonUI.createUI(close);
		MaterialButtonUI.createUI(button);
		MaterialLabelUI.createUI(l);
		MaterialLabelUI.createUI(l1);
		MaterialTextFieldUI.createUI(tf1);
		MaterialLabelUI.createUI(l2);
		MaterialComboBoxUI.createUI(jcb1);
		MaterialPanelUI.createUI(contentPane);
	}
	
	public CustomJFrame(String s4,String s5) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
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
		close.setBounds(500,15,50,50);
		
		JLabel l = new JLabel("Add Attributes");
		l.setBounds(10,0,400,80);
		l.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
		
		JLabel l1 = new JLabel(s4);
		l1.setBounds(10,70,170,60);
		
		
		JTextField tf1 = new JTextField();
		tf1.setToolTipText(s4);
		tf1.setBackground(MaterialColors.RED_200);
		tf1.setBounds(190,70,250,40);
		
		JButton button  = new JButton("SUBMIT");
		button.setBounds(160,150,200,30);
		
		String temp = new String(s5);
		
		button.setBackground(MaterialColors.GREEN_100);
		button.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_200);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_200);
				if(tf1.getText().length() == 0) {
				}else {
					ConnectToDatabase db = new ConnectToDatabase();
					db.connectionDatabase();
					try {
						CallableStatement cstmt = null;
						String name = tf1.getText();
						String update = "";
						if(temp.equals("Color")) {
							update += "{call ColorInsert(?)}";
						}else if(temp.equals("Size")) { 
							update += "{call SizeInsert(?)}";
						}
						cstmt = db.cn.prepareCall(update);
						cstmt.setString("@NAME", name);
						cstmt.execute();
					}catch(SQLException e) {
						System.out.println("There might be some error..");
					}
					db.disconnectDatabase();
					dispose();
				}
			}
		});


		add(close);
		add(l);
		add(l1);
		add(tf1);
		add(button);
		
		MaterialButtonUI.createUI(close);
		MaterialButtonUI.createUI(button);
		MaterialLabelUI.createUI(l);
		MaterialLabelUI.createUI(l1);
		MaterialTextFieldUI.createUI(tf1);

		MaterialPanelUI.createUI(contentPane);
	}
	
	
	
	
	
	
	
	
	
	
	
	public CustomJFrame(String s11,String s12,String s13, String s14) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
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
		close.setBounds(500,15,50,50);
		
		JLabel l = new JLabel(s12);
		l.setBounds(10,0,400,80);
		l.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
		
		JLabel l1 = new JLabel(s11);
		l1.setBounds(10,70,170,60);
		
		
		JTextField tf1 = new JTextField();
		tf1.setToolTipText(s11);
		tf1.setText(s14);
		tf1.setBackground(MaterialColors.RED_200);
		tf1.setBounds(190,70,250,40);
		
		JButton button  = new JButton("SUBMIT");
		button.setBounds(160,150,200,30);
		
		String temp = new String(s13);
		
		button.setBackground(MaterialColors.GREEN_100);
		button.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_200);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_200);
				if(tf1.getText().length() == 0) {
				}else {
					ConnectToDatabase db = new ConnectToDatabase();
					db.connectionDatabase();
					try {
						CallableStatement cstmt = null;
						String name = tf1.getText();
						String update = "";
						if(temp.equals("Color")) {
							update += "{call ColorUpdate(?,?)}";
						}else if(temp.equals("Size")) { 
							update += "{call SizeUpdate(?,?)}";
						}
						cstmt = db.cn.prepareCall(update);
						cstmt.setString("@NAME", name);
						cstmt.setString("@NAME1", s14);
						cstmt.execute();
					}catch(SQLException e) {
						System.out.println("There might be some error..");
					}
					db.disconnectDatabase();
					dispose();
				}
			}
		});


		add(close);
		add(l);
		add(l1);
		add(tf1);
		add(button);
		
		MaterialButtonUI.createUI(close);
		MaterialButtonUI.createUI(button);
		MaterialLabelUI.createUI(l);
		MaterialLabelUI.createUI(l1);
		MaterialTextFieldUI.createUI(tf1);

		MaterialPanelUI.createUI(contentPane);
	}
	
	
	
	
	
	public CustomJFrame(String s6,String s7,String s8,String s9,String s10) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		close.setBounds(500,15,50,50);
		
		JLabel l = new JLabel(s8);
		l.setBounds(10,0,400,80);
		l.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
		
		JLabel l1 = new JLabel(s6);
		l1.setBounds(10,70,170,60);
		
		
		JTextField tf1 = new JTextField();
		tf1.setToolTipText(s6);
		tf1.setText(s9);
		tf1.setBackground(MaterialColors.RED_200);
		tf1.setBounds(190,70,250,40);
		
		
		JLabel l2 = new JLabel(s7);
		l2.setBounds(10,160,170,60);
		
		String status[] = {"Active","Not Active"};
		JComboBox jcb1 = new JComboBox(status);
		int z=0;
		if(s10.equals("NO")) {
			z=1;
		}else {
			z=0;
		}
		jcb1.setSelectedIndex(z);
		jcb1.setBounds(190,175,250,30);
		
		String temp = new String(s8);
		
		JButton button  = new JButton("Edit");
		button.setBounds(160,250,200,30);
		button.setBackground(MaterialColors.GREEN_100);
		button.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_200);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button.setBackground(MaterialColors.GREEN_200);
				if(tf1.getText().length() == 0) {
				}else {
					ConnectToDatabase db = new ConnectToDatabase();
					db.connectionDatabase();
					try {
						CallableStatement cstmt = null;
						String name = tf1.getText();
						int value = jcb1.getSelectedIndex();
						String update = "";
						if(temp.equals("Edit Brands")) {
							update += "{call BrandsUpdate(?,?,?)}";
						}else if(temp.equals("Edit Catagory")) { 
							update += "{call CatagoryUpdate(?,?,?)}";
						}else if(temp.equals("Edit Store")) {  
							update += "{call StoresUpdate(?,?,?)}";
						}else if(temp.equals("Edit Attribute")) {
							update += "{call AttributesUpdate(?,?,?)}";
						}
						cstmt = db.cn.prepareCall(update);
						cstmt.setString("@NAME", name);
						cstmt.setString("@STATUS", value+"");
						cstmt.setString("@NAME1", s9);
						cstmt.execute();
					}catch(SQLException e) {
						System.out.println("There might be some error..");
					}
					db.disconnectDatabase();
					dispose();
				}
			}
		});

		
		add(close);
		add(l);
		add(l1);
		add(l2);
		add(tf1);
		add(jcb1);
		add(button);
		
		MaterialButtonUI.createUI(close);
		MaterialButtonUI.createUI(button);
		MaterialLabelUI.createUI(l);
		MaterialLabelUI.createUI(l1);
		MaterialTextFieldUI.createUI(tf1);
		MaterialLabelUI.createUI(l2);
		MaterialComboBoxUI.createUI(jcb1);
		MaterialPanelUI.createUI(contentPane);		
	}
}