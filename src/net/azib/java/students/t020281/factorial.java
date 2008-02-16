package net.azib.java.students.t020281;

import java.math.BigInteger;

/**
 * factorial
 *
 * @author t020281
 */
public class factorial {
	
	// Number of elements to be calculated
	static final int NUM = 100;
	
	public static void main(String[] args) {
		// BigInteger initialization
		byte[] n = new byte[] {1} ;	
		BigInteger n1 = new BigInteger(n) ;
		BigInteger n2 = new BigInteger(n);
		BigInteger n3 = new BigInteger (n);
		// temporary value, used during swapping
		//Calculate n3*n2 and swap until NUM'th number appear
		for (int i = 1; i < NUM; i++) {
			//sum of BigIntegers
			n2 = n1.add(n2);
			n3 = n3.multiply(n2);
		} 
		System.out.println(NUM+"! factorial is "+n3);
	}
}
