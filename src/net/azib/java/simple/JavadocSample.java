package net.azib.java.simple;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Date;

/**
 * A class to show how to use <i>javadoc</i> in Java.
 *
 * @version 1.0
 * @author anton
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
		
		BigInteger[] ints = {BigInteger.ONE, BigInteger.ZERO};
		// old style
		for (int i = 0; i < ints.length; i++) {
			BigInteger i2 = ints[i];
			System.out.println(i2);
		}
		/*
		// new style
		for (BigInteger i : ints) {ll
			System.out.println(i);
		}*/
	}

}
