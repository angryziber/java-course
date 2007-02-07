package net.azib.java.students.t030636;

import java.math.BigDecimal;

/**
 * NumberStuff
 *
 * @author t030636
 */
public class NumberStuff {
	static int b=2;
	
	static final String HELLO = "hullumas" ;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		final int nummer = 7;
//		NumberStuff.b = 10;
//		System.out.println(nummer);
//		System.out.println(NumberStuff2.accessMe);
		
		
		Dog d = new Dog("Muki", (byte) 2);
		//System.out.println(dog.name);
		
		char c;
		c ='a'+ 4;
		System.out.println(c);
		BigDecimal j = new BigDecimal("1.025");
		BigDecimal k = BigDecimal.TEN;
		// j.add(k)		// ei tööta;
		j = j.add(k);
		//System.out.println(j.add(k));
		System.out.println(j);
		
		System.out.println(d.getName());
		
		
		}

}
