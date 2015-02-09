package uk.ac.sheffield.com1003.collections.boxing;

import java.util.ArrayList;

public class AutoBoxingExample {

	public static void main(String[] args) {

		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(5);

		int unboxedValue = l.get(0);

		System.out.println(unboxedValue);
	}
}
