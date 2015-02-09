package uk.ac.sheffield.com1003.objectville.abstractclasses;

import uk.ac.sheffield.com1003.EasyGraphics;

public class Circle extends Shape {

	private int radius;

	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public void draw(EasyGraphics g) {
		g.drawEllipse(x, y, radius, radius);
	}
}
