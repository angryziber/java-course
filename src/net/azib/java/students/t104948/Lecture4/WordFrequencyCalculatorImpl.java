package net.azib.java.students.t104948.Lecture4;


import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {
	@Override
	public Map<String, Integer> calculateFrequenciesOf(String text) {
		String[] stringArray = text.split("\\s");
		Map<String, Integer> stringMap = new LinkedHashMap<String, Integer>();
		for(String word: stringArray){
			word = word.toLowerCase();
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
		String testString = "A C D E a A K L D e B c b k M l L ";
		System.out.println(testString);
		WordFrequencyCalculator calculator = new WordFrequencyCalculatorImpl();
		System.out.println(calculator.calculateFrequenciesOf(testString));
	}
}
