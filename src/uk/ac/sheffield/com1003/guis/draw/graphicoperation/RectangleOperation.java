package uk.ac.sheffield.com1003.guis.draw.graphicoperation;

import java.awt.*;
import java.awt.image.*;

public class RectangleOperation extends GraphicOperation {
	private static final long serialVersionUID = -1645774737917099830L;
	private int width, height;

	public RectangleOperation(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	public void draw(Graphics g, BufferedImage image) {
		g.setColor(penColour);
		g.drawRect(x, y, width, height);
	}
}
