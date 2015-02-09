package uk.ac.sheffield.com1003.kalah;

/* 
 NOTE: When extending this class you must not add any of your own public methods or constructors.
 This is to ensure the compatibility of your code with your peers for the Tournament stage.
 */

public abstract class KalahGameState {
	
	/** The number of side pits */
	public static final int NUM_SIDE_PITS = 6;
	
    /**
     * Constructs a new GameState with two players and a specified number of stones 
     * in each player's side pits
     * @param playerA player 'A'
     * @param playerA player 'B'
     * @param startingStones the number of starting stones in each side pit.
     * @throws InvalidStartingStonesException if startingStones not in the range 1-10.
     */
    public abstract void startGame(Player playerA, Player playerB, int startingStones) 
    		throws InvalidStartingStonesException;
       
    /**
     * Returns player 'A'
     * @return the player instance corresponding to player 'A'
     */
    public abstract Player getPlayerA();

    /**
     * Returns player 'B'
     * @return the player instance corresponding to player 'B'
     */
    public abstract Player getPlayerB();    
    
    /**
     * Returns the instance of the player whose turn it is.  
     * @return the player whose turn it is
     */
    public abstract Player getTurn();
        
    /**
     * Returns the current kalah for a specified player.
     * @param player the player to get the kalah for   
     */     
    public abstract int getKalah(Player player);
    
    /**
     * Returns the current number of stones in the specified pit for 
     * the player whose turn it is.
     * @param sidePitNum the side pit being queried in the range 1-6.
     * @throws IllegalSidePitNumberException if the sidePitNum parameter
     * is not in the range 1-6.
     */ 
    public abstract int getNumStones(int sidePitNum) throws IllegalSidePitNumberException;

    /**
     * Returns the current number of stones in the specified pit for a specified player.
     * @param player the player whose kalah is sought  
     * @param sidePitNum the side pit being queried (in the range 1-6).  
     * @throws IllegalSidePitNumberException if the sidePitNum parameter is not in the 
     * range 1-6.
     */
    public abstract int getNumStones(Player player, int sidePitNum) 
    		throws IllegalSidePitNumberException;
    
    /**
     * Returns the current score for a specified player - the player's 
     * kalah plus the number of stones in each of their side pits.
     * @param player the player whose kalah is sought  
     */ 
    public abstract int getScore(Player player);
    
    /**
     * Makes a move for the player whose turn it is.
     * @param sidePitNum the side pit being queried (should be in the range 1-6)
     * @throws IllegalSidePitNumberException if the sidePitNum parameter is not in the range 1-6.
     * @throws EmptySidePitException if the side pit is empty and has no stones in it.
     */ 
    public abstract void makeMove(int sidePitNum)
    		throws IllegalSidePitNumberException, EmptySidePitException;
	
    /**
     * Returns true when the current game is finished
     */    
    public abstract boolean isGameOver();    

    /**
     * Returns the player who has won, or null if there is no winner 
     * (or the game is not over)
     */    
    public abstract Player getWinner();     
    
    /**
     * Returns a copy of the game state in which the board elements are deep-copied 
     * @return A copy of this instance
     */
	public abstract KalahGameState copy();	
}
