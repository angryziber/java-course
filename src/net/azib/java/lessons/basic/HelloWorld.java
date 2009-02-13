package net.azib.java.lessons.basic;

import java.util.Date;

/**
 * HelloWorld
 *
 * @author anton
 */
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println(Constants.GREETING_MESSAGE);
		
		int a = 0;
		System.out.println(a);
		
		Dog dog = new Dog("Muki", 2);
		//Dog dog2 = new Dog();
		System.out.println(dog);
		
		byte b = 1;
		int i = 1;
		
		b = (byte)i;
		i = b;
		
		Object o = new Object();
		Date d = new Date();
		
//		o = d;
//		d = (Date)o;
//		System.out.println(d);
	}
}
