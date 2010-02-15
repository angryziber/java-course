package net.azib.java.students.t092859;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author Konstantin
 */
public class Fibonacci {
	
	BigInteger getFibNum (int seqNum){
		BigInteger numberA = BigInteger.ZERO;
		BigInteger numberB = BigInteger.ONE;
		BigInteger numberTemp;
		int i;
		
		for(i = 2 ; i <= seqNum; i++)
		{
			numberTemp = numberA.add(numberB);
			numberA = numberB;
			numberB = numberTemp;
		}

		if(seqNum == 0)
			return BigInteger.ZERO;
		return numberB;
	}
	
}
