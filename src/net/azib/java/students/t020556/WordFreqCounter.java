package net.azib.java.students.t020556;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * WordFreqCounter
 *
 * @author t020556
 */
public class WordFreqCounter {

	/**
	 * @param args
	 */
	public static void main(String argString) {
		String[] strArr = argString.split("\\s");
		Map<String, Integer> strMap = new LinkedHashMap<String, Integer>();
		
		for(String str : strArr){
			Integer val = strMap.get(str);
			val = val == null ? 0 : val + 1;
			strMap.put(str, val++);
		}
		
		System.out.println(strMap.toString());
	}

}
