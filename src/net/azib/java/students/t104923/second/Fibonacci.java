package net.azib.java.students.t104923.second;

import java.math.BigInteger;

public class Fibonacci {
    private static BigInteger a = new BigInteger("0");
    private static BigInteger b = new BigInteger("1");
	private static BigInteger c;

    public static BigInteger getFibonacciNumber(int number) {
        for(int i = 2; i <= number ; i++){
            c = a.add(b);
            a = b;
	        b = c;
        }
	    return c;
    }
}
