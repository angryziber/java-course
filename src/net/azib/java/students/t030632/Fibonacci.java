package net.azib.java.students.t030632;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author Toni
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fibonacciNumbers(100);

	}
	private static void fibonacciNumbers(int bound) {
		BigInteger result [] = new BigInteger[bound], a = BigInteger.ZERO, b= BigInteger.ONE;
		
		for(int i=0; i<bound;i++){
			
			result[i]= a.add(b);
			a=b;
			b=result[i];
		}
		int i=1;
		for(BigInteger it: result){
			System.out.println((i++)+". "+it);
		}
		System.out.println("Fibonacci from: " +bound +" equals: "+result[bound-1]);
	}

}
