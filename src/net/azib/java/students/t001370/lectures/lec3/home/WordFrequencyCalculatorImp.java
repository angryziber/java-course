package net.azib.java.students.t001370.lectures.lec3.home;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.HashMap;
import java.util.Map;

/**
 * WordFrequencyCalculator
 *
 * @author maksim
 */
public class WordFrequencyCalculatorImp implements WordFrequencyCalculator{

	
	private String removaMarksFromString(String text){
		if (text.contains(".")) {text = text.replace(".", " ");}
		if (text.contains(",")) {text = text.replace(",", " ");}
		if (text.contains(")")) {text = text.replace(")", " ");}
		if (text.contains("(")) {text = text.replace("(", " ");}
		if (text.contains(":")) {text = text.replace(":", " ");}
		if (text.contains(";")) {text = text.replace(";", " ");}
		if (text.contains("<")) {text = text.replace("<", " ");}
		if (text.contains(">")) {text = text.replace(">", " ");}
		if (text.contains("-")) {text = text.replace("-", " ");}
		if (text.contains("[")) {text = text.replace("[", " ");}
		if (text.contains("]")) {text = text.replace("]", " ");}
		if (text.contains("{")) {text = text.replace("{", " ");}
		if (text.contains("}")) {text = text.replace("}", " ");}
		
		do {
			text = text.replace("  ", " ");
		}
		while (text.contains("  "));
		
		return text;
	}
	
	public Map<String,Integer> calculateFrequenciesOf(String text) {
		Map<String,Integer> returnMap = new HashMap<String,Integer>();
		
		text = removaMarksFromString(text);
		String[] strArray = text.split("\\s");
		
		for (String keyStr : strArray) {
			if (returnMap.containsKey(keyStr)){
				returnMap.put(keyStr, returnMap.get(keyStr) + 1);
			}
			else{
				returnMap.put(keyStr, 1);
			}
		}
		return returnMap;
	}
}
