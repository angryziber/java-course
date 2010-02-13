package net.azib.java.students.t050731;
import java.math.BigInteger;

public class Fibonacci 
{
	//----------------------------------------------------------------
	// IN: 			0-based index, integer
	// OUT: 		BigInteger result
	// FUNCTION:	Calculates the fibonacci value, based on its index
	//----------------------------------------------------------------
	public BigInteger calcFibonacci(int index) 
	{		
		BigInteger fibNr1 = BigInteger.ZERO;
		BigInteger fibNr2 = BigInteger.ONE;		
		BigInteger fibSum = BigInteger.ZERO;
		
		switch(index)
		{
		case 0:
			return fibNr1;
		case 1:
		case 2:
			return fibNr2;			
		}
		
		for(int i = 2; i <= index; i++) 
		{
			fibSum = fibNr1.add(fibNr2);
			fibNr1 = fibNr2;
			fibNr2 = fibSum;
		}
		return fibSum;
	}
}
