package net.azib.java.students.t030721;

import java.math.BigDecimal;

/**
 * NumS
 *
 * @author t030721
 */
public class NumberStuff {

	static int b;
	
	static final String HELLO = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog = new Dog("Pitsu", (byte)3);
		System.out.println(dog.getName());
		Boolean b = new Boolean(true);
		char c = 'る';
		char d = '業';
		char e = '\u0010';
		System.out.println(c);
		System.out.println(e);
		System.out.println(b);
		System.out.println(d);
		BigDecimal db = new BigDecimal("1.025");
		BigDecimal db2 = BigDecimal.TEN;
		System.out.println(db.add(db2));
		

	}

}
