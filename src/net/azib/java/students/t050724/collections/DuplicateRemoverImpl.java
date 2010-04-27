package net.azib.java.students.t050724.collections;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.HashSet;
//import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemoverImpl
 *
 * @author xom
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	@Override
	public String[] removeDuplicateStrings(String... array) {
		Set<String> set = new HashSet<String>(Arrays.asList(array));
		return set.toArray(new String[set.size()]);
	}

}
