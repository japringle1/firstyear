package uk.ac.sheffield.com1003.kalah;

public class Kalah {

	public void play(KalahGameState gameState, Player playerA, Player playerB,
			int startingStones, Display display) {

		// start the game
		gameState.startGame(playerA, playerB, startingStones);

		// display the game title and the board
		display.displayTitle();
		display.displayBoard(gameState);

		// keep making moves until the game is over
		while (!gameState.isGameOver()) {

			// whose turn is it?
			Player player = gameState.getTurn();

			// display whose turn it is
			display.displayTurn(player);

			// make a move
			makeMove(gameState, player, display);

			// update the board
			display.displayBoard(gameState);
		}

		// the above loop exited, the game is over, so display
		// the board and the winner
		display.displayWinner(gameState);
	}

	private void makeMove(KalahGameState gameState, Player player,
			Display display) {

		boolean madeMove = false;

		while (!madeMove) {
			// get the player to choose their move
			// using a copy of the board
			int move = player.chooseMove(gameState.copy());

			try {
				// make the move
				gameState.makeMove(move);

				// display the move
				display.displayMove(player, move);

				// successfully made the move, set
				// flag to true so can exit the loop
				madeMove = true;

			} catch (IllegalSidePitNumberException e) {
				display.displayError("Side pit number must be between 1 and 6");
			} catch (EmptySidePitException e) {
				display.displayError("There are no stones to move in pit "
						+ move);
			}
		}
	}
}
