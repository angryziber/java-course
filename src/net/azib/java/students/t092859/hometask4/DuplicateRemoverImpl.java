package net.azib.java.students.t092859.hometask4;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * DuplicateRemoverImpl
 * @author kostya
 */
public class DuplicateRemoverImpl implements DuplicateRemover{

/** @param array - array of strings to be cleaned of duplicates
* @return array of string without duplicates, in the same order as the original
*/
	@Override
	public String[] removeDuplicateStrings(String... array) {
		LinkedHashSet<String> strings = new LinkedHashSet<String>(Arrays.asList(array));
		return strings.toArray(new String[0]);
	}
	
	public static void main(String[] args) {
		DuplicateRemoverImpl remover = new DuplicateRemoverImpl();
		
		String[] originalStrings = new String[]{"str1", "str2", "str1"};
		System.out.println("Original array of strings: " + Arrays.deepToString(originalStrings));
		
		String[] filteredStrings = remover.removeDuplicateStrings(originalStrings);
		System.out.println("Array of strings after removing duplicates: " + Arrays.deepToString(filteredStrings));
	}

}
