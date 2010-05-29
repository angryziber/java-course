package net.azib.java.students.t092859.hometask4;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * WordFrequencyCalculatorImpl
 *
 *	Calculates frequencies of words in text (case insensitive)
 *
 * @author kostya
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator{

/** @param text - string containing words to count
* @return map with words in lowercase and their frequencies, sorted by word in
* alphabetical order
*/
	@Override
	public Map<String, Integer> calculateFrequenciesOf(String text) {
			Map<String, Integer> wordFrequencies = new TreeMap<String, Integer>();
			
			String[] words = text.split("\\s");
			
			for(String word: words){
				word = word.toLowerCase();
				Integer freq = wordFrequencies.get(word);
				if(freq == null)
					freq = 0;
				wordFrequencies.put(word, freq + 1);
			}
			return wordFrequencies;
	}
	
	public static void main(String[] args) {
		WordFrequencyCalculatorImpl freqCalculator = new WordFrequencyCalculatorImpl();
		
		String sourceText = "Strawberry ice cream is not as tasty as strawberry is itself";
		System.out.println("Calculating word frequencies from text:\n\t" + sourceText + "\n");
		
		Map<String, Integer> frequencies = freqCalculator.calculateFrequenciesOf(sourceText);
		System.out.println("Word frequencies:");
		for(Entry<String, Integer> elem : frequencies.entrySet())
			System.out.println("\t" + elem.getKey() + ": " + elem.getValue());
	}

}
