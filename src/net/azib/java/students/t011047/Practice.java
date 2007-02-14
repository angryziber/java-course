package net.azib.java.students.t011047;

import java.io.PrintStream;

/**
 * A class to <b>show</b> <u>how</u> to use <i>JavaDoc</i> in Java.
 *
 * @author t011047
 * @version 0.1
 */
public class Practice {
	
	static int b = 100;

	/**
	 * Entry point to our program
	 * @param args command-line arguments
	 */
	public static void main(String ... args) {
		final int hello = 7;
		System.out.println(hello);
		System.out.println(Practice.b);
		
		System.out.printf("Printf: %d", hello);
		
		System.out.println();
		displayHello("Test");
	}
	
	/**
	 * Displays hello to the user
	 * @param name user's name
	 * @deprecated please use {@link System#out} method {@link PrintStream#println()} directly
	 */
	private static void displayHello(String name) {
		System.out.println("Hello, " + name + "!");
	}

}
