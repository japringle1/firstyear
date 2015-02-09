package uk.ac.sheffield.com1003.exceptions;

public class PropagatedException {

	public void exceptionThrower() throws ExceptionA {
		throw new ExceptionA();
	}

	public void doesntHandleExceptionA() throws ExceptionA {
		exceptionThrower();
	}

	public void handleExceptionA() {
		try {
			doesntHandleExceptionA();
		} catch (ExceptionA e) {
			// ...
		}
	}
}

@SuppressWarnings("serial")
class ExceptionA extends Exception {
}
