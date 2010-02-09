package net.azib.java.students.t092875;

import java.math.BigInteger;

/**
 * FibonacciGenerator
 *
 * @author Mihhail
 */
public class FibonacciGenerator implements NumbersGenerator {

	@Override
	public BigInteger getNthNumber(int n) {
		if(n < 0){
			return null;
		}else{
			switch(n){
				case 0: return BigInteger.ZERO;
				case 1: return BigInteger.ONE;
				default: return generateNthFibonacci(n);
			}
		}
	}
	
	private BigInteger generateNthFibonacci(int n){
		BigInteger[] tempNumbers = new BigInteger[2];
		tempNumbers[0] = BigInteger.ZERO;
		tempNumbers[1] = BigInteger.ONE;
		for(int i=2; i<n+1; i++){
			BigInteger temp = tempNumbers[1].add(tempNumbers[0]);
			tempNumbers[0] = tempNumbers[1];
			tempNumbers[1] = temp;
		}
		return tempNumbers[1];
	}

}
