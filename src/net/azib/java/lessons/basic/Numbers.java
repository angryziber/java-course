package net.azib.java.lessons.basic;

import java.math.BigInteger;

/**
 * Test class for learning numbers in Java
 *
 * @author anton
 */
public class Numbers {
	
	/**
	 * Prints the specified number to the console
	 * @param n 
	 * @deprecated please use {@link System#out} instead
	 */
	static void printNumber(Number n) {
		System.out.println(n);
	}
	
	static boolean a() {
		System.out.println("a");
		return false;
	}
	
	static boolean b() {
		System.out.println("b");
		return true;
	}
	
	public static void main(String[] args) {
		BigInteger i = BigInteger.ZERO;
		if (i != null && i.equals(BigInteger.ONE)) {
			i = i.add(BigInteger.ONE);
		}
		printNumber(i);
		
		System.out.println(a() && b());
		System.out.println(5 < 7 ? "Hello" : "something");
		System.out.println(i instanceof Number);
		
	}
}
