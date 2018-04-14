package groupd.paint;

import java.awt.Color;

/**
 * 
 * @author ansgar.goeb
 *
 */
abstract class BoundedShape extends BaseShape {

	Color fillColor;
	
	public BoundedShape(int aStartX, int aStartY, Color aColor, Color aFillColor) {
		super(aStartX, aStartY, aColor);
		this.fillColor = aFillColor;

	}
	
	public Color getFillColor() {
		return fillColor;
	}

	public int getWidth() {
		
		return Math.abs( getEndX() - getStartX());
	}
	
	public int getHeight() {
		return     Math.abs(     getEndY() - getStartY());
	}
	
	public int getX() {
		 
		return Math.min(getStartX(), getEndX());
	}
	
	public int getY() {
		
		return Math.min(getStartY(), getEndY());
	}
}
