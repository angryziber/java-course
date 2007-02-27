package net.azib.java.lessons.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * WordFrequencyCalculator
 *
 * @author anton
 */
public class WordFrequencyCalculator {

	/**
	 * Calculates frequencies of words passed as an array of Strings
	 * @param words array of words
	 * @return a Map, where keys are words and values are number of occurencies 
	 */
	public Map<String, Integer> calculateFrequenciesOf(String[] words) {
		Map<String, Integer> frequencies = new LinkedHashMap<String, Integer>();
		for (String word : words) {
			if (!frequencies.containsKey(word))
				frequencies.put(word, 0);
			frequencies.put(word, frequencies.get(word)+1);
		}
		return frequencies;
	}

}
