package net.azib.java.students.t072054.hometask1;

/**
 * DuplicateRemoverImpl
 *
 * @author Roman
 */

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class DuplicateRemoverImpl implements DuplicateRemover {

	public String[] uniqueWords;

	/**
	 * 
	 */
	public DuplicateRemoverImpl(String[] text) {
		uniqueWords = removeDuplicateStrings(text);
	}

	/**
	 * Removes all duplicate elements from an array of Strings.
	 * 
	 * @param array
	 * @return an array of Strings, where each String appears only once. The
	 *         Strings have the same order as in the source array.
	 */
	public String[] removeDuplicateStrings(String[] array) {
		LinkedHashSet<String> uniqueStrings = new LinkedHashSet<String>(Arrays.asList(array));
		return uniqueStrings.toArray(new String[uniqueStrings.size()]);
	}

	public static void main(String[] args) {
		String str[] = { "fafsfads", "adsfsadf", "fadssadf", "fasfdsafsad", "ffsad", 
				"afdadfs", "asfasf", "fadfsadfs", "asfs",
				"affs", "asafsd", "fadsdfsadsf", "afsfadssadf", "afdsaf", "afds", "afasf", 
				"afdafs", "asfasd", "asfasf",
				"asdfds", "afsd" };
		String str2[];

		str2 = new DuplicateRemoverImpl(str).removeDuplicateStrings(str);

		for (String element : str2) {
			System.out.println(element);
		}

	}
}