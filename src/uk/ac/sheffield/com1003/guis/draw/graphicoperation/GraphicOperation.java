package uk.ac.sheffield.com1003.guis.draw.graphicoperation;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

public abstract class GraphicOperation implements Serializable {
	private static final long serialVersionUID = 6347488579896438079L;
	protected int x, y;
	protected Color penColour = Color.BLACK;

	public GraphicOperation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void draw(Graphics g, BufferedImage image);
}
