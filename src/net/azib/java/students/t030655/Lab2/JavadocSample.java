package net.azib.java.students.t030655.Lab2;

import java.util.Date;

/**
 * JavadocSample - 
 * A class to show how to use <i>javadoc</i> in Java.
 * @author t030655
 */
public class JavadocSample {
	/**
	 * Displays hello to the user
	 * @param name user's name
	 * @deprecated please use {@link System#out} method {@link PrintStream#println()} directly
	 */
	private static void displayHello(String name) {
		System.out.println("Hello, " + name + "!");
	}

	/**
	 * The entry point to our program
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		displayHello("Myself");

	}

}
