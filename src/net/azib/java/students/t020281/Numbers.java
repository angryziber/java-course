package net.azib.java.students.t020281;

import java.math.BigInteger;

/**
 * Numbers
 *
 * @author Trial
 */
public class Numbers {

	/**
	 * Prints the specified number to console
	 * @param n - number to print
	 * @deprecated Please use {@link System#out} instead
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
		
		i = i.add(BigInteger.ONE);
		System.out.println(i);
		
		System.out.println(a()&& b());
		
		System.out.println();
	
	}
	
}
