package uk.ac.sheffield.com1003.objectville.interfaces;

public class Car {

	private int numDoors, numWheels;

	public Car(int numDoors, int numWheels) {
		this.numDoors = numDoors;
		this.numWheels = numWheels;
	}

	public int getNumDoors() {
		return numDoors;
	}

	public int getNumWheels() {
		return numWheels;
	}
}
