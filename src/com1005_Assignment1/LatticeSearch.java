package com1005_Assignment1;
/**
 * A search class for a word lattice.
 * @author Jonny
 *
 */
public class LatticeSearch extends Search {

	private WordLattice latt;
	private LM bg;
	
	/**
	 * Constructor for the search.
	 * @param latt
	 * @param bg
	 */
	public LatticeSearch(WordLattice latt, LM bg) {
		this.latt = latt;
		this.bg = bg;
	}
	
	/**
	 * Accessor for the Word Lattice of this state.
	 * @return latt WordLattice The word lattice that is being searching.
	 */
	public WordLattice getWordLattice() {
		return latt;
	}
	/**
	 * Accessor for the language model for the word lattice.
	 * @return bg LM The language model for the word lattice.
	 */
	public LM getLM() {
		return bg;
	}

}
