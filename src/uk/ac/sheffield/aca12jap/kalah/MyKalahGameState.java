package uk.ac.sheffield.aca12jap.kalah;

import uk.ac.sheffield.com1003.kalah.EmptySidePitException;
import uk.ac.sheffield.com1003.kalah.IllegalSidePitNumberException;
import uk.ac.sheffield.com1003.kalah.InvalidStartingStonesException;
import uk.ac.sheffield.com1003.kalah.KalahGameState;
import uk.ac.sheffield.com1003.kalah.Player;

public class MyKalahGameState extends KalahGameState {

	// Declare variables
	private Player playerA, playerB; // Player A and Player B
	private int startingStones = 0; // Starting stones
	private int[] playerAStones = new int[7]; // Player A's pits
	private int[] playerBStones = new int[7]; // Player B's pits
	private boolean isPlayerATurn = true; // Boolean to indicate whose turn it is
	
	public void startGame(Player playerA, Player playerB, int startingStones)
			throws InvalidStartingStonesException {
		// Instantiate the variables
		this.playerA = playerA;
		this.playerB = playerB;
		this.startingStones = startingStones;
		// Throw an exception if starting stones is too high or too low
		if (startingStones < 1 || startingStones > 10)
		{
			throw new InvalidStartingStonesException();
		} else {
			// Put the number of starting stones in each pit
			for (int i = 0; i < 6; i++) {
				playerAStones[i] = startingStones;
				playerBStones[i] = startingStones;
			}
		}
	}

	public Player getPlayerA() {
		// Return player A
		return playerA;
	}

	public Player getPlayerB() {
		// Return player B
		return playerB;
	}

	public Player getTurn() {
		// Determine whose turn it is and return the respective player
		if (isPlayerATurn) 
		{
			return playerA;
		} else 
		{
			return playerB;
		}
		
	}

	public int getKalah(Player player) {
		// Determine which player's Kalah to return
		// and return that player's 7th pit (Kalah)
		if (player.equals(playerA)) 
		{
			return playerAStones[6];
		} else 
		{
			return playerBStones[6];
		}
	}

	public int getNumStones(int sidePitNum)
			throws IllegalSidePitNumberException {
		// Throw an exception if sidePitNum is too high or too low
		if ((sidePitNum < 1) || (sidePitNum > 6))
		{
			throw new IllegalSidePitNumberException();
		} else
		{
			// Determine whose turn it is and return the number
			// of stones in the chosen pit for that player
			if (isPlayerATurn)
			{
				return playerAStones[sidePitNum-1];
			} else
			{
				return playerBStones[sidePitNum-1];
			}
		}
		
	}

	public int getNumStones(Player player, int sidePitNum)
			throws IllegalSidePitNumberException {
		// Throw an exception if sidePitNum is too high or too low
		if ((sidePitNum < 1) || (sidePitNum > 6))
		{
			throw new IllegalSidePitNumberException();
		} else
		{
			// Determine which players pit to return and return the number
			// of stones in the chosen pit for that player
			if (player.equals(playerA))
			{
				return playerAStones[sidePitNum-1];
			} else
			{
				return playerBStones[sidePitNum-1];
			}
		}
	}

	public int getScore(Player player) {
		// Create a variable to keep track of the stones.
		int score = 0;
		// Determine which player to get the score of.
		if (player.equals(playerA)) 
		{
			// Loop through the player's pits adding each pit's stones to score
			for (int stones : playerAStones) {
				score += stones;
			}
			return score;
		} else 
		{
			for (int stones : playerBStones) {
				score += stones;
			}
			// Return the final number of stones
			return score;
		}
	}
	
