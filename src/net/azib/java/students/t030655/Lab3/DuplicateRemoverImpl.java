package net.azib.java.students.t030655.Lab3;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemoverImpl
 *
 * @author t030655
 */
public class DuplicateRemoverImpl implements DuplicateRemover {


	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.DuplicateRemover#removeDuplicateStrings(java.lang.String[])
	 */
	@Override
	public String[] removeDuplicateStrings(String[] array) {
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		return (String[]) set.toArray(new String[set.size()]);
	}

}
