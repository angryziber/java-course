package net.azib.java.students.t050657;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author t050657
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BigInteger[] fib = new BigInteger[100];
		fib[0] = BigInteger.ZERO;
		fib[1] = BigInteger.ONE;

		//assert !fib[0].equals(0): "fib[0] == 0!!!";
		
		for(int i = 0; i<98; i++) {
			fib[i+2] = fib[i].add(fib[i+1]);
			System.out.println(i + ": " + fib[i]);
		}
		System.out.println(fib[99]);
		
		int i = 12;
		System.out.printf("%d", i);
		System.out.println("");

		printed(1, true, "a", "b", "c");
	}
	
	public static void printed(int a, boolean b, String ... str) {
		for( String strx : str ) {
			System.out.println(strx);
		}
	}

}
