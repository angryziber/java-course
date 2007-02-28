package net.azib.java.students.t020648;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;

/**
 * WordFrequencyCalculator
 * Arvutab sõnade esinemise sagesuda vastavalt etteantud stringile
 *
 * @author t020648
 */
public class WordFrequencyCalculator {
	
	public static void main (String [] args){
		
		String inputString = "uuu uuu tere tere üks kaks kolm";
		Map resultMap = countStrings(inputString);
		
		Set keySet = resultMap.keySet();
		Iterator iter = keySet.iterator();
		
		while(iter.hasNext()){
			String key = (String)iter.next();
			System.out.println("Sõna: " + key);
			System.out.println("Sagedus: " + resultMap.get(key));
		}
		
	}

	/**
	 * Tagastab vastavalt sisseantud stringile mapi stringi esinemisesagedustega
	 * @param inputString
	 * @return
	 */
	public static Map countStrings(String inputString){
		
		String [] differentWords = inputString.split("\\s");
		
		Map map = new TreeMap();		
		
		for(int i = 0;i<differentWords.length; i++){			
			if(map.containsKey(differentWords[i])){
				Integer currentFrequency = (Integer)map.get(differentWords[i]);
				map.put(differentWords[i], new Integer(currentFrequency.intValue()+ 1));
			}
			else{
				map.put(differentWords[i], new Integer(1));
			}
		}
		return map;
	}
	
}
