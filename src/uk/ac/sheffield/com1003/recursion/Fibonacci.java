package uk.ac.sheffield.com1003.recursion;

public class Fibonacci {

	public int fibonacci(int i) {
		if (i <= 1) {
			return i;
		} else {
			return fibonacci(i - 1) + fibonacci(i - 2);
		}
	}

}
