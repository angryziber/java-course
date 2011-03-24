package net.azib.java.lessons.text;

import java.util.Locale;

public class LocaleDemo {
	public static void main(String[] args) {
		System.out.println(Locale.getDefault());
		System.out.println(Locale.FRENCH);
		System.out.println(Locale.FRANCE);
		Locale estonian = new Locale("et", "EE");
		Locale.setDefault(estonian);
		System.out.println(Locale.getDefault());

	}
}
