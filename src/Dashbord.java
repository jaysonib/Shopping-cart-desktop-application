import mdlaf.*;
import mdlaf.components.menubar.MaterialMenuBarUI;
import mdlaf.components.menuitem.MaterialMenuItemUI;
import mdlaf.components.panel.MaterialPanelUI;
import mdlaf.components.popupmenu.MaterialPopupMenuUI;
import mdlaf.utils.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Dashbord {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try {
			UIManager.setLookAndFeel (new MaterialLookAndFeel());
			
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace ();
		}

		//jframe 
		JFrame frame = new JFrame ("Inventory management");
		frame.setMinimumSize(new Dimension(screenSize.width, screenSize.height-70));
		frame.setUndecorated(true);

		//content panel : for menuBar
		JPanel content = new JPanel();
		content.setLayout(null);
		
		//content1 panel 
		JPanel content1 = new JPanel();
		content1.setBounds(200,0,screenSize.width-200,screenSize.height-70);
		content1.setLayout(null);
//		String temp1[] = {"temp1","temp2"};
//		JComboBox jcb1 = new JComboBox(temp1);
//		jcb1.setBounds(30,30,140,30);
//		content1.add(jcb1);
		content1.add(new JLabel("Inventory management project"));
				
		//
		JMenuBar jmb1 = new JMenuBar();
		jmb1.setBounds(0, 0, 200, screenSize.height-70);
		jmb1.setBackground(MaterialColors.LIGHT_BLUE_200);
		jmb1.setLayout(new GridLayout(0, 1));

		//popup menu for products panel
		JPopupMenu jpm1 = new JPopupMenu();
		JMenuItem jpm11 = new JMenuItem("Add Products");
		jpm11.setBackground(MaterialColors.LIGHT_BLUE_200);
		jpm11.setForeground(MaterialColors.WHITE);
		JMenuItem jpm12 = new JMenuItem("Manage Products");
		jpm12.setBackground(MaterialColors.LIGHT_BLUE_200);
		jpm12.setForeground(MaterialColors.WHITE);
		jpm1.add(jpm11);
		jpm1.add(jpm12);

		
		JPopupMenu jpm2 = new JPopupMenu();
		JMenuItem jpm21 = new JMenuItem("Add Order");
		jpm21.setBackground(MaterialColors.LIGHT_BLUE_200);
		jpm21.setForeground(MaterialColors.WHITE);
		JMenuItem jpm22 = new JMenuItem("Manage Orders");
		jpm22.setBackground(MaterialColors.LIGHT_BLUE_200);
		jpm22.setForeground(MaterialColors.WHITE);
		jpm2.add(jpm21);
		jpm2.add(jpm22);

		
		JPopupMenu jpm3 = new JPopupMenu();
		JMenuItem jpm31 = new JMenuItem("Add User");
		jpm31.setBackground(MaterialColors.LIGHT_BLUE_200);
		jpm31.setForeground(MaterialColors.WHITE);
		JMenuItem jpm32 = new JMenuItem("Manage Users");
		jpm32.setBackground(MaterialColors.LIGHT_BLUE_200);
		jpm32.setForeground(MaterialColors.WHITE);
		jpm3.add(jpm31);
		jpm3.add(jpm32);
		//close button : for closing jframe
		ImageIcon icon1 = new ImageIcon("delete1.png");
		ImageIcon icon2 = new ImageIcon("delete2.png");
		JButton closeButton1 = new JButton(new ImageIcon("delete1.png"));
		closeButton1.setBounds(screenSize.width-250,0,50,50);
		closeButton1.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				closeButton1.setIcon(icon1);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				closeButton1.setIcon(icon1);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				closeButton1.setIcon(icon1);	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				closeButton1.setIcon(icon2);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				closeButton1.setIcon(icon2);
				frame.dispose();
			}
		});
		
		//dashbord menu
		JMenu jm1 = new JMenu("DashBord");
		jm1.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				content1.removeAll();
				content1.repaint();
				JPanel panel1 = new UserPanel();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		
		//Users menu
		JMenu jm2 = new JMenu("Users");
		jm2.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				jpm3.show(frame, 200, 30);
			}
		});
		jpm31.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				content1.removeAll();
				content1.repaint();
				JPanel panel1 = new UserPanel1();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		jpm32.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				content1.removeAll();
				content1.repaint();
				JPanel panel1 = new UserPanel2();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		
		
		
		//Brands menu
		JMenu jm4 = new JMenu("Brands");
		jm4.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				content1.removeAll();
				content1.repaint();
				JPanel panel1 = new BrandsPanel();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		
		//catagory menu
		JMenu jm5 = new JMenu("Catagory");
		jm5.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				content1.removeAll();
				JPanel panel1 = new CatagoryPanel();
				panel1.add(closeButton1);
				content1.repaint();
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		
		//stores menu
		JMenu jm6 = new JMenu("Stores");
		jm6.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				content1.removeAll();
				content1.repaint();
				JPanel panel1 = new StorePanel();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		
		//attributes menu
		JMenu jm7 = new JMenu("Attributes");
		jm7.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				content1.removeAll();
				content1.repaint();
				JPanel panel1 = new AttributesPanel();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		
		//products menu
		JMenu jm8 = new JMenu("Products                          <");
		//to show popup menu
		jm8.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {			
			}
			@Override
			public void mouseExited(MouseEvent e) {			
			}
			@Override
			public void mouseEntered(MouseEvent e) {				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				jpm1.show(frame, 200, 330);		
			}
		});
		//to open add brands panel
		jpm11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				content1.removeAll();
				content1.repaint();
				JPanel panel1 = new ProductPanel();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		jpm12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				content1.removeAll();
				content1.repaint();
				JPanel panel1 = new ProductPanel1();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		
		//orders panel
		JMenu jm9 = new JMenu("Orders                              <");
		jm9.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {	
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				jpm2.show(frame, 200, 370);
			}
		});
		jpm21.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				content1.removeAll();
				content1.repaint();
				JPanel panel1 = new OrderPanel1();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		jpm22.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				content1.removeAll();
				content1.repaint();
				JPanel panel1 = new OrderPanel2();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		
		//this is reports panel
		JMenu jm10 = new JMenu("Reports");
		jm10.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				content1.removeAll();
				content1.setBackground(Color.black);
			}
		});
		
		//company panel
		JMenu jm11 = new JMenu("Company");
		jm11.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				content1.removeAll();
				content1.repaint();
				JPanel panel1 = new CompanyPanel();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		
		//profile panel
		JMenu jm12 = new JMenu("Profile");
		jm12.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				content1.removeAll();
				content1.repaint();
				JPanel panel1 = new ProfilePanel();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		
		JMenu jm13 = new JMenu("Settings");
		jm13.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				content1.removeAll();
				content1.repaint(); 
				JPanel panel1 = new SettingPanel();
				panel1.add(closeButton1);
				content1.setLayout(null);
				content1.add(panel1);
				content1.setBackground(Color.cyan);
				content1.setVisible(true);
				MaterialPanelUI.createUI(panel1);
			}
		});
		JMenu jm14 = new JMenu("LOGOUT");
		jm14.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				content1.removeAll();
				content1.setBackground(Color.black);
			}
		});

		//add jmenu to the menubar
		jmb1.add(jm1);
		jmb1.add(jm2);
		jmb1.add(jm4);
		jmb1.add(jm5);
		jmb1.add(jm6);
		jmb1.add(jm7);
		jmb1.add(jm8);
		jmb1.add(jm9);
		jmb1.add(jm10);
		jmb1.add(jm11);
		jmb1.add(jm12);
		jmb1.add(jm13);
		jmb1.add(jm14);
		
		
		
		content.add(jmb1);
		content.add(content1);
		
		
		frame.add(content,BorderLayout.CENTER);
		MaterialPopupMenuUI.createUI(jpm1);
		MaterialMenuItemUI.createUI(jpm11);
		MaterialMenuItemUI.createUI(jpm12);
		MaterialPanelUI.createUI(content);
		MaterialMenuBarUI.createUI(jmb1);
		MaterialPanelUI.createUI(content1);
		
		
		
		frame.pack();
		frame.setVisible (true);
		MaterialLookAndFeel.getControlShadow();
	}

}