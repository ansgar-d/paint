package groupd.paint;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * 
 * @author ansgar.goeb
 *
 */
public class Paint {

	private JFrame mainFrame;
	private PaintPanel paintPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint window = new Paint();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Paint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame("Java Paint");
		mainFrame.setBounds(100, 100, 918, 525);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Shapes shapes = new Shapes ();
		Colors colors = new Colors ();
		
		CurrentPaintConfiguration configuration = new CurrentPaintConfiguration();

		// just for test must be replaced with menu-settings!
		// for the menu the fill color can be set to null
		// the Color (which means the outline color, or the line must allways be filled)
		configuration.setCurrentShape(shapes.shapeArray[0]);
		configuration.setCurrentOutlineColor(colors.colorArray[0]);
		configuration.setCurrentFillColor(colors.colorArray[0]);
		
		prepareMenu();

		
		paintPanel = new PaintPanel(configuration);
		mainFrame.getContentPane().add(paintPanel, BorderLayout.CENTER);

		JPanel menuPanel = new MenuPanel(configuration, paintPanel);
		mainFrame.getContentPane().add(menuPanel, BorderLayout.NORTH);

	}

	private void prepareMenu(){
		 //create a menu bar
	      final JMenuBar menuBar = new JMenuBar();
	      
	    //create menus
	      JMenu fileMenu = new JMenu("File");
	      final JMenu editMenu = new JMenu("Edit");
	    
	    //create File Menu items
	      JMenuItem newMenuItem = new JMenuItem("New");
	      newMenuItem.setActionCommand("New");
	      newMenuItem.setAccelerator(KeyStroke.getKeyStroke(
	    		    KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	      
	      JMenuItem exitMenuItem = new JMenuItem("Exit");
	      exitMenuItem.setActionCommand("Exit");
	      exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(
	    		    KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
	      
	      
	      //create Edit Menu Item
	      JMenuItem newUndoItem = new JMenuItem("Undo");
	      newUndoItem.setActionCommand("Undo");
	      newUndoItem.setAccelerator(KeyStroke.getKeyStroke(
	    		    KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
	      
	      JMenuItem newRedoItem = new JMenuItem("Redo");
	      newRedoItem.setActionCommand("Redo");
	      newRedoItem.setAccelerator(KeyStroke.getKeyStroke(
	    		    KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
	      
	      MenuItemListener menuItemListener = new MenuItemListener();

	      newMenuItem.addActionListener(menuItemListener);
	      exitMenuItem.addActionListener(menuItemListener);
	      newUndoItem.addActionListener(menuItemListener);
	      newRedoItem.addActionListener(menuItemListener);

	      
	      fileMenu.add(newMenuItem);
	      fileMenu.addSeparator();
	      fileMenu.add(exitMenuItem);
	      
	      editMenu.add(newUndoItem);
	      editMenu.add(newRedoItem);
	      
	    //add menu to menubar
	      menuBar.add(fileMenu);
	      menuBar.add(editMenu);

	      
	      //add menubar to the frame
	      mainFrame.setJMenuBar(menuBar);
	      mainFrame.setVisible(true);
	}
	
	class MenuItemListener implements ActionListener {
	      
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equalsIgnoreCase("New"))
			{
				paintPanel.erase();
			}
			else if (e.getActionCommand().equalsIgnoreCase("Exit"))
			{
				System.exit(0);
			}
			else if (e.getActionCommand().equalsIgnoreCase("Undo"))
			{
				paintPanel.undo();
			}
			else if (e.getActionCommand().equalsIgnoreCase("Redo"))
			{
				paintPanel.redo();
			}
		}    
	   }
	
}
