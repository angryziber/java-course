package net.azib.java.students.t010687;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemoverClass
 *
 * @author t010687
 */
public class DuplicateRemoverClass implements DuplicateRemover {

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.DuplicateRemover#removeDuplicateStrings(java.lang.String[])
	 */
	@Override
	public String[] removeDuplicateStrings(String[] array) {
		Set<String> set = new LinkedHashSet<String> (Arrays.asList(array));
		return null;
	}

}
