package net.azib.java.students.t092875.hw3;

import java.util.Iterator;
import java.util.Map;

/**
 * StringProcessorDemo
 *
 * @author Mihhail
 */
public class StringProcessorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new StringProcessorDemo().runDemo();
	}
	
	public void runDemo(){
		//didn't use Interface instead of StringProcessor to save space;
		StringProcessor processor = new StringProcessor();
		String[] test = processor.removeDuplicateStrings("this","this","is","is","is","a","test","test");
		for (String string : test) {
			System.out.println(string);
		}
		System.out.println("\nnow let's count some words:");
		Map<String, Integer> wordCounter = processor.calculateFrequenciesOf("this is a test of the test programm that counts a test string that this string contains and this string that i use for this test does not make any test sence bla bla bla");
		Iterator i = wordCounter.entrySet().iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

}
