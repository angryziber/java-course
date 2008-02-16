package net.azib.java.students.t020281;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * fibonacci
 *
 * @author t020281
 */
public class fibonacci {
	// Number of elements to be calculated
	static final int NUM = 100;
		
		public static void main(String[] args) {
			// BigInteger initialization
			byte[] n = new byte[] {1} ;	
			BigInteger n1 = new BigInteger(n) ;
			BigInteger n2 = new BigInteger(n);
			// temporary value, used during swapping
			BigInteger temp;
			//Calculate n1 + n2 until NUM'th number appear
			for (int i = 0; i < NUM-2; i++) {
				temp = n2;
				//sum of BigIntegers
				n2 = n1.add(n2);
				n1 = temp;			
			} 
			System.out.println(NUM+"th fibonacci number is "+n2);
	}
}
