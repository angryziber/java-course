package net.azib.java.students.t092861.lecture4;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.LinkedHashSet;

import net.azib.java.lessons.collections.DuplicateRemover;

/**
 * @author Stanislav / 092861
 * 
 */
public class DuplicateRemoverImpl implements DuplicateRemover {
	String[] arrayOne;

	@Override
	public String[] removeDuplicateStrings(String... array) {
		// this.arrayOne = array;
		HashSet<String> set = new LinkedHashSet<String>(asList(array));
		arrayOne = (String[]) (set.toArray(new String[set.size()]));
		return arrayOne;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] array = new String[] { "C", "C", "B", "A", "A", "D", "F", "F",	"G", "A" };
		DuplicateRemoverImpl dri = new DuplicateRemoverImpl();
		System.out.print("before: ");
		dri.printArray(array);
		String[] arrayAfter = dri.removeDuplicateStrings(array);
		System.out.print("\nafter: ");
		dri.printArray(arrayAfter);
	}

	public void printArray(String[] array) {
		for (String elem : array) {
			System.out.print(elem + " ");
		}
	}

}
