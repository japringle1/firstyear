package uk.ac.sheffield.com1003.exceptions;

@SuppressWarnings("serial")
public class OutOfRangeException extends Exception {

	private int value;

	public OutOfRangeException(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
