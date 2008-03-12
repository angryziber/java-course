package net.azib.java.students.t980814.lec1;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author allan
 */
public class Fibonacci {

	BigInteger fibonacciNumber;
	BigInteger prevNumber;
	int fibonacciCount;
	
	/**
	 * Constructor, that calculates the fibonacci number
	 * @param n
	 */
	public Fibonacci(int n) {
		reCalculate(n);
	}
	
	/**
	 * Calculates the new value for fibonacci number
	 * @param n
	 */
	public void reCalculate(int n) {
		BigInteger nextPrevNumber = new BigInteger("1");
		prevNumber = BigInteger.ZERO;
		
		fibonacciNumber = prevNumber;
		fibonacciCount = n;
		for (int count = 0; count <= n; count++) {
			fibonacciNumber = fibonacciNumber.add(prevNumber);
			prevNumber = nextPrevNumber;
			nextPrevNumber = fibonacciNumber;
			// System.out.println("Result=" + fibonacciNumber + ", prev=" + prevNumber + ", nextPrev=" + nextPrevNumber);
		}
	}
	
	/**
	 * Calculates the next fibonacci number
	 */
	public void calcNext() {
		BigInteger nextPrevNumber = fibonacciNumber;
		fibonacciNumber = fibonacciNumber.add(prevNumber);
		prevNumber = nextPrevNumber;
		fibonacciCount++;
	}
	
    /**
     * Calculates the previous fibonacci number 
     */
	public void calcPrev() {
		if (fibonacciCount > 0) {
			BigInteger prevPrevNumber = fibonacciNumber.subtract(prevNumber);
			fibonacciNumber = prevNumber;
			prevNumber = prevPrevNumber;
			fibonacciCount--;
		}
	}
	
	/**
	 * Returns the calculated fibonacci number
	 * @return
	 */
	public BigInteger getResult() {
		return fibonacciNumber;
	}
	
	/**
	 * Returns the counter that represents the calculated fibonacci number
	 * @return
	 */
	public int getCounter() {
		return fibonacciCount;
	}
	
/*	public static void main(String[] args) {
		Fibonacci f = new Fibonacci(21);
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
	}
*/	
}
