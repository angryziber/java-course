package net.azib.java.students.t020544;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Formatting
 * 
 * @author Julija
 */
public class Formatting {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.GERMANY);
		// Locale.setDefault(new Locale("et", "EE"));
		NumberFormat nf = NumberFormat.getInstance();
		System.out.println(nf.format(6776676.87));

		Calendar cal = new GregorianCalendar();
		cal.setLenient(false);
		cal.set(2007, GregorianCalendar.NOVEMBER, 30);
		cal.add(Calendar.MONTH, 2);

		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(df.format(cal.getTime()));

		System.out.println(df.parse("Mittwoch, 30. Januar 2008"));

		ChoiceFormat cf = new ChoiceFormat(new double[] { 0, 1, 2 }, new String[] 
		     { "zero messages", "one message","many messages" });

		System.out.println("You have " + cf.format(2));
		
		
		DateFormat df2=new SimpleDateFormat("dd.MM.yyyy");
		System.out.println(df2.format(new Date()));

	}

}
