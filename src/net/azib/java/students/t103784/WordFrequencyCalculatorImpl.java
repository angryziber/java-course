package net.azib.java.students.t103784;

import net.azib.java.lessons.collections.WordFrequencyCalculator;
import net.azib.java.students.t103640.implementing.WordCalc;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 16.03.11
 * Time: 23:07
 * To change this template use File | Settings | File Templates.
 */
abstract public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {

	public static void main(String[] args) {
		String string = "one one zero one zero zero one one zero zero one zero one one";
        WordFrequencyCalculator freCalc = new WordFrequencyCalculator() {

	        @Override
	        public Map<String, Integer> calculateFrequenciesOf(String text) {
		        String[] strings = text.split("\\s+");
		Map<String, Integer> freq = new LinkedHashMap<String, Integer>();
		for (String string : strings) {
			string = string.toLowerCase();
			if (!freq.containsKey(string))
				freq.put(string, 0);
			freq.put(string, freq.get(string)+1);
		}
		return freq;
	        }
        };
        System.out.println("String: " + string);
        System.out.println("After calculating: " + freCalc.calculateFrequenciesOf(string));

	}





}
