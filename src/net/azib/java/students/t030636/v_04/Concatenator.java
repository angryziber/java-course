package net.azib.java.students.t030636.v_04;

/**
 * Concatenator
 *
 * @author Martin
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
