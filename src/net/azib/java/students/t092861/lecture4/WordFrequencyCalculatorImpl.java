package net.azib.java.students.t092861.lecture4;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import net.azib.java.lessons.collections.WordFrequencyCalculator;

/**
 * @author Stanislav / 092861
 * 
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {
	String[] array;

	/*
	 * (non-Javadoc)
	 * 
	 * @seenet.azib.java.lessons.collections.WordFrequencyCalculator#
	 * calculateFrequenciesOf(java.lang.String)
	 */
	@Override
	public Map<String, Integer> calculateFrequenciesOf(String text) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		String newText = "";
		char c = '.';

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != c)
				newText += text.charAt(i);
		}

		newText = newText.toLowerCase();

		array = newText.split("\\s");
		// for (String element : array) {
		// System.out.println(element);
		// }

		for (String word : array)
			if (!map.containsKey(word))
				map.put(word, 1); // one occurrence
			else
				map.put(word, map.get(word) + 1); // adding another occurrence

		return map;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		String text = "The first step is to be able to analyze web pages based on their content. "
				+ "This will eventually allow us to rate how relevant a particular page is for a given user request. "
				+ "We assume that the content of a page is correlated with the words it contains. "
				+ "For this assignment you will use a binary search tree to help you calculate and store the frequencies of words found in a given web page. "
				+ "Then you will print out the most frequent words found.";

		WordFrequencyCalculatorImpl wci = new WordFrequencyCalculatorImpl();
		map = wci.calculateFrequenciesOf(text);
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println(key + " - " + map.get(key));
		}
	}
}
