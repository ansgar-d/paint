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
 * @author helmi.hasan (added save functionality)
 * 
 * Class to paint shapes
 */
public class PaintPanel extends JPanel {

    // the not yet finished currently painted shape
	private BaseShape currentShape;
	
	// shapes that are painted and which need to be reproduced when the shapes
	// are repainted
	private List<BaseShape> paintedShapes = new ArrayList<BaseShape>();
	
	// shapes that are undone, save in this list make it possible to redo them
	private List<BaseShape> undoneShapes = new ArrayList<BaseShape>();
	
	// the current configuration as an object to exchange information between
	// the menu and the paint panel
	private CurrentPaintConfiguration configuration;
	private SavePaint savePaint ;

    /**
     * constructor of the PaintPanel
     * The configuration to exchange information and the main frame to save the drawing
     * needs to be set
     */
	public PaintPanel(CurrentPaintConfiguration aConfiguration, JFrame mainFrame) {
		this.savePaint = new SavePaint(this, mainFrame);
		this.configuration = aConfiguration;
		
		initialize();
	}

	/**
	 * initialize the area  to paint
	 */
	private void initialize() {

		setLayout(new BorderLayout());
		
		// put the color of the background to white to make it look as a
		// whiteboard
		setBackground(Color.WHITE);

		// add the mouse handler for the drawing
		MouseHandler mouseHandler = new MouseHandler();
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
	}

	/**
	 * undo the previous operation - it works for all finished
	 * operations
	 */
	public void undo() {
	
		
		if (paintedShapes.size() > 0)
		{
		    // get the last shape of the list of painted shapes and add it
			// to the list of shapes that can be undone 
			undoneShapes.add(paintedShapes.get(paintedShapes.size() - 1));
			
			// remove the last painted shape of the list of shapes 
			paintedShapes.remove(paintedShapes.size() - 1);
		}
		
		// repaint the list of painted shapes
		repaint();
	}
	
	/**
	 * a shape that is undone can be redone (the undone shapes is set back
	 * to the painting)
	 */
	public void redo() {
		
		// the last undone shape is simply added to the list of painted shapes
		if(undoneShapes.size() > 0) {
			
			paintedShapes.add(undoneShapes.get(undoneShapes.size() -1 ));
			
			// remove from the list of undone shapes
			undoneShapes.remove(undoneShapes.size() -1);
		}

		// repaint the list of painted shapes
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
	
	/**
	 * deletes the whole painting - an empty whiteboard will 
	 * be shown
	 */
	public void erase() {
		
		// delete all the painted shapes
		paintedShapes.clear();
		
		// repaint the list of painted shapes
		repaint();
	}
	
	/**
	 * paints all the shapes
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// process each entry of the painted shapes 
		for (BaseShape eachshape : paintedShapes) {
			
			// call the draw method of the different shapes
			eachshape.draw(g);

		}

		// paint the not finished shape
		if (currentShape != null) {
			currentShape.draw(g);
		}

	}


	/**
	 * inner class to handle the mouse events
	 */
	private class MouseHandler extends MouseAdapter {

		/**
		 * when the mouse is pressed construct an object of the chosen shape
		 */
		public void mousePressed(MouseEvent event) {
			
			// if chosen, create a Line object
			if (configuration.getCurrentShape() == Shape.Line) {
				
				currentShape = new Line(event.getX(), event.getY(), configuration.getCurrentOutlineColor());
			
			}
			
			// if chosen, create a Rectangle object
			else if (configuration.getCurrentShape() == Shape.Rectangle) {
				
				currentShape = new Rectangle(event.getX(),event.getY(), configuration.getCurrentOutlineColor(), configuration.getCurrentFillColor());
			}
			
			// if chosen, create an Oval object
			else if (configuration.getCurrentShape() == Shape.Oval) {
				
				currentShape = new Oval(event.getX(),event.getY(), configuration.getCurrentOutlineColor(), configuration.getCurrentFillColor());
			}

		}

		/**
		 * finishes the drawing when the mouse is released
		 */
		public void mouseReleased(MouseEvent event) {

			// add the coordinates where the mouse is released
			currentShape.setEndPosition(event.getX(), event.getY());

			// add the shape to the painted shapes
			paintedShapes.add(currentShape);
			
			// set the current shape to null, because it is added to the
			// printed shapes
			currentShape = null;
			
			// repaint the list of painted shapes
			repaint();
		}

		// handle the mouse event when the mouse is dragged (but not 
		// released)
		public void mouseDragged(MouseEvent event) {

			// set the coordinates of the position where the mouse is dragged
			currentShape.setEndPosition(event.getX(), event.getY());

			// repaint the list of painted shapes and the not yet finished shape
			repaint();
		}
	}
}
