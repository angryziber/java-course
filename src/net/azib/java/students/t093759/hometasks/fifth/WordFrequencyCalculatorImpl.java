package net.azib.java.students.t093759.hometasks.fifth;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author dionis
 *         23.03.11 13:20
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {
	@Override
	public Map<String, Integer> calculateFrequenciesOf(String text) {
		if (text == null) throw new IllegalArgumentException();
		Map<String, Integer> wordsWithFrequencies = new TreeMap<String, Integer>();
		for (String s : text.split("\\s")) {
			int countValue = 1;
			if (wordsWithFrequencies.containsKey(s)) {
				countValue = wordsWithFrequencies.get(s) + 1;
			}
			wordsWithFrequencies.put(s, countValue);
		}
		return wordsWithFrequencies;
	}
}
