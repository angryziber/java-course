package net.azib.java.students.t104887.lecture4;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 3.04.11
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
public class DuplicateRemoverImpl implements DuplicateRemover{

	public String[] removeDuplicateStrings(String ... array) {
		List<String> list = Arrays.asList(array);
		Set<String> set = new LinkedHashSet<String>(list);
		List<String> clearedList = new ArrayList<String>(set);
		return clearedList.toArray(new String[clearedList.size()]);
	}
}
