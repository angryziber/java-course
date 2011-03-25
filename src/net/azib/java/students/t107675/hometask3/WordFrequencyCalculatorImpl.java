package net.azib.java.students.t107675.hometask3;


import net.azib.java.lessons.collections.WordFrequencyCalculator;


import java.util.Map;
import java.util.TreeMap;


public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator{
	public static void main(String[] args) {
		String text = "my name is Samet your name is also Samet What is your name I do not know my name";
		System.out.println("The text is: " + text);
		WordFrequencyCalculatorImpl freqCalc = new WordFrequencyCalculatorImpl();
		System.out.println("Calculation is: " +freqCalc.calculateFrequenciesOf(text));
	}

	public Map<String, Integer> calculateFrequenciesOf(String text){
		String[] array=text.split("\\s");
		Map<String,Integer> rslt= new TreeMap <String,Integer>();

		for(String tree:array){
			int a=0;
			for(String arrayStrng: array)
				 if (arrayStrng.equals(tree))
					 a++;
					 rslt.put(tree,a);
		}
		return rslt;

	}

}
