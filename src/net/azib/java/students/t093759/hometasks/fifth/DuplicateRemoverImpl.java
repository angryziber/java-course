package net.azib.java.students.t093759.hometasks.fifth;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author dionis
 *         23.03.11 13:17
 */
public class DuplicateRemoverImpl implements DuplicateRemover {
	@Override
	public String[] removeDuplicateStrings(String... array) {
		Set<String> noDuplicates = new LinkedHashSet<String>(Arrays.asList(array));
		return noDuplicates.toArray(new String[noDuplicates.size()]);
	}
}
