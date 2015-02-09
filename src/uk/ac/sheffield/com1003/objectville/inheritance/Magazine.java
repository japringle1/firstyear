package uk.ac.sheffield.com1003.objectville.inheritance;

public class Magazine extends ReadingMatter {

	private String name, periodicity;

	public Magazine(int numPages, String name, String periodicity) {
		super(numPages);
		this.name = name;
		this.periodicity = periodicity;
	}

	public String getPeriodicity() {
		return periodicity;
	}

	public void printInfo() {
		System.out.println("Magazine. Name: " + name + ". " + "Periodicity: "
				+ periodicity + ". " + "No. pages: " + getNumPages());
	}
}
