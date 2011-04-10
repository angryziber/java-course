package net.azib.java.students.t092855.lecture4;


import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Map;
import java.util.TreeMap;

public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator{


	@Override
	public Map<String, Integer> calculateFrequenciesOf(String text) {
		String[] words = text.split("\\s+");
		Map<String, Integer> wordFreq = new TreeMap<String, Integer>();

		for (String s : words) {
			s = s.toLowerCase();
			if (wordFreq.containsKey(s))
				wordFreq.put(s, wordFreq.get(s) + 1);
			else
				wordFreq.put(s, 1);
		}

		return wordFreq;
	}

	public static void main(String[] args) {
		String text = "aaa bbb ccc ddd eee aaa bbb eee fff ggg ccc ddd";

		Map textFrequencies = new WordFrequencyCalculatorImpl().calculateFrequenciesOf(text);
		System.out.println(textFrequencies.toString());
	}
}
