import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import DatabaseConnection.ConnectToDatabase;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.components.label.MaterialLabelUI;
import mdlaf.components.scrollbar.MaterialScrollBarUI;
import mdlaf.components.table.MaterialTableCellRenderer;
import mdlaf.components.table.MaterialTableUI;
import mdlaf.utils.MaterialColors;

public class newAttributesPanel extends JFrame{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private JPanel contentPane;
	public static String tempName = "";
	public newAttributesPanel(String name) {
		//for panel
		tempName = name;
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
		
		//heading label
		JLabel lb1 = new JLabel("Manage Attributes "+name);
		lb1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,35));
		lb1.setBounds(10,0,400,50);
		add(lb1);
		
		
		JLabel lb2 = new JLabel("Attribute name : "+name);
		lb2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		lb2.setBounds(10,60,500,50);
		add(lb2);
		
		//button to add new Brands
		JButton b= new JButton("Add Value");
		b.setMaximumSize(new Dimension (200, 200));
		b.setBounds(10,110,200,40);
		b.setBackground(MaterialColors.GREEN_100);
		b.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				b.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				b.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				b.setBackground(MaterialColors.GREEN_100);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				b.setBackground(MaterialColors.GREEN_200);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				b.setBackground(MaterialColors.GREEN_200);
				JFrame fm = new CustomJFrame("Enter the Attribute name" , name);
				fm.setMinimumSize (new Dimension (550, 300));
				fm.setUndecorated(true);
				fm.setVisible(true);	
			}
		});
		add(b);
		
		//jtable to show the data with fields : 
		JTable jt1 = new JTable(new JTableModel());
		jt1.setBackground(MaterialColors.CYAN_100);
		jt1.setBounds(10,200,screenSize.width-200,screenSize.height-280);
		jt1.getColumn("Edit").setCellRenderer(new JTableButtonRenderer());
		jt1.getColumn("Delete").setCellRenderer(new JTableButtonRenderer());
		
		jt1.addMouseListener(new JTableButtonMouseListener(jt1));
		
		JScrollPane jts1 = new JScrollPane(jt1);
		jts1.setBounds(10,200,screenSize.width-200,screenSize.height-280);
		jts1.setForeground(MaterialColors.RED_500);
		add(jts1);
		
		
		MaterialLabelUI.createUI(lb1);
		MaterialButtonUI.createUI(b);
		MaterialTableUI.createUI(jt1);
		MaterialScrollBarUI.createUI(jts1);
		
	}
	public static class JTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private static final String[] COLUMN_NAMES = new String[] {"Name","Edit","Delete"};
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {Integer.class, String.class, JButton.class};
		
		String data[];
		
		public JTableModel(){
			
			ConnectToDatabase db = new ConnectToDatabase();
			db.connectionDatabase();
			CallableStatement cstmt = null;
			
			try {
				String tot = "";
				if(tempName.equals("Color")) {
					tot = "{call ColorCount()}";
				}else if(tempName.equals("Size")) {
					tot = "{call SizeCount()}";
				}
				cstmt = db.cn.prepareCall(tot);
				ResultSet rs = cstmt.executeQuery();
				int temp=0;
				while(rs.next()) {
					temp++;
				}
				String s[] = new String[temp];
				data = s;
				try {
					String retrive = new String(tot);
					cstmt = db.cn.prepareCall(retrive);
					rs = cstmt.executeQuery();
					int i = 0;
					while(rs.next()) {
						data[i] = rs.getString("name");
						i++;
					}
				}catch(SQLException e) {
					System.out.println("There might be some error for retriving data from the database");
				}
			}catch(SQLException e) {
				
			}
			db.disconnectDatabase();
		}
		
		public void deleteData(String st) {
			ConnectToDatabase db = new ConnectToDatabase();
			db.connectionDatabase();
			CallableStatement cstmt = null;
			
			try {
				String delB = "";
				if(tempName.equals("Color")) {
					delB = "{call ColorDelete(?)}";
				}else if(tempName.equals("Size")) {
					delB = "{call SizeDelete(?)}";
				}
				cstmt = db.cn.prepareCall(delB);
				cstmt.setString("@NAME1", st);
				cstmt.execute();				
			}catch(SQLException e) {
				System.out.println("There might be some error to delete this product");
			}
			db.disconnectDatabase();
		}


		
		@Override public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override public int getRowCount() {
			return data.length;
		}
		
		@Override public String getColumnName(int columnIndex) {
	        return COLUMN_NAMES[columnIndex];
	    }
		
		@Override public Class<?> getColumnClass(int columnIndex) {
			return COLUMN_TYPES[columnIndex];
		}

		@Override public Object getValueAt(final int rowIndex, final int columnIndex) {
			switch (columnIndex) {
				case 0: return data[rowIndex];
				case 1:
					ImageIcon icon1 = new ImageIcon("delete1.png");
					
//					IconImage newIcon = new IconImage(bi);
					
					final JButton button1 = new JButton();
					button1.setIcon(icon1);
					button1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							JFrame fm = new CustomJFrame("Enter the Attribute name", "Edit Attribute", tempName, data[rowIndex]);
							fm.setMinimumSize (new Dimension (550, 300));
							fm.setUndecorated(true);
							fm.setVisible(true);
						}
					});
					return button1;
		
				case 2: // fall through
						ImageIcon icon = new ImageIcon("delete1.png");
						final JButton button = new JButton();
						button.setIcon(icon);
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								deleteData(data[rowIndex]);
								JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button), 
										"The row number "+rowIndex+" is deleted from the table");
							}
						});
						return button;
				default: return "Error";
			}
		}	
	}
	
	public class JTableButtonRenderer extends MaterialTableCellRenderer {
		  @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		    JButton button = (JButton)value;
		    MaterialButtonUI.createUI(button);
		    ImageIcon icon1 = new ImageIcon("delete1.png");
		    ImageIcon icon2 = new ImageIcon("delete2.png");
		    if (hasFocus)
            {
		    	  button.setForeground(MaterialColors.WHITE);
			      button.setBackground(MaterialColors.CYAN_200);
			      button.setIcon(icon2);
            }
		    else if (isSelected) {
			      button.setForeground(MaterialColors.WHITE);
			      button.setBackground(MaterialColors.CYAN_100);
			      button.setIcon(icon2);
		    } else {
			      button.setForeground(MaterialColors.CYAN_900);
			      button.setBackground(MaterialColors.WHITE);
			      button.setIcon(icon1);
		    }
		    return button;
		  }
		}
	public class JTableButtonMouseListener extends MouseAdapter {
		  private final JTable table;
				
		  public JTableButtonMouseListener(JTable table) {
		    this.table = table;
		  }
	
		  @Override public void mouseClicked(MouseEvent e) {
		    int column = table.getColumnModel().getColumnIndexAtX(e.getX());
		    int row    = e.getY()/table.getRowHeight(); 
	
		    if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
		      Object value = table.getValueAt(row, column);
		      if (value instanceof JButton) {
		        ((JButton)value).doClick();
		      }
		    }
		  }
		}	
}