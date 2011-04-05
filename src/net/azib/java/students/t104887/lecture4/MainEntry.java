package net.azib.java.students.t104887.lecture4;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 3.04.11
 * Time: 18:37
 * To change this template use File | Settings | File Templates.
 */
public class MainEntry {
	public static void main(String[] args) {
		duplicateRemover();
		wordFrequencyCalculator();
	}

	private static void wordFrequencyCalculator() {
		WordFrequencyCalculatorImpl wordsCollection = new WordFrequencyCalculatorImpl();
		String text = Helper.GetText();
		Map<String, Integer> words = wordsCollection.calculateFrequenciesOf(text);

		Iterator it = words.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
		}
	}

	private static void duplicateRemover() {
		DuplicateRemoverImpl collection = new DuplicateRemoverImpl();
		String[] inputValues = new String[]{"one", "one", "two", "one", "three", "two"};
		String[] outputValues = collection.removeDuplicateStrings(inputValues);

		System.out.println("Input values:");
		for (String value : inputValues) {
			System.out.println(value);
		}

		System.out.println("Output values:");
		for (String value : outputValues) {
			System.out.println(value);
		}
	}
}
