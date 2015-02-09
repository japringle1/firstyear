package uk.ac.sheffield.com1003.collections.boxing;

import java.util.ArrayList;

public class ManualBoxingExample {

	public static void main(String[] args) {

		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(new Integer(5));

		Integer boxedValue = l.get(0);
		int unboxedValue = boxedValue.intValue();

		System.out.println(unboxedValue);
	}
}
