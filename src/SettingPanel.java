import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import mdlaf.utils.MaterialColors;

public class SettingPanel extends JPanel{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public SettingPanel() {
		//when company menu is clicked 
		setLayout(null);
		setBounds(0,0,screenSize.width-200,screenSize.height-70);
		
		
		//label : which gives the purpose of panel
		JLabel lb1 = new JLabel("User Setting");
		lb1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,35));
		lb1.setBounds(10,0,600,100);
		add(lb1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(MaterialColors.GRAY_200);
		panel2.setBounds(10,100,1000,600);
		
		JLabel lbUser = new JLabel("Update Information");
		lbUser.setBounds(50,10,200,40);
		lbUser.setFont(new Font(Font.SANS_SERIF,Font.BOLD,22));
		panel2.add(lbUser);
		
		//
		JLabel lb2 = new JLabel("Username");
		lb2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb2.setBounds(50,50,200,40);
		panel2.add(lb2);
		JTextField jtf2 = new JTextField();
		jtf2.setBackground(MaterialColors.RED_200);		
		jtf2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf2.setBounds(250,55,300,40);
		jtf2.setForeground(Color.GRAY);
		jtf2.setText("Sigma123");
		panel2.add(jtf2);
		
		//
		JLabel lb3 = new JLabel("Email");
		lb3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb3.setBounds(50,100,200,40);
		panel2.add(lb3);
		JTextField jtf3 = new JTextField();
		jtf3.setBackground(MaterialColors.RED_200);
		jtf3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf3.setBounds(250,105,300,40);
		jtf3.setText("sigma123@gmail.com");
		jtf3.setForeground(Color.gray);
		panel2.add(jtf3);
		
		//
		JLabel lb4 = new JLabel("First Name");
		lb4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb4.setBounds(50,150,200,40);
		panel2.add(lb4);
		JTextField jtf4 = new JTextField();
		jtf4.setBackground(MaterialColors.RED_200);
		jtf4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf4.setBounds(250,155,300,40);
		jtf4.setForeground(Color.gray);
		jtf4.setText("Umang");
		panel2.add(jtf4);
		
		//textfield for address
		JLabel lb5 = new JLabel("Last Name");
		lb5.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb5.setBounds(50,200,200,40);
		panel2.add(lb5);
		JTextField jtf5 = new JTextField();
		jtf5.setBackground(MaterialColors.RED_200);
		jtf5.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf5.setBounds(250,205,300,40);
		jtf5.setForeground(Color.gray);
		jtf5.setText("Patel");
		panel2.add(jtf5);
		
		//textfield for Phone
		JLabel lb6 = new JLabel("Phone");
		lb6.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb6.setBounds(50,250,200,40);
		panel2.add(lb6);
		JTextField jtf6 = new JTextField();
		jtf6.setBackground(MaterialColors.RED_200);
		jtf6.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf6.setBounds(250,255,300,40);
		jtf6.setForeground(Color.gray);
		jtf6.setText("9875653424");
		panel2.add(jtf6);
		
		//textfield for Country
		JLabel lb7 = new JLabel("Gender");
		lb7.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb7.setBounds(50,300,200,40);
		panel2.add(lb7);
		JRadioButton jrb71 = new JRadioButton("Male");
		jrb71.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jrb71.setBounds(250,300,100,40);
		jrb71.setBackground(MaterialColors.GRAY_200);
		//jtf7.setBackground(MaterialColors.RED_200);
		//jtf7.setForeground(Color.gray);
		jrb71.setSelected(true);
		panel2.add(jrb71);
		JRadioButton jrb72 = new JRadioButton("Female");
		jrb72.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jrb72.setBounds(350,300,300,40);
		jrb72.setBackground(MaterialColors.GRAY_200);
		//jtf7.setBackground(MaterialColors.RED_200);
		//jtf7.setForeground(Color.gray);
		panel2.add(jrb72);
		
		
		//JLabel lb6 = new JLabel("If you don't want to change the password leave it empty");
		
		JLabel lb8 = new JLabel("Password");
		lb8.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb8.setBounds(50,350,200,40);
		panel2.add(lb8);
		JPasswordField jtf8 = new JPasswordField();
		jtf8.setBackground(MaterialColors.RED_200);
		jtf8.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf8.setBounds(250,355,300,40);
		jtf8.setForeground(Color.gray);
		jtf8.setText("sigma@123");
		panel2.add(jtf8);
		
		JLabel lb9 = new JLabel("Confirm Password");
		lb9.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb9.setBounds(50,400,200,40);
		panel2.add(lb9);
		JPasswordField jtf9 = new JPasswordField();
		jtf9.setBackground(MaterialColors.RED_200);
		jtf9.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf9.setBounds(250,405,300,40);
		jtf9.setForeground(Color.gray);
		jtf9.setText("sigma@123");
		panel2.add(jtf9);
		
		
		//button to save all changes
		JButton button1 = new JButton("Save Changes");
		button1.setBounds(50,480,200,50);
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
				if(jtf9.getText().equals(jtf8.getText())) {
					 
				}else {
					JOptionPane.showMessageDialog(panel2, "Please enter password again.", "Error message", JOptionPane.OK_OPTION, null);
				}
			}
		});
		panel2.add(button1);
		JButton button2 = new JButton("Back");
		button2.setBounds(270,480,200,50);
		button2.setBackground(MaterialColors.GREEN_100);
		button2.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button2.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				button2.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				button2.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button2.setBackground(MaterialColors.GREEN_200);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button2.setBackground(MaterialColors.GREEN_200);
			}
		});
		panel2.add(button2);
		
		add(panel2);
	}	
}