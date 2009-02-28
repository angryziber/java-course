package net.azib.java.students.t090437;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.HashMap;
import java.util.Map;

/**
 * MyWordFreqCounter
 * 
 * @author Ronald
 */
public class MyWordFrequencyCalculator implements WordFrequencyCalculator {

	public Map<String, Integer> calculateFrequenciesOf(String text) {
		HashMap<String, Integer> hm = new HashMap();
		String[] words = text.split(" ");

		for (String word : words) {
			if (hm.containsKey(word)) {
				hm.put(word, hm.get(word) + 1);
			}
			else {
				hm.put(word, new Integer(1));
			}
		}

		return hm;
	}

	public static void main(String[] args) {
		String text = "tere tere vana kere";
		MyWordFrequencyCalculator mWFC = new MyWordFrequencyCalculator();
		Map<String, Integer> m = mWFC.calculateFrequenciesOf(text);

		for (Map.Entry e : m.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
}
