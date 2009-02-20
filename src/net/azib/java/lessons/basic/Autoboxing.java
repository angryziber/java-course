package net.azib.java.lessons.basic;

/**
 * Autoboxing
 *
 * @author anton
 */
public class Autoboxing {
	public static void main(String[] args) {
		int a = 1, b = 1;
		Integer aa = 1, bb = 1, cc = new Integer(1);
		
		System.out.println(a == b);
		System.out.println(aa == cc);
		System.out.println(aa == bb);
		System.out.println(aa.equals(cc));
	}
}
