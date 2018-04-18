package groupd.paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author ansgar.goeb
 * 
 *         Shape that draws a line
 */
public class Line extends BaseShape {

	/**
	 * constructor of a line the start coordinates and the color of the lines must
	 * be set
	 */
	public Line(int aStartX, int aStartY, Color aColor) {
		super(aStartX, aStartY, aColor);
	}

	/**
	 * methods to draw aline
	 */
	@Override
	public void draw(Graphics g) {

		g.setColor(getColor());
		g.drawLine(getStartX(), getStartY(), getEndX(), getEndY());
	}
}
