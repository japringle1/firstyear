package uk.ac.sheffield.aca12jap.kalah;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uk.ac.sheffield.com1003.kalah.*;

public class KalahGameStateTest {
	
	// Test that an exception is thrown if a number too high is entered
	@Test(expected=InvalidStartingStonesException.class)
	public void testInvalidStartingStonesExceptionHigh() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 11);
	}
	
	// Test that an exception is thrown if a number too low is entered
	@Test(expected=InvalidStartingStonesException.class)
	public void testInvalidStartingStonesExceptionLow() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 0);
	}

	// Test that the 'getPlayerA' function is correct
	@Test
	public void testPlayerA() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertEquals(state.getPlayerA(), playerA);
	}
	
	// Test that the 'getPlayerB' function is correct
	@Test
	public void testPlayerB() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertEquals(state.getPlayerB(), playerB);
	}
	
	// Test that the 'getTurn' function is correct when it is player A's turn
	@Test
	public void testPlayerATurn() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertEquals(state.getTurn(), playerA);
	}
	
	// Test that the 'getTurn' function is correct when it is player B's turn
	@Test
	public void testPlayerBTurn() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(1);
		assertEquals(state.getTurn(), playerB);
	}
	
	// Test that the 'getKalah' function is correct for player A
	@Test
	public void testPlayerAKalah() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertEquals(state.getKalah(playerA), 0);
	}
	
	// Test that the 'getKalah' function is correct for player B
	@Test
	public void testPlayerBKalah() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertEquals(state.getKalah(playerB), 0);
	}
	
	// Test that the 'getNumStones' function is correct for all of the current player's pits when it should be player A
	@Test
	public void testPlayerAStones() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertEquals(state.getNumStones(1), 3);
		assertEquals(state.getNumStones(2), 3);
		assertEquals(state.getNumStones(3), 3);
		assertEquals(state.getNumStones(4), 3);
		assertEquals(state.getNumStones(5), 3);
		assertEquals(state.getNumStones(6), 3);
	}
	
	// Test that the 'getNumStones' function is correct for all of the current player's pits when it should be player B
	@Test
	public void testPlayerBStones() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(2);
		assertEquals(state.getNumStones(1), 3);
		assertEquals(state.getNumStones(2), 3);
		assertEquals(state.getNumStones(3), 3);
		assertEquals(state.getNumStones(4), 3);
		assertEquals(state.getNumStones(5), 3);
		assertEquals(state.getNumStones(6), 3);
	}
	
	// Test that the 'getNumStones' function is correct for specifically player A's pits
	@Test
	public void testPlayerASpecificStones() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertEquals(state.getNumStones(playerA, 1), 3);
		assertEquals(state.getNumStones(playerA, 2), 3);
		assertEquals(state.getNumStones(playerA, 3), 3);
		assertEquals(state.getNumStones(playerA, 4), 3);
		assertEquals(state.getNumStones(playerA, 5), 3);
		assertEquals(state.getNumStones(playerA, 6), 3);
	}
	
	// Test that the 'getNumStones' function is correct for specifically player B's pits
	@Test
	public void testPlayerBSpecificStones() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertEquals(state.getNumStones(playerB, 1), 3);
		assertEquals(state.getNumStones(playerB, 2), 3);
		assertEquals(state.getNumStones(playerB, 3), 3);
		assertEquals(state.getNumStones(playerB, 4), 3);
		assertEquals(state.getNumStones(playerB, 5), 3);
		assertEquals(state.getNumStones(playerB, 6), 3);
	}
	
	// Test that an exception is thrown when a side pit number too small is entered
	@Test(expected=IllegalSidePitNumberException.class)
	public void testIllegalSidePitNumberExceptionGetNumStonesLow() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.getNumStones(0);
	}
	
	// Test that an exception is thrown when a side pit number too high is entered
	@Test(expected=IllegalSidePitNumberException.class)
	public void testIllegalSidePitNumberExceptionGetNumStonesHigh() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.getNumStones(7);
	}
	
	// Test that an exception is thrown when a side pit number too high is entered for the overloaded function
	@Test(expected=IllegalSidePitNumberException.class)
	public void testIllegalSidePitNumberExceptionGetNumStonesOverloadHigh() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.getNumStones(playerB, 7);
	}
	
	// Test that an exception is thrown when a side pit number too low is entered for the overloaded function
	@Test(expected=IllegalSidePitNumberException.class)
	public void testIllegalSidePitNumberExceptionGetNumStonesOverloadLow() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.getNumStones(playerB, 0);
	}
	
	// Test that the 'getScore' function works for player A
	@Test
	public void testPlayerAScore() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertEquals(state.getScore(playerA), 18);
	}
	
	// Test that the 'getScore' function works for player A
	@Test
	public void testPlayerBScore() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertEquals(state.getScore(playerB), 18);
	}
	
	// Test that the 'copy' function works and copies all attributes correctly
	@Test
	public void testCopy() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertEquals(state.copy().getPlayerA(), state.getPlayerA());
		assertEquals(state.copy().getPlayerB(), state.getPlayerB());
		assertEquals(state.copy().getKalah(playerA), state.getKalah(playerA));
		assertEquals(state.copy().getKalah(playerB), state.getKalah(playerB));
		assertEquals(state.copy().getTurn(), state.getTurn());
		assertEquals(state.copy().getScore(playerA), state.getScore(playerA));
		assertEquals(state.copy().getScore(playerB), state.getScore(playerB));
		assertEquals(state.getNumStones(playerA, 1), state.copy().getNumStones(playerA, 1));
		assertEquals(state.getNumStones(playerA, 2), state.copy().getNumStones(playerA, 1));
		assertEquals(state.getNumStones(playerA, 3), state.copy().getNumStones(playerA, 1));
		assertEquals(state.getNumStones(playerA, 4), state.copy().getNumStones(playerA, 1));
		assertEquals(state.getNumStones(playerA, 5), state.copy().getNumStones(playerA, 1));
		assertEquals(state.getNumStones(playerA, 6), state.copy().getNumStones(playerA, 1));
		assertEquals(state.getNumStones(playerB, 1), state.copy().getNumStones(playerB, 1));
		assertEquals(state.getNumStones(playerB, 2), state.copy().getNumStones(playerB, 1));
		assertEquals(state.getNumStones(playerB, 3), state.copy().getNumStones(playerB, 1));
		assertEquals(state.getNumStones(playerB, 4), state.copy().getNumStones(playerB, 1));
		assertEquals(state.getNumStones(playerB, 5), state.copy().getNumStones(playerB, 1));
		assertEquals(state.getNumStones(playerB, 6), state.copy().getNumStones(playerB, 1));
	}
	
	// Test that a move can be made correctly
	@Test
	public void testValidMove() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(1);
		assertEquals(state.getNumStones(playerA, 1), 0);
		assertEquals(state.getNumStones(playerA, 2), 4);
		assertEquals(state.getNumStones(playerA, 3), 4);
		assertEquals(state.getNumStones(playerA, 4), 4);
		assertEquals(state.getNumStones(playerA, 5), 3);
		assertEquals(state.getKalah(playerA), 0);
	}
	
	// Test that a move can be made correctly that loops to the other player's pits
		@Test
		public void testValidLoopMove() throws IllegalSidePitNumberException, EmptySidePitException {
			MyKalahGameState state = new MyKalahGameState();
			KeyboardPlayer playerA = new KeyboardPlayer("Player A");
			KeyboardPlayer playerB = new KeyboardPlayer("Player B");
			state.startGame(playerA, playerB, 3);
			state.makeMove(6);
			assertEquals(state.getNumStones(playerA, 6), 0);
			assertEquals(state.getKalah(playerA), 1);
			assertEquals(state.getNumStones(playerB, 1), 4);
			assertEquals(state.getNumStones(playerB, 2), 4);
			assertEquals(state.getNumStones(playerB, 3), 3);
		}
	
	// Make sure an exception is thrown if a player attempts to make a move from a pit with no stones in
	@Test(expected=EmptySidePitException.class)
	public void testEmptySidePitException() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(1);
		state.makeMove(1);
		state.makeMove(1);
	}
	
	// Make sure an exception is thrown if a player attempts to make a move from a pit number too low
	@Test(expected=IllegalSidePitNumberException.class)
	public void testIllegalSidePitNumberExceptionLowMove() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(0);
	}
	
	// Make sure an exception is thrown if a player attempts to make a move from a pit number too high
	@Test(expected=IllegalSidePitNumberException.class)
	public void testIllegalSidePitNumberExceptionHighMove() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(7);
	}
	
	// Make sure player A gets another go if his move finishes in their kalah
	@Test
	public void testAnotherGoPlayerA() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(4);
		assertEquals(state.getTurn(), playerA);
	}
	
	// Make sure player B gets another go if his move finishes in their kalah
	@Test
	public void testAnotherGoPlayerB() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(1);
		state.makeMove(4);
		assertEquals(state.getTurn(), playerB);
	}
	
	// Make sure player A doesn't get another go if his move doesn't finish in their kalah
	@Test
	public void testNotAnotherGoPlayerA() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(1);
		assertEquals(state.getTurn(), playerB);
	}
	
	// Make sure player B doesn't get another go if his move doesn't finish in their kalah
	@Test
	public void testNotAnotherGoPlayerB() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(1);
		state.makeMove(1);
		assertEquals(state.getTurn(), playerA);
	}
	
	// Make sure that if a big enough move is made, stones aren't dropped in the opposite player's kalah
	@Test
	public void testSkipsOppositePlayerKalah() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 10);
		state.makeMove(6);
		assertEquals(state.getKalah(playerA), 1);
		assertEquals(state.getNumStones(playerA, 6), 0);
		assertEquals(state.getNumStones(playerB, 1), 11);
		assertEquals(state.getNumStones(playerB, 2), 11);
		assertEquals(state.getNumStones(playerB, 3), 11);
		assertEquals(state.getNumStones(playerB, 4), 11);
		assertEquals(state.getNumStones(playerB, 5), 11);
		assertEquals(state.getNumStones(playerB, 6), 11);
		assertEquals(state.getKalah(playerB), 0);
		assertEquals(state.getNumStones(playerA, 1), 11);
		assertEquals(state.getNumStones(playerA, 2), 11);
		assertEquals(state.getNumStones(playerA, 3), 11);
	}
	
	// Test to make sure a capture is made correctly
	@Test
	public void testCapture() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(6);
		state.makeMove(6);
		state.makeMove(3);
		assertEquals(state.getKalah(playerA), 6);
		assertEquals(state.getNumStones(playerA, 4), 4);
		assertEquals(state.getNumStones(playerA, 5), 4);
		assertEquals(state.getNumStones(playerA, 6), 0);
		assertEquals(state.getNumStones(playerB, 1), 0);
	}
	
	// Test to make sure an 'own-capture' isn't made if a player finished his move in an opposite player's pit
	// of 0 stones
	@Test
	public void testNoCaptureOppositePlayer() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 10);
		state.makeMove(6);
		state.makeMove(2);
		assertEquals(state.getKalah(playerB), 1);
		assertEquals(state.getNumStones(playerA, 6), 1);
		assertEquals(state.getNumStones(playerB, 2), 0);
	}
	
	// Test to make sure an 'own-capture' isn't made if player a finished his move in an opposite player's pit
	// of 0 stones
	@Test
	public void testNoCapturePlayerAOppositePitZero() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 1);
		state.makeMove(4);
		state.makeMove(3);
		state.makeMove(3);
		assertEquals(state.getKalah(playerA), 0);
		assertEquals(state.getKalah(playerB), 0);
		assertEquals(state.getNumStones(playerA, 4), 1);
		assertEquals(state.getNumStones(playerA, 3), 0);
		assertEquals(state.getNumStones(playerB, 3), 0);
	}
		
	// Test to make sure an 'own-capture' isn't made if player b finished his move in an opposite player's pit
	// of 0 stones
	@Test
	public void testNoCapturePlayerBOppositePitZero() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 1);
		state.makeMove(3);
		state.makeMove(4);
		state.makeMove(5);
		state.makeMove(3);
		assertEquals(state.getKalah(playerA), 0);
		assertEquals(state.getKalah(playerB), 0);
		assertEquals(state.getNumStones(playerB, 4), 1);
		assertEquals(state.getNumStones(playerA, 3), 0);
		assertEquals(state.getNumStones(playerB, 3), 0);
	}
	
	// Test to make sure a capture isn't made if a turn finishes in their kalah which has 0 stones
	@Test
	public void testNoCaptureKalah() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(4);
		assertEquals(state.getKalah(playerA), 1);
		assertEquals(state.getNumStones(playerA, 4), 0);
		assertEquals(state.getNumStones(playerA, 5), 4);
		assertEquals(state.getNumStones(playerA, 6), 4);
		
	}
	
	// Test to make sure a capture is made if a move is made all the way round the board
	@Test
	public void testAllWayRoundCapture() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 10);
		state.makeMove(1);
		state.makeMove(1);
		state.makeMove(2);
		state.makeMove(3);
		assertEquals(state.getKalah(playerB), 17);
		assertEquals(state.getNumStones(playerA, 4), 0);
		assertEquals(state.getNumStones(playerB, 3), 0);
	}
	
	// Test to make sure a game over isn't adjudged to be over if it shouldn't be
	@Test
	public void testGameOverFalse() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertFalse(state.isGameOver());
	}
	
	// Test to make sure a game is over when one player has no stones left in their pits
	@Test
	public void testGameOverTrue() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 1);
		state.makeMove(1);
		state.makeMove(1);
		state.makeMove(2);
		state.makeMove(2);
		state.makeMove(3);
		state.makeMove(3);
		state.makeMove(4);
		state.makeMove(5);
		state.makeMove(1);
		state.makeMove(6);
		int score = state.getScore(playerA);
		assertEquals(score, 3);
		assertTrue(state.isGameOver());
	}

	// Test to make sure the 'getWinner' function is correct if the game isn't over
	@Test
	public void testGetWinnerNull() {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		assertEquals(state.getWinner(), null);
	}
	
	// Test to make sure the 'getWinner' function is correct if the game is a draw
	@Test
	public void testGetWinnerDraw() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 3);
		state.makeMove(1);
		state.makeMove(1);
		state.makeMove(2);
		state.makeMove(2);
		state.makeMove(3);
		state.makeMove(3);
		state.makeMove(6);
		state.makeMove(5);
		state.makeMove(4);
		state.makeMove(6);
		state.makeMove(6);
		state.makeMove(5);
		state.makeMove(4);
		state.makeMove(6);
		state.makeMove(5);
		state.makeMove(5);
		assertEquals(state.getWinner(), null);
	}
	
	// Test to make sure the 'getWinner' function is correct if player A wins
	@Test
	public void testGetWinnerPlayerAWins() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 1);
		state.makeMove(1);
		state.makeMove(1);
		state.makeMove(2);
		state.makeMove(2);
		state.makeMove(5);
		state.makeMove(3);
		state.makeMove(4);
		state.makeMove(4);
		state.makeMove(5);
		state.makeMove(1);
		state.makeMove(6);
		assertEquals(state.getWinner(), playerA);
	}
	
	// Test to make sure the 'getWinner' function is correct if player B wins
	@Test
	public void testGetWinnerPlayerBWins() throws IllegalSidePitNumberException, EmptySidePitException {
		MyKalahGameState state = new MyKalahGameState();
		KeyboardPlayer playerA = new KeyboardPlayer("Player A");
		KeyboardPlayer playerB = new KeyboardPlayer("Player B");
		state.startGame(playerA, playerB, 1);
		state.makeMove(1);
		state.makeMove(1);
		state.makeMove(2);
		state.makeMove(2);
		state.makeMove(3);
		state.makeMove(3);
		state.makeMove(4);
		state.makeMove(5);
		state.makeMove(1);
		state.makeMove(6);
		assertEquals(state.getWinner(), playerB);
	}
}
