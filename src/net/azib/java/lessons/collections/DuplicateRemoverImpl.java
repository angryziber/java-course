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

	@Override
	public String[] removeDuplicateStrings(String[] array) {
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		return set.toArray(new String[0]);
	}

}
