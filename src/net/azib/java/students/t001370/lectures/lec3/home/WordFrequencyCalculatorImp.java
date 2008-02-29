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

	public Map calculateFrequenciesOf(String text) {
		Map<String,Integer> returnMap = new HashMap<String,Integer>();
		String[] strArray = text.split("\\s");
		
		for (String keyStr : strArray) {
			Integer integerValue = new Integer(0);
			
			integerValue = returnMap.get(keyStr);
			
			if (integerValue == null) {
				returnMap.put(keyStr, (integerValue.valueOf(1)));
			}
			else{
				returnMap.put(keyStr, integerValue.valueOf(integerValue.intValue() + 1));
			}
		}
		return returnMap;
	}
}
