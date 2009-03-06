/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture3;

import java.util.Map;
import java.util.TreeMap;
import net.azib.java.lessons.collections.WordFrequencyCalculator;

/**
 *
 * @author Karl
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {

    public Map<String, Integer> calculateFrequenciesOf(String text) {
        String[] wordArray = text.split("\\s+");
        Map<String, Integer> wordFrequencies = new TreeMap<String, Integer>();

        if (text.length() == 0) {return wordFrequencies;}

        int frequency;
        for (String word : wordArray) {
            word = word.toLowerCase();
            frequency = wordFrequencies.containsKey(word) ? wordFrequencies.get(word) + 1 : 1;
            wordFrequencies.put(word, frequency);
        }
        return wordFrequencies;
    }
}

