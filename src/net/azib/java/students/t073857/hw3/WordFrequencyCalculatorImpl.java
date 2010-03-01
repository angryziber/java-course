package net.azib.java.students.t073857.hw3;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculatorImpl
 * 
 *	
 *
 * @author Joonas Vali
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator{	
	/**
	 * Calculates frequencies of words in a text, represented by a String. Case-sensitive.
	 * @param text the text to analyze
	 * @return a Map, where keys are words and values are number of occurrences.
	 * 		   Words are returned in the alphabetical order.  
	 */		
	public Map<String, Integer> calculateFrequenciesOf(String text) {
		Map<String, Integer> m = new TreeMap<String, Integer>();		
		String[] spl = text.split("\\s");
		for (String s : spl) {			
			Integer val = m.get(s);
			if(val != null)
				m.put(s, val+1);
			else
				m.put(s, 1);
		}		
		return m;
	}
	

}
