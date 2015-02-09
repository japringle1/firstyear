package uk.ac.sheffield.com1003.collections.generics;

import java.util.ArrayList;

import uk.ac.sheffield.com1003.collections.elements.Animal;
import uk.ac.sheffield.com1003.collections.elements.Lecturer;

public class LifeWithoutGenerics {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		ArrayList list = new ArrayList();

		list.add(new Lecturer("Phil McMinn"));

		Lecturer lecturer = (Lecturer) list.get(0);
		System.out.println(lecturer.getName());

		Animal animal = (Animal) list.get(0);
		System.out.println(animal.getName());
	}
}
