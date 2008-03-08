package net.azib.java.students.t001370.lectures.lec1;

import java.math.BigDecimal;

/**
 * Fibonacci
 *
 * @author zorgy
 */
public class Fibonacci {
	
	/*public String calc(int inp){
		return "1";
	}*/
	
	
	public static BigDecimal calcFibonacci(int count){
		BigDecimal a = new BigDecimal("0");
		BigDecimal b = new BigDecimal("1");
		BigDecimal c = new BigDecimal("0");
		
		int i = 0;
		if (count == 0) 
			c = a;
		else if (count == 1) 
			c = b;
		else
			while (i < count - 1){
				c = a.add(b);
				a = b;
				b = c;

				i++;
			}
		
		return c;
	}

	public static void main(String[] args){
		int fibCount = 100;
		
		System.out.println("Fibonacci number:");
		System.out.println("F(" + fibCount + ") = " + 
				calcFibonacci(fibCount).toString());
	}
}
