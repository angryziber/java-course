package net.azib.java.students.t970880;

import java.math.BigInteger;

/**
 * fibonach
 * 
 * @author vvj
 */
public class fibonach {
	public static void main(String[] args) {
		BigInteger bi1 = new BigInteger("0");
		BigInteger bi2 = new BigInteger("1");
		for (int i = 2; i < 51; i++) {
			bi1 = bi1.add(bi2);
			bi2 = bi2.add(bi1);
			System.out.println("F" + (i * 2 - 1) + " = " + bi1);
			System.out.println("F" + (i * 2) + " = " + bi2);
		}
	}

}
