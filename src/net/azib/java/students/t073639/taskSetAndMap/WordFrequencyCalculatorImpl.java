package net.azib.java.students.t073639.taskSetAndMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * WordFrequencyCalculatorImpl
 * 
 * @author t073639
 * 
 */
public class WordFrequencyCalculatorImpl implements net.azib.java.lessons.collections.WordFrequencyCalculator {
	public static void main(String[] args) {
		String str = "Write a a a a a program that calculates word word word frequency table in text text ";
		WordFrequencyCalculatorImpl wfc = new WordFrequencyCalculatorImpl();
		Map<String, Integer> map = wfc.calculateFrequenciesOf(str);
		Iterator<Integer> it = map.values().iterator();
		Iterator<String> is = map.keySet().iterator();
		while (is.hasNext()) {
			System.out.println("Key=" + is.next() + ", Freq=" + it.next());
		}
	}

	@Override
	public Map<String, Integer> calculateFrequenciesOf(String text) {
		Map<String, Integer> tm = new TreeMap<String, Integer>();
		Collection<String> c = Arrays.asList(text.split(" ", text.length()));
		TreeSet<String> ts = new TreeSet<String>(c);
		Iterator<String> its = ts.iterator();
		while (its.hasNext()) {
			String str=its.next();
			tm.put(str, Collections.frequency(c, str));
		}
		return tm;
	}

}
