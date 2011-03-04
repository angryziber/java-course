package net.azib.java.students.t104971.collections;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jaroslav Judin
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {

    /**
     *
     * @param text the text to analyze
     * @return word frequency calculated result
     */
    public Map<String, Integer> calculateFrequenciesOf(String text) {
        Map<String, Integer> result = new TreeMap<String, Integer>();
        for(String s : text.split("\\s")) {
            Integer counter = result.put(s, 1);
            if (counter != null) {
                result.put(s, ++counter);
            }
        }
        return result;
    }
}
