package net.azib.java.students.t040750;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Numbers.
 * 
 * Test class for learning numbers
 *
 * @author t040750
 */
public class Numbers {
	
	/**
	 * Prints the specified number to the console
	 * @param n
	 * @deprecated please use {@Link System#out} {@Link PrintStream#} instead
	 */
	static void printNumber(Number n) {
		System.out.println(n);
		//n.change(1);
	}
	
	static boolean b() {
		System.out.println('b');
		return true;
	}
	
	static boolean a() {
		System.out.println('a');
		return true;
	}
	
	public static void main(String[] args) {
		BigInteger i = BigInteger.ZERO;
		i.add(BigInteger.ONE);
		System.out.println(i); 	//i = 0, kuna BigInteger on immutable,
								//st et objekti olek ei muutu (kui me seda ise ei muuda?)
		
		i = i.add(BigInteger.ONE);
		System.out.println(i); 	//nüüd on i = 1
		
		printNumber(i);
		
		Date d = new Date(2008, 1, 1); 	//deprecated, kuna ei tööta piisavalt
										//hästi erinevate timezone'ide puhul
		
		Calendar c = new GregorianCalendar();
		System.out.println(c.getFirstDayOfWeek());
		
		if(i != null && i.equals(BigInteger.ONE)){ 	//Kui on &&, siis võime sellist võrdlust kasutada.
			i = i.add(BigInteger.ONE);				//Kui aga on &, siis saame NullPointerExceptioni juhul,
		}											//kui i = null, kuna i.equals() ei saa kutsuda siis
		
		System.out.println(i instanceof BigInteger);//Kas i on klassi BigInteger instants?
	}
}
