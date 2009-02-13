package net.azib.java.lessons.basic;

import java.math.BigInteger;

/**
 * Numbers
 *
 * @author anton
 */
public class Numbers {
	public static void main(String[] args) {
		int t = 125;
		
		System.out.println((float)t/100 + " kroon");
		
		if (t <= 10) {
			System.out.println("Can buy!");
		}
		
		System.out.println(Long.MAX_VALUE);
				
		BigInteger i = new BigInteger("110239012930192039120390129301293012909");
		i = i.add(BigInteger.ONE);
		System.out.println(i);
		
		
	}
}
