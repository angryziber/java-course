package net.azib.java.students.t092859.hometask2;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author Konstantin
 */
public class Factorial {
	
	BigInteger getFactNum (int seqNum){
		BigInteger result = BigInteger.ONE;
		int i;
		
		for(i = 1 ; i <= seqNum; i++)
			result = result.multiply(BigInteger.valueOf(i));

		return result;
	}
}
