package net.azib.java.students.t000522;

import java.math.BigInteger;

/**
 *  
 * Class for calculation of Fibonacci number
 *
 * check it out {@link net.azib.java.students.t000522.Factorial}
 *
 * @author jurrassic
 * @since 2009
 * 
 */

public class Fibonacci {

	/**
	 * Compute fibonacci number with arbitrary precision
	 * @param index
	 * @return Fibonacci number with specified index
	 */
	
	public BigInteger compute(long index) {
		
		//holds current element value
		BigInteger fibonacciCurrent = new BigInteger("0");
		//holds previous element value
		BigInteger fibonacciPrevious = new BigInteger("0");
		
		if (index > 0) {
			fibonacciCurrent = fibonacciCurrent.ONE;
		}
		
		for (int i=2; i<=index; i++){
			fibonacciCurrent = fibonacciCurrent.add(fibonacciPrevious);
			fibonacciPrevious = fibonacciCurrent.subtract(fibonacciPrevious);
		}
		return fibonacciCurrent;
	}
	
	public static void main(String[] args) {
		System.out.println(new Fibonacci().compute(5L));
	}
}
