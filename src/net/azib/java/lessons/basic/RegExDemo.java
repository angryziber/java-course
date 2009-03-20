package net.azib.java.lessons.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegExDemo
 *
 * @author anton
 */
public class RegExDemo {
	public static void main(String[] args) {
		String text = "some text";

		String regex = "[a-z\\s]*";
		Pattern pattern = Pattern.compile(regex);
		
		Matcher m = pattern.matcher(text);
		System.out.println(m.matches());
		
		String[] words = text.split(" ");
		System.out.println(words[0].replaceAll("s|o", "S"));
	}
}
