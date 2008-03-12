package net.azib.java.students.t654321;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * LocaleDemo
 *
 * @author Karl
 */
public class LocaleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale locale = new Locale("et","EE");
		System.out.println(locale.toString());
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,locale);
		String dateToString = df.format(new Date());
		System.out.println(dateToString);
	}

}
