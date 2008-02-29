package net.azib.java.students.t980814.lec3;

import java.util.LinkedHashSet;

/**
 * DuplicateRemover
 *
 * @author allan
 */
public class DuplicateRemoverImpl {

	/**
	 * Removes all duplicate elements from an array of Strings.
	 * 
	 * @param array
	 * @return an array of Strings, where each String appears only once. 
	 * The Strings have the same order as in the source array.
	 */
	static public String[] removeDuplicateStrings(String[] array) {
		LinkedHashSet<String> uniqueStrings = new LinkedHashSet<String>();
		for (String s : array) {
			if (!uniqueStrings.contains(s))
				uniqueStrings.add(s);
		}
		return uniqueStrings.toArray(new String[uniqueStrings.size()]);
	}
}