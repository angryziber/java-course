package net.azib.java.students.t020632;

import java.math.BigDecimal;

/**
 * NumberStuff
 *
 * @author t020632
 */
public class NumberStuff {
	
	static int b;
	static final String HELLO = "abc";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog = new Dog();
		Boolean b = new Boolean(true);
		char c = 'a';
		BigDecimal bd = new BigDecimal("1.025");
		BigDecimal bd2 = BigDecimal.TEN;
		String s = "aa";

		Integer n = 1;
		n++;
		System.out.println(n);
		
		System.out.println(bd .add(bd2));
		System.out.println(1 > 2 ? "false" : "true");
		System.out.println(s instanceof String);
	}

}
