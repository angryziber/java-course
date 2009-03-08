package net.azib.java.students.t000522;

/**
 * WordFrequencyCalculator
 *
 * @author jurrassic
 */

import java.util.*;

public class WordFrequencyCalculator {

	/**
	 * @param args
	 */
	public Map<String, Integer> calculateFrequency(String text) {
		String delimiter = "\\s";
		String[] splitted;
		splitted = text.split(delimiter);
		SortedMap<String, Integer> wordfrequence = new TreeMap<String, Integer>();
		for(int i = 0; i < splitted.length; i++) {
			if(wordfrequence.containsKey(splitted[i])) {
				wordfrequence.put(splitted[i], wordfrequence.get(splitted[i]) + 1);
			}
			else {
				wordfrequence.put(splitted[i], new Integer(1));
			}
		}
		return wordfrequence;
	}
}
