package net.azib.java.students.t072054.hometask1;

/**
 * Change
 * 
 * @author r_vassiljev
 */

public class Change {
	public static void main(String[] args) {
		String s = new String("blah");
		System.out.println(s);
	}
}

class String {
	java.lang.String s;

	public String(java.lang.String s) {
		this.s = s;
	}

	public java.lang.String toString() {
		return s;
	}
}