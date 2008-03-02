package net.azib.java.students.t040771.hometasks.hometask3;

import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculator
 *
 * @author raido
 */
public class WordFrequencyCalculator implements net.azib.java.lessons.collections.WordFrequencyCalculator {

	@SuppressWarnings("unchecked")
	@Override
	public Map calculateFrequenciesOf(String text) {
		TreeMap<String, Integer> tmap = new TreeMap<String, Integer>();
		String stringArray[] = text.split("\\s");
		Integer i;
		for(String s: stringArray) {
			if ((i = tmap.get(s)) == null) tmap.put(s, 1);
			else tmap.put(s, i + 1);
		}
		return tmap;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		WordFrequencyCalculator wordCalc = new WordFrequencyCalculator();
		String s = "hello world hello world goodbye hello world";
		System.out.println(s);
		
		Map map;
		map = wordCalc.calculateFrequenciesOf(s);
		
		System.out.println(map);
	}
}
