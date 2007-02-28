package net.azib.java.students.t050657;

/**
 * Concatenator
 *
 * @author t050657
 */
public class Concatenator {
	
	public String concat(String a, String b) {
		if(b == null)
			return a;
		if(a == null)
			return b;
		return a + b;
	}
	
	
}
