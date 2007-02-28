package net.azib.java.students.t030632.collectionsTask;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * WordFrequencyCalculator
 * 
 * @author Toni
 */
public class WordFrequencyCalculator {
	public static void main(String... strings) {
		new WordFrequencyCalculator().calculateWordFrequency(strings);

	}

	public void calculateWordFrequency(String[] strings) {
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		for (String str : strings){
			if(map.containsValue(str)){
				map.put(str, (map.get(str))+1);
			}else{
				map.put(str, 1);
			}
			
		}
		
		for (Map.Entry <String, Integer> me : map.entrySet() ){
			System.out.println(me.getKey()+" esineb "+me.getValue()+" korda.");
		}
	}
}
