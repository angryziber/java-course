package net.azib.java.students.t073857.hw3;


import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * DuplicateRemoverImplemented
 *
 * @author Joonas Vali
 */
public class DuplicateRemoverImplemented implements DuplicateRemover{

	public static void main(String[] args) {		
		String[] s = {"oo", "aaa", "bbb", "ccc", "aaa", "fff", "ggg", "ggg", "aaa", "bbb"};
		s = new DuplicateRemoverImplemented().removeDuplicateStrings(s);
		for (String string : s) {
			System.out.println(string);
		}
		
	}
	
	/**
	 * Removes all duplicate elements from an array of Strings.
	 * 
	 * @param array array of Strings
	 * @return an array of Strings, where each String appears only once. 
	 * The Strings have the same order as in the source array.
	 */
	public String[] removeDuplicateStrings(String... array) {
		Set<String> h = new LinkedHashSet<String>();		
		for(int i = 0 ; i < array.length; i ++){
			h.add(array[i]);
		}
		return h.toArray(new String[h.size()]);		
	}

}
