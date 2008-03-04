package net.azib.java.students.t030633.hometasks;

import net.azib.java.lessons.collections.DuplicateRemover;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemoverImpl
 * 
 * @author t030633
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.azib.java.lessons.collections.DuplicateRemover#removeDuplicateStrings(java.lang.String[])
	 */
	public String[] removeDuplicateStrings(String[] array) {

		// LinkedHashSet<String> coll = new LinkedHashSet<String>();
		// for (String i : array) {
		// coll.add(i);
		// }
		// return coll.toArray(new String[coll.size()]);

		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		return set.toArray(new String[set.size()]);

	}

}
