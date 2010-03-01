package net.azib.java.students.t073862.third;

import net.azib.java.lessons.collections.DuplicateRemover;
import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * ThirdHomework
 *
 * @author Pets
 */
public class ThirdHomework implements DuplicateRemover, WordFrequencyCalculator {

	@Override
	public String[] removeDuplicateStrings(String... array) {
		Set<String> set = new LinkedHashSet<String>();
		for(String s : array) {
			if(!set.contains(s))
				set.add(s);
		}
		return set.toArray(new String[set.size()]);
	}

	@Override
	public Map<String, Integer> calculateFrequenciesOf(String text) {
		String[] data = text.split("\\s");
		Map<String, Integer> result = new TreeMap<String, Integer>();
		for(String s : data) {
			if(result.containsKey(s)) {
				result.put(s, result.get(s)+1);
			}
			else {
				result.put(s,1);
			}
		}
		return result;
	}
	
}
