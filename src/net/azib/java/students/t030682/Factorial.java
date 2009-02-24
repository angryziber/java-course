package net.azib.java.students.t030682;

import java.math.BigInteger;

/**
 * factorial
 * 
 * @author t030682
 */
public class Factorial {
	
	public static void compute(int n) {
		BigInteger result;
		result = BigInteger.valueOf(1);
		for (int i = 1; i <= 100; ++i) {
			result = result.multiply(BigInteger.valueOf(i));
			System.out.println("100th element: " + result);
		}
	}
	
	public static void main(String[] args) {
		int number = 100;
		compute(number);
	}
}
