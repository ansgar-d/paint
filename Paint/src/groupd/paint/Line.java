package groupd.paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author ansgar.goeb
 *
 */
public class Line extends BaseShape {

	public Line(int aStartX, int aStartY, Color aColor) {
		super(aStartX, aStartY, aColor);
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(getColor());
		g.drawLine(getStartX(), getStartY(), getEndX(), getEndY());

	}

}
