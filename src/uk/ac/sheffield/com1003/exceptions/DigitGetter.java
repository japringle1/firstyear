package uk.ac.sheffield.com1003.exceptions;

import uk.ac.sheffield.com1003.EasyReader;

public class DigitGetter {

	private int min, max;
	private EasyReader r;

	public DigitGetter(int min, int max) {
		this.min = min;
		this.max = max;
		this.r = new EasyReader();
	}

	public int readDigit() throws NotANumberException, TooLowException,
			TooHighException {
		char c = r.readChar();

		if (c < '0' || c > '9') {
			throw new NotANumberException(c);
		}

		int value = c - '0';

		if (value < min) {
			throw new TooLowException(value);
		}

		if (value > max) {
			throw new TooHighException(value);
		}

		return value;
	}
}
