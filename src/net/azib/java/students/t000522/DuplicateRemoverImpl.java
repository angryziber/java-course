package net.azib.java.students.t000522;

/**
 * DuplicateRemoverImpl
 *
 * @author jurrassic
 */

import net.azib.java.lessons.collections.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateRemoverImpl implements DuplicateRemover{
	
	public String[] removeDuplicateStrings(String[] array) {
		Set<String> unsortedcollection = new HashSet<String>(Arrays.asList(array));
		String[] finalarray = (String[])unsortedcollection.toArray(new String[unsortedcollection.size()]);	
		return finalarray;
	}

}
