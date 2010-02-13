package net.azib.java.students.t050731;
import java.math.BigInteger;

public class Factorial
{
	//----------------------------------------------------------------
	//IN: 		Integer value
	//OUT: 		BigInteger factorial
	//FUNCTION:	Calculates the factorial value of input 
	//----------------------------------------------------------------
	public BigInteger calcFactorial(int n) 
	{		
		BigInteger factSum = BigInteger.ONE;
		
		for(int i = 1; i <= n; i++) 
		{
			factSum = factSum.multiply(BigInteger.valueOf(i));
		}
		return factSum;
	}
}