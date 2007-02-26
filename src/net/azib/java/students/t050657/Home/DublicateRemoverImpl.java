package net.azib.java.students.t050657.Home;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DublicateRemoverImpl
 *
 * @author t050657
 */
public class DublicateRemoverImpl {
	
	// NOTE: this class doesn't implement the DuplicateRemover interface
	// why? probably it should be deleted.

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strs = {"aaa", "sss", "ddd", "aaa", "fff"};
		for(String str : removeDuplicateStrings(strs)) {
			System.out.println(str);
		}
	}
	
	public static String[] removeDuplicateStrings(String[] array) {
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		return set.toArray(new String[set.size()]);
	}

}
