package net.azib.java.students.t040719;

import java.util.ArrayList;

/**
 * Primes
 *
 * @author Administrator
 */
public class Primes {
	private ArrayList<Integer> primes = new ArrayList<Integer>();
	public String findPrimes(int n){
		for(int i=1; i<=n; i++){
			if (!devisible(i))
				primes.add(i);
		}
		return arrayToString(primes);
	}
	private String arrayToString(ArrayList<Integer> arr){
		String str = "";
		for (Integer i : arr){
			str += i +" ";
		}
		return str;
	}
	private boolean devisible(int num){
		for (Integer i: primes){
			if (i != 1 && num % i == 0){
				return true;
			}
		}
		return false;
	}
}
