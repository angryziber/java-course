package net.azib.java.lessons.text;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatDemo {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);

		Format format = DateFormat.getInstance();
		System.out.println(format.format(date));

		format = DateFormat.getDateInstance();
		System.out.println(format.format(date));

		Locale.setDefault(new Locale("et"));
		System.out.println(DateFormat.getDateInstance().format(date));
		System.out.println(DateFormat.getDateInstance(DateFormat.SHORT).format(date));
		System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(date));

		System.out.println(DateFormat.getTimeInstance().format(date));
		System.out.println(DateFormat.getTimeInstance(DateFormat.SHORT).format(date));
		System.out.println(DateFormat.getTimeInstance(DateFormat.LONG).format(date));

		System.out.println(format.getClass());
		format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.format(date));
	}
}
