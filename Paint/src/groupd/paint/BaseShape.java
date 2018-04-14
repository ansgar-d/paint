package groupd.paint;

import java.awt.Color;
import java.awt.Graphics;


/**
 * 
 * @author ansgar.goeb
 *
 */
abstract class BaseShape {
	
	private int startX, startY, endX, endY;
	private Color color;

	
	public BaseShape(int aStartX, int aStartY, Color aColor) {
		
		this.startX = aStartX;
		this.startY = aStartY;
		this.color = aColor;
	}
	
	public void setEndPosition(int aEndX, int aEndY) {
		
		this.endX = aEndX;
		this.endY = aEndY;
	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public int getEndX() {
		return endX;
	}

	public int getEndY() {
		return endY;
	}

	public Color getColor() {
		return color;
	}
	
	public abstract void draw(Graphics g);
	
	
}
