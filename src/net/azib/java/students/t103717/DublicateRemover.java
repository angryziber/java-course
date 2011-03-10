package net.azib.java.students.t103717;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * User: ruzard
 * Malyshev Konstantin 103717IAPB28
 * Date: 10.03.11
 */
public class DublicateRemover {
	public static void main(String[] args) {
		String[] firstArray = {"three", "two", "one", "six", "seven", "five", "black", "dragons", "iddqd", "iddqd", "idkfa", "six"};
		String[] secondArray = removeDub(firstArray);
		System.out.print(Arrays.toString(secondArray));
	}


	private static String[] removeDub(String[] gotarray) {
		Collection<String> remover = new LinkedHashSet<String>();
		remover.addAll(Arrays.asList(gotarray));
		String[] withoutDubs = new String[remover.size()];
		remover.toArray(withoutDubs);
		return withoutDubs;
	}
}