package net.azib.java.students.t073639.taskSetAndMap;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * DuplicateRemoverImpl
 * 
 * @author t073639
 */
public class DuplicateRemoverImpl implements DuplicateRemover {
	public static void main(String[] args) {
		DuplicateRemoverImpl dri = new DuplicateRemoverImpl();
		dri.outPrint();
	}

	private void outPrint() {
		String[] str = { "String", "array", "array", "which", "contains", "duplicates", "duplicates", "duplicates" };
		for (String string : removeDuplicateStrings(str)) {
			System.out.println(string);
		}
	}

	@Override
	public String[] removeDuplicateStrings(String... array) {
		LinkedHashSet<String> lhs = new LinkedHashSet<String>(Arrays.asList(array));
		return Arrays.copyOf(lhs.toArray(), lhs.toArray().length, String[].class);
	}

}
