package groupd.paint;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ansgar.goeb
 *
 */
public class PaintPanel extends JPanel {

	private BaseShape currentShape;
	private List<BaseShape> paintedShapes = new ArrayList<BaseShape>();
	private List<BaseShape> undoneShapes = new ArrayList<BaseShape>();
	private CurrentPaintConfiguration configuration;
	private SavePaint savePaint ;

	
	public PaintPanel(CurrentPaintConfiguration aConfiguration, JFrame mainFrame) {
		this.savePaint = new SavePaint(this, mainFrame);
		this.configuration = aConfiguration;
		initialize();
	}

	private void initialize() {

		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		MouseHandler mouseHandler = new MouseHandler();
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);

	}

	public void undo() {
	
		if (paintedShapes.size() > 0)
		{
			undoneShapes.add(paintedShapes.get(paintedShapes.size() - 1));
			paintedShapes.remove(paintedShapes.size() - 1);
		}
		
		repaint();
	}
	
	public void redo() {
		if(undoneShapes.size() > 0) {
			paintedShapes.add(undoneShapes.get(undoneShapes.size() -1 ));
			undoneShapes.remove(undoneShapes.size() -1);
		}

		repaint();
	}
	
	public void save() {
		savePaint.save();
	}
	
	public void saveAs() {
		savePaint.saveAs();
	}
	
	public void autoSave() {
		savePaint.autoSave();
	}
	
	public void erase() {
		paintedShapes.clear();
		repaint();
	}
	
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		for (BaseShape eachshape : paintedShapes) {
			eachshape.draw(g);

		}

		if (currentShape != null) {
			currentShape.draw(g);
		}

	}

	private class MouseHandler extends MouseAdapter {

		public void mousePressed(MouseEvent event) {
			
			if (configuration.getCurrentShape() == Shape.Line) {
				
				currentShape = new Line(event.getX(), event.getY(), configuration.getCurrentOutlineColor());
			
			}
			
			else if (configuration.getCurrentShape() == Shape.Rectangle) {
				
				currentShape = new Rectangle(event.getX(),event.getY(), configuration.getCurrentOutlineColor(), configuration.getCurrentFillColor());
			}
			
			else if (configuration.getCurrentShape() == Shape.Oval) {
				
				currentShape = new Oval(event.getX(),event.getY(), configuration.getCurrentOutlineColor(), configuration.getCurrentFillColor());
			}

		}

		public void mouseReleased(MouseEvent event) {

			currentShape.setEndPosition(event.getX(), event.getY());

			paintedShapes.add(currentShape);
			currentShape = null;
			repaint();

		}

		public void mouseDragged(MouseEvent event) {

			currentShape.setEndPosition(event.getX(), event.getY());
			repaint();
		}

	}

}
