package uk.ac.sheffield.com1003.kalah;

@SuppressWarnings("serial")
public class EmptySidePitException extends Exception {

	public EmptySidePitException(int sidePitNum) {
		super("There are no stones in side pit number " + sidePitNum);
	}
}
