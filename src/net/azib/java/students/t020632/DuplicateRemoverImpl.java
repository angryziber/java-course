package net.azib.java.students.t020632;

import net.azib.java.collections.DuplicateRemover;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Arrays;

/**
 * DuplicateRemoverImpl
 *
 * @author t020632
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	/* (non-Javadoc)
	 * @see net.azib.java.collections.DuplicateRemover#removeDuplicateStrings(java.lang.String[])
	 */
	@Override
	public String[] removeDuplicateStrings(String[] array) {
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		
		return  set.toArray(new String[0]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] strings;

	}

}
