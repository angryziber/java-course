package net.azib.java.students.t107110.hometask_0303;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Map;
import java.util.TreeMap;

public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {
	/**
	 * Calculates frequencies of words in a text, represented by a String
	 *
	 * @param text the text to analyze
	 * @return a Map, where keys are words and values are number of occurrences.
	 *         Words should be in the alphabetical order.
	 */
	@Override
	public Map<String, Integer> calculateFrequenciesOf(final String text) {
		final Map<String, Integer> wordMap = new TreeMap<String, Integer>();
		for (final String word : text.split("\\s+")) {
			if (wordMap.containsKey(word)) {
				wordMap.put(word, wordMap.get(word) + 1);
			} else {
				wordMap.put(word, 1);
			}
		}
		return wordMap;
	}

	public static void main(final String[] args) {
		final String text = "text test text one one red one";
		final WordFrequencyCalculator wordFrequencyCalculator = new WordFrequencyCalculatorImpl();
		for (final Map.Entry<String, Integer> entry : wordFrequencyCalculator.calculateFrequenciesOf(text).entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
