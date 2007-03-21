package net.azib.java.students.t020556;

import java.util.Locale;

/**
 * Locales
 *
 * @author Agu Aarna
 */
public class Locales {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale.setDefault(new Locale("ee", "EE"));
		System.out.println(Locale.getDefault());

	}

}
