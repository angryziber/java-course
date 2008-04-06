package net.azib.java.students.t020544.hometasks.task03;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemoverImpl
 * 
 * @author Julija Kondratjeva
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	public String[] removeDuplicateStrings(String[] array) {
//		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));

		Set<String> words = new LinkedHashSet<String>();
		for (String s : array) {
			words.add(s);
		}
		return words.toArray(new String[words.size()]);
	}

	public static void main(String[] args) {
		DuplicateRemoverImpl d = new DuplicateRemoverImpl();
		String[] arr = new String[] { "one", "two", "three", "one", "two" };
		
		for (String s : d.removeDuplicateStrings(arr)){
			System.out.print(s + " ");
		}
	}

}
