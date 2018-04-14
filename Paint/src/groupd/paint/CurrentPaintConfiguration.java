package groupd.paint;

import java.awt.Color;

public class CurrentPaintConfiguration {

	Shapes currentShape;
	Color currentOutlineColor;
	Color currentFillColor;
	
	public Shapes getCurrentShape() {
		return currentShape;
	}
	public void setCurrentShape(Shapes currentShape) {
		this.currentShape = currentShape;
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
