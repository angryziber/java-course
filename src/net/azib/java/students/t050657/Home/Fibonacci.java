package net.azib.java.students.t050657.Home;

import java.math.BigInteger;


/**
 * Fibonacci
 * @author t050657
 *
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BigInteger[] sum = new BigInteger[100];
		sum[0] = BigInteger.ZERO;
		sum[1] = BigInteger.ONE;
		
		for(int i = 2; i<100; i++) {
			sum[i] = sum[i-1].add(sum[i-2]);
		}
		System.out.println(sum[99]);
	}

}
