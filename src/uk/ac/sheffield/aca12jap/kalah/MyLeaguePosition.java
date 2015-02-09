package uk.ac.sheffield.aca12jap.kalah;

import uk.ac.sheffield.com1003.kalah.Player;
import uk.ac.sheffield.com1003.kalah.tournament.LeaguePosition;

/**
 * A class to represent a player's position in a league.
 * @author Jonny
 *
 */
public class MyLeaguePosition extends LeaguePosition {
	
	// Declare integers to represent a player's wins, draws and games
	int games, wins, draws, points;
	// Declare the player to represent
	Player player;
	
	/**
	 * Constructor for the class.
	 * @param games Total games played.
	 * @param wins Total wins.
	 * @param draws Total draws.
	 * @param player The player being represented.
	 */
	public MyLeaguePosition(int games, int wins, int draws, Player player) {
		// Assign each parameter to the class' attributes
		this.games = games;
		this.wins = wins;
		this.draws = draws;
		this.player = player;
		// Simple points system, 3 for a win 1 for a draw
		points = (wins*3)+draws;
	}

	/**
	 * Accessor for the player being represented.
	 * @return The player.
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Accessor for the total wins.
	 * @return The number of wins.
	 */
	public int getWins() {
		return wins;
	}
	
	/**
	 * Accessor for the total games.
	 * @return The number of games.
	 */
	public int getGames() {
		return games;
	}
	
	/**
	 * Accessor for the total draws.
	 * @return The number of draws.
	 */
	public int getDraws() {
		return draws;
	}
	
	/**
	 * Accessor for the total points.
	 * @return The number of points.
	 */
	public int getPoints() {
		return points;
	}

}
