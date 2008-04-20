package net.azib.java.students.t072054.hometask1;

import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculatorImpl
 *
 * @author Roman
 */


public class WordFrequencyCalculatorImpl implements net.azib.java.lessons.collections.WordFrequencyCalculator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.azib.java.lessons.collections.WordFrequencyCalculator#calculateFrequenciesOf(java.lang.String)
	 */

	public Map<String, Integer> calculateFrequenciesOf(String text) {

		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		String[] strings = text.split("\\s");

		for (String i : strings) {
			if (map.get(i) == null)
				map.put(i, 1);
			else
				map.put(i, map.get(i) + 1);
		}
		return map;

	}

}