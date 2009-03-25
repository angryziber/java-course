package net.azib.java.students.t050545.hometasks.collect;

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
	 * @return a Map, where keys are words and values are number of occurrences 
	 */
	Map<String, Integer> calculateFrequenciesOf(String text);

}
