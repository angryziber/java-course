package net.azib.java.students.t030721;

import net.azib.java.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemoverImp
 *
 * @author t030721
 */
public class DuplicateRemoverImp implements DuplicateRemover {

	/* (non-Javadoc)
	 * @see net.azib.java.collections.DuplicateRemover#removeDuplicateStrings(java.lang.String[])
	 */
	@Override
	public String[] removeDuplicateStrings(String[] array) {
		Set set = new LinkedHashSet(Arrays.asList(array));
		return null;
	}

}
