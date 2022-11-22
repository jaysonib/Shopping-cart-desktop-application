import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.table.AbstractTableModel;

import DatabaseConnection.ConnectToDatabase;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.components.label.MaterialLabelUI;
import mdlaf.components.scrollbar.MaterialScrollBarUI;
import mdlaf.components.table.MaterialTableCellRenderer;
import mdlaf.components.table.MaterialTableUI;
import mdlaf.utils.MaterialColors;

public class ProductPanel1 extends JPanel{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public ProductPanel1() {
		//for panel
		setForeground(Color.black);
		setBounds(0,0,screenSize.width-200,screenSize.height-70);
		
		//heading label
		JLabel lb1 = new JLabel("Manage Product");
		lb1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,35));
		lb1.setBounds(10,0,600,100);
		add(lb1);
		
		//button to add new Brands
		/*JButton b= new JButton("Add Brands");
		b.setMaximumSize(new Dimension (200, 200));
		b.setBounds(10,100,200,40);
		b.setBackground(MaterialColors.GREEN_100);
		b.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				b.setBackground(MaterialColors.GREEN_100);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				b.setBackground(MaterialColors.GREEN_100);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				b.setBackground(MaterialColors.GREEN_100);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				b.setBackground(MaterialColors.GREEN_200);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				b.setBackground(MaterialColors.GREEN_200);
				JFrame fm = new CustomJFrame("Enter the Brands name", "Enter the status", "Add Brands");
				fm.setMinimumSize (new Dimension (550, 300));
				fm.setUndecorated(true);

				fm.setVisible(true);
				
			}
		});
		add(b);*/
		
		
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
		MaterialTableUI.createUI(jt1);
		MaterialScrollBarUI.createUI(jts1);
		
	}
	public static class JTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private static final String[] COLUMN_NAMES = new String[] {"Name", "Price", "Quantity", "Description", "Color,Size", "Brands", "Catagory", "Stores", "Availability",  "Edit", "Delete"};
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, JButton.class, JButton.class};
		String data[][];
		
		public JTableModel(){
			
			ConnectToDatabase db = new ConnectToDatabase();
			db.connectionDatabase();
			CallableStatement cstmt = null;
			
			try {
				String tot = "{call ProductsTotal()}";
				cstmt = db.cn.prepareCall(tot);
				ResultSet rs = cstmt.executeQuery();
				int temp=0;
				while(rs.next()) {
					temp++;
				}
				String s[][] = new String[temp][9];
				data = s;
				try {
					String retrive = "{call Products_Retrive()}";
					cstmt = db.cn.prepareCall(retrive);
					rs = cstmt.executeQuery();
					int i = 0;
					while(rs.next()) {
						data[i][0] = rs.getString("name");
						data[i][1] = rs.getString("price");
						data[i][2] = rs.getString("qty");
						data[i][3] = rs.getString("description");
						data[i][4] = rs.getString("attribute_value_id");
						data[i][5] = rs.getString("brand_id");
						data[i][6] = rs.getString("catagory_id");
						data[i][7] = "Store "+rs.getString("store_id");
						if(rs.getString("availability").equals("2")) {
							data[i][8] = "NO";
						}else {
							data[i][8] = "YES";
						}
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
				String delB = "{call ProductDelete(?)}";
				cstmt = db.cn.prepareCall(delB);
				cstmt.setString("@NAME", st);
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
				case 0: return data[rowIndex][0];
				case 1: return data[rowIndex][1];
				case 2: return data[rowIndex][2];
				case 3: return data[rowIndex][3];
				case 4: return data[rowIndex][4];
				case 5: return data[rowIndex][5];
				case 6: return data[rowIndex][6];
				case 7: return data[rowIndex][7];
				case 8: return data[rowIndex][8];
				

				case 9: // fall through
					ImageIcon icon1 = new ImageIcon("delete1.png");
					
//					IconImage newIcon = new IconImage(bi);
					
					final JButton button1 = new JButton();
					button1.setIcon(icon1);
					button1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String color[] = data[rowIndex][4].split(" ");
							JFrame frame1 = new CustomJFrame1(data[rowIndex][0],data[rowIndex][1],data[rowIndex][2],data[rowIndex][3],color[0],color[1],data[rowIndex][5],data[rowIndex][6],data[rowIndex][7],data[rowIndex][8]);
							frame1.setMinimumSize (new Dimension (550, 300));
							frame1.setUndecorated(true);
							frame1.setVisible(true);
						}
					});
					return button1;
				case 10: // fall through
					ImageIcon icon = new ImageIcon("delete1.png");
					
//					IconImage newIcon = new IconImage(bi);
					
					final JButton button = new JButton();
					button.setIcon(icon);
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							deleteData(data[rowIndex][0]);
							JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button), 
									"The row number "+rowIndex + "is delete from the Product table");
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