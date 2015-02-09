package uk.ac.sheffield.com1003.exceptions;

@SuppressWarnings("serial")
public class TooHighException extends OutOfRangeException {

	public TooHighException(int value) {
		super(value);
	}
}
