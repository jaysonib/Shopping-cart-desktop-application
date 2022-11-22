import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import mdlaf.components.button.MaterialButtonUI;
import mdlaf.components.label.MaterialLabelUI;
import mdlaf.components.scrollbar.MaterialScrollBarUI;
import mdlaf.components.table.MaterialTableCellRenderer;
import mdlaf.components.table.MaterialTableUI;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialFonts;

public class GroupPanel extends JPanel{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public GroupPanel() {
		setForeground(Color.black);
		setBounds(0,0,screenSize.width-200,screenSize.height-70);
		System.out.println("This is UserPanel");
		
		
		JLabel lb1 = new JLabel("Manage Groups");
		lb1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,35));
		lb1.setBounds(10,0,600,100);
		add(lb1);
		
		JButton b= new JButton("submit");
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
				JFrame fm = new CustomJFrame("Enter the Item name", "Enter the item price","Groups panel");
				fm.setMinimumSize (new Dimension (550, 300));
				fm.setUndecorated(true);

				fm.setVisible(true);
				
			}
		});
		add(b);
		
		
		
		JTable jt1 = new JTable(new JTableModel());
		jt1.setBackground(MaterialColors.CYAN_100);
		jt1.setBounds(10,200,screenSize.width-200,screenSize.height-280);
		jt1.getColumn("Button1").setCellRenderer(new JTableButtonRenderer());
		
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
		private static final String[] COLUMN_NAMES = new String[] {"Id", "Stuff", "Button1"};
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {Integer.class, String.class, JButton.class};
		Object data[][] = {{1,"12334534"},
				{2,"33532344"},
				{2,"33532344"},
				{2,"33532344"},
				{2,"33532344"},
				{2,"33532344"},
				{2,"33532344"},
				{2,"33532344"},
				{2,"33532344"},
				{2,"33532344"},
				{2,"33532344"},
				{2,"33532344"},
				{3,"33532344"},
				{3,"33532344"}};

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
				case 2: // fall through
						ImageIcon icon = new ImageIcon("delete1.png");
						
//						IconImage newIcon = new IconImage(bi);
						
						final JButton button = new JButton();
						button.setIcon(icon);
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								System.out.println("Button is clicked");
								JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button), 
										"Button clicked for row "+rowIndex);
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