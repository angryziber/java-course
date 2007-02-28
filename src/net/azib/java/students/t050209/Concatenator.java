package net.azib.java.students.t050209;

/**
 * Concatenator
 *
 * @author t050209
 */
public class Concatenator {
	public String concatenate(String a, String b) {
		if (b == null)
			return a;
		if (a == null)
			return b;
		return /*"Result: " + */a + b; /* -ea lisatud Run VM arguments all*/
	}
}
