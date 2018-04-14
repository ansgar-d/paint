package groupd.paint;

import javax.swing.JOptionPane;
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
	private CurrentPaintConfiguration configuration;

	public PaintPanel(CurrentPaintConfiguration aConfiguration) {
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
			
			if (configuration.getCurrentShape() == Shapes.Line) {
				
				currentShape = new Line(event.getX(), event.getY(), configuration.getCurrentOutlineColor());
			
			}
			
			else if (configuration.getCurrentShape() == Shapes.Rectangle) {
				
				currentShape = new Rectangle(event.getX(),event.getY(), configuration.getCurrentOutlineColor(), configuration.getCurrentFillColor());
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
