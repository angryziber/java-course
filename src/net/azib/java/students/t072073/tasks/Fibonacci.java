package net.azib.java.students.t072073.tasks;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author janika
 */
public class Fibonacci {

	public static void print(BigInteger number) {
		System.out.println(calculate(number));
	}
	
	public static BigInteger calculate(BigInteger number){
		BigInteger result = BigInteger.ZERO;
		BigInteger previous = BigInteger.ONE;
		while(number.compareTo(BigInteger.ZERO) == 1){
			BigInteger sum = result.add(previous);
			previous = result;
			result = sum;
			number=number.subtract(BigInteger.ONE);
		}
		return result;
	}
	
	public static void main(String[] args){
		print(BigInteger.valueOf(100));	
	}

}
