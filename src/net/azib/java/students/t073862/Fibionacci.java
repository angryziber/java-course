package net.azib.java.students.t073862;

import java.math.BigInteger;

/**
 * Fibionacci
 *
 * @author Pets
 */
public class Fibionacci {
	/**
	 * Calculates Fibionacci number to the n-th
	 * @param n
	 * @return
	 */
	public BigInteger calculateFibionacci(int n) {
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		BigInteger sum = BigInteger.ZERO;
		
		switch(n) {
			case 0:
				return a;
			case 1:
			case 2: 
				return b;
		}
		
		for(int i = 2; i <= n; i++) {
			sum = a.add(b);
			a = b;
			b = sum;
		}
		return sum;
	}
}
