package net.azib.java.students.t030636.second;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author t030636
 */
public class Fibonacci {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger i = BigInteger.ZERO; 
		BigInteger j = BigInteger.ONE;
		BigInteger h = BigInteger.ZERO;
		
		for(int k=1; k <100; k ++ ){
			h = j.add(i);
			i=j;
			j=h;
		}
		System.out.println(j);
		
		/*BigInteger[] ints =
		for (BigInteger i: ints){
			
		}*/
		
	}

}
