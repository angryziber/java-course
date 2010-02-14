package net.azib.java.students.t092858;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author qwert
 */
public class Fibonacci {

	static BigInteger calculate(int SequenceLenght){
	BigInteger FibonacciNumber1 = new BigInteger("1");
	BigInteger FibonacciNumber2 = new BigInteger("0");
	
	if (SequenceLenght < 1){
		return FibonacciNumber2;
	}
	
	for(int i = 0; i < SequenceLenght-2; i++)
	{
		if (i%2 == 1){
			FibonacciNumber1 = FibonacciNumber1.add(FibonacciNumber2);
		}
		else{
			FibonacciNumber2 = FibonacciNumber1.add(FibonacciNumber2);
		}		
	}
	
	return FibonacciNumber2 = FibonacciNumber1.add(FibonacciNumber2);
	
	}
	
}