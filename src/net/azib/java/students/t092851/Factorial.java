package net.azib.java.students.t092851;
import java.math.BigInteger;

/**
 * Factorial
 *
 * @author t092851
 */
public class Factorial {
	
	public BigInteger getFactorial(int factorialOf) {
		return getFactorial(factorialOf, false);
	}
	
	public BigInteger getFactorial(int factorialOf, boolean printOut) {
		BigInteger bigInteger = new BigInteger("1");
		long i;
		
		for (i = 1; i <= factorialOf; i++)
		{
			bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
			if (printOut)
			{
				System.out.println(bigInteger);
			}
		}
		
		return bigInteger;
	}

}
