package net.azib.java.students.t072073.tasks;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author janika
 */
public class Factorial {

	public static void print(BigInteger number){
		System.out.println(calculate(number));
	}
	
	public static BigInteger calculate(BigInteger number) {
		BigInteger result = BigInteger.ONE;
		while(number.compareTo(BigInteger.ONE) == 1){
			result = result.multiply(number);
			number = number.subtract(BigInteger.ONE);
		}
		return result;
	}
	
	public static void main(String[] args) {
		print(BigInteger.valueOf(100));
	}

}
