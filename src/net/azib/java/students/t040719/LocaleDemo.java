package net.azib.java.students.t040719;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;


/**
 * LocaleDemo
 *
 * @author t040719
 */
public class LocaleDemo {
	public static void main(String[] args) throws ParseException {
		Locale locale = new Locale("et","EE");
		System.out.println(locale + " " +locale.getCountry() + " " + locale.getDisplayCountry());
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		DateFormat tf = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		System.out.println("please enter date(" + ((SimpleDateFormat)df).toPattern()+")");
		String dateAsString = tf.format(new Date());
		System.out.println(dateAsString);
		df.setLenient(false); //vale kuupäeva puhul viskab parseExceptioni
		System.out.println(df.parse("29.02.2008"));
		System.out.println(df.format(new Date()));
		//NumberFormat nf = NumberFormat.getIntegerInstance(locale);
		//NumberFormat nf = new DecimalFormat("#0.00");
		NumberFormat nf = NumberFormat.getPercentInstance();
		System.out.println(nf.format(1213112.123213));
		
		ChoiceFormat cf = new ChoiceFormat(new double[] {0, 1, 2}, new String[]{"no files", "one file", "many files"});
		System.out.println("You have " + cf.format(3));
		
		MessageFormat mf = new MessageFormat("I have {0,number} apples"); //loe javadoci kasutuseks
		Object[] data = mf.parse("I have 10 apples");
		System.out.println(Arrays.toString(data));
	}
}
