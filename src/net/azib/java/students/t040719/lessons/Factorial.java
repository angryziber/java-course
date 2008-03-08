package net.azib.java.students.t040719.lessons;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Factorial
 *
 * @author Romi Agar
 */
public class Factorial {
	private static ArrayList<BigInteger> factCache = new ArrayList<BigInteger>();
	
	static {
	      factCache.add(BigInteger.ONE);
	}
	
	public String getFactList(int n){
		String result = new String();
		for(int i=0; i<n; i++){
	        if (i < factCache.size()) {
				result += factCache.get(i) + " ";
	        } else {
	        	factCache.add(i, BigInteger.valueOf(i).multiply(calculateFact(i-1)));	        	
				result += factCache.get(i) + " ";
	        }
		}
		return result;
	}
	
	public BigInteger calculateFact(int n) {
        if (n >= factCache.size()) {
            factCache.add(n, BigInteger.valueOf(n).multiply(calculateFact(n-1)));
        }
        return factCache.get(n);
	}
}
