package net.azib.java.students.t040750.homework.lesson3;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * DuplicateRemoverImpl
 *
 * @author karpo
 */
public class DuplicateRemoverImpl implements DuplicateRemover{

	public String[] removeDuplicateStrings(String[] array) {
		Collection<String> c = new LinkedHashSet<String>();
		
		for(String str:array)
		{
			c.add(str);
		}
			
		return (String[])c.toArray();
	}

}
