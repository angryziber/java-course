package net.azib.java.students.t050545.hometasks.collect;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculatorImpl
 *
 * @author libricon
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {

	public Map<String, Integer> calculateFrequenciesOf(String text) {
		String[] words = text.split("[\\s.,:!?()]+");
		Map<String, Integer> frequencies = new LinkedHashMap<String, Integer>();
		for (String word : words) {
			word = word.toLowerCase();
			if (!frequencies.containsKey(word))
				frequencies.put(word, 0);
			frequencies.put(word, frequencies.get(word)+1);
		}
		return new TreeMap<String, Integer>(frequencies);
	}
	
	public static void main(String[] args) {
		WordFrequencyCalculator fr = new WordFrequencyCalculatorImpl();
		System.out.println(fr.calculateFrequenciesOf("black blue boy sheet water a waterfall").keySet());
		System.out.println(fr.calculateFrequenciesOf("blu blue dark white black green yellow a boy sheet paper mellon blue white red purple red"));
	}
        
	
}
