package uk.ac.sheffield.aca12jap.kalah;
import java.util.ArrayList;
import java.util.List;

import uk.ac.sheffield.com1003.kalah.*;

public class Play {

	static Kalah kalah = new Kalah();
	
	public static void main(String[] args) {
	
	/**
	kalah.play(
			   new MyKalahGameState(),
			   new MiniMaxPlayer("Player A"), 
			   new RandomMovePlayer("Player B"), 
			   5, 
			   new ConsoleDisplay());
	*/
	
	
		List<Player> players = new ArrayList<Player>();
		players.add(new MiniMaxPlayer("MiniMax "));
		players.add(new OneMoveLookAheadPlayer(" 1 Move "));
		players.add(new RandomMovePlayer("Random 1"));
		players.add(new RandomMovePlayer("Random 2"));
		players.add(new RandomMovePlayer("Random 3"));
		
		
		MyTournament tournament = new MyTournament();
		tournament.play(players);
		tournament.getStandings();
		tournament.printLeague();
	
		
	}
}
