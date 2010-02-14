package net.azib.java.lessons.basic;

/**
 * NumbersDemo
 *
 * @author anton
 */
public class NumbersDemo {
	static final double PI_VALUE = 3.1415;
	
	public static void main(String[] args) {
		int i1 = 200;
		byte b = 2;
		long l = 127386172368127638L;
		float f = 0.1f;
		int hex = 0x20;
		int octal = 020;
		System.out.println(octal);
		
		System.out.println(Integer.toString(i1, 2));
		
		int n = Integer.valueOf("5");
		
		System.out.println(Long.MAX_VALUE);
		
		byte smallByte = (byte)i1;
		System.out.println(b);
	}
}
