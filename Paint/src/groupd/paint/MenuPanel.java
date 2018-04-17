package groupd.paint;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	
	private CurrentPaintConfiguration configuration;
//	private PaintPanel paintPanel;
	
	public MenuPanel(CurrentPaintConfiguration aConfigurration, PaintPanel aPaintPanel) {

		this.configuration = aConfigurration;
//		this.paintPanel = aPaintPanel;
		
		
		
		initialize();
		
	}
	
	private void initialize() {
		
		Colors colors = new Colors();

		Shapes shapes = new Shapes();
		
		JComboBox<String> shapeCombo = new JComboBox<String>(shapes.shapeOptions);
		shapeCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int selectedIndex = shapeCombo.getSelectedIndex();
				  configuration.setCurrentShape(shapes.shapeArray[selectedIndex]);
			}
		});
		add(shapeCombo);
		
//		JButton btnUndo = new JButton("undo");
//		btnUndo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				paintPanel.undo();
//			}
//		});
//		add(btnUndo);
//		
//		JButton btnErase = new JButton("erase");
//		btnErase.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				paintPanel.erase();
//			}
//		});
//		add(btnErase);
//		
//		JButton btnRedo = new JButton("redo");
//		btnRedo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				paintPanel.redo();
//			}
//		});
//		add(btnRedo);
		
		JLabel outlineLabel = new JLabel("Outline Color : ");
		add(outlineLabel);
		
		JComboBox<String> outLineColorCombo = new JComboBox<String>(colors.colorOptions);
		outLineColorCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			int selectedIndex = outLineColorCombo.getSelectedIndex();
			  configuration.setCurrentOutlineColor(colors.colorArray[selectedIndex]);
				
			}
		});
		add(outLineColorCombo);
		
		
		JLabel filledColor = new JLabel("Filled Color : ");
		add(filledColor);
		
		JComboBox<String> filledColorCombo = new JComboBox<String>(colors.colorOptions);
		filledColorCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			int selectedIndex = filledColorCombo.getSelectedIndex();
			  configuration.setCurrentFillColor(colors.colorArray[selectedIndex]);
				
			}
		});
		add(filledColorCombo);
		
	}

}
