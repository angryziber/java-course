package net.azib.java.students.t030675;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemoverClass
 *
 * @author t030675
 */
public class DuplicateRemoverImp implements DuplicateRemover{
	public String[] removeDuplicateStrings(String[] array) {
		
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
	
		return set.toArray(new String[set.size()]);
	}
}
