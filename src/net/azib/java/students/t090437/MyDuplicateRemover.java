package net.azib.java.students.t090437;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * MyDuplicateRemover
 *
 * @author Ronald
 */
public class MyDuplicateRemover implements DuplicateRemover {

	public String[] removeDuplicateStrings(String[] array) {
		LinkedHashSet lhs = new LinkedHashSet();
		lhs.addAll(Arrays.asList(array));
		return (String[]) lhs.toArray(new String[0]);	
	}
	
	public static void main(String[] args) {
		MyDuplicateRemover myRemover = new MyDuplicateRemover();
		String[] test1 = new String[]{"a", "b", "a", "c", "d", "b"};
		String[] test2 = myRemover.removeDuplicateStrings(test1);
		
		for(String a : test2) {
			System.out.println(a);
		}
	}
}
