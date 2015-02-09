package uk.ac.sheffield.aca12jap.kalah;

import java.util.*;
import uk.ac.sheffield.com1003.kalah.*;
import uk.ac.sheffield.com1003.kalah.tournament.*;
/**
 * A class to run a Kalah tournament between a number of players
 * including playing games, storing standing and displaying standing.
 * @author Jonny Pringle
 *
 */
public class MyTournament extends Tournament {
	
	// Declare a hash map to store LeaguePositions by their respective players
	Map<Player, MyLeaguePosition> tournamentPlayers = new HashMap<Player, MyLeaguePosition>();
	// Declare a list to store the LeaguePositions
	List<MyLeaguePosition> standings = new ArrayList<MyLeaguePosition>();
	
	/**
	 * A function to play the tournament. Pits each player against each other twice
	 * and updates each player's league position depending on the result.
	 * @param players List<Players> The list of players participating in the tournament.
	 */
	public void play(List<Player> players) {
		// Declare a new kalah to play the games
		Kalah kalah = new Kalah();
	
		// For each player participating, add them to the hash map.
		for (Player player : players) {
			tournamentPlayers.put(player, new MyLeaguePosition(0, 0, 0, player));
		}
		
		// For each player participating, play a game against the other players
		// making sure not to play a game against itself
		for (Player player1 : players) {
			for (Player player2 : players) {
				if (!(player1 == player2)) {
					// Create a new kalah game state to play the game in and play the game
					MyKalahGameState state = new MyKalahGameState();
					kalah.play(state, player1, player2, 3, new ConsoleDisplay());
					// Update the player's wins, draws and games depending on the result
					if (!(state.getWinner() == null) && state.getWinner().equals(player1)) {
						updateWin(player1);
						updateLoss(player2);
					} else if (!(state.getWinner() == null) && state.getWinner().equals(player2)) {
						updateWin(player2);
						updateLoss(player1);
					} else {
						updateDraw(player1);
						updateDraw(player2);
					}
				}
			}
		}
	}

	/**
	 * Get the standings of the tournament.
	 * @return List<LeaguePosition> A list of LeaguePositions sorted by the number of wins.
	 */
	public List<LeaguePosition> getStandings() {
		// Clear the last standings ready for update
		standings.clear();
	    
		// For each player participating in the tournament,
		// add them to the list of standings.
	    for (MyLeaguePosition leaguePosition : tournamentPlayers.values()) {
	    	standings.add(leaguePosition);
	    }
	    
	    // Sort the standings using the Points Comparator
	    Collections.sort(standings, new PointsComparator());
	    
	    // Return the standings
	    return (List) standings;
	}

	/**
	 * Print the league standings.
	 */
	public void printLeague() {
		// Declare an integer to store the current position
		int position = 1;
		// Print a blank line, then the format for the standings
		System.out.println();
		System.out.println("Final Standings:");
		System.out.println("POS PLAYER    P   W   D   L   PTS");
		// For each league position in the standings print its...
		for (MyLeaguePosition leaguePosition : standings) {
			System.out.println(position + // Final position
							   ".  " + leaguePosition.getPlayer().getName() + // Name of the player
							   ": " + leaguePosition.getGames() + // Total games played
			 				   " - " + leaguePosition.getWins() + // Total games won
			 				   " - " + leaguePosition.getDraws() + // Total games drawn
			 				   // Total games lost
			 				   " - " + (leaguePosition.getGames() - leaguePosition.getWins() - leaguePosition.getDraws()) +
							   " - " + (leaguePosition.getPoints())); // Total points
							   position++; // Increment the position
		}
	}
	
	/**
	 * Add one to the player's wins via their league position.
	 * @param player The player to update.
	 */
	private void updateWin(Player player) {
		// Add one to the player's games and wins
		tournamentPlayers.put(player,
				  new MyLeaguePosition(
				  tournamentPlayers.get(player).getGames()+1,
				  tournamentPlayers.get(player).getWins()+1,
				  tournamentPlayers.get(player).getDraws(),
				  player));
	}
	
	/**
	 * Add one to the player's wins via their league position.
	 * @param player The player to update.
	 */
	private void updateDraw(Player player) {
		// Add one to the player's games and draws
		tournamentPlayers.put(player,
				  new MyLeaguePosition(
				  tournamentPlayers.get(player).getGames()+1,
				  tournamentPlayers.get(player).getWins(),
				  tournamentPlayers.get(player).getDraws()+1,
				  player));
	}
	
	/**
	 * Update the player to add one to the player's losses via their league position.
	 * @param player The player to update.
	 */
	private void updateLoss(Player player) {
		// Add one to the player's games
		tournamentPlayers.put(player,
	  			  new MyLeaguePosition(
	  			  tournamentPlayers.get(player).getGames()+1,
	  			  tournamentPlayers.get(player).getWins(),
	  			  tournamentPlayers.get(player).getDraws(),
	  			  player));
	}

}
