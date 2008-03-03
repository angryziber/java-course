package net.azib.java.students.t040750.hometasks.lesson3;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DuplicateRemoverImpl
 *
 * @author karpo
 */
public class DuplicateRemoverImpl implements DuplicateRemover{

	public String[] removeDuplicateStrings(String[] array) {
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		
		return (String[])set.toArray(new String[set.size()]);
	}
	
	

}
