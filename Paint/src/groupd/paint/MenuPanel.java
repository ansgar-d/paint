package groupd.paint;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class MenuPanel extends JPanel {
	
	private CurrentPaintConfiguration configuration;
	private PaintPanel paintPanel;
	
	public MenuPanel(CurrentPaintConfiguration aConfigurration, PaintPanel aPaintPanel) {

		this.configuration = aConfigurration;
		this.paintPanel = aPaintPanel;
		
		initialize();
		
	}
	
	private void initialize() {
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		add(mnNewMenu);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);
		
	}

}
