package uk.ac.sheffield.com1003.guis.draw.graphicoperation;

import java.awt.*;
import java.awt.image.*;

public class LineOperation extends GraphicOperation {
	private static final long serialVersionUID = 8295120438565566064L;
	private int x2, y2;

	public LineOperation(int x, int y, int x2, int y2) {
		super(x, y);
		this.x2 = x2;
		this.y2 = y2;
	}

	public void draw(Graphics g, BufferedImage image) {
		g.setColor(penColour);
		g.drawLine(x, y, x2, y2);
	}
}
