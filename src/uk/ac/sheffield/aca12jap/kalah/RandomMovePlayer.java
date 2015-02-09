package uk.ac.sheffield.aca12jap.kalah;

import java.util.Random;

import uk.ac.sheffield.com1003.kalah.KalahGameState;
import uk.ac.sheffield.com1003.kalah.NoMoveAvailableException;
import uk.ac.sheffield.com1003.kalah.Player;

/**
 * A class to represent a Kalah player that selects moved randomly.
 * @author Jonny
 *
 */
public class RandomMovePlayer extends Player {

	/**
	 * Constructor for the class.
	 * @param name String The name of the player.
	 */
	public RandomMovePlayer(String name) {
		super(name);
	}

	/**
	 * Chooses the move to make. In this case a random choice between 1 & 6.
	 * @param gameState KalahGameState The current game state.
	 * @return moveNum int The chosen move to make.
	 */
	public int chooseMove(KalahGameState gameState) throws NoMoveAvailableException {
		// Check to make sure a move is available
		boolean atLeastOnePitHasStones = false;
		for (int i=1; i <= KalahGameState.NUM_SIDE_PITS; i++) {
			if (gameState.getNumStones(i) > 0) {
				atLeastOnePitHasStones = true;
				break;
			}
		}
		if (!atLeastOnePitHasStones) {
			throw new NoMoveAvailableException();
		}
		
		// Generate a random number between 1 & 6
		Random random = new Random();
		int randomNum = (random.nextInt(6) + 1);
		// Return the random number
		return randomNum;
	}

}
