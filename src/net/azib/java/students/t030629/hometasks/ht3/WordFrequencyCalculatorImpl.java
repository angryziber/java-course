package net.azib.java.students.t030629.hometasks.ht3;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * An implementation for WordFrequencyCalculator in Lesson 4.
 *
 * @author anton_chepurov
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {
	private Comparator<String> comparator;
	
	public WordFrequencyCalculatorImpl(Comparator<String> comparator){
		this.comparator = comparator;
	}

	public WordFrequencyCalculatorImpl() {
		this(null);
	}

	public Map<String, Integer> calculateFrequenciesOf(String text) {
		Map<String, Integer> wordMap = (comparator == null)
			? new TreeMap<String, Integer>() : new TreeMap<String, Integer>(comparator);
		String[] words = text.split("\\s");
		
		Integer amount;
		for (String word : words) {
			amount = wordMap.get(word);
			wordMap.put(word, amount == null ? 1 : amount + 1);
		}
		
		return wordMap;
	}

	public static void main(String... args) {
		String phrase = "One thr one but cow cow cow heeee huh muah muah bee huh";
		
		/* Do not ignore case */
		System.out.println("Case sensitive:");
		Map<String, Integer> wordFrequences = new WordFrequencyCalculatorImpl().calculateFrequenciesOf(phrase);
		for (Map.Entry<String, Integer> entry : (Set<Map.Entry<String, Integer>>) wordFrequences.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		/* Ignore case */
		System.out.println("###########################");
		System.out.println("Case insensitive:");
		wordFrequences = new WordFrequencyCalculatorImpl(new AlphabeticalComparator()).calculateFrequenciesOf(phrase);
		for (Map.Entry<String, Integer> entry : (Set<Map.Entry<String, Integer>>) wordFrequences.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}		
		
	}
	
    private static class AlphabeticalComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            return s1.compareToIgnoreCase(s2);
        }
    }	

}
