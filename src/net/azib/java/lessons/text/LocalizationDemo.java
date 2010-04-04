package net.azib.java.lessons.text;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * LocalizationDemo
 *
 * @author anton
 */
public class LocalizationDemo {
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle(LocalizationDemo.class.getPackage().getName() + ".Messages");
		System.out.println(bundle.getString("hello"));
		
		Locale.setDefault(new Locale("et"));
		bundle = ResourceBundle.getBundle(LocalizationDemo.class.getPackage().getName() + ".Messages");
		System.out.println(bundle.getString("hello"));
	}
}
