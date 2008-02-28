package net.azib.java.students.t030633;

import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculator
 * 
 * @author t030633
 */
public class WordFrequencyCalculator implements net.azib.java.lessons.collections.WordFrequencyCalculator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.azib.java.lessons.collections.WordFrequencyCalculator#calculateFrequenciesOf(java.lang.String)
	 */

	@SuppressWarnings("unchecked")
	public Map calculateFrequenciesOf(String text) {

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

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		WordFrequencyCalculator freqCalc = new WordFrequencyCalculator();
		String text = "Steve Ballmer Developers Developers Developers Developers Developers Developers Developers " +
				"Developers Developers Developers Developers Developers Developers Developers Developers";

		Map map = freqCalc.calculateFrequenciesOf(text); // does the work :)

		System.out.println(map.toString());

	}

}
