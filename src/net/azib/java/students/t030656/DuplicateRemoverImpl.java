package net.azib.java.students.t030656;

import net.azib.java.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemoverImpl
 *
 * @author t030656
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	/* (non-Javadoc)
	 * @see net.azib.java.collections.DuplicateRemover#removeDuplicateStrings(java.lang.String[])
	 */
	@Override
	public String[] removeDuplicateStrings(String[] array) {
		Set set = new LinkedHashSet(Arrays.asList(array));
		
		return (String[]) set.toArray(new String[set.size()]);
	}
	
	public static void main(String[] args) {
		
	}
}
