package uk.ac.sheffield.com1003.objectville.inheritance;

public class Newspaper extends ReadingMatter {

	private String headline;

	public Newspaper(int numPages, String headline) {
		super(numPages);
		this.headline = headline;
	}

	public String getHeadline() {
		return headline;
	}

	public void printInfo() {
		System.out.println("Newspaper. Headline: " + headline + ". "
				+ "No. pages: " + getNumPages());
	}
}
