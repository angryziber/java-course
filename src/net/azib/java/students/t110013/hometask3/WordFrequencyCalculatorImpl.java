package net.azib.java.students.t110013.hometask3;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: Vadim
 * Date: 6.03.11
 * Time: 12:20
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {

	public Map<String, Integer> calculateFrequenciesOf(String text) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (String s : text.split("\\s")) {
			Integer freq = map.get(s);
			map.put(s, freq == null ? 1 : freq + 1);
		}
		return map;
	}
}
