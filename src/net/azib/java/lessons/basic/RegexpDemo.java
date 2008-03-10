package net.azib.java.lessons.basic;

import java.util.regex.Matcher;
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
		System.out.println(s.replaceAll("(Dog|Cat)(\\d+)", "$1ABC$2"));
		
		Pattern compiledPattern = Pattern.compile("67");
		Matcher matcher = compiledPattern.matcher(s);
		System.out.println(matcher.find());
	}
}
