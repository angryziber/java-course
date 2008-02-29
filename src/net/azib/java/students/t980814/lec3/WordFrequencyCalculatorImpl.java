package net.azib.java.students.t980814.lec3;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.TreeMap;

/**
 * WordFrequencyCalculator
 *
 * @author allan
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {

	public TreeMap<String, Integer> freqMap;

	public WordFrequencyCalculatorImpl(String text) {
		freqMap = calculateFrequenciesOf(text);
	}
	
	/**
	 * Calculates frequencies of words in a text, represented by a String
	 * @param text the text to analyze
	 * @return a Map, where keys are words and values are number of occurrences 
	 */
	public TreeMap<String, Integer> calculateFrequenciesOf(String text) {
		TreeMap<String, Integer> freqTable = new TreeMap<String, Integer>();
		String[] splitString = text.split("\\s");
		
		// Remove punctuation
		for (int i = 0; i < splitString.length; i++) {
			if (splitString[i].endsWith(",") || splitString[i].endsWith(".")) {
				splitString[i] = splitString[i].substring(0, splitString[i].length()-1);
			}
		}

		// Build Map
		for(String s : splitString) {
			if (freqTable.containsKey(s))
				freqTable.put(s, freqTable.get(s) + 1);
			else
				freqTable.put(s, 1);
		}
		return freqTable;
	}

}
