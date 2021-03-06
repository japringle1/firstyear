package uk.ac.sheffield.com1003.objectville.composition;

public class Dragon {

	private String name;
	private boolean breathesFire;

	public Dragon(String name, boolean breathesFire) {
		this.name = name;
		this.breathesFire = breathesFire;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isBreathesFire() {
		return breathesFire;
	}

	public void setBreathesFire(boolean breathesFire) {
		this.breathesFire = breathesFire;
	}
}
