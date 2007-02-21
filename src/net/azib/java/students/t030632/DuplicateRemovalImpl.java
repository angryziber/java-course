package net.azib.java.students.t030632;

import net.azib.java.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemovalImpl
 *
 * @author Toni
 */
public class DuplicateRemovalImpl implements DuplicateRemover {

	/**
	 * @param args
	 */
	

	/* (non-Javadoc)
	 * @see net.azib.java.collections.DuplicateRemover#removeDuplicateStrings(java.lang.String[])
	 */
	public String[] removeDuplicateStrings(String[] array) {
		Set set = new LinkedHashSet(/*Arrays.asList(array)*/);
		for(String s: array){
			set.add(s);
		}
		int i = set.size();
		String []strings = new String[i];
		i=0;
		for(Object o : set){
			strings[i]= o.toString();
			i++;
		}
//		strings = (String[])set.toArray();
		return strings;
	}

}
