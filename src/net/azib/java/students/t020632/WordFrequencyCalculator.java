package net.azib.java.students.t020632;

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Set;

/**
 * WordFrequencyCalculator
 *
 * @author Marek
 */
public class WordFrequencyCalculator {

	/**
	 * @param args
	 */
	public Map countStrings(String s){
		
		String [] words = s.split("\\s");
		int j = 0;
		
		Map<String, Integer> map = new TreeMap<String, Integer>();
		
		for(int i = 0; i < words.length; i++){
			if(map.containsKey(words[i])){
				j = map.get(words[i]);
				map.put(words[i], new Integer(j+1));
			}
			else{
				map.put(words[i], new Integer(1));
			}
			
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		
		
		String s = "karu koer karu karu";
		WordFrequencyCalculator c = new WordFrequencyCalculator();
		
		Map map = c.countStrings(s);
		
		Set set = map.keySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()){
			String k = (String)it.next();
			System.out.print("Sõna " + k);
			System.out.println(" esineb " + map.get(k)+ " korda");
		}

	}

}
