package uk.ac.sheffield.aca12jap.kalah;

import uk.ac.sheffield.com1003.kalah.EmptySidePitException;
import uk.ac.sheffield.com1003.kalah.IllegalSidePitNumberException;
import uk.ac.sheffield.com1003.kalah.KalahGameState;
import uk.ac.sheffield.com1003.kalah.NoMoveAvailableException;
import uk.ac.sheffield.com1003.kalah.Player;

/**
 * A class to represent a Kalah player that selects the best move
 * based on looking ahead and seeing what results in the highest
 * score in the next state.
 * @author Jonny
 *
 */
public class OneMoveLookAheadPlayer extends Player {

	/**
	 * Constructor for the class.
	 * @param name String The name of the player.
	 */
	public OneMoveLookAheadPlayer(String name) {
		super(name);
	}

	/**
	 * Chooses the move to make. For this player it will copy the game state and make a move from
	 * each of the player's pits that has more than 0 stones in. It will return the pit number that
	 * resulted in the player's score being the highest.
	 * @param gameState KalahGameState The current state of the game.
	 * @return moveNum int The chosen move to make.
	 */
	public int chooseMove(KalahGameState gameState) throws NoMoveAvailableException {
		// Make sure a move is available
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
		
		// Create a copy of the game state
		MyKalahGameState copyState = (MyKalahGameState) gameState.copy();
		int moveNum = 0; // Int to hold the chosen move number
		int score = 0; // Int to hold the highest score of any move
		
		// For every pit the player owns that has more than 0 stones in...
		for (int i=1; i <= KalahGameState.NUM_SIDE_PITS; i++) {
			if (copyState.getNumStones(this, i) > 0) {
				// Make a move in the copy state
				try {
					copyState.makeMove(i);
				} catch (IllegalSidePitNumberException e) {
					e.printStackTrace();
				} catch (EmptySidePitException e) {
					e.printStackTrace();
				}
			
				// If the player's score after this move is more than the current score;
				// update score and set the moveNum to the pit number of the move just made.
				if (evaluateBoard(copyState) >= score) {
					score = evaluateBoard(copyState);
					moveNum = i;
				}
			}
			// Refresh the copy state before looping again
			copyState = (MyKalahGameState) gameState.copy();
		}
		// Return moveNum
		return moveNum;	
	}
	
	/**
	 * The evaluation function for the current game state.
	 * @param state The current game state. 
	 * @return A score based on the state of the current board.
	 */
	private int evaluateBoard(KalahGameState state) {
		// Create a new variable to store the score in
		int score = 0;
		// Determine whether this player is player A or player B
		if (this.equals(state.getPlayerA())) {
			// If the result of this player's score minus the opposite player's score is positive
			// Set the score to that value
			if (state.getScore(this) > state.getScore(state.getPlayerB())) {
				score = state.getScore(this) - state.getScore(state.getPlayerB());
			}
		} else {
			// If the result of this player's score minus the opposite player's score is positive
			// Set the score to that value
			if (state.getScore(this) > state.getScore(state.getPlayerA())) {
				score = state.getScore(this) - state.getScore(state.getPlayerA());
			}
		}
		// Return the score
		return score;
	}
}
