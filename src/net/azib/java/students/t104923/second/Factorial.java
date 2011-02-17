package net.azib.java.students.t104923.second;

import java.math.BigInteger;

public class Factorial {
	private static BigInteger a = new BigInteger("1");
	private static BigInteger b = new BigInteger("1");

    public static BigInteger getFactorialNumber(int number) {
	    for(int i = number; i > 1; i--){
             a = a.multiply(b = b.add(BigInteger.ONE));
	    }
         return a;
    }
}