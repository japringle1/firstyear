package uk.ac.sheffield.com1003.kalah;

public abstract class Display {

	public abstract void displayTitle();

	public abstract void displayBoard(KalahGameState gameState);

	public abstract void displayWinner(KalahGameState gameState);

	public abstract void displayTurn(Player player);

	public abstract void displayMove(Player player, int sidePitNum);

	public abstract void displayError(String string);
}
