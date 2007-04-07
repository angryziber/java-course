package net.azib.java.students.t050657.Class;

import java.io.PrintStream;

/**
 * JavaDocTest to show how <i>javadoc</i> works
 * @version 1.0
 * @author t050657
 */
public class JavaDocTest {

	/**
	 * Entry point to our programm 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		displayHello("Boriss");
		numWhilePrint(10);
		System.out.println("---------------");
		numDoWhilePrint(0);
	}
	
	/**
	 * Displays Hello to user
	 * @param name user's name
	 * @deprecated please use {@link System#out} method {@link PrintStream#println} directly
	 */
	private static void displayHello(String name) {
		System.out.println("Hello, " + name);
	}
	
	private static void numWhilePrint(int n) {
		int i = 1;
		while(i<=n) {
			System.out.println(i++);
			//i++;
		}
	}
	
	private static void numDoWhilePrint(int n) {
		int i = 1;
		do {
			System.out.println(i++);
		}
		while (i<=n);
		
			
	}
}
