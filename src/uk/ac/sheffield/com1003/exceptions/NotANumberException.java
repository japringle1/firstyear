package uk.ac.sheffield.com1003.exceptions;

@SuppressWarnings("serial")
public class NotANumberException extends Exception {

	private char c;

	public NotANumberException(char c) {
		this.c = c;
	}

	public char getCharacter() {
		return c;
	}
}
