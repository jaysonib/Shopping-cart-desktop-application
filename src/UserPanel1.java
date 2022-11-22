import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import mdlaf.utils.MaterialColors;

public class UserPanel1 extends JPanel{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	
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
	
	public UserPanel1() {
		//when add product popup menu is clicked 
		
		setLayout(null);
		setBounds(0,0,screenSize.width-200,screenSize.height-70);
		
		//new panel panel2() is added to the jscrollpane
		
		
		//label : which gives the purpose of panel
		JLabel lb1 = new JLabel("Add User");
		lb1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,35));
		lb1.setBounds(10,0,600,50);
		add(lb1);

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(10,60,1000,600);
		
		
		
		JLabel l1 = new JLabel("Add user");
		l1.setBounds(10,10,400,50);
		l1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		panel2.add(l1);
		
		//label and textfield for product name
		JTextField jtf2 = new JTextField();
		jtf2.setBackground(MaterialColors.RED_200);		
		jtf2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf2.setBounds(10,80,300,40);
		jtf2.setForeground(Color.GRAY);
		jtf2.setText("Groups");
		method1(jtf2,"Groups");
		panel2.add(jtf2);
		//label and textfield for product price
		
		JTextField jtf3 = new JTextField();
		jtf3.setBackground(MaterialColors.RED_200);
		jtf3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf3.setBounds(10,130,300,40);
		jtf3.setText("Username");
		jtf3.setForeground(Color.gray);
		method1(jtf3,"Username");
		panel2.add(jtf3);
		
		//label and textfield for product quantity

		
		JTextField jtf4 = new JTextField();
		jtf4.setBackground(MaterialColors.RED_200);
		jtf4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf4.setBounds(10,180,300,40);
		jtf4.setForeground(Color.gray);
		jtf4.setText("Email");
		method1(jtf4,"Email");
		panel2.add(jtf4);

		JPasswordField jtf5 = new JPasswordField();
		jtf5.setBackground(MaterialColors.RED_200);
		jtf5.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf5.setBounds(10,230,300,40);
		jtf5.setForeground(Color.gray);
		jtf5.setText("Password");
		method1(jtf5,"Password");
		panel2.add(jtf5);
		
		//label and textfield for product color
		
		JPasswordField jtf6 = new JPasswordField();
		jtf6.setBackground(MaterialColors.RED_200);
		jtf6.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf6.setBounds(10,280,300,40);
		jtf6.setForeground(Color.gray);
		jtf6.setText("Confirm Password");
		method1(jtf6,"Confirm Password");
		panel2.add(jtf6);
		
		//label and textfield for product size

		
		JTextField jtf7 = new JTextField();
		jtf7.setBackground(MaterialColors.RED_200);
		jtf7.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf7.setBounds(10,330,300,40);
		jtf7.setForeground(Color.gray);
		jtf7.setText("First Name");
		method1(jtf7,"First Name");
		panel2.add(jtf7);
		
		//label and textfield for product brands

		JTextField jtf8 = new JTextField();
		jtf8.setBackground(MaterialColors.RED_200);
		jtf8.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf8.setBounds(10,380,300,40);
		jtf8.setForeground(Color.gray);
		jtf8.setText("Last Name");
		method1(jtf8,"Last Name");
		panel2.add(jtf8);
		
		//label and textfield for product catagory
		
		JTextField jtf9 = new JTextField();
		jtf9.setBackground(MaterialColors.RED_200);
		jtf9.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf9.setBounds(10,430,300,40);
		jtf9.setForeground(Color.gray);
		jtf9.setText("Phone");
		method1(jtf9,"Phone");
		panel2.add(jtf9);
		
		//label and textfield which shows all stores which contains this product
		
		JRadioButton male = new JRadioButton("Male");
		male.setBackground(MaterialColors.GRAY_200);
		male.setBounds(10,480,150,40);
		panel2.add(male);
		JRadioButton female = new JRadioButton("Female");
		female.setBackground(MaterialColors.GRAY_200);
		female.setBounds(160,480,150,40);
		panel2.add(female);
		
		//label and combobox field which shows the availability of the product
		
		//button to save all changes
		JButton button1 = new JButton("Save Changes");
		button1.setBounds(10,530,200,50);
		button1.setBackground(MaterialColors.GREEN_100);
		button1.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button1.setBackground(MaterialColors.GREEN_100);
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button1.setBackground(MaterialColors.GREEN_100);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button1.setBackground(MaterialColors.GREEN_100);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button1.setBackground(MaterialColors.GREEN_200);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button1.setBackground(MaterialColors.GREEN_200);
			}
		});
		panel2.add(button1);
		
		add(panel2);
		

	}	
}
