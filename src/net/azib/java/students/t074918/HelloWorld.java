package net.azib.java.students.t074918;

import java.util.Date;

/**
 * HelloWorld 
 * @author Mart Mangus
 */
public class HelloWorld {
	
	public static void main(String[] args) {
		System.out.println(Constants.GREETING_MESSAGE);
		Date now = new Date();
		System.out.println(now);
		Dog dog = new Dog("Muki", 2);
		System.out.println(dog);
		
		int a = 0;
		System.out.println(a);
		
//		byte b = 1;
//		int i = 1;
//		i = b; // Okei, infot ei lähe kaduma...
//		b = (byte)i; // Ei saa niisama, peab castima
		
//		Object o = new Object();
//		Date d = new Date();
//		o = d; // Object on Date alamklass -- väärtustamine okei
//		d = o; // Ei ole okei... peab castima:
//		d = (Date)o;
		
		System.out.println("Instance of...");
		System.out.println(dog instanceof Object);
		
//		System.gc(); // Käivitab Garbage collector-i -- pole vaja kasutada!

	}
}
