package uk.ac.sheffield.com1003.kalah;

public class ConsoleDisplay extends Display {

	public void displayTitle() {
		System.out.println("    __ __      __      __   ");
		System.out.println("   / //_/___ _/ /___ _/ /_  ");
		System.out.println("  / ,< / __ `/ / __ `/ __ \\");
		System.out.println(" / /| / /_/ / / /_/ / / / / ");
		System.out.println("/_/ |_\\__,_/_/\\__,_/_/ /_/");
	}

	public void displayBoard(KalahGameState gameState) {
		// player A's side
		System.out.println("\n  (6) (5) (4) (3) (2) (1)");
		System.out.print("  ");
		for (int i = KalahGameState.NUM_SIDE_PITS; i >= 1; i--) {
			printNumStones(gameState.getNumStones(gameState.getPlayerA(), i));
			System.out.print("  ");
		}
		System.out.println();

		// mid-section
		printNumStones(gameState.getKalah(gameState.getPlayerA()));
		System.out.print("                       ");
		printNumStones(gameState.getKalah(gameState.getPlayerB()));
		System.out.println();

		// player B's side
		System.out.print("  ");
		for (int i = 1; i <= KalahGameState.NUM_SIDE_PITS; i++) {
			printNumStones(gameState.getNumStones(gameState.getPlayerB(), i));
			System.out.print("  ");
		}
		System.out.println();
		System.out.println("  (1) (2) (3) (4) (5) (6)");
		System.out.println();
	}

	private void printNumStones(int numStones) {
		if (numStones < 10) {
			System.out.print(" ");
		}
		System.out.print(numStones);
	}

	public void displayWinner(KalahGameState gameState) {
		System.out.print("Final score - ");
		System.out.print(gameState.getPlayerA().getName() + " "
				+ gameState.getScore(gameState.getPlayerA()));
		System.out.print(" - ");
		System.out.print(gameState.getScore(gameState.getPlayerB()) + " "
				+ gameState.getPlayerB().getName());
		System.out.println();

		Player winner = gameState.getWinner();
		if (winner == null) {
			System.out.println("It's a draw!!!");
		} else {
			System.out.println(winner.getName() + " wins!!!");
		}
	}

	public void displayTurn(Player player) {
		System.out.println("Turn: " + player.getName());
	}

	public void displayMove(Player player, int sidePitNum) {
		System.out.println("Move made: " + sidePitNum);
	}

	public void displayError(String error) {
		System.out.println(error);
	}
}
