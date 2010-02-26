package net.azib.java.students.t093052.hometask03;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculatorImpl
 *
 * @author Kostja
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {
	
	@Override
	public Map<String, Integer> calculateFrequenciesOf(String text) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		
		String[] textArray = text.split("\\s+");
		for (String key : textArray) {
			Integer value = map.get(key);
			map.put(key, value == null ? 1 : ++value);
		}
		
		return map;
	}

}
