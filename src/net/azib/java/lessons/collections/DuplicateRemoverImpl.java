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
		Set<String> uniqueStrings = new LinkedHashSet<String>(Arrays.asList(array));
		return uniqueStrings.toArray(new String[uniqueStrings.size()]);
	}
}
