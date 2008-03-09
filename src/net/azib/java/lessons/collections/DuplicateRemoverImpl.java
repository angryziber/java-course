package net.azib.java.lessons.collections;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemoverImpl
 *
 * @author anton
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	public String[] removeDuplicateStrings(String[] array) {
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		return set.toArray(new String[set.size()]);
	}

}
