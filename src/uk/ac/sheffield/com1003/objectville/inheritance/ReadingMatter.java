package uk.ac.sheffield.com1003.objectville.inheritance;

public class ReadingMatter {

	private int numPages;

	public ReadingMatter(int numPages) {
		this.numPages = numPages;
	}

	public int getNumPages() {
		return numPages;
	}

	public void printInfo() {
		System.out.println("ReadingMatter. Number of pages: " + numPages);
	}
}
