package uk.ac.sheffield.com1003.exceptions;

@SuppressWarnings("serial")
public class TooLowException extends OutOfRangeException {

	public TooLowException(int value) {
		super(value);
	}
}
