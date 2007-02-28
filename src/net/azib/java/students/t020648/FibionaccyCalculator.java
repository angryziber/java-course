package net.azib.java.students.t020648;

import java.math.BigInteger;

/**
 * FibionaccyCalculator
 *
 * @author t020648
 */
public class FibionaccyCalculator {
	
	public static void main (String [] args){
		printFibionacciNumber(100);
	}
	
	/**
	 * Prindib n-nda numbri
	 * @param number
	 */
	public static void printFibionacciNumber(int number){
		BigInteger fibionacciNumber = BigInteger.ZERO;
		BigInteger firstNumber = BigInteger.ONE;
		BigInteger secondNumber = BigInteger.ONE;
		
		for(int i = 0; i<number; i++){			
			fibionacciNumber = firstNumber;
			firstNumber = secondNumber;
			secondNumber = firstNumber.add(fibionacciNumber);
		}
		System.out.println("Fibionaccinumber: " + fibionacciNumber);
	}

}
