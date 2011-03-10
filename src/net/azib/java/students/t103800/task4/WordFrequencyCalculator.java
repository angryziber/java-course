package net.azib.java.students.t103800.task4;

import java.util.Map;
import java.util.TreeMap;

/**
 * User: Jaan Aigro
 * Date: 9.03.11
 * Time: 11:12
 */
public class WordFrequencyCalculator implements net.azib.java.lessons.collections.WordFrequencyCalculator {

    public static void main(String[] args) {
        String string = "four four five four asd asd frogs froggy crazy four frogs asd uboat, uboat, tractor";
        WordFrequencyCalculator freqCalc = new WordFrequencyCalculator();
        System.out.println("String: " + string);
        System.out.println("Result: " + freqCalc.calculateFrequenciesOf(string));
    }

    public WordFrequencyCalculator() {
    }

    public Map<String, Integer> calculateFrequenciesOf(String text) {
        String[] array = text.split("\\s");
        Map<String, Integer> result = new TreeMap<String, Integer>();

        for (String treeString : array) {
            int frequency = 0;
	        // TODO: WTF?
            for (String arrayString : array)
	            if (arrayString.equals(treeString)) frequency++;
            result.put(treeString, frequency);
        }
        return result;
    }
}
