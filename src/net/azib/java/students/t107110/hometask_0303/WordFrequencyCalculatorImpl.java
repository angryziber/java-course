package net.azib.java.students.t107110.hometask_0303;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Eduard Shustrov
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {
	@Override
	public Map<String, Integer> calculateFrequenciesOf(final String text) {
		if (text == null) return null;

		Map<String, Integer> wordMap = new TreeMap<String, Integer>();
		for (final String word : text.split("\\s+")) {
			if (word.isEmpty()) continue;

			final Integer wordCount = wordMap.get(word);
			wordMap.put(word, wordCount == null ? 1 : wordCount + 1);
		}
		return wordMap;
	}
}
