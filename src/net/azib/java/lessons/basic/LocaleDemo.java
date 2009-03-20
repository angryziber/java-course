package net.azib.java.lessons.basic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * LocaleDemo
 *
 * @author anton
 */
public class LocaleDemo {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("et", "EE"));
		
		System.out.println(Locale.getDefault());
		
		Date now = new Date();
		System.out.println(now);
		System.out.println(DateFormat.getDateInstance().format(now));
		System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(now));
		System.out.println(DateFormat.getDateTimeInstance().format(now));
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(now));
	}
}
