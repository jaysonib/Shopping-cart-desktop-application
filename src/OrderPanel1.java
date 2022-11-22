import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mdlaf.utils.MaterialColors;

public class OrderPanel1 extends JPanel {
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
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
	
	public OrderPanel1() {
		setLayout(null);
		setBounds(0,0,screenSize.width-200,screenSize.height-70);
		
		System.out.println("This is order panel");
		
		JLabel lb1 = new JLabel("Add Order");
		lb1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,35));
		lb1.setBounds(10,0,600,50);
		add(lb1);
		
		//Jlabel for date and time on right side 
		JLabel date = new JLabel();
		String date1 = "Date : " + LocalDate.now();
		date.setText(date1);
		date.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		date.setBounds(850,50,300,50);
		add(date);
		JLabel time = new JLabel("Add Order");
		date1 = "Time : "+ LocalTime.now();
		time.setText(date1);
		time.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		time.setBounds(850,90,300,50);
		add(time);
		
		
		//jlabel and textfield for customer information on left side
		JLabel lb2 = new JLabel("Customer Name :");
		lb2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb2.setBounds(10,100,200,40);
		add(lb2);
		
		JTextField jtf2 = new JTextField();
		jtf2.setBackground(MaterialColors.RED_200);		
		jtf2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf2.setBounds(200,105,300,40);
		jtf2.setForeground(Color.GRAY);
		jtf2.setText("Customer Name");
		method1(jtf2,"Customer Name");
		add(jtf2);
		
		JLabel lb3 = new JLabel("Customer Address :");
		lb3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb3.setBounds(10,150,200,50);
		add(lb3);
		
		JTextField jtf3 = new JTextField();
		jtf3.setBackground(MaterialColors.RED_200);		
		jtf3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf3.setBounds(200,155,300,40);
		jtf3.setForeground(Color.GRAY);
		jtf3.setText("Customer Address");
		method1(jtf3,"Customer Address");
		add(jtf3);
		
		JLabel lb4 = new JLabel("Customer Phone :");
		lb4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb4.setBounds(10,200,200,50);
		add(lb4);
		
		JTextField jtf4 = new JTextField();
		jtf4.setBackground(MaterialColors.RED_200);		
		jtf4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf4.setBounds(200,205,300,40);
		jtf4.setForeground(Color.GRAY);
		jtf4.setText("Customer Phone");
		method1(jtf4,"Customer Phone");
		add(jtf4);
		
		
		//jlabel and jtextfield in a row for adding details of product
		JLabel lb5 = new JLabel("Product");
		lb5.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb5.setBounds(10,250,200,50);
		add(lb5);
		
		String product[] = {"T-Shirt","Shirt"};
		JComboBox jtf5 = new JComboBox(product);
		jtf5.setBackground(Color.GRAY);
		jtf5.setBounds(10,290,200,40);
		add(jtf5);
		
		JLabel lb6 = new JLabel("Quantity");
		lb6.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb6.setBounds(240,250,200,50);
		add(lb6);
		
		JTextField jtf6 = new JTextField();
		jtf6.setBackground(MaterialColors.RED_200);		
		jtf6.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf6.setBounds(240,295,200,40);
		jtf6.setForeground(Color.GRAY);
		jtf6.setText("Quantity");
		method1(jtf6,"Quantity");
		add(jtf6);
		
		JLabel lb7 = new JLabel("Rate");
		lb7.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb7.setBounds(480,250,200,50);
		add(lb7);
		
		JTextField jtf7 = new JTextField();
		jtf7.setBackground(MaterialColors.RED_200);		
		jtf7.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf7.setBounds(480,295,200,40);
		jtf7.setForeground(Color.GRAY);
		jtf7.setText("Rate");
		method1(jtf7,"Rate");
		add(jtf7);
		
		JLabel lb8 = new JLabel("Amount");
		lb8.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb8.setBounds(720,250,200,50);
		add(lb8);
		
		JTextField jtf8 = new JTextField();
		jtf8.setBackground(MaterialColors.RED_200);		
		jtf8.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf8.setBounds(720,295,200,40);
		jtf8.setForeground(Color.GRAY);
		jtf8.setText("Amount");
		method1(jtf8,"Amount");
		add(jtf8);
		
		
		//right side the label and textfield for amount related values
		JLabel lb9 = new JLabel("Gross Amount");
		lb9.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb9.setBounds(720,350,200,50);
		add(lb9);
		
		JTextField jtf9 = new JTextField();
		jtf9.setBackground(MaterialColors.RED_200);		
		jtf9.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf9.setBounds(860,355,200,40);
		jtf9.setForeground(Color.GRAY);
		jtf9.setText("Gross Amount");
		method1(jtf9,"Gross Amount");
		add(jtf9);
		
		JLabel lb10 = new JLabel("S-charge 13%");
		lb10.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb10.setBounds(720,400,200,50);
		add(lb10);
		
		JTextField jtf10 = new JTextField();
		jtf10.setBackground(MaterialColors.RED_200);		
		jtf10.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf10.setBounds(860,405,200,40);
		jtf10.setForeground(Color.GRAY);
		jtf10.setText("S-charge 13%");
		method1(jtf10,"S-charge 13%");
		add(jtf10);
		
		JLabel lb11 = new JLabel("vat 10%");
		lb11.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb11.setBounds(720,450,200,50);
		add(lb11);
		
		JTextField jtf11 = new JTextField();
		jtf11.setBackground(MaterialColors.RED_200);		
		jtf11.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf11.setBounds(860,455,200,40);
		jtf11.setForeground(Color.GRAY);
		jtf11.setText("vat 10%");
		method1(jtf11,"vat 10%");
		add(jtf11);
		
		JLabel lb12 = new JLabel("Discount");
		lb12.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb12.setBounds(720,500,200,50);
		add(lb12);
		
		JTextField jtf12 = new JTextField();
		jtf12.setBackground(MaterialColors.RED_200);		
		jtf12.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf12.setBounds(860,505,200,40);
		jtf12.setForeground(Color.GRAY);
		jtf12.setText("Discount");
		method1(jtf12,"Discount");
		add(jtf12);
		
		JLabel lb13 = new JLabel("Net Amount");
		lb13.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		lb13.setBounds(720,550,200,50);
		add(lb13);
		
		JTextField jtf13 = new JTextField();
		jtf13.setBackground(MaterialColors.RED_200);		
		jtf13.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		jtf13.setBounds(860,555,200,40);
		jtf13.setForeground(Color.GRAY);
		jtf13.setText("Net Amount");
		method1(jtf13,"Net Amount");
		add(jtf13);
		
		//left side on bottom two button for create order and back(reset all the values).
		JButton button1 = new JButton("Create Order");
		button1.setBounds(10,570,200,40);
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
		add(button1);
		
		JButton button2 = new JButton("Back");
		button2.setBounds(240,570,200,40);
		button2.setBackground(MaterialColors.GREEN_100);
		button2.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button2.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button2.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button2.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button2.setBackground(MaterialColors.GREEN_200);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button2.setBackground(MaterialColors.GREEN_200);
			}
		});
		add(button2);
	}
}
