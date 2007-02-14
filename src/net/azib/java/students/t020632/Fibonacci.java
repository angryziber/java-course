package net.azib.java.students.t020632;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author t020632
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		BigInteger c = new BigInteger("1");
		int i;
		BigInteger [] m = new BigInteger[100];
		
		for(i = 3; i<=100; c = a.add(b), b = c, a = b, i++ ){
			m[i-1] = c;
			if(i == 100){
					System.out.println(c);
			}
		}
		
		for(BigInteger bi : m){
			System.out.println(bi);
		}
		

	}

}
