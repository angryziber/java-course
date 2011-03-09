package net.azib.java.students.t103640.implementing;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordCalc implements WordFrequencyCalculator {

    public static void main(String[] args) {
        WordCalc mamba = new WordCalc();
          String testItOut = "Boom, habba, Boom, boom, bauwau, waubau bauwau habba habba";
        System.out.println("String: " + testItOut);

         System.out.println("Word count: " + mamba.calculateFrequenciesOf(testItOut));
    }
    public WordCalc(){}

    public Map<String, Integer> calculateFrequenciesOf(String text) {
        String[] jada = text.split("\\s");
        TreeSet<String> v6saKaart = new TreeSet<String>(Arrays.asList(jada));
        Map<String, Integer> tulem = new TreeMap<String, Integer>();
       for(String treeString : v6saKaart){
             int a = 0;
           for (String jadaString : jada) if (jadaString.equals(treeString)) a++;
            tulem.put(treeString, a);
       }
        return tulem;
    }
}
