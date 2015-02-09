package uk.ac.sheffield.com1003.objectville.inheritance;

public class Book extends ReadingMatter {

	private String name, author;

	public Book(int numPages, String name, String author) {
		super(numPages);
		this.name = name;
		this.author = author;
	}

	public void printInfo() {
		System.out.println("Book. Name: " + name + ". " + "Author: " + author
				+ ". " + "No. pages: " + getNumPages());
	}
}
