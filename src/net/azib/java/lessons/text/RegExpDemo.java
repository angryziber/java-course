package net.azib.java.lessons.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegExpDemo
 *
 * @author anton
 */
public class RegExpDemo {
	public static void main(String[] args) {
		System.out.println("ABCA".replaceAll("[A-B]", "x"));
		
		Pattern emailPattern = Pattern.compile("[a-z0-9_A-Z.]+@[-a-zA-Z0-9.]+\\.[a-zA-Z]{2,4}");
		Matcher m = emailPattern.matcher("Blah blah x@azib.net more blah xxx@gmail.com ppppp");
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
