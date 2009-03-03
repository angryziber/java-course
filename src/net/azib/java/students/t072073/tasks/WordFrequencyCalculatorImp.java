package net.azib.java.students.t072073.tasks;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculatorImp
 *
 * @author janika
 */
public class WordFrequencyCalculatorImp implements WordFrequencyCalculator {

	public Map<String, Integer> calculateFrequenciesOf(String text) {
		String [] words = text.split("\\s");
		TreeMap<String, Integer> wordFrequencies = new TreeMap<String, Integer>();
		for(String word : words){
			int frequency = wordFrequencies.containsKey(word) ? wordFrequencies.get(word) + 1 : 1;
			wordFrequencies.put(word, frequency);
		}
		return wordFrequencies;
	}

	public static void main(String[] args) {
		WordFrequencyCalculatorImp wordFrequencies = new WordFrequencyCalculatorImp();
		System.out.println(wordFrequencies.calculateFrequenciesOf("how much wood would a woodchuck chuck if a woodchuck could chuck wood if if if").toString());
		
	}

}
