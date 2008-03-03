package net.azib.java.students.t030629.hometasks.ht3;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * An implementation for an interface for a task in the 4th lesson for practicing with Set.
 *
 * @author anton_chepurov
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	public String[] removeDuplicateStrings(String[] array) {
		Set<String> set = new LinkedHashSet<String>(array.length);
		
		for (String element : array){
			set.add(element);
		}
		
		return set.toArray(new String[set.size()]);
	}

	public static void main(String... args) {
		String[] arrayWithDuplicates = {
				"abc",
				"more abc",
				"abc",
				"123",
				"11111",
				"qwer",
				"qwer",
				"321",
				"123"
		};
		
		String[] arrayWithoutDuplicates = new DuplicateRemoverImpl().removeDuplicateStrings(arrayWithDuplicates);
		
		for (String element : arrayWithoutDuplicates) {
			System.out.println(element);
		}
	}

}
