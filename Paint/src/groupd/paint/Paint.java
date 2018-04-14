package groupd.paint;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;

/**
 * 
 * @author ansgar.goeb
 *
 */
public class Paint {

	private JFrame mainFrame;

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
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 718, 525);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));

		CurrentPaintConfiguration configuration = new CurrentPaintConfiguration();
		
		configuration.setCurrentShape(Shapes.Line);
		configuration.setCurrentFillColor(Color.BLACK);
		configuration.setCurrentOutlineColor(Color.red);

		
		PaintPanel  paintPanel = new PaintPanel(configuration);
		mainFrame.getContentPane().add(paintPanel, BorderLayout.CENTER);
		
		JPanel menuPanel = new MenuPanel(configuration,paintPanel);
		mainFrame.getContentPane().add(menuPanel, BorderLayout.NORTH);
		
	
	}

}
