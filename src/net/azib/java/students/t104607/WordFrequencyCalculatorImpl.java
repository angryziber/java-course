package net.azib.java.students.t104607;
// @author 104607 IASM

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Map;
import java.util.TreeMap;

public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {
	public Map<String, Integer> calculateFrequenciesOf(String text) {
		Map<String, Integer> result = new TreeMap<String, Integer>();
		for (String word:text.split("\\s")) {
			if (result.containsKey(word)) {
				result.put(word,result.get(word)+1);
			} else {
				result.put(word,1);
			}
		}
		return result;
	}
}
