package net.azib.java.students.t980814.lec3;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * DuplicateRemover
 *
 * @author allan
 */
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
	 * @return an array of Strings, where each String appears only once. 
	 * The Strings have the same order as in the source array.
	 */
	public String[] removeDuplicateStrings(String[] array) {
		LinkedHashSet<String> uniqueStrings = new LinkedHashSet<String>(Arrays.asList(array));
		return uniqueStrings.toArray(new String[uniqueStrings.size()]);

// Ülal on parim lahendus, all on minu lahendus.
//		
//		LinkedHashSet<String> uniqueStrings = new LinkedHashSet<String>();
//		for (String s : array)
//			uniqueStrings.add(s);
//		return uniqueStrings.toArray(new String[uniqueStrings.size()]);
	}
}