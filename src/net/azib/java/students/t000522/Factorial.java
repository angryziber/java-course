package net.azib.java.students.t000522;

import java.math.BigInteger;

public class Factorial {
	
	public BigInteger compute(long index) {
		//value of factorial
		BigInteger factorial = new BigInteger("1");
		
		for (int i=1; i<=index; i++) {	
			factorial = factorial.multiply(factorial.valueOf(i));
		}
		
		return factorial;
	}
	
	public static void main(String[] args) {
		System.out.println(new Factorial().compute(100L));
	}
}
