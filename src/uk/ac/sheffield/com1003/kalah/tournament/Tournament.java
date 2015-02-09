package uk.ac.sheffield.com1003.kalah.tournament;

import java.util.List;

import uk.ac.sheffield.com1003.kalah.Player;

public abstract class Tournament {

	public abstract void play(List<Player> players);

	public abstract List<LeaguePosition> getStandings();

	public abstract void printLeague();
}
