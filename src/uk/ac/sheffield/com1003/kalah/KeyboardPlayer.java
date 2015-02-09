package uk.ac.sheffield.com1003.kalah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardPlayer extends Player {

	public KeyboardPlayer(String name) {
		super(name);
	}
	
	public int chooseMove(KalahGameState gameState) throws NoMoveAvailableException {
		boolean atLeastOnePitHasStones = false;
		for (int i=1; i <= KalahGameState.NUM_SIDE_PITS; i++) {
			if (gameState.getNumStones(i) > 0) {
				atLeastOnePitHasStones = true;
			}
		}
		if (!atLeastOnePitHasStones) {
			throw new NoMoveAvailableException();
		}
		return readNumber(1, KalahGameState.NUM_SIDE_PITS);
	}

	/**
	 * Reads a number from the keyboard -- this code will become clear after the 
	 * lecture on I/O later in the course 
	 * @param min the minimum number allowed
	 * @param max the maximum number allowed 
	 * @return the number read
	 */
	private int readNumber(int min, int max) {
		System.out.print("Please enter a number between " + min + " and " + max + ": ");
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		boolean readNumber = false;
		int number = 0;

		while (!readNumber) {
			try {
				String readLine = keyboard.readLine();
				number = Integer.parseInt(readLine);
				if (number >= min && number <= max) {
					readNumber = true;
				} else {
					System.out.print("Please enter a number from " + min + "-" + max + ": ");
				}
			} catch (NumberFormatException e) {
				System.out.print("Please enter a number from " + min + "-" + max + ": ");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return number;
	}
}