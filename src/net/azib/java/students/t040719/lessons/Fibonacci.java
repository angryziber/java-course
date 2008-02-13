package net.azib.java.students.t040719.lessons;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Fibonacci
 * 
 * @author Romi Agar
 */
public class Fibonacci {
	private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();
	
	static {
	      fibCache.add(BigInteger.ZERO);
	      fibCache.add(BigInteger.ONE);
	}
	
	public String getFiboList(int n){
		String result = new String();
		for(int i=0; i<n; i++){
	        if (i < fibCache.size()) {
				result += fibCache.get(i) + " ";
	        } else {
	            fibCache.add(i, calculateFib(i-1).add(calculateFib(i-2)));	        	
	        }
		}
		return result;
	}
	
	public BigInteger calculateFib(int n) {
        if (n >= fibCache.size()) {
            fibCache.add(n, calculateFib(n-1).add(calculateFib(n-2)));
        }
        return fibCache.get(n);
	}
	
}
