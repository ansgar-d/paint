package groupd.paint;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JButton btnUndo = new JButton("undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paintPanel.undo();
			}
		});
		add(btnUndo);
		
		JButton btnErase = new JButton("erase");
		btnErase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paintPanel.erase();
			}
		});
		add(btnErase);
		
		JButton btnRedo = new JButton("redo");
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paintPanel.redo();
			}
		});
		add(btnRedo);
		
	}

}
