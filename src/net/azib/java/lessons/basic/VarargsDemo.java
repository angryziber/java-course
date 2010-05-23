package net.azib.java.lessons.basic;

import static java.lang.System.out;

/**
 * VarargsDemo
 *
 * @author anton
 */
public class VarargsDemo {
	
	public static void main(String ... args) {
		printAll(args);
		printAll("a", "b", "c", "d");
	}

	private static void printAll(String ... strings) {
		for (String string : strings) {
			out.println(string);
		}
	}
}
