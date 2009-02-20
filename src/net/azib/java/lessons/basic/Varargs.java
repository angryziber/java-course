package net.azib.java.lessons.basic;

/**
 * Varargs
 *
 * @author anton
 */
public class Varargs {
	
	public static void printAll(Object ... params) {
		for (Object s : params) {
			System.out.println(s);
		}
	}
	
	public static void main(String ... args) {
		printAll("a", "b", "c");
		printAll(1, 2, 3);
	}
}
