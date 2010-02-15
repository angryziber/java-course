package net.azib.java.students.t050724;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author xom
 * @since 2010
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
		BigInteger fibonacci0 = BigInteger.ZERO;
		BigInteger fibonacci1 = BigInteger.ONE;
		
		for(int i = 3; i < countNumber + 2; i++)
		{
			BigInteger tempFibonacci = fibonacci0.add(fibonacci1);
			fibonacci0 = fibonacci1;
			fibonacci1 = tempFibonacci;
		}
		
		return fibonacci1;
		
	}
	
}
