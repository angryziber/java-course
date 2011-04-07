package net.azib.java.students.t104540.hometask4;

import java.util.Map;
import java.util.TreeMap;

public class WordFrequencyCalculatorImpl implements net.azib.java.lessons.collections.WordFrequencyCalculator{
	public Map<String, Integer> calculateFrequenciesOf(String text){
		Map<String, Integer> map = new TreeMap<String, Integer>();
		String[] arr = text.split("\\s");

		for (String s : arr) {
			if(map.containsKey(s)){
				map.put(s.toLowerCase(), map.get(s)+1);
			}
			else{
				map.put(s.toLowerCase(), 1);
			}
		}

		return map;
	}

}
