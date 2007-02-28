package net.azib.java.lessons.misc;

/**
 * Concatenator
 *
 * @author anton
 */
public class Concatenator {
	public String concatenate(String a, String b) {
		if (b == null)
			return a;
		if (a == null)
			return b;
		
		return a+b;
	}
}
