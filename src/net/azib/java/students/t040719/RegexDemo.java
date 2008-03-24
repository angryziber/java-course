package net.azib.java.students.t040719;

import java.util.regex.Pattern;

/**
 * RegexDemo
 *
 * @author t040719
 */
public class RegexDemo {
	public static void main(String[] args) {
		String s = "Dog";
		String s2 = "Cat4";
		System.out.println(s.matches("[DC][ao][gt][0-9]*")); //*-zero ore more, +-1 or more, ?-0 or 1
		System.out.println(s2.matches("[DC][ao][gt]\\d+"));
		System.out.println(s2.replaceAll("([DC][ao][gt])(\\d+)","ABC$1$2"));
		Pattern p = Pattern.compile("(Dog|Cat)(\\d+)");
		p.matcher(s).find();
		
	}
}