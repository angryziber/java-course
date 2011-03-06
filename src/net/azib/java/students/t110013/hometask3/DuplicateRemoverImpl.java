package net.azib.java.students.t110013.hometask3;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Vadim
 * Date: 6.03.11
 * Time: 12:20
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	public String[] removeDuplicateStrings(String... array) {
		Set<String> c = new LinkedHashSet<String>(Arrays.asList(array));
		return c.toArray(new String[c.size()]);
	}
}
