package net.azib.java.students.t092875.hw3;

import net.azib.java.lessons.collections.DuplicateRemover;
import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * StringProcessor
 *
 * @author Mihhail
 */
public class StringProcessor implements DuplicateRemover, WordFrequencyCalculator {

	@Override
	public String[] removeDuplicateStrings(String... array) {
		Set<String> set = new LinkedHashSet<String>();
		for (String string : array) {
			set.add(string);
		}
		return set.toArray(new String[set.size()]);
	}

	@Override
	public Map calculateFrequenciesOf(String text) {
		String[] seperatedStrings = text.split("\\s+");
		Map<String, Integer> wordBank = new TreeMap<String, Integer>();
		for (String string : seperatedStrings) {
			if(wordBank.containsKey(string)){
				Integer value = wordBank.get(string);
				value++;
				wordBank.put(string, value);
			}else{
				wordBank.put(string, 1);
			}
		}
		return wordBank;
	}

}
