import mdlaf.*;
import mdlaf.animation.*;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.components.checkbox.MaterialCheckBoxUI;
import mdlaf.components.combobox.MaterialComboBoxUI;
import mdlaf.components.label.MaterialLabelUI;
import mdlaf.components.menu.MaterialMenuUI;
import mdlaf.components.menubar.MaterialMenuBarUI;
import mdlaf.components.panel.MaterialPanelUI;
import mdlaf.components.popupmenu.MaterialPopupMenuUI;
import mdlaf.components.radiobutton.MaterialRadioButtonUI;
import mdlaf.components.scrollbar.MaterialScrollBarUI;
import mdlaf.components.textfield.MaterialTextFieldUI;
import mdlaf.utils.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaterialUISwingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel (new MaterialLookAndFeel());
			
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace ();
		}

		JFrame frame = new JFrame ("Material Design UI for Swing by atharva washimkar");
		frame.setMinimumSize (new Dimension (600, 600));
		frame.setUndecorated(true);
		
		//Button
		
		//ComboBox
		String[] item = {"Pepsi","Sprite","Slice","Coca cola"};
		JComboBox itemlist = new JComboBox(item);
		itemlist.setBounds(10, 50, 120, 30);
		
		//CheckBox
		JCheckBox check = new JCheckBox();
		check.setText("Pepsi");
		check.isSelected();
		check.setBounds(10, 150, 200, 30);
		
		//password
		JTextField pasf=new JTextField();
		pasf.setBounds(10, 10, 200, 30);
		pasf.setToolTipText("Please Enter Your Name");
		
		//Radio Button
		JRadioButton M = new JRadioButton("Male");
		JRadioButton F = new JRadioButton("FeMale");
		M.setBounds(250, 10, 100,50);
		F.setBounds(250, 50, 100,50);
		
		JLabel jl1 = new JLabel("Label1");
		
		jl1.setBounds(10, 200, 100, 50);
		
		JMenuBar jmb1 = new JMenuBar();
		jmb1.setBounds(0, 280, 150, 200);
		jmb1.setBackground(MaterialColors.BLUE_A100);
		jmb1.setLayout(new GridLayout(0, 1));
		JMenu jm1 = new JMenu("Menu 1");
		JMenu jm2 = new JMenu("Menu 2");
		JMenu jm3 = new JMenu("Menu 3");
		JMenu jm4 = new JMenu("Menu 4");
		jmb1.add(jm1);
		jmb1.add(jm2);
		jmb1.add(jm3);
		jmb1.add(jm4);
		
		JScrollPane js1 = new JScrollPane();
		js1.setBounds(590, 0, 600, 200);
		
		
		JPopupMenu jp1 = new JPopupMenu("Edit");
		
		jp1.setToolTipText("This is popupmenu");
		jp1.setBackground(MaterialColors.CYAN_300);
		jp1.setForeground(MaterialColors.CYAN_100);
		//jp1.setBounds(50,50,400,200);
		JMenuItem jmi1 = new JMenuItem("CUT");
		JMenuItem jmi2 = new JMenuItem("COPY");
		JMenuItem jmi3 = new JMenuItem("PASTE");
		jp1.add(jmi1);
		jp1.add(jmi2);
		jp1.add(jmi3);
		
		JButton button = new JButton ("PRESS ME");
		button.setMaximumSize (new Dimension (200, 200));
		button.setBackground(MaterialColors.GREEN_100);
		button.setBounds(10, 100, 200, 30);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jp1.show(frame, 400, 200);
			}
		});
		
		
		//js1.setSize(10, 400);
		
		JPanel content = new JPanel();
		content.setLayout(null);
		content.add(js1);
		content.add (button);
		content.add(check);
		content.add(itemlist);
		content.add(pasf);
		content.add(M);
		content.add(F);
		content.add(jl1);
		content.add(jmb1);
		content.add(jp1);
		
		frame.add(content, BorderLayout.CENTER);
		
		
//		js1.add(content);
//		frame.add(js1, BorderLayout.CENTER);
		
		
		// on hover, button will change to a light gray
		MaterialUIMovement.add (button, MaterialColors.BLUE_A100);
		MaterialPanelUI.createUI(content);
		MaterialButtonUI.createUI(button);
		MaterialCheckBoxUI.createUI(check);
		MaterialComboBoxUI.createUI(itemlist);
		MaterialTextFieldUI.createUI(pasf);
		MaterialRadioButtonUI.createUI(M);
		MaterialRadioButtonUI.createUI(F);
		MaterialLabelUI.createUI(jl1);
		MaterialMenuBarUI.createUI(jmb1);
		MaterialMenuUI.createUI(jm1);
		MaterialMenuUI.createUI(jm2);
		MaterialMenuUI.createUI(jm3);
		MaterialMenuUI.createUI(jm4);
		MaterialScrollBarUI.createUI(js1);
		MaterialPopupMenuUI.createUI(jp1);
		
		frame.pack();
		frame.setVisible (true);
		MaterialLookAndFeel.getControlShadow();
	}

}
