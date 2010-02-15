package net.azib.java.students.t050724;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author xom
 */
public class Factorial {
	
	BigInteger calculateFactorial(int countNumber)
	{
		BigInteger tempFactorial = BigInteger.ONE;
		
		if (countNumber == 0)
			return BigInteger.ONE;
		else

			for (int i = 1; i < countNumber + 1	; i++)
			{			
				tempFactorial = tempFactorial.multiply(BigInteger.valueOf(i));			
			}
		
			return tempFactorial;
	}
	
	
	

}
