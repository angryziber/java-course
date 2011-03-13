package net.azib.java.students.t107678.hw3;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator{

    @Override
    public Map<String, Integer> calculateFrequenciesOf(String text) {
        String[] words = text.split("\\s+");
		Map<String, Integer> frequencies = new LinkedHashMap<String, Integer>();
		for (String word : words) {
			word = word.toLowerCase();
			if (!frequencies.containsKey(word))
				frequencies.put(word, 0);
			frequencies.put(word, frequencies.get(word)+1);
		}
		return frequencies;

    }
}
