package net.azib.java.students.t030629.hometasks.ht3;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * AN implementationf for WordFrequencyCalculator in Lesson 4.
 *
 * @author anton_chepurov
 */
public class WordFrequencyCalculator implements net.azib.java.lessons.collections.WordFrequencyCalculator {
	private Comparator comparator;
	
	public WordFrequencyCalculator(Comparator comparator){
		this.comparator = comparator;
	}

	public WordFrequencyCalculator() {
		this(null);
	}

	public Map calculateFrequenciesOf(String text) {
		Map<String, Integer> wordMap = (comparator == null)
			? new TreeMap<String, Integer>() : new TreeMap<String, Integer>(comparator);
		String[] words = text.split("\\s");
		
		for (String word : words) {
			wordMap.put(word, wordMap.containsKey(word) ? wordMap.get(word) + 1 : 1);
		}
		
		return wordMap;
	}

	public static void main(String... args) {
		String phrase = "One thr one but cow cow cow heeee huh muah muah bee huh";
		
		/* Do not ignore case */
		System.out.println("Case sensitive:");
		Map wordFrequences = new WordFrequencyCalculator().calculateFrequenciesOf(phrase);
		for (Map.Entry<String, Integer> entry : (Set<Map.Entry<String, Integer>>) wordFrequences.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		/* Ignore case */
		System.out.println("###########################");
		System.out.println("Case insensitive:");
		wordFrequences = new WordFrequencyCalculator(new AlphabeticalComparator()).calculateFrequenciesOf(phrase);
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
