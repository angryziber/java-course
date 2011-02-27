package net.azib.java.students.t104923.hometask2;

import java.math.BigInteger;

public class Fibonacci {
    private BigInteger a = BigInteger.ZERO;
    private BigInteger b = BigInteger.ONE;
	private BigInteger c;

    public BigInteger getFibonacciNumber(int number) {
	    for(int i = 2; i <= number ; i++){
		    c = a.add(b);
		    a = b;
		    b = c;
        }
	    return c;
    }
}
