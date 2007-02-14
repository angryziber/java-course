package net.azib.java.students.t011047;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author t011047
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		assert args.length == 1 : "Not enough command-line parameters given";
		
		// initialization
		BigInteger last = BigInteger.ZERO;
		BigInteger current = BigInteger.ONE; 
		BigInteger output;
		
		BigInteger[] fiboNumbers = new BigInteger[100];
		
		// calculation
		for(int i = 0; i < 100; i++)
		{
			output = last;
			last = current;
			current = output.add(current);
			
			fiboNumbers[i] = output;
			/*
			if(i == 99)
				System.out.println(output);
			*/

			/*
			System.out.print(i + ". ");
				System.out.println(output);
			*/
		}
		
		for(BigInteger fiboNumber : fiboNumbers)
		{
			System.out.println(fiboNumber);
		}
	}

}
