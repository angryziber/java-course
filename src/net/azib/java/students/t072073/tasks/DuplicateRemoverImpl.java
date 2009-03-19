package net.azib.java.students.t072073.tasks;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * DuplicateRemoverImpl
 *
 * @author janika
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	public String[] removeDuplicateStrings(String ... array) {
		return new LinkedHashSet<String>(Arrays.asList(array)).toArray(new String[0]);
	}

}
