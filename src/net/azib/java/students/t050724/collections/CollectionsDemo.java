package net.azib.java.students.t050724.collections;

import java.util.Iterator;
import java.util.Map;

/**
 * CollectionsDemo
 *
 * @author xom
 */
public class CollectionsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CollectionsDemo demo = new CollectionsDemo();
		demo.dupRemover();
		demo.freqCalculator();
	}

	/**
	 * 
	 */
	private void dupRemover() {
		String[] s = {"gg", "bb", "cc", "aa", "ff", "gg", "gg", "aa", "bb", "ii"};
		s = new DuplicateRemoverImpl().removeDuplicateStrings(s);
		for (String string : s) {
			System.out.println(string);
		}
	}
	
	private void freqCalculator() {
		String s = "aa bb cc dd ee ee bb aa aa dd ee ii uu tt cc";
		WordFrequencyCalculator calculator = new WordFrequencyCalculator();
		Map<String, Integer> demomap = calculator.calculateFrequenciesOf(s);
		Iterator<Integer> value = demomap.values().iterator();
		Iterator<String> key = demomap.keySet().iterator();
		while (key.hasNext()) {
			System.out.println("Key = " + key.next() + ", Frequency = " + value.next());
		}
	}

}
