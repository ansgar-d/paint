package groupd.paint;

import java.awt.Color;
import java.awt.Graphics;


/** 
 * 
 * @author ansgar.goeb
 * 
 * The class is the base class for any shapes that
 * can be used in the painting program. In case a
 * shape does not extend (directly or indirectly)
 * it cannot be used in the painting program. The
 * class is abstract because it cannot paint
 * anything.
 */
abstract class BaseShape {
	
	// the start and end coordinates from any shape
	private int startX, startY, endX, endY;
	
	// the color of the shape 
	private Color color;

	
	/** 
	 * constructor of the base class - when a shape starts to
     * draw at least the start coordinates and the color must
	 * be available
	 */
	public BaseShape(int aStartX, int aStartY, Color aColor) {
		
		this.startX = aStartX;
		this.startY = aStartY;
		this.color = aColor;
	}
	
	
	/**
	 * sets the coordinates when drawing is stopped
	 */
	public void setEndPosition(int aEndX, int aEndY) {
		
		this.endX = aEndX;
		this.endY = aEndY;
	}

	/**
	 * returns the start of drawing x-coordinate
	 */
	public int getStartX() {
		return startX;
	}

	/**
	 * returns the start of drawing y-coordinate
	 */
	public int getStartY() {
		return startY;
	}

	/**
	 * returns the end of drawing x-coordinate
	 */
	public int getEndX() {
		return endX;
	}

	/**
	 * returns the end of drawing y-coordinate
	 */
	public int getEndY() {
		return endY;
	}

	/**
	 * returns the color of the object
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * abstract method, that needs to be implemented
	 * for each concrete shape
	 */
	public abstract void draw(Graphics g);
}
