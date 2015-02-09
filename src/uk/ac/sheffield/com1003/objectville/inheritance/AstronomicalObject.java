package uk.ac.sheffield.com1003.objectville.inheritance;

public class AstronomicalObject {

	private double magnitude;

	public AstronomicalObject(double magnitude) {
		this.magnitude = magnitude;
	}

	public double getMagnitude() {
		return magnitude;
	}

	public void printInfo() {
		System.out.println("Magnitude: " + magnitude);
	}
}
