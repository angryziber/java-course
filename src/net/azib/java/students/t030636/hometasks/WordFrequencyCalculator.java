package net.azib.java.students.t030636.hometasks;

import java.util.Map;
import java.util.TreeMap;

public class WordFrequencyCalculator {
	
	public String outputFrequencyTable(String inputString) {
		
		Map<String, Integer> map = new TreeMap<String, Integer>(); 	//using a TreeMap(results in alphabetical order), where words are keys and frequency is the value
		String[] splitText = inputString.split("\\s"); 				//separate string into array of strings(words)
		
		for (String word : splitText) { 			//loop - for every word in the text
			if (map.containsKey(word))				//the word already exists in the map
				map.put(word, map.get(word) + 1);	//increment the value
			else
				map.put(word, 1);					//first time we have seen this word
		}
		
		String outputTable = new String();			//the output string
				
		for (Map.Entry<String, Integer> m : map.entrySet()) {			//loop - for every entry in the map
			outputTable = outputTable +"The word - " + m.getKey() 
			+ " - occurred in the text " +  m.getValue()  + " times!" 	//add a line to the output string(word + frequency)
			+ System.getProperty("line.separator");
		}
		return outputTable;	//output the lines in a string
	}

	public static void main(String[] args) {
		String text = "The R1 has been touted by some as a rival to the Lotus Elise "
			+ "For £30,139 you get an open-topped sports car that can reach 62 mph from standstill in 3.6 sec "
			+ "— 1.3 sec faster than the Elise R";
		
		WordFrequencyCalculator calculate = new WordFrequencyCalculator();
		System.out.println(calculate.outputFrequencyTable(text)); //output the string returned by frequency calculator method
	}

}
