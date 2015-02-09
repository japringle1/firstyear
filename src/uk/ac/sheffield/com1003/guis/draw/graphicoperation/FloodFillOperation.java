package uk.ac.sheffield.com1003.guis.draw.graphicoperation;

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

public class FloodFillOperation extends GraphicOperation {
	private static final long serialVersionUID = 984524380781024294L;

	public FloodFillOperation(int x, int y) {
		super(x, y);
	}

	public void draw(Graphics g, BufferedImage image) {
		floodFill(x, y, image, penColour.getRGB());
	}

	protected void floodFill(int x, int y, BufferedImage image, int rgbColour) {
		class Pixel {
			int x, y;

			Pixel(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		ArrayList<Pixel> pixels = new ArrayList<Pixel>();
		pixels.add(new Pixel(x, y));

		while (pixels.size() > 0) {
			Pixel p = pixels.remove(0);

			if (inCanvas(p.x, p.y, image)
					&& fillPixel(p.x, p.y, image, rgbColour)) {
				pixels.add(new Pixel(p.x + 1, p.y));
				pixels.add(new Pixel(p.x - 1, p.y));
				pixels.add(new Pixel(p.x, p.y + 1));
				pixels.add(new Pixel(p.x, p.y - 1));
			}
		}
	}

	protected boolean inCanvas(int x, int y, BufferedImage image) {
		return (x >= 0 && y >= 0 && x < image.getWidth() && y < image
				.getHeight());
	}

	protected boolean fillPixel(int x, int y, BufferedImage image, int rgbColour) {
		if (image.getRGB(x, y) != rgbColour) {
			image.setRGB(x, y, rgbColour);
			return true;
		}
		return false;
	}
}
