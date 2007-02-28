package net.azib.java.students.t030647;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculator
 *
 * @author t030647
 */
public class WordFrequencyCalculator {

	/**
	 * @param args
	 */
	public WordFrequencyCalculator(String s) {
		Map<String, Integer> map = new TreeMap();
		String s2[] = s.split("\\s");
		for (int i=0; i<s2.length; i++) {
			if (map.containsKey(s2[i])) {
				map.put(s2[i], map.get(s2[i]) + 1);
			}
			else map.put(s2[i], 1);
		}
		for (Map.Entry<String, Integer> me : map.entrySet()) {
			System.out.println(me.getKey() + " = "+ me.getValue());
		}
	}

}
