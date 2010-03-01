package net.azib.java.students.t073857.hw3;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * WordFrequencyCalculatorImpl
 * 
 *	
 *
 * @author Joonas Vali
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator{
	public static void main(String[] args) {
		String s = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
				"Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
				"when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
				"It has survived not only five centuries, but also the leap into electronic typesetting, " +
				"remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset " +
				"sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like " +
				"Aldus PageMaker including versions of Lorem Ipsum.";
		Map<String, Integer> m = new WordFrequencyCalculatorImpl().calculateFrequenciesOf(s);		
		for(Entry<String, Integer> entry :m.entrySet()){
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
	}
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
