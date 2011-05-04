package net.azib.java.students.t092877.lecture4;

import net.azib.java.lessons.collections.DuplicateRemover;
import java.util.*;
import static java.util.Arrays.asList;

public class DuplicateRemoverImpl implements DuplicateRemover {

	@Override
	public String[] removeDuplicateStrings(String... array) {

		Set<String> set = new LinkedHashSet<String>(asList(array));
		return set.toArray(new String[set.size()]);
	}

	public static void main(String[] args) {

		String[] original = new String[] { "John", "David", "Kevin", "Charles", "John", "Kevin", "David" };
		DuplicateRemoverImpl dupremover = new DuplicateRemoverImpl();

		String[] duplicatesRemoved = dupremover.removeDuplicateStrings(original);

		System.out.println("Original data:");
		for (String element : original)
			System.out.print(" " + element);

		System.out.println("\nDuplicates removed:");
		for (String element : duplicatesRemoved)
			System.out.print(" " + element);

	}

}
