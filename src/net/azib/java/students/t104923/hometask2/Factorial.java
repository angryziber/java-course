package net.azib.java.students.t104923.hometask2;

import java.math.BigInteger;

public class Factorial {
	private BigInteger a = BigInteger.ONE;
	private BigInteger b = BigInteger.ONE;

    public BigInteger getFactorialNumber(int number) {
	    for(int i = number; i > 1; i--){
             a = a.multiply(b = b.add(BigInteger.ONE));
	    }
         return a;
    }
}