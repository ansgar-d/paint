package groupd.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


/**
 * 
 * @author ansgar.goeb
 *
 */
public class Rectangle extends BoundedShape {

	public Rectangle(int aStartX, int aStartY, Color aColor, Color aFillColor) {
		super(aStartX, aStartY, aColor, aFillColor);
	}

	
	@Override
	public void draw(Graphics g) {
	
		Graphics2D g2 = (Graphics2D) g;
		
		if (getFillColor() != null) {

			g2.setColor(getFillColor());
			g2.fillRect(getX() , getY() ,getWidth(), getHeight() );
		}
		
		g2.setStroke(new BasicStroke(2));
		g2.setColor(getColor());

		g2.drawRect(getX(), getY(),getWidth(), getHeight());
	}
}

