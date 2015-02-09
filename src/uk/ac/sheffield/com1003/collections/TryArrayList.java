package uk.ac.sheffield.com1003.collections;

import java.util.ArrayList;

public class TryArrayList {

	public static void main(String[] args) {

		ArrayList<String> lecturers = new ArrayList<String>();

		lecturers.add("Georg");
		lecturers.add("Phil");
		lecturers.add("Steve");

		// add Guy at position 1
		lecturers.add(1, "Guy");

		// remove Guy at position 1
		lecturers.remove(1);

		for (String lecturer : lecturers) {
			System.out.println(lecturer);
		}
	}

}
