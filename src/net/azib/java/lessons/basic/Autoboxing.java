package net.azib.java.lessons.basic;

import java.util.Date;

/**
 * Autoboxing
 *
 * @author anton
 */
public class Autoboxing {
	
	
	public static void main(String[] args) {
		Boolean b = true;
		System.out.println(b == Boolean.TRUE);
		System.out.println(new Boolean(true) == Boolean.TRUE);
		
		Integer n = 123;
		System.out.println(n == (Integer)123);
		
		n = 1000;
		System.out.println(n == (Integer)1000);
		
		printAll(1, 2, "a", new Date(), 'a');
	}

	private static void printAll(Object ... anything) {
		for (Object object : anything) {
			System.out.println(object.getClass() + ": " + object);
		}
	}
}
