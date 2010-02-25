package net.azib.java.students.t073857.hw3;

import java.util.Map;

/**
 * WordFrequencyCalculator
 *
 * @author anton
 */
public interface WordFrequencyCalculator {

	/**
	 * Calculates frequencies of words in a text, represented by a String
	 * @param text the text to analyze
	 * @return a Map, where keys are words and values are number of occurrences.
	 * 		   Words should be in the alphabetical order.  
	 */
	Map calculateFrequenciesOf(String text);

}
