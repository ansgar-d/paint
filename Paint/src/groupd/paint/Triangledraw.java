package groupd.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;


/**
 * 
 * @author chan
 *
 */
public class Triangledraw extends BoundedShape {

	public void Triangledraw(Graphics g, int aStartX, int aStartY, int x2, int y2, int x3, int y3, Color aColor, Color aFillColor) {
		Polygon filledPolygon = new Polygon ();
		filledPolygon.addPoint(aStartX, aStartY);
		filledPolygon.addPoint(x2, y2);
		filledPolygon.addPoint(x3, y3);
		
		g.setColor(getFillColor());
		g.drawPolygon(filledPolygon);
	}
}
	