package net.azib.java.lessons.misc;

import java.math.BigDecimal;

/**
 * NumberStuff
 *
 * @author anton
 */
public class Numbers {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(10 / 3);
		
		BigDecimal three = new BigDecimal(3);
		BigDecimal ten = BigDecimal.TEN;
		System.out.println(three.add(ten));
	}

}
