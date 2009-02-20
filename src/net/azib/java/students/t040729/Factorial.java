package net.azib.java.students.t040729;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author ValleTon
 */
public class Factorial {

	public static BigInteger get(int n){
		
		BigInteger result=BigInteger.valueOf(1);
		
		for (int i=2; i<=n; i++){
			result=result.multiply(BigInteger.valueOf(i));
		}
		
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("100! = "+get(100));
		
	}

}
