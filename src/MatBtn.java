import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import mdlaf.MaterialLookAndFeel;
import mdlaf.components.button.*;

public class MatBtn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel (new MaterialLookAndFeel());
			
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace ();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatBtn frame = new MatBtn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MatBtn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JButton btn = new JButton("Sigma");
		btn.setBounds(0, 0, 80, 20);
		add(btn);
		MaterialButtonUI.createUI(btn);
	}

}
