package uk.ac.sheffield.com1003.guis.draw.graphicoperation;

import java.awt.*;
import java.awt.image.*;

public class EllipseOperation extends GraphicOperation {
	private static final long serialVersionUID = 3210667771252852200L;
	private int xRadius, yRadius;

	public EllipseOperation(int x, int y, int xRadius, int yRadius) {
		super(x, y);
		this.xRadius = xRadius;
		this.yRadius = yRadius;
	}

	public void draw(Graphics g, BufferedImage image) {
		g.setColor(penColour);
		g.drawOval(x - xRadius / 2, y - yRadius / 2, xRadius, yRadius);
	}
}
