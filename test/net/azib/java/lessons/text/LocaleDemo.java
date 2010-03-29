package net.azib.java.lessons.text;

import java.util.Locale;

/**
 * LocaleDemo
 *
 * @author anton
 */
public class LocaleDemo {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("et"));
		System.out.println(Locale.getDefault());		
	}
}
