package net.azib.java.students.t001370.homework.home1;

import java.math.BigDecimal;

/**
 * Factorial
 *
 * @author maksim
 */
public class Factorial {
	static BigDecimal calcFactorial(int count){
		BigDecimal fact = new BigDecimal("1");
		
		for (int i = 1; i <= count; i++) {
			fact = fact.multiply(BigDecimal.valueOf(i));
		}
		
		return fact;
	}
	
	public static void main(String[] args) {
		int facCount = 100;
		
		System.out.println(facCount + "! = " + 
						calcFactorial(facCount));
	}

}
