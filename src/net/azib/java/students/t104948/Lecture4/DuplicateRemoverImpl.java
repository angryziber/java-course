package net.azib.java.students.t104948.Lecture4;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Arrays;

public class DuplicateRemoverImpl implements DuplicateRemover{
	@Override
	public String[] removeDuplicateStrings(String... array) {
		Set <String> stringSet= new LinkedHashSet<String>(Arrays.asList(array));
		return stringSet.toArray(new String[stringSet.size()]);
	}

	public static void main(String[] args) {
		String[] stringArray = {"A", "B", "B", "D", "E", "C", "A", "F"};
		DuplicateRemover remover = new DuplicateRemoverImpl();
		String[] resultString = remover.removeDuplicateStrings(stringArray);
		System.out.println(Arrays.toString(resultString));
	}
}
