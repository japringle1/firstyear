package uk.ac.sheffield.com1003.exceptions;

import uk.ac.sheffield.com1003.EasyReader;
import uk.ac.sheffield.com1003.EasyWriter;

public class MySqrt {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
			EasyReader keyboard = new EasyReader();
			EasyWriter screen = new EasyWriter();
			
			double ans = 0.0;
			boolean answerGot = false;
			
			while (!answerGot) {
				try {
					double num = keyboard.readDouble("Enter a number please: ");
					ans = SquareRoot(num);
					answerGot = true;
					screen.println("Answer: "+ans);
				} catch (NegativeArgumentException e) {
					screen.println(e.getDouble() + " is a negative number, please try again.");
				}
			}
	}
	
	public static double SquareRoot(double num) throws NegativeArgumentException {
		if (num < 0) {
			throw new NegativeArgumentException(num);
		}
		return Math.sqrt(num);
	}
}
