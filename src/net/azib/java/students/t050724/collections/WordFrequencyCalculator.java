package net.azib.java.students.t050724.collections;

import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculator
 *
 * @author xom
 */
public class WordFrequencyCalculator implements net.azib.java.lessons.collections.WordFrequencyCalculator {

	@Override
	public Map<String, Integer> calculateFrequenciesOf(String text) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		String[] tArray = text.split("\\s");
		for (String key : tArray) {
			Integer value = map.get(key);
			map.put(key, value == null ? 1 : ++value);
		}
		return map;
	}

}
