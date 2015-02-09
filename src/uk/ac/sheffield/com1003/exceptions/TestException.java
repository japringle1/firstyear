package uk.ac.sheffield.com1003.exceptions;

import org.junit.*;

public class TestException {

	CheckedVsUncheckedException c = new CheckedVsUncheckedException();

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testArrayIndexOutOfBounds() {
		c.arrayIndexOutOfBounds();
	}

	@Test(expected = NotANumberException.class)
	public void testNotANumberException() throws NotANumberException {
		c.notANumber();
	}
}
