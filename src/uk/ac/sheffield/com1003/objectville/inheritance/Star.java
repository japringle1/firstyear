package uk.ac.sheffield.com1003.objectville.inheritance;

public class Star extends AstronomicalObject {

	private double surfaceTemperature;

	public Star(double magnitude, double surfaceTemperature) {
		super(magnitude);
		this.surfaceTemperature = surfaceTemperature;
	}

	public double getSurfaceTemperature() {
		return surfaceTemperature;
	}

	public void printInfo() {
		super.printInfo();
		System.out.println("Surface Temperature: " + surfaceTemperature);
	}
}
