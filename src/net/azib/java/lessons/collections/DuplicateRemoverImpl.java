package net.azib.java.lessons.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * DuplicateRemoverImpl
 *
 * @author anton
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	public String[] removeDuplicateStrings(String[] array) {
		Set set = new HashSet(Arrays.asList(array));
		return (String[]) set.toArray(new String[set.size()]);
	}

}
