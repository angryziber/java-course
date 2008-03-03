package net.azib.java.students.t040771.hometasks.hometask3;

import net.azib.java.lessons.collections.WordFrequencyCalculator;
import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculator
 *
 * @author raido
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {

	public Map<String, Integer> calculateFrequenciesOf(String text) {
		TreeMap<String, Integer> tmap = new TreeMap<String, Integer>();
		String stringArray[] = text.split("\\s");
		Integer i;
		for(String s: stringArray) {
			if ((i = tmap.get(s)) == null) tmap.put(s, 1);
			else tmap.put(s, i + 1);
		}
		return tmap;
	}

	public static void main(String[] args) {
		WordFrequencyCalculatorImpl wordCalc = new WordFrequencyCalculatorImpl();
		String s = "hello world hello world goodbye hello world";
		System.out.println(s);
		
		Map<String, Integer> map;
		map = wordCalc.calculateFrequenciesOf(s);
		
		System.out.println(map);
	}
}
