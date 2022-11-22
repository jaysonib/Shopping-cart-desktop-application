import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mdlaf.utils.MaterialColors;

public class UserPanel extends JPanel{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public UserPanel() {

		setLayout(null);
		setBounds(0,0,screenSize.width-200,screenSize.height-70);
		System.out.println("This is UserPanel");
		
		
		JLabel lb1 = new JLabel("User Profile");
		lb1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,35));
		lb1.setBounds(10,0,600,100);
		add(lb1);
		
		//panel for adding user information
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(MaterialColors.GRAY_200);
		panel2.setBounds(10,100,1000,430);
		
		JLabel lbProfile = new JLabel("Profile");
		lbProfile.setFont(new Font(Font.SANS_SERIF,Font.BOLD,22));
		lbProfile.setBounds(50,10,200,40);
		panel2.add(lbProfile);
		
		JLabel lb2 = new JLabel("Username");
		lb2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		lb2.setBounds(50,60,200,40);
		panel2.add(lb2);
		
		JLabel lb3 = new JLabel("Email");
		lb3.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		lb3.setBounds(50,110,200,40);
		panel2.add(lb3);
		
		JLabel lb4 = new JLabel("First name");
		lb4.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		lb4.setBounds(50,160,200,40);
		panel2.add(lb4);
		
		JLabel lb5 = new JLabel("Last name");
		lb5.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		lb5.setBounds(50,210,200,40);
		panel2.add(lb5);
		
		JLabel lb6 = new JLabel("Gender");
		lb6.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		lb6.setBounds(50,260,200,40);
		panel2.add(lb6);
		
		JLabel lb7 = new JLabel("Phone");
		lb7.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		lb7.setBounds(50,310,200,40);
		panel2.add(lb7);
		
		
		JLabel lb21 = new JLabel("sigma123");
		lb21.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb21.setBounds(450,60,200,40);
		panel2.add(lb21);
		
		JLabel lb31 = new JLabel("Sigma123@gmail.com");
		lb31.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb31.setBounds(450,110,200,40);
		panel2.add(lb31);
		
		JLabel lb41 = new JLabel("Umang");
		lb41.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb41.setBounds(450,160,200,40);
		panel2.add(lb41);
		
		JLabel lb51 = new JLabel("Patel");
		lb51.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb51.setBounds(450,210,200,40);
		panel2.add(lb51);
		
		JLabel lb61 = new JLabel("Male");
		lb61.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb61.setBounds(450,260,200,40);
		panel2.add(lb61);
		
		JLabel lb71 = new JLabel("9898982324");
		lb71.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb71.setBounds(450,310,200,40);
		panel2.add(lb71);
		
		add(panel2);
		}
}
