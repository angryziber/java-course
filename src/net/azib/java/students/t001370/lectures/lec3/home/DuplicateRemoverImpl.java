package net.azib.java.students.t001370.lectures.lec3.home;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * DuplicateRemoverImpl
 *
 * @author maksim
 */
public class DuplicateRemoverImpl implements DuplicateRemover{
	
	public String[] removeDuplicateStrings(String[] array) {
		Collection<String> lhs = new LinkedHashSet<String>();
		
		for (String str : array) {
			lhs.add(str);
		}

		return lhs.toArray(new String[lhs.size()]);
	}
}
