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
		Collection lhs = new LinkedHashSet();
		
		for (String str : array) {
			lhs.add((Object)str);
		}

		String[] returnArray = new String[lhs.size()];
		int i = 0;
		for (Object object : lhs) {
			returnArray[i] = object.toString();
			i++;
		}
		
		return returnArray;
	}
}
