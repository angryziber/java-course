package net.azib.java.students.t103758;
import java.util.Map;
import java.util.TreeMap;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator{

  public static void main (String[] args) {
    String someText = "one two two fly fly fly lol";
    WordFrequencyCalculatorImpl WFCI = new WordFrequencyCalculatorImpl();
      System.out.println("input is: " + someText);
      System.out.println("result is: " + WFCI.calculateFrequenciesOf(someText));
  }

  @Override
  public Map<String, Integer> calculateFrequenciesOf (String text) {
  String array[] = text.split("\\s");
    Map <String, Integer> words = new TreeMap <String, Integer>();
      for (String word : array) {
          if(words.get(word)== null)
            words.put(word, 1);
          else
            words.put(word, words.get(word)+1);
      }
      System.out.println(words.size());
  return words;
  }

}
