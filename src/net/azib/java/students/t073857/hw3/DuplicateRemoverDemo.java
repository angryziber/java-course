package net.azib.java.students.t073857.hw3;

/**
 * DuplicateRemoverDemo
 *
 * @author Joonas Vali
 */
public class DuplicateRemoverDemo {
	public static void main(String[] args) {
		String[] s = {"oo", "aaa", "bbb", "ccc", "aaa", "fff", "ggg", "ggg", "aaa", "bbb"};
		s = new DuplicateRemoverImpl().removeDuplicateStrings(s);
		for (String string : s) {
			System.out.println(string);
		}
	}
}
