package net.azib.java.lessons.basic;

import java.math.BigDecimal;

/**
 * MoneyDemo
 *
 * @author anton
 */
public class MoneyDemo {
	public static void main(String[] args) {
		float balance = 1;
		balance -= 0.1;
		System.out.println(balance);
		
		if (balance >= 0.9) 
			System.out.println("I have 90 cents");
		else
			System.out.println("I don't have 90 cents (floats are imprecise)");
				
		BigDecimal balance2 = new BigDecimal("2637462873467238468723687462368263487263463287463264");
		balance2 = balance2.add(BigDecimal.TEN);
		System.out.println(balance2);
	}
}
