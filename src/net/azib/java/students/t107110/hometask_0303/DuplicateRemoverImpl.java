package net.azib.java.students.t107110.hometask_0303;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @author Eduard Shustrov
 */
public class DuplicateRemoverImpl implements DuplicateRemover {
	@Override
	public String[] removeDuplicateStrings(final String... array) {
		if (array == null) return null;

		final Collection<String> strings = new LinkedHashSet<String>(Arrays.asList(array));
		return strings.toArray(new String[strings.size()]);
	}
}
