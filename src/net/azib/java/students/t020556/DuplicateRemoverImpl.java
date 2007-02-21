package net.azib.java.students.t020556;

import net.azib.java.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 * DuplicateRemoverImpl implements DuplicateRemover
 *
 * @author t020556
 * 
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	/**
	 * @param array
	 * 
	 */

	@Override
	public String[] removeDuplicateStrings(String[] array) {
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		return set.toArray(new String[set.size()]);
	}

}
