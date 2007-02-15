package net.azib.java.students.t960644;

import java.math.BigInteger;

/**
 * Fibonacci3
 *
 * @author Lembit
 */
public class Fibonacci3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger[] ints = new BigInteger[100];
		ints[0] = new BigInteger("0");
		ints[1] = new BigInteger("1");
		for (int i=2;i<100;i++){
			ints[i]=ints[i-1].add(ints[i-2]);
		}
			System.out.println(ints[99]);
	}

}
