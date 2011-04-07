package net.azib.java.students.t104540.hometask4;

import java.util.Map;

public class WordFrequencyCalculatorDemo {
	    public static void main(String[] args) {
		String text = "one two three four four four four three three two";
		WordFrequencyCalculatorImpl wfc = new WordFrequencyCalculatorImpl();
		Map result = wfc.calculateFrequenciesOf(text);
		for (Object o : result.entrySet()) {
			System.out.println(o.toString());
		}
	}
}
