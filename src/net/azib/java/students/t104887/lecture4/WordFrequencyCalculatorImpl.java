package net.azib.java.students.t104887.lecture4;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 5.04.11
 * Time: 21:37
 * To change this template use File | Settings | File Templates.
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {

	public Map<String, Integer> calculateFrequenciesOf(String text) {
		HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
		ValueComparator bvc = new ValueComparator(wordsCount);
		Map<String, Integer> sortedWordsCount = new TreeMap(bvc);
		String[] words = text.split("\\s+|[,.()\":-]|'s");

		for (String word : words) {
			word = word.toLowerCase();

			if (!wordsCount.containsKey(word))
				wordsCount.put(word, 0);
			else
				wordsCount.put(word, wordsCount.get(word) + 1);
		}

		sortedWordsCount.putAll(wordsCount);

		return sortedWordsCount;
	}
}
