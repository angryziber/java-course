package net.azib.java.students.t040729;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author ValleTon
 */
public class Fibonacci {

	public static BigInteger get(long n){
		
		BigInteger lastlast=BigInteger.valueOf(-1); //n-2
		BigInteger last=BigInteger.valueOf(1); //n-1
		BigInteger result=null;
		
		for (long i=0; i<=n; i++){
			//System.out.println("// "+i+" DEBUG: "+lastlast+","+last+"\n");
			result=lastlast.add(last);
			lastlast=last;
			last=result;
		}
		
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long num=100;
		System.out.println("Fibonacci "+num+": "+get(num));
		
	}

}
