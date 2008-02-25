package net.azib.java.students.t040750.homework.lesson1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Factorial
 *
 * @author karpo
 */
public class Factorial {
	private static BufferedReader buff;
	
	public static void main(String[] args) {
		buff = new BufferedReader(new InputStreamReader( System.in ));
		String input;
		int iterator;
		
		try {
			/* Get number whose Factorial is needed. Check if the input is 
			 * valid (non-negative integer)
			*/
			while(true) {
				System.out.print("Sisesta number, millest faktoriaal arvutada: ");
				input = buff.readLine();
					
					if(validInt(input)) {
						iterator = Integer.parseInt(input);
						break;
					}
					
				System.out.println("Vigane sisend. Proovi uuesti!");
			}
			
			System.out.println("Arvu " + iterator + " faktoriaal on: " + getFactorial(iterator));
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
	 * Returns the factorial of the input number
	*/
	private static BigInteger getFactorial(int input) {
		return getFactorial(0,input,BigInteger.ONE);
	}
	
	/*
	 * Calculates factorial of the input number recursively until the specified iterator 
	 * equals the recursive steps
	*/
	private static BigInteger getFactorial(int i, int input, BigInteger factorial) {
		if(i < input)
			return getFactorial(++i,input,factorial.multiply(BigInteger.valueOf(i)));
		else
			return factorial;
	}
}
