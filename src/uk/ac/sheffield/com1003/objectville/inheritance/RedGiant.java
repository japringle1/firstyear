package uk.ac.sheffield.com1003.objectville.inheritance;

public class RedGiant extends Star {

	private double yearsToExtinction;

	public RedGiant(double magnitude, double surfaceTemperature,
			double yearsToExtinction) {
		super(magnitude, surfaceTemperature);
		this.yearsToExtinction = yearsToExtinction;
	}

	public double getYearsToExtinction() {
		return yearsToExtinction;
	}

	public void printInfo() {
		super.printInfo();
		System.out.println("Years to extinction: " + yearsToExtinction);
	}
}
