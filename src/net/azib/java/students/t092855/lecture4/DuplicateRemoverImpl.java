package net.azib.java.students.t092855.lecture4;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.HashSet;
import java.util.Set;

public class DuplicateRemoverImpl implements DuplicateRemover {
	public String[] removeDuplicateStrings(String ... array) {
		Set<String> s = new HashSet<String>();
		for(String a : array)
			s.add(a);

		return s.toArray(new String[s.size()]);
	};

}
