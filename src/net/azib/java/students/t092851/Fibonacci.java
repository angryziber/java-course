package net.azib.java.students.t092851;
import java.math.BigInteger;


/**
 * Fibonacci numbers calculation
 *
 * @author t092851
 */
public class Fibonacci {

	public BigInteger getFibonacci(int numbers) {
		return getFibonacci(numbers, false);
	}

	public BigInteger getFibonacci(int numbers, boolean printOut) {
		BigInteger [] bigIntegers = { null, new BigInteger("1"), new BigInteger("0") };
		int i;
		
		if (printOut == true && numbers > 0)
			System.out.println(0); // First number
		
		for (i = 0; i < numbers - 1; i++) {
			
			bigIntegers[i % 3] = BigInteger.ZERO;
			bigIntegers[i % 3] = bigIntegers[i % 3].add(bigIntegers[(i + 1) % 3]);
			bigIntegers[i % 3] = bigIntegers[i % 3].add(bigIntegers[(i + 2) % 3]);
			
			if (printOut)
				System.out.println(bigIntegers[i % 3]);
		}
		
		if (numbers < 2)
			return BigInteger.ZERO;
		
		if (numbers < 4)
			return BigInteger.ONE;
		
		return bigIntegers[(i - 1) % 3];
	}
	
}
