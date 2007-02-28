package net.azib.java.students.t020556;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * WordFreqCounter
 *
 * @author t020556
 */
public class WordFreqCounter {

	public static void main(String[] args){
		WordFreqCounter wfc = new WordFreqCounter();
		
		wfc.countWordFreq("hehe haha hehe tere");
	}
	/**
	 * @param args
	 */
	public void countWordFreq(String argString) {
		String[] strArr = argString.split("\\s");
		Map<String, Integer> strMap = new LinkedHashMap<String, Integer>();
		
		for(String str : strArr){
			Integer val = strMap.get(str);
			val = val == null ? 1 : val + 1;
			strMap.put(str, val);
		}
		
		System.out.println(strMap.toString());
	}

}
