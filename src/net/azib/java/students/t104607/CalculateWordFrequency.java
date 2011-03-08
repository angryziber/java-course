package net.azib.java.students.t104607;
// @author 104607 IASM

import java.util.Map;

public class CalculateWordFrequency {
	public static void main(String[] args) {
		String longText = new String (
			"I am trying to see\n" +
			"I am trying to believe\n" +
			"this is not where I should be\n" +
			"I am trying to believe"
		);

		System.out.println(longText + "\n");
		WordFrequencyCalculatorImpl textFreq = new WordFrequencyCalculatorImpl();
		Map<String,Integer> result = textFreq.calculateFrequenciesOf(longText);
		for (String word:result.keySet()) {
			System.out.println(word + " - " + result.get(word));
		}
	}
}
