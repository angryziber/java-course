package net.azib.java.students.t104923.hometask4;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator{

	public Map<String, Integer> calculateFrequenciesOf (String text) {
		text = text.replaceAll("\\p{Punct}", "");
		String[] stringArray = text.split("\\s");
		Map<String, Integer> stringMap = new LinkedHashMap<String, Integer>();
		for(String word: stringArray){
			word = word.toLowerCase();
			stringMap.get(word);
			if(!stringMap.containsKey(word)){
				stringMap.put(word, 1);
			}
			else{
				stringMap.put(word, stringMap.get(word)+1);
			}
		}
		return stringMap;
	}

	public static void main(String[] args) {
		String stringText = "As authorities work to avoid a full meltdown at the Fukushima Daiichi power plant, where a second explosion occurred this morning and where three of four nuclear reactors are now experiencing severe cooling problems, potentially harmful radiation has already been introduced to the surrounding environment.";
		System.out.println(stringText);
		WordFrequencyCalculator calculator = new WordFrequencyCalculatorImpl();
		System.out.println(calculator.calculateFrequenciesOf(stringText));
	}
}
