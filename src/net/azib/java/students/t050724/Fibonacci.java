package net.azib.java.students.t050724;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author xom
 */
public class Fibonacci {

	BigInteger calculateFibonacci(int countNumber)
	{
		BigInteger zeroFibonacci = BigInteger.ZERO, oneFibonacci = BigInteger.ONE;
		
		//Just to practice switchcase
		switch (countNumber) {
		case 1: return zeroFibonacci;
		case 2: return oneFibonacci;
		default: return getNthFibonacci(countNumber);
		}
	}
	
	private BigInteger getNthFibonacci(int countNumber)
	{
		BigInteger tempFibonacci0 = BigInteger.ZERO;
		BigInteger tempFibonacci1 = BigInteger.ONE;
		
		for(int i = 3; i < countNumber + 2; i++)
		{
			BigInteger tempFibonacci = tempFibonacci0.add(tempFibonacci1);
			tempFibonacci0 = tempFibonacci1;
			tempFibonacci1 = tempFibonacci;
		}
		
		return tempFibonacci1;
		
	}
	
}
