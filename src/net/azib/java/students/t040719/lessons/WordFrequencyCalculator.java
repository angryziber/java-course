package net.azib.java.students.t040719.lessons;

import java.util.Map;
import java.util.TreeMap; // Sorteerib võtmed tähestikulises järjekorras
import java.util.LinkedHashMap; // Kasutada seda, kui tahad näha sõnu esinemise järjekorras

/**
 * WordFrequencyCalculator
 *
 * @author Administrator
 */

public class WordFrequencyCalculator{
	static Map<String,Integer> calculateFrequenciesOf(String text){
		Map<String,Integer> ret = new TreeMap<String,Integer>();
		for (String s: text.split("\\s")){
			if(!ret.containsKey(s))
				ret.put(s, 0);
			ret.put(s, ret.get(s)+1);
		}
		return ret;
	}
}
