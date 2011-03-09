package net.azib.java.students.t105870.Lecture4;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.*;

public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator{
	public static void main(String[] args) {
        String string = "one two ten six two nine eight one two one six seven lol fly fly";
        WordFrequencyCalculator frequencyCalc = new WordFrequencyCalculatorImpl();
        System.out.println("String: " + string);
        System.out.println("Result: " + frequencyCalc.calculateFrequenciesOf(string));
    }

    public WordFrequencyCalculatorImpl() {
    }

    public Map<String, Integer> calculateFrequenciesOf(String text) {
        String[] array = text.split("\\s");
        TreeSet<String> treeMap = new TreeSet<String>(Arrays.asList(array));
        Map<String, Integer> result = new TreeMap<String, Integer>();

        for (String treeString : treeMap) {
            int i = 0;
            for (String arrayString : array) if (arrayString.equals(treeString)) i++;
            result.put(treeString, i);
        }
        return result;
    }
}
