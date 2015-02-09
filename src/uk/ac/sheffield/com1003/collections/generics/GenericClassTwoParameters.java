package uk.ac.sheffield.com1003.collections.generics;

public class GenericClassTwoParameters<T, V> {

	T obj1; // declare an instance variable of class T
	V obj2; // declare an instance variable of class V

	public GenericClassTwoParameters(T obj1, V obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	T getObj1() {
		return obj1;
	}

	V getObj2() {
		return obj2;
	}
}
