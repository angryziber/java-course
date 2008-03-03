package net.azib.java.students.t040750.hometasks.lesson1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author karpo
 */
public class Fibonacci {
	private static BufferedReader buff;
	
	public static void main(String[] args) {
		buff = new BufferedReader(new InputStreamReader( System.in ));
		String input;
		int iterator;
		
		try {
			/* Get the iterator for the Fibonacci number. Check if the input is 
			 * valid (non-negative integer)
			*/
			while(true) {
				System.out.print("Sisesta soovitud Fibonacci arvu järk: ");
				input = buff.readLine();
					
					if(validInt(input)) {
						iterator = Integer.parseInt(input);
						break;
					}
					
				System.out.println("Vigane sisend. Proovi uuesti!");
			}
			
			System.out.println(iterator + ". järku Fibonacci arv on: " + getFibonacciNumber(iterator));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Check if String can be converted to int and whether it is not negative
	*/
	private static boolean validInt(String input) {
		try {
			if(Integer.parseInt(input) < 0) {
				return false;
			}
			
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	/*
	 * Returns the positive Fibonacci number specified by the iterator by calling the
	 * Fibonacci calculation function.
	*/
	private static BigInteger getFibonacciNumber(int iterator) {
		return getFibonacciNumber(0,iterator,BigInteger.ZERO,BigInteger.ONE);
	}
	
	/*
	 * Calculates the positive Fibonacci number recursively until the specified iterator 
	 * equals the recursive steps
	*/
	private static BigInteger getFibonacciNumber(int i, int iterator, BigInteger fibNr, BigInteger prevFibNr) {
		if(i < iterator)
			return getFibonacciNumber(++i,iterator,fibNr.add(prevFibNr),fibNr);
		else
			return fibNr;
	}
}
