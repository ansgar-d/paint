package groupd.paint;

import java.awt.Color;

/**
 * 
 * @author ansgar.goeb
 *
 * Abstract class that can be used to construct any
 * shape that can be constructed with start coordinates
 * and a bound (width and height)
 */
abstract class BoundedShape extends BaseShape {

	// the fill-color of the shape
	Color fillColor;
	
	
	/**
	 * The constructor of the abstract class. When a bounded shape is
	 * constructed at least the start coordinates, the color of the outline
	 * and the color to fill the object needs to be available
	 */
	public BoundedShape(int aStartX, int aStartY, Color aColor, Color aFillColor) {
		super(aStartX, aStartY, aColor);
		this.fillColor = aFillColor;
	}

	
	/**
	 * returns the fill color of the object
	 */
	public Color getFillColor() {
		return fillColor;
	}

	
	/**
	 * returns the width of the shape
	 */
	public int getWidth() {
		
		return Math.abs( getEndX() - getStartX());
	}
	
	
	/**
	 * returns the height of the shape
	 */
	public int getHeight() {
		return     Math.abs(     getEndY() - getStartY());
	}
	
	/**
	 * returns the start x-coordinate
	 */
	public int getX() {
		 
		return Math.min(getStartX(), getEndX());
	}
	
	/**
	 * returns the start y-coordinate
	 */
	public int getY() {
		
		return Math.min(getStartY(), getEndY());
	}
}
