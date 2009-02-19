package net.azib.java.students.t000522;

import java.math.*;

public class Fibonacci {

	//holds current element value
	private static BigInteger fibonacciCurrent = new BigInteger("0");
	//holds previous element value
	private static BigInteger fibonacciPrevious = new BigInteger("0");
	//index of element
	private static int n = 100;
	
	public static void main(String[] args) {
		for (int i=0; i<=n; i++){
			if (i==1){
				fibonacciCurrent = fibonacciCurrent.add(new BigInteger("1"));
			}
			else{
				fibonacciCurrent = fibonacciCurrent.add(fibonacciPrevious);
				fibonacciPrevious = fibonacciCurrent.subtract(fibonacciPrevious);
			}
			System.out.println(fibonacciCurrent);
		}
	}
}
