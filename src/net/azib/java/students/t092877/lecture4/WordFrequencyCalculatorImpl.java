package net.azib.java.students.t092877.lecture4;

import net.azib.java.lessons.collections.WordFrequencyCalculator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {

	@Override
	public Map<String, Integer> calculateFrequenciesOf(String text) {

		Map<String, Integer> freqs = new TreeMap<String, Integer>();
		String[] exSymbols = new String[] { ".", ",", ":", "!", "?", "[", "]", "(", ")", "/", "\\", "'" };

		for (String str : exSymbols)
			text = text.replace(str, "");

		String[] modifiedText = text.toLowerCase().split("\\s");

		for (String word : modifiedText)
			if (!freqs.containsKey(word))
				freqs.put(word, 1);
			else
				freqs.put(word, freqs.get(word) + 1);

		return freqs;
	}

	public static void main(String... args) {

		Map<String, Integer> map = new TreeMap<String, Integer>();
		String text = "Hometask: Create your own abstract class Animal with common fields and methods " +
				      "for all animals, like age. Create a child abstract class Pet, adding name as the " +
				      "common field for all pets. Make some abstract methods as well, like makeSound(). " +
				      "Implement a few concrete animal/pet types by extending the Animal, like Dog, Cat, " +
				      "Sheep, Hedgehog, etc. Make sure each of them has some distinct properties as well " +
				      "as common ones inherited from Animal. Implement toString(). In AnimalDemo, create " +
				      "an Animal[] array, fill it with different animals, and output them to the screen " +
				      "using 'for each' loop.";

		WordFrequencyCalculatorImpl wordFreqCalc = new WordFrequencyCalculatorImpl();
		map = wordFreqCalc.calculateFrequenciesOf(text);

		Iterator<String> iter = map.keySet().iterator();

		System.out.println("Word\t\tFrequency");
		System.out.println("-------------------------");

		while (iter.hasNext()) {

			String word = iter.next();
			System.out.printf("%-10s  %10d\n", word, map.get(word));
		}
	}
}
