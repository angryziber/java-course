package net.azib.java.students.t030655.Lab2ja4;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author t030655
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger k0 = new BigInteger("0");
		BigInteger k1 = new BigInteger("1");
		for (int i=2; i<=101; i++){
			BigInteger k = k0.add(k1);
			k0 = k1;
			k1 = k;
			if (i == 100)
				System.out.println(k);
		}

	}

}
