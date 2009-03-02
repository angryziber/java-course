package net.azib.java.students.t030682;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class DuplicateRemoverImplementation implements DuplicateRemover {

	public String[] removeDuplicateStrings(String[] array) {
		LinkedHashSet<String> set1 = new LinkedHashSet<String>();
		set1.addAll(Arrays.asList(array));
		return (String[]) set1.toArray(new String[0]);
	}

	public static void main(String[] args) {
		DuplicateRemoverImplementation duplicate = new DuplicateRemoverImplementation();
		String[] s1 = { "n", "f", "a", "f", "5", "1", "r", "s", "s", "a", "n", "f" ,"1"};
		String[] s2 = duplicate.removeDuplicateStrings(s1);
		for (String s : s2) {
			System.out.println(s);
		}
	}
}
