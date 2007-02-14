package net.azib.java.students.t030655.Lab2;

import java.math.BigInteger;

/**
 * Fibonacci2
 *
 * @author t030655
 */
public class Fibonacci2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BigInteger[] k = new BigInteger[101];
		BigInteger k0 = new BigInteger("0");
		BigInteger k1 = new BigInteger("1");
		for (int i=2; i<=100; i++){
			k[i] = k0.add(k1);
			k0 = k1;
			k1 = k[i];
		}
		for (BigInteger value :  k)
			System.out.println(value);

	}

}