package net.azib.java.students.t020281.homework.kt3;

import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculator
 *
 * @author Trial
 */
public class WordFrequencyCalculator implements net.azib.java.lessons.collections.WordFrequencyCalculator {

	public Map<String, Integer> calculateFrequenciesOf(String text) {
		// TODO Auto-generated method stub
		
		String[] myArray = text.split("\\s");
		
		Map<String, Integer> myMap = new TreeMap<String, Integer>();
		
		for (String a: myArray) {
			if (myMap.containsKey(a)) {
				myMap.put(a, myMap.get(a)+1);
			} else {
				myMap.put(a, 1);
			}
		}
		
		return myMap;
	}
	
	public static void main(String[] args) {
		Map<String, Integer> myCalculatedMap = new TreeMap<String, Integer>();
		String text = "The Map interface provides three collection views," +
				" which allow a map's contents to be viewed as a set of keys," +
				" collection of values, or set of key-value mappings. The order of" +
				" a map is defined as the order in which the iterators on the map's " +
				"collection views return their elements. Some map implementations," +
				" like the TreeMap class, make specific guarantees as to their" +
				" order; others, like the HashMap class, do not. ";
		WordFrequencyCalculator myCalculator = new WordFrequencyCalculator();
		
		myCalculatedMap = myCalculator.calculateFrequenciesOf(text);
		
		for (String a: myCalculatedMap.keySet().toArray(new String[myCalculatedMap.size()])) {
			System.out.println(a+" - "+myCalculatedMap.get(a));
		}
		
	}

}
