package net.azib.java.students.t020544;

import java.util.Locale;

/**
 * Locales
 * 
 * @author Julija
 */
public class Locales {

	public static void main(String[] args) {
		// System.out.println(Locale.getDefault().getDisplayCountry());
		// System.out.println(new Locale("et","EE"));

		Locale.setDefault(new Locale("et", "EE"));
		System.out.println(Locale.getDefault());

		// StringBuilder

		// halb variant
		long t1 = System.nanoTime();
		String s = "";
		for (int i = 1; i <= 1000; i++) {
			s += i + " ";

		}
		System.out.println(s);

		// hea variant
		long t2 = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 1000; i++) {
			sb.append(i).append(' ');

		}
		System.out.println(sb.toString());
		
		
		long t = System.nanoTime();
		System.out.println((t - t2) + "  " + (t - t1));
	}
}
