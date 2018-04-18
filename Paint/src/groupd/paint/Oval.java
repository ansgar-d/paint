package groupd.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 * @author ansgar.goeb
 * 
 * Class paints an Oval
 */
public class Oval extends BoundedShape {

    /** 	
     * Constructor of an Oval. The start coordinates of
     * the object, the color of the outline and the fill color
     * needs to be set.
     */
	public Oval(int aStartX, int aStartY, Color aColor, Color aFillColor) {
		super(aStartX, aStartY, aColor, aFillColor);
	}


	/**
	 * draws an Oval
	 */
	@Override
	public void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		if (getFillColor() != null) {

			g2.setColor(getFillColor());
			g2.fillOval(getX(), getY(), getWidth(), getHeight());
		}

		g2.setStroke(new BasicStroke(2));
		g2.setColor(getColor());

		g2.drawOval(getX(), getY(), getWidth(), getHeight());
	}
}
