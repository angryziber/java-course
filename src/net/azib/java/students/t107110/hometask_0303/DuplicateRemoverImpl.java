package net.azib.java.students.t107110.hometask_0303;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

public class DuplicateRemoverImpl implements DuplicateRemover {
	/**
	 * Removes all duplicate elements from an array of Strings.
	 *
	 * @param array an array of Strings
	 * @return an array of Strings, where each String appears only once.
	 *         The Strings have the same order as in the source array.
	 */
	@Override
	public String[] removeDuplicateStrings(final String... array) {
		final Collection<String> strings = new LinkedHashSet<String>(Arrays.asList(array));
		return strings.toArray(new String[strings.size()]);
	}

	public static void main(final String[] args) {
		final DuplicateRemover duplicateRemover = new DuplicateRemoverImpl();
		for (final String string : duplicateRemover.removeDuplicateStrings("1", "2", "3", "2", "4", "3", "1")) {
			System.out.println(string);
		}
	}
}
