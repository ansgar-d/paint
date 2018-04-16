package groupd.paint;

import java.awt.Color;


/**
 * 
 * @author ansgar.goeb
 *
 */
public class CurrentPaintConfiguration {

	Shape currentShape;
	Color currentOutlineColor;
	Color currentFillColor;
	
	public Shape getCurrentShape() {
		return currentShape;
	}
	public void setCurrentShape(Shape shapeArray) {
		this.currentShape = shapeArray;
	}
	public Color getCurrentOutlineColor() {
		return currentOutlineColor;
	}
	public void setCurrentOutlineColor(Color currentOutlineColor) {
		this.currentOutlineColor = currentOutlineColor;
	}
	public Color getCurrentFillColor() {
		return currentFillColor;
	}
	public void setCurrentFillColor(Color currentFillColor) {
		this.currentFillColor = currentFillColor;
	}
}
