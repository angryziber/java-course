package net.azib.java.students.t040771.hometasks.hometask3;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * DuplicateRemoverImpl
 *
 * @author raido
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	public String[] removeDuplicateStrings(String[] array) {
		LinkedHashSet<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		return set.toArray(new String[set.size()]);
	}

	public static void main(String[] args) {
		DuplicateRemoverImpl dupImp = new DuplicateRemoverImpl();
		String text = "hello world hello world goodbye hello world"; //No commas to write
		System.out.println(text);
		String stringArray[] = text.split("\\s");
		
		stringArray = dupImp.removeDuplicateStrings(stringArray);
		
		for(String s: stringArray) System.out.print(s + " ");
		System.out.println();
	}
}
