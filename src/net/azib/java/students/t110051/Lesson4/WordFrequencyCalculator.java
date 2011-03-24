package net.azib.java.students.t110051.Lesson4;

import net.azib.java.lessons.collections.WordFrequencyCalculatorImpl;
import java.util.TreeMap;
import java.util.Map;

public class WordFrequencyCalculator implements net.azib.java.lessons.collections.WordFrequencyCalculator{

	public static void main(String[] args) {
	String text = "Sotsiaalminister Sotsiaalminister Sotsiaalminister . Hanno Pevkur rääkis Postimees.ee’le, et vanemapensioni süsteem lööb pensionärid küll laste sünniaja põhjal kolme gruppi, kuid eesmärk on tegelikult võrdsus ja selgus.";
		WordFrequencyCalculatorImpl WordFrequencyCalculator = new WordFrequencyCalculatorImpl();
		System.out.println(WordFrequencyCalculator.calculateFrequenciesOf(text));
	}


	@Override
	public Map<String, Integer> calculateFrequenciesOf(String text) {
		String newText = text.toString().toLowerCase();
		String array[]  = newText.split("\\s");
		Map <String, Integer> words = new TreeMap <String, Integer> ();
		for ( String word : array){
			if (words.get(word) == null){
				words.put(word, 1);}
			else{
				words.put(word, words.get(word) + 1);
			}
		}
		return words;
		}
	}
