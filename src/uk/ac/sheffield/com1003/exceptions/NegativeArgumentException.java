package uk.ac.sheffield.com1003.exceptions;

@SuppressWarnings("serial")
public class NegativeArgumentException extends Exception {

	private double c;
	
	public NegativeArgumentException(double c) {
		this.c = c;
	}
	
	public double getDouble() {
		return c;
	}
}
