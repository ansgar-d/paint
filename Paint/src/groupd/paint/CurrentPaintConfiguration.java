package groupd.paint;

import java.awt.Color;


/**
 * 
 * @author ansgar.goeb
 * 
 * The class is used to coordinate setting between the
 * menu and the painting panel. It should be used in the
 * application as a singleton.
 */
public class CurrentPaintConfiguration {

	// the current selected shape
	Shape currentShape;
	
	// the current selected outline color
	Color currentOutlineColor;
	
	// the current selected color to fill an object
	Color currentFillColor;
	
	/**
	 * returns the currently selected shape
	 */
	public Shape getCurrentShape() {
		return currentShape;
	}
	
	/**
	 * sets an array of available shapes 
	 */
	public void setCurrentShape(Shape shapeArray) {
		this.currentShape = shapeArray;
	}
	
	/**
	 * returns the currently set outline color
	 */
	public Color getCurrentOutlineColor() {
		return currentOutlineColor;
	}
	
	/**
	 * set the outline color
	 */
	public void setCurrentOutlineColor(Color currentOutlineColor) {
		this.currentOutlineColor = currentOutlineColor;
	}
	
	/**
	 * returns the currently set color
	 */
	public Color getCurrentFillColor() {
		return currentFillColor;
	}
	
	/**
	 * sets the fill color 
	 */
	public void setCurrentFillColor(Color currentFillColor) {
		this.currentFillColor = currentFillColor;
	}
}