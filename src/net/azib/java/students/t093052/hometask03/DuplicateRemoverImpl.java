package net.azib.java.students.t093052.hometask03;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.Set;
import java.util.LinkedHashSet;

/**
 * DuplicateRemoverImpl
 *
 * @author Kostja
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	@Override
	public String[] removeDuplicateStrings(String... array) {
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		return set.toArray(new String[] {});
	}

}
