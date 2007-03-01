package net.azib.java.students.t020544;

import java.util.*;

/**
 * HelloWorld
 * 
 * @author t020544
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Random rand = new Random();
		Date date1 = new Date();
		// System.out.println(date1);

//		printsHello();

		Date date2 = new Date();

		for (int i = 1; i < 25; i++) {
			System.out.println("Random number " + i + " : " + rand.nextGaussian());
		}

//		System.out.println(date1);
//		System.out.println(date2);
//		System.out.println("Date2 after date1 " + date2.after(date1));

	}

	/**
	 * 
	 */
	private static void printsHello() {
		for (int i = 1; i < 25; i++) {
			System.out.println("Hello World!");
		}
	}
}
