package net.azib.java.students.t020632;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author Marek
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigInteger bi = new BigInteger("1");
		BigInteger bi1 = new BigInteger("1");
		BigInteger bi2 = new BigInteger("2");
		int i = 1; 
	
		
		while( i < 100){
			bi1 = bi1.multiply(bi2);
			bi2.add(bi);
			i++;
		}
		
		System.out.println(bi1);
		

	}

}
