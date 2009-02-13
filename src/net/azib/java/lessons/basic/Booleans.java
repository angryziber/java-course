package net.azib.java.lessons.basic;

import java.util.Date;

/**
 * Booleans
 *
 * @author anton
 */
public class Booleans {
	static boolean a() {
		System.out.println("a");
		return true;
	}
	static boolean b() {
		System.out.println("b");
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(a() || b());
		System.out.println(1 == 2 ? "true" : "false");
		System.out.println(new Date() instanceof Object);
	}
}
