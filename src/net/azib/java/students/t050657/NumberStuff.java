package net.azib.java.students.t050657;

import java.math.BigDecimal;

/**
 * NumberStuff
 *
 * @author t050657
 */
public class NumberStuff {

	static final String HELLO = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int a = 7;
		System.out.println(a);
		System.out.println(Number2Stuff.a);
		
		System.out.println(HELLO);
		
		Dog dog = new Dog("Fred");
		Dog bob = new Dog("Bobby", 27);
		System.out.println(dog.toString());
		System.out.println(bob.toString());
		
		
		BigDecimal big = new BigDecimal("1521582245121851215132.4815312318");
		System.out.println(1 > 2 ? "trU" : "fAlse");
		
	}
}
