package net.azib.java.students.t107678.hw3;

public class WordFrequencyCalculatorDemo {
    public static void main(String[] args) {
        String input = "Today is very cold day day";
        WordFrequencyCalculatorImpl example = new WordFrequencyCalculatorImpl();
        System.out.println(example.calculateFrequenciesOf(input));

    }
}
