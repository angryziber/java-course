package net.azib.java.students.t074918;

/**
 * Varargs
 *
 * @author Mart Mangus
 */
public class Varargs {
	
	public static void printAll(Object ... params) {
		for (Object s : params) {
			System.out.println(s);
		}
		
	}
	
	public static void main(String[] args) {
		printAll("a", "b", "f");
		printAll(); // Ka okei...
		printAll(1, 2, 3);
	}

}
