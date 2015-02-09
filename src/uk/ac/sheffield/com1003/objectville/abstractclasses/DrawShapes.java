package uk.ac.sheffield.com1003.objectville.abstractclasses;

import uk.ac.sheffield.com1003.EasyGraphics;

public class DrawShapes {

	public static void main(String[] args) {
		EasyGraphics g = new EasyGraphics(200, 200);

		Shape[] shapes = { new Rectangle(10, 10, 75, 50),
				new Circle(75, 75, 50), new EquilateralTriangle(165, 175, 50) };

		for (int i = 0; i < shapes.length; i++) {
			shapes[i].draw(g);
		}
	}
}
