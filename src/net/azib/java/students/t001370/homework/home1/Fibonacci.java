package net.azib.java.students.t001370.homework.home1;

import java.math.BigDecimal;

/**
 * Fibonacci
 *
 * @author zorgy
 */
public class Fibonacci {
	
	static BigDecimal calcFibonacci(int count)
	{
		BigDecimal a = new BigDecimal("0");
		BigDecimal b = new BigDecimal("1");
		BigDecimal c = new BigDecimal("0");
		
		int i = 0;
		while (i < count) 
		{
			c = a.add(b);
			a = b;
			b = c;
			i++;
		}
		return c;
	}

	public static void main(String[] args) 
	{
		int fibCount = 100;
		System.out.println("Fibonacci number:");
		System.out.println("F(" + fibCount + ") = " + 
				calcFibonacci(fibCount).toString());
	}
}
