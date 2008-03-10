package net.azib.java.lessons.basic;

import java.util.regex.Pattern;

/**
 * RegexpDemo
 *
 * @author anton
 */
public class RegexpDemo {
	public static void main(String[] args) {
		String s = "Dog676";
		System.out.println(s.matches("(Dog|Cat)\\d+"));
		System.out.println(s.replaceAll("", "$1ABC$2"));
	}
}
