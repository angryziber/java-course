package net.azib.java.students.t020544;

/**
 * Concatenator
 * 
 * @author Julija Kondratjeva
 */
public class Concatenator {

	public String concatenate(String a, String b) {
		if (b == null)
			return a;

		if (a == null)
			return b;

		return a + b;
	}

}
