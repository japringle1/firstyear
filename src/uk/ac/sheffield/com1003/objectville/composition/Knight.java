package uk.ac.sheffield.com1003.objectville.composition;

public class Knight {

	private String name;
	private Dragon dragon;

	public Knight(String name) {
		this.name = name;
	}

	public Knight(String name, Dragon dragon) {
		this.name = name;
		this.dragon = dragon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dragon getDragon() {
		return dragon;
	}

	public void setDragon(Dragon dragon) {
		this.dragon = dragon;
	}

	public String toString() {
		String s = "Knight: " + name;
		if (dragon != null) {
			s += ", his dragon is: " + dragon.getName();
		}
		return s;
	}
}
