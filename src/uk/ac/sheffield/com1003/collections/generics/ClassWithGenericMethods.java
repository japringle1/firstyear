package uk.ac.sheffield.com1003.collections.generics;

public class ClassWithGenericMethods {

	public <N> void print(N obj) {
		// print something
	}

	public <N extends Number> void print(N obj) {
		// print something
	}

	public <N> void print(GenericClass<?> obj) {
		// print something
	}

	public <N> void print2(GenericClass<? extends Number> obj) {
		// print something
	}
}
