package net.azib.java.lessons.basic;

import java.math.BigInteger;

/**
 * Class for calculation of <b>Fibonacci</b> numbers.
 *
 * @author anton
 */
public class Fibonacci {
	
	/**
	 * Computes Fibonacci numbers with arbitrary precision
	 * @param index 
	 * @return Fibonacci number with specified index (0-based)
	 */
	public BigInteger compute(int index) {
		BigInteger n = BigInteger.ZERO, n1 = n, n2 = n;
		
		if (index > 0)
			n = BigInteger.ONE;
		
		for (int i = 1; i < index; i++) {
			n2 = n1;
			n1 = n;
			n  = n1.add(n2);
		}
		
		return n;
	}
}
