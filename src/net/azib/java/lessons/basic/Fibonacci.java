package net.azib.java.lessons.basic;

import java.math.BigInteger;

/**
 * Class for calculation of <b>Fibonacci</b> numbers.
 *
 * @author anton
 * @since 2009
 */
public class Fibonacci {
	
	/**
	 * @deprecated please use {@link #compute(long)} instead
	 */
	public int compute(int index) {
		return 0;
	}
	
	/**
	 * Computes Fibonacci numbers with arbitrary precision
	 * @param index 
	 * @return Fibonacci number with specified index
	 */
	public BigInteger compute(long index) {
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
	
	public static void main(String[] args) {
		System.out.println(new Fibonacci().compute(100L));
	}
	
}
