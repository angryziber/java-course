package net.azib.java.students.t654321;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemoverImpl
 *
 * @author t999902
 */
public class DuplicateRemoverImpl implements DuplicateRemover{

	public String[] removeDuplicateStrings(String[] array) {
//		Before: Set set = new LinkedHashSet(Arrays.asList(array));
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
//		Before: return (String []) set.toArray(new String[set.size()]);		
		return set.toArray(new String[set.size()]);
	}
	
}
