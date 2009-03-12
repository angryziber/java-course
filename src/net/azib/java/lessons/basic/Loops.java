package net.azib.java.lessons.basic;

/**
 * Loops
 *
 * @author anton
 */
public class Loops {
	public static void main(String[] args) {
		String[] s = {"a", "b", "c"};
		
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		
		for (String string : s) {
			System.out.println(string);
		}
	}
}
