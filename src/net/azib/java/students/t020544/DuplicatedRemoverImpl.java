package net.azib.java.students.t020544;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicatedRemoverImpl
 *
 * @author Julija Kondratjeva
 */
public class DuplicatedRemoverImpl implements DuplicateRemover {

	/* (non-Javadoc)
	 * @see net.azib.java.collections.DuplicateRemover#removeDuplicateStrings(java.lang.String[])
	 */
	public String[] removeDuplicateStrings(String[] array) {
		
		//List<String> c =new ArrayList
		
		Set set = new LinkedHashSet(Arrays.asList(array));
		return (String[]) set.toArray(new String[set.size()]);
	}

}
