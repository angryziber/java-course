package net.azib.java.students.t040719;

import java.util.Date;


/**
 * HelloWorld
 * 
 * @author t040719
 */
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println(Constants.GREET);
		System.out.println(new Date()); //selekteeri ja Ctrl+1 et importida
		char c = 'A' + 1 + '\u0020' + 0x20;
		byte b = (byte)0;
		byte bb = (byte)129;
		long l = 0L;
		Integer i = Integer.parseInt("5");
		System.out.println(bb);
	}
}
