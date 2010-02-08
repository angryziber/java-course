package net.azib.java.lessons.basic;

import java.math.BigDecimal;

/**
 * MoneyLosingDemo
 *
 * @author anton
 */
public class MoneyLosingDemo {
	public static void main(String[] args) {
		float balance = 1;
		balance = balance - 0.9f;
		System.out.println(balance);
		
		if (balance == 0.1f) {
			System.out.println("Can buy");
		}
		
		BigDecimal balance2 = new BigDecimal("2637462873467238468723687462368263487263463287463264");
		balance2 = balance2.add(BigDecimal.TEN);
		System.out.println(balance2);
	}
}
