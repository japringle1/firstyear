package com1005_Assignment1;

import java.util.ArrayList;

/**
 * @author Jonny
 * A state in a World Lattice search.
 */
public class LatticeState extends SearchState {
	
	private WordH word;
	
	/**
	 * Constructor for the state.
	 * @param word The word of which to base the state on.
	 * @param localCost The local cost of the word.
	 */
	public LatticeState(WordH word, int localCost) {
		this.word = word;
		this.localCost = localCost;
	}
	
	/**
	 * Accessor for the word of the state.
	 * @return word WordH The word the state is based on.
	 */
	public WordH getWord() {
		return word;
	}
	
	/**
	 * Determines whether the current word is the last word (the goal) by comparing the
	 * end time of the word to the end time of the lattice.
	 * @param searcher The current search that is taking place.
	 * @return boolean Whether or not the end time of the word equals the end time of the lattice.
	 */
	boolean goalP(Search searcher) {
		// Cast the searcher to a lattice searcher
		LatticeSearch lsearcher = (LatticeSearch) searcher;
		// Get the end time of the lattice
		int endTime = lsearcher.getWordLattice().getEndTime();
		// Return whether the time of the end of this word equals the time of the end of the lattice
		return (endTime == word.getEnd());
	}

	/**
	 * Gets a list of successors to the current state by selecting words that have a start time equal
	 * to the end time of the previous word.
	 * @param searcher The current search that is taking place.
	 * @return ArrayList<SearchState> A list of search states of words which have times starting where the previous word ends.
	 */
	ArrayList<SearchState> getSuccessors(Search searcher) {
		// Cast the searcher to a lattice searcher
		LatticeSearch lsearcher = (LatticeSearch) searcher;
		// Create a list of words of which their start time equals the last word's end time
		ArrayList<WordH> nextWords = lsearcher.getWordLattice().wordsAtT(word.getEnd());
		// Create a list of search states to return
		ArrayList<SearchState> succs = new ArrayList<SearchState>();
		
		// For each possible 'next word' add it to the list of search states passing
		// the word and its cost (including local cost and LM cost)
		for (WordH word : nextWords) {
			succs.add((SearchState)new LatticeState(word, (word.getCost() + lsearcher.getLM().getCost(this.word.getWord(), word.getWord()))));
		}
		
		// Return the list of search states
		return succs;
	}

	/**
	 * Determines whether a certain state is equal to this one.
	 * @param n2 The search state being queried.
	 * @return boolean Whether or not the parameter state is equal to this state.
	 */
	boolean sameState(SearchState n2) {
		// Cast the search state to a lattice state
		LatticeState mn2 = (LatticeState) n2;
		// Return whether the state passed is equal to the current state
		return (this.equals(mn2));
	}
	
	/**
	 * Returns the word of the current state.
	 * @return The word of the current state.
	 */
	public String toString() {
		// Return the word
		return word.getWord();
	}

}
