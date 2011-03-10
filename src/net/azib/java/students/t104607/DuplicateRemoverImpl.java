package net.azib.java.students.t104607;
// @author 104607 IASM

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

public class DuplicateRemoverImpl implements DuplicateRemover {
	public String[] removeDuplicateStrings(String... array) {
		Collection<String> set;
		set = new LinkedHashSet<String>(Arrays.asList(array));
		return set.toArray(new String[set.size()]);
	}
}
