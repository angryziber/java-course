package net.azib.java.students.t074918;

import java.math.BigInteger;

/**
 * Numbers
 *
 * @author Mart Mangus
 */
public class Numbers {

	public static void main(String[] args) {
		
//		double f = 1.0;
//		f -= 0.9;
//		System.out.println(f);
//		// if (f >= 0.9) <- ei tööta nii nagu vaja!
//		if (f - 0.9 <= 0.0000001)
//			System.out.println("Olemas raha 0.9 jaoks!");
//		else
//			System.out.println("Pole raha!");
		
		int m = 125; // Hea raha esitlusviis -- sentidena
		System.out.println((float)m/100 + " krooni");
		
		Integer o = new Integer("45");
		System.out.println(o);
		
		System.out.println(Integer.parseInt("123")); // String to Integer
		//System.out.println(String); // Integer to String
		
		System.out.println(Long.MAX_VALUE);
		
		Integer i = 5; // Autoboxing...
		Object oo = i;
		System.out.println(i.intValue());
		
		BigInteger b = new BigInteger("4709377777732453453427777777777777589234");
		b.add(BigInteger.ONE);
		System.out.println(b);
		
		// Bitikaupa nihutamine
		// >> arvestab märki
		// >>> ei arvesta märki
		
		// ~ bittide inverteerimine	
	}
}
