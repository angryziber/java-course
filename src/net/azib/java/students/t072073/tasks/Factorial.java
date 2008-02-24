package net.azib.java.students.t072073.tasks;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author t072073
 */
public class Factorial {
	static int LAST_VALUE = 100;
	private static BigInteger factorial = BigInteger.ONE;
	
	public static void main(String[] args) {
		for (int i = 2; i <= LAST_VALUE; i++) {			
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		System.out.println(LAST_VALUE + "th factorial number is " + factorial);
	}

}
