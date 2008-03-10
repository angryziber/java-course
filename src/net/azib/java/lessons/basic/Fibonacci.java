package net.azib.java.lessons.basic;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author anton
 */
public class Fibonacci {
	
	public BigInteger compute(int index) {
		if (index < 0)
			throw new IllegalArgumentException("index must be positive");
		
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
