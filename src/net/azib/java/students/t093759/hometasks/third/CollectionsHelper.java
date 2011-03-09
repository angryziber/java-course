package net.azib.java.students.t093759.hometasks.third;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: dionis
 * Date: 09.03.11
 * Time: 23:08
 */
public class CollectionsHelper implements net.azib.java.lessons.collections.DuplicateRemover, WordFrequencyCalculator {
	private CollectionsHelper() {
	}

	private static CollectionsHelper instance;

	public static CollectionsHelper getInstance() {
		if (instance == null) {
			instance = new CollectionsHelper();
		}

		return instance;
	}

	public String[] removeDuplicateStrings(String... array) {
		return new LinkedHashSet<String>(Arrays.asList(array)).toArray(new String[0]);
	}

	public Map<String, Integer> calculateFrequenciesOf(String text) {
		Map<String, Integer> wordsWithFrequencies = new TreeMap<String, Integer>();

		for (String s : text.split(" ")) {
			int countValue = 1;
			if (wordsWithFrequencies.containsKey(s)) {
				countValue = wordsWithFrequencies.get(s) + 1;
			}
			wordsWithFrequencies.put(s, countValue);
		}
		return wordsWithFrequencies;
	}
}
