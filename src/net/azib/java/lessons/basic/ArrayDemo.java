package net.azib.java.lessons.basic;

import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args) {
		String[] s = {"a", "b", "c"};
		s = new String[] {"a", "b", "c"};
		s = new String[3];
		System.out.println(s[0] + " " + s.length);

		int[] a = {1, 2, 3};
		int[] b = new int[a.length + 1];
		System.arraycopy(a, 0, b, 0, a.length);
		System.out.println(Arrays.toString(b));

		for (int element : b) {
			System.out.print(element + " ");
		}
		System.out.println();

		System.out.println(a instanceof Object);
		System.out.println(s instanceof Object);
		System.out.println(s instanceof String[]);
		System.out.println(s instanceof Object[]);
	}
}
