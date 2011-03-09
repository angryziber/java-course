package net.azib.java.students.t093759.hometasks.third;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: dionis
 * Date: 09.03.11
 * Time: 22:30
 */
public class CollectionsHelperDemo {
	public static void main(String[] args) {
		final String[] words = {"Tee", "Chair", "Tree", "Tee", "Chair", "Tree", "Tree"};
		for (String word : CollectionsHelper.getInstance().removeDuplicateStrings(words)) {
			System.out.println(word);
		}

		System.out.println("----------------------");

		final String text = "Tee Chair Tree Tee";
		for (Map.Entry<String, Integer> wordWithFrequency : CollectionsHelper.getInstance().calculateFrequenciesOf(text).entrySet()) {
			System.out.printf("%-15s:%5d", wordWithFrequency.getKey(), wordWithFrequency.getValue());
			System.out.println();
		}
	}
}
