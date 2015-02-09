package uk.ac.sheffield.com1003.recursion;

public class PrintDownFrom {

	void printDownFrom(int i) {
		System.out.println(i);
		if (i > 1) {
			printDownFrom(i - 1);
		}
	}

	public static void main(String[] args) {
		PrintDownFrom p = new PrintDownFrom();
		p.printDownFrom(10);
	}

}