	/**
	 * Method to make the move for a player to save repeated code.
	 * @param sidePitNum int The chosen pit to start the move from.
	 * @param playerStones int[] The player that is making the move's pits.
	 * @param oppStones int[] The opposite player to the one that is making the move's pits.
	 */
	private void makeMove(int sidePitNum, int[] playerStones, int[] oppStones) {
		int stonesToDrop = getNumStones(sidePitNum); // Put the stones picked up in a variable
		playerStones[sidePitNum-1] = 0; // Set the stones in that pit to 0
		
		while (stonesToDrop != 0) {
			while (sidePitNum != 7 && stonesToDrop != 0) {
				// Drop one stone in the required pit
				playerStones[sidePitNum]++;
				// Decrement the stones to drop
				stonesToDrop--;
				// Increment the pit by one
				sidePitNum++;
			}
			
			// If the last pit stones were dropped into only has one stone left in (was zero before)
			// and the opposite pit isn't 0 and the last pit isn't the kalah:
			// Capture the opponent's stones and put them into the player's kalah
			if (playerStones[sidePitNum-1] == 1 & (sidePitNum-1) != 6 && oppStones[6-sidePitNum] != 0) {
				playerStones[6] += playerStones[sidePitNum-1] + oppStones[6-sidePitNum];
				oppStones[6-sidePitNum] = 0;
				playerStones[sidePitNum-1] = 0;
			}
			
			// If the last pit stones were dropped into was the player's kalah, the player gets another turn
			if (sidePitNum-1 == 6 && stonesToDrop == 0){
				isPlayerATurn = !isPlayerATurn;
			}
			
			sidePitNum = 0; // Reset pit num
			
			while (sidePitNum != 6 && stonesToDrop != 0) {
				// Drop one stone in the required pit
				oppStones[sidePitNum]++;
				// Decrement the stones to drop
				stonesToDrop--;
				// Increment the pit by one
				sidePitNum++;
			}
			
			sidePitNum = 0; // Reset pit num
		}
	}

	public void makeMove(int sidePitNum) throws IllegalSidePitNumberException,
			EmptySidePitException {
		
		// Throw an exception if the pit is empty or an invalid pit choice is made
		if (getNumStones(sidePitNum) == 0) 
		{
			throw new EmptySidePitException(sidePitNum);
		}
		if ((sidePitNum < 1) || (sidePitNum > 6)) 
		{
			throw new IllegalSidePitNumberException();
		}
		 
		// Determine which player to make the move for and make the move
		if (getTurn().equals(playerA)) 
		{
			makeMove(sidePitNum, playerAStones, playerBStones);
		} else if (getTurn().equals(playerB))
		{	
			makeMove(sidePitNum, playerBStones, playerAStones);
		}
		// Change whose turn it is
		isPlayerATurn = !isPlayerATurn;
	}
	
	public boolean isGameOver() {
		boolean gameOver = false;
		int stonesA = 0, stonesB = 0;
		
		// Check if there are no stones left in either player's pits
		for (int i = 0; i < 6; i++) {
			stonesA += playerAStones[i];
			stonesB += playerBStones[i];
		}
		
		if ((stonesA == 0) || (stonesB == 0))
		{
			// If there are no stones left in one player's pits, set the game to over
			gameOver = true;
		}
		return gameOver;
	}

	public Player getWinner() {
		// If the game isn't over or it's a draw return null
		if (!isGameOver() || (getScore(playerA) == getScore(playerB)))
		{
			return null;
		} else if (getScore(playerA) > getScore(playerB))
		// If player A has won return player A
		{
			return playerA;
		} else
		{
		// If player B has won return player B
			return playerB;
		}
	}

	public KalahGameState copy() {
		// Create a deep copy of the game state by copying each attribute
		MyKalahGameState copyState = new MyKalahGameState();
		copyState.playerA = getPlayerA();
		copyState.playerB = getPlayerB();
		copyState.startingStones = startingStones;
		copyState.playerAStones = playerAStones.clone();
		copyState.playerBStones = playerBStones.clone();
		copyState.isPlayerATurn = isPlayerATurn;
		return copyState;
	}
	

}
