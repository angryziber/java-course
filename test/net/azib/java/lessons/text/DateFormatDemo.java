package net.azib.java.lessons.text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * DateFormatDemo
 *
 * @author anton
 */
public class DateFormatDemo {
	private static void printDate(int style) {
		DateFormat dateFormat = DateFormat.getDateInstance(style);
		System.out.println(dateFormat.format(new Date()));
	}
	
	private static void printTime(int style) {
		DateFormat dateFormat = DateFormat.getTimeInstance(style);
		System.out.println(dateFormat.format(new Date()));
	}

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(new Locale("et"));
		printDate(DateFormat.SHORT);
		printDate(DateFormat.MEDIUM);
		printDate(DateFormat.LONG);

		printTime(DateFormat.SHORT);
		printTime(DateFormat.MEDIUM);
		printTime(DateFormat.LONG);
		
		DateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(isoFormat.format(new Date()));
		
		SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println(format.toPattern());
		format.setLenient(true);
		Date date = format.parse("30.02.2009");
		System.out.println(date.toString());
		
		Calendar cal = Calendar.getInstance();
		cal.set(GregorianCalendar.YEAR, 2050);
		cal.add(GregorianCalendar.DAY_OF_YEAR, 2);
		System.out.println(cal.getTime());
	}
}
