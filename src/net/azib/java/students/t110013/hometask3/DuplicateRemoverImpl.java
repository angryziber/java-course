package net.azib.java.students.t110013.hometask3;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Vadim
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	public String[] removeDuplicateStrings(String... array) {
		if (array == null)
			return null;

		Set<String> c = new LinkedHashSet<String>(Arrays.asList(array));
		return c.toArray(new String[c.size()]);
	}
}
