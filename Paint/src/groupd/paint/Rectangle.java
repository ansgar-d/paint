package groupd.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 * @author ansgar.goeb
 * 
 *         Paints a rectangle.
 * 
 */
public class Rectangle extends BoundedShape {

	/**
	 * Constructor of an Rectangle. The start coordinates of the object, the color
	 * of the outline and the fill color needs to be set.
	 */
	public Rectangle(int aStartX, int aStartY, Color aColor, Color aFillColor) {
		super(aStartX, aStartY, aColor, aFillColor);
	}

	/**
	 * paints a rectangle
	 */
	@Override
	public void draw(Graphics g) {

		// use 2D graphics because it's possible to set an outline
		Graphics2D g2 = (Graphics2D) g;

		// set the fill color in case the user has chosen to use one
		if (getFillColor() != null) {

			g2.setColor(getFillColor());
			
			// set the coordinates - the width and height is calculated in the
			// BoundedShape
			g2.fillRect(getX(), getY(), getWidth(), getHeight());
		}

		// set the outline of the shape - the color must be set because otherwise
		// the shape is invisible 
		g2.setStroke(new BasicStroke(2));
		g2.setColor(getColor());

		// draw the rectangle
		g2.drawRect(getX(), getY(), getWidth(), getHeight());
	}
}
