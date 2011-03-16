package net.azib.java.students.t103784;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 16.03.11
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public class DupRemImpl implements DuplicateRemover {
	public static void main(String[] args) {
		String[] strings = {"one", "one", "zero", "one", "two", "three", "four", "two"};
		DupRemImpl dupRem = new DupRemImpl();
		System.out.println("Strings: " + Arrays.toString(strings));
        System.out.println("After removing: " + Arrays.toString(dupRem.removeDuplicateStrings(strings)));

	}

	public String[] removeDuplicateStrings(String[] array) {
		Set<String> strings = new LinkedHashSet<String>(Arrays.asList(array));
		return strings.toArray(new String[strings.size()]);
	}
}
