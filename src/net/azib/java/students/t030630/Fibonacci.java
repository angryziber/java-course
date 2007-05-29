package net.azib.java.students.t030630;

import java.math.BigInteger;

/**
 * Fibonacci
 * 
 * @author Kasutaja
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 0 1 1 2 3 5 8 new = prev1 + prev2
		BigInteger first = BigInteger.ZERO;
		BigInteger second = BigInteger.ONE;
		BigInteger third = BigInteger.ONE;
		BigInteger[] array = new BigInteger[98];
		// int third = first+second;
		for (int k = 0; k < 98; k++) {
			//BigInteger third = 
			third = second;
			second = second.add(first);
			first = third;
			//System.out.println(second);
			array[k] = second;
		}
		
		for(BigInteger i : array){
			System.out.println(i);
		}

	}

}
