package net.azib.java.students.t050657.Home;

import net.azib.java.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DublicateRemoverImpl
 *
 * @author t050657
 */
public class DublicateRemoverImpl implements DuplicateRemover {

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
