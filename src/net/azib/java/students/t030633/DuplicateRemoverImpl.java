package net.azib.java.students.t030633;

import net.azib.java.lessons.collections.DuplicateRemover;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * DuplicateRemoverImpl
 * 
 * @author t030633
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.azib.java.lessons.collections.DuplicateRemover#removeDuplicateStrings(java.lang.String[])
	 */
	public String[] removeDuplicateStrings(String[] array) {

		// LinkedHashSet<String> coll = new LinkedHashSet<String>();
		// for (String i : array) {
		// coll.add(i);
		// }
		// return coll.toArray(new String[coll.size()]);

		LinkedHashSet<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		return set.toArray(new String[set.size()]);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DuplicateRemoverImpl dupRem = new DuplicateRemoverImpl();
		String[] strings = new String[] { "pong", "ping", "ping", "ping", "pong" };

		System.out.println(Arrays.toString(strings));
		System.out.println(Arrays.toString(dupRem.removeDuplicateStrings(strings)));		

	}

}
