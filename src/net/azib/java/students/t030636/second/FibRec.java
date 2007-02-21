package net.azib.java.students.t030636.second;

import java.math.BigInteger;

/**
 * FibRec
 *
 * @author Martin
 */
public class FibRec {

	/**
	 * @param args
	 */
	private static BigInteger Fib(int n) {
		if(n <= 2)
			return BigInteger.ONE;
		else
		    return Fib(n - 2).add(Fib(n - 1));
		}
	
	
	public static void main(String[] args) {
		int n = 16;
		System.out.println(Fib(n));
	}

}
