package net.azib.java.students.t980814.lec3;

import java.util.TreeMap;

/**
 * WordFrequencyCalculator
 *
 * @author allan
 */
public class WordFrequencyCalculator {

	/**
	 * Calculates frequencies of words in a text, represented by a String
	 * @param text the text to analyze
	 * @return a Map, where keys are words and values are number of occurrences 
	 */
	static public TreeMap<String, Integer> calculateFrequenciesOf(String[] text) {
		TreeMap<String, Integer> freqTable = new TreeMap<String, Integer>();

		for(String s : text) {
			if (freqTable.containsKey(s))
				freqTable.put(s, freqTable.get(s) + 1);
			else
				freqTable.put(s, 1);
		}
		return freqTable;
	}

}
