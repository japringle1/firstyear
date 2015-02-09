package uk.ac.sheffield.com1003.objectville.abstractclasses;

import uk.ac.sheffield.com1003.EasyGraphics;

public abstract class Shape {

	protected int x, y;

	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(int newX, int newY) {
		this.x = newX;
		this.y = newY;
	}

	public abstract double getArea();

	public abstract void draw(EasyGraphics g);
}
