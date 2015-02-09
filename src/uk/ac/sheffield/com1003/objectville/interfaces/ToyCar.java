package uk.ac.sheffield.com1003.objectville.interfaces;

public class ToyCar extends Car implements Toy {

	private int ageSuitableFor;

	public ToyCar(int numWheels, int numDoors, int ageSuitableFor) {
		super(numWheels, numDoors);
		this.ageSuitableFor = ageSuitableFor;
	}

	public int getAgeSuitableFor() {
		return ageSuitableFor;
	}
}
