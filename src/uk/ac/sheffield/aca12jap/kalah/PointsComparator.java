package uk.ac.sheffield.aca12jap.kalah;

import java.util.Comparator;

/**
 * A comparator to compare two League Positions by their number of wins.
 * @author Jonny
 *
 */
public class PointsComparator implements Comparator<MyLeaguePosition> {

	/**
	 * A function to compare two league positions by their number of wins.
	 * @param The first league position.
	 * @param The second league position.
	 * @return A negative number if the first league position is higher than the second,
	 * 		   a positive number if the opposite and 0 if they are equal.
	 */
	public int compare(MyLeaguePosition mlp1, MyLeaguePosition mlp2) {
		if (mlp1.getPoints() > mlp2.getPoints()) {
			return -1;
		} else if (mlp2.getPoints() > mlp1.getPoints()) {
			return 1;
		} else {
			return 0;
		}
	}
}
