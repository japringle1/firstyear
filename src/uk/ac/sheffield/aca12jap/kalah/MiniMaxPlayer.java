package uk.ac.sheffield.aca12jap.kalah;

import uk.ac.sheffield.com1003.kalah.EmptySidePitException;
import uk.ac.sheffield.com1003.kalah.IllegalSidePitNumberException;
import uk.ac.sheffield.com1003.kalah.KalahGameState;
import uk.ac.sheffield.com1003.kalah.NoMoveAvailableException;
import uk.ac.sheffield.com1003.kalah.Player;

/**
 * A class to represent a Kalah player that chooses moves based 
 * on a minimax algorithm to a fixed depth.
 * @author Jonny
 *
 */
public class MiniMaxPlayer extends Player {
	
	/**
	 * Constructor for the class.
	 * @param name String The name of the player.
	 */
	public MiniMaxPlayer(String name) {
		super(name);
	}

	/**
	 * A function to choose the best move based on a minimax algorithm.
	 * @param gameState KalahGameState The current state of the board.
	 * @return int The move to make.
	 */
	public int chooseMove(KalahGameState gameState)	throws NoMoveAvailableException {
		final double start = System.currentTimeMillis();
		
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
		
		// Create variables to score the best move, the best score and the new score from the algorithm.
		int bestMove = 0;
		int bestScore = 0;
		int newScore = 0;
		
		// For each pit in the pits
		for (int i=1; i <= KalahGameState.NUM_SIDE_PITS; i++) {
			// Create a copy of the game state
			MyKalahGameState copyState = (MyKalahGameState) gameState.copy();
				// Make sure it's possible to make a move
				if (copyState.getNumStones(i) != 0) {
				
					// Make the move
					try {
						copyState.makeMove(i);
					} catch (IllegalSidePitNumberException e) {
						e.printStackTrace();
					} catch (EmptySidePitException e) {
						e.printStackTrace();
					}
					
					// Get it's score from the minimax function
					newScore = miniMax(copyState, 1);
					
					// If the new score is higher than the current best score
					if (newScore >= bestScore) {
						bestScore = newScore; // Update the best score
						bestMove = i; // Set the best move to this move
					}
			}
		}
		final double finaltime = System.currentTimeMillis() - start;
		System.out.println("Time taken to calculate move: " + finaltime/1000);
		// After all moves have been evaluated, return the best move
		return bestMove;
				
	}
	
	/**
	 * A function to look through a game playing tree to a fixed depth.
	 * @param gameState The next state to look at.
	 * @param depth The depth for the tree to go down to.
	 * @return A score based on the evaluation of the board if the depth is reached,
	 * 		   the maximum score of the child game states if the state passed in 
	 * 		   a parameter requires a move from this player or the minimum score
	 * 		   of a child node if the state passed requires a move from the opposite player.
	 */
	private int miniMax(KalahGameState gameState, int depth) {
		// Create variables to compare scores to, min is 120
		// because that's the most stones there can be on the
		// board. (10*120)
		int max=0, min=120;
		
		// If the bottom of the tree is reached
		if (depth >= 5) {
			// Return the result of the evaluation function.
			return evaluateBoard(gameState, gameState.getTurn());
		// If the bottom of the tree is yet to be reached, determine whose turn it is
		// If it's this players turn, maximize the score gained from the next game states
		} else if (gameState.getTurn().equals(this)) {
			// For each move available in the current state
			for (int i=1; i <= KalahGameState.NUM_SIDE_PITS; i++) {
				if (gameState.getNumStones(gameState.getTurn(), i) != 0) {
					// Create a copy of the state
					MyKalahGameState copyState = (MyKalahGameState) gameState.copy();
					
					
					
					// Make a move in the copy state
					try {
						copyState.makeMove(i);
					} catch (IllegalSidePitNumberException e) {															
						System.out.println("1-6 please.");
					} catch (EmptySidePitException e) {
						System.out.println("No stones in this pit.");
					}
					
					// Get its value from calling the minimax function again
					// but increase the depth by 1
					int score = miniMax(copyState, depth+1);
					
					// If the move results in a win, make the max 120 so the player will choose this move
					if (copyState.getWinner() == this) {
						max = 120;
					}
				
					// If the value is more than or equal to the current maximum score,
					// update the max so it is equal to the value
					if (score >= max) {
						max = score;
					}
					
				}	
			}
			// Return the maximum score of possible game states
			return max;
		// If it's not this players turn, minimize the score gained from the next game states
		} else {
			// For each move available in the current state
			for (int i=1; i <= KalahGameState.NUM_SIDE_PITS; i++) {
				if (gameState.getNumStones(gameState.getTurn(), i) != 0) {
					// Create a copy of the game state
					MyKalahGameState copyState = (MyKalahGameState) gameState.copy();
					
					// Make a move in the copy state
					try {
						copyState.makeMove(i);
					} catch (IllegalSidePitNumberException e) {															
						System.out.println("1-6 please.");
					} catch (EmptySidePitException e) {
						System.out.println("No stones in this pit.");
					}
					
					// Get its value from calling the minimax function again
					// but increase the depth by 1
					int score = miniMax(copyState, depth+1);
					
					// If the value is less than or equal to the current maximum score,
					// update the min so it is equal to the value
					if (score <= min) {					
						min = score;
					}
				}
			}
			// Return the minimum score of possible game states
			return min;
		}
	}
	
	/**
	 * The evaluation function for the current game state.
	 * @param state The current game state. 
	 * @param player The player to evaluate the board for.
	 * @return A score based on the state of the current board.
	 */
	private int evaluateBoard(KalahGameState state, Player player) {
		// Create a new variable to store the score in
		int score = 0;
		// Determine whether this player is player A or player B
		if (player.equals(state.getPlayerA())) {
			// If the result of this player's score minus the opposite player's score is positive
			// Set the score to that value
			if (state.getScore(player) > state.getScore(state.getPlayerB())) {
				score = state.getScore(player) - state.getScore(state.getPlayerB());
			}
		} else {
			// If the result of this player's score minus the opposite player's score is positive
			// Set the score to that value
			if (state.getScore(player) > state.getScore(state.getPlayerA())) {
				score = state.getScore(player) - state.getScore(state.getPlayerA());
			}
		}
		// Return the score
		return score;
	}
}
