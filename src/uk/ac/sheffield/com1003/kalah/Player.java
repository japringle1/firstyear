package uk.ac.sheffield.com1003.kalah;

public abstract class Player {

	protected String name;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract int chooseMove(KalahGameState gameState)
			throws NoMoveAvailableException;
}
