package net.azib.java.students.t104923.hometask4;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateRemoverImpl implements DuplicateRemover {

	public String[] removeDuplicateStrings(String[] array) {
		Set<String> stringsSet = new LinkedHashSet<String>(Arrays.asList(array));
		return stringsSet.toArray(new String[stringsSet.size()]);
	}

	public static void main(String[] args) {
		String[] stringArray = {"A", "A", "B", "D", "D", "E" ,"C", "A", "F", "W", "Z", "Z", "A"};
		DuplicateRemover remover = new DuplicateRemoverImpl();
		String[] finalString = remover.removeDuplicateStrings(stringArray);
		System.out.println(Arrays.toString(finalString));
	}
}