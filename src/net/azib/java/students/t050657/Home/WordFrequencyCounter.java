package net.azib.java.students.t050657.Home;

import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCounter
 * @author t050657
 *
 */
public class WordFrequencyCounter {	
	
	public static void main(String[] args) {
		
		String text = "The String class represents character strings. " +
				"All string literals in Java programs, such as abc, " +
				"are implemented as instances of this class Strings " +
				"are constant; their values cannot be changed after " +
				"they are created. String buffers support mutable strings. " +
				"Because String objects are immutable they can be shared.";
		
		String[] words = text.split("\\s");
		
		Map<String, Integer> map = new TreeMap<String, Integer>();
		
		for(String word : words) {
			if(map.containsKey(word)) {
				Integer counter = map.get(word)+1;
				map.put(word, counter);
			}
			else {
				map.put(word, 1);
			}
		}
		
		for(Map.Entry me : map.entrySet()) {
			System.out.println(me.getKey() + " = " + me.getValue() + " times");
		}
		
	}
}
