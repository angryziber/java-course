package net.azib.java.students.t001370.lectures.lec5;

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
import java.util.Scanner;

/**
 * LocaleDemo
 *
 * @author maksim
 */
public class LocaleDemo {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {

		Locale locale = new Locale("et", "EE");
		System.out.println(locale);
		//DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
		//DateFormat df = DateFormat.getTimeInstance(DateFormat.FULL, locale);
		//DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,locale);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		
		System.out.println("enter date (" + ((SimpleDateFormat)df).toPattern() + ")");
		String dateAsString = df.format(new Date());
		System.out.println(dateAsString);
		System.out.println(df.parseObject("29.09.2206"));
		System.out.println(df.parseObject("29.02.2007")); // Thu Mar 01 00:00:00 EET 2007
		
		
		
		//NumberFormat nf = NumberFormat.getInstance(locale);
		//NumberFormat nf = new DecimalFormat("#0.00");
		//NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		NumberFormat nf = NumberFormat.getPercentInstance(locale);
		System.out.println(nf.format(15413451.3453));
		
		
		/*ChoiceFormat cf = new ChoiceFormat(double[]{0,1,2}, new String[]{"no files", "one file", "two files"});
		System.out.println("you have " + cf.format(1));*/
		
		MessageFormat mf = new MessageFormat("I have {0, number} apples");
		Object[] data = mf.parse("I have 10 apples");
		System.out.println(Arrays.toString(data));
		
	}
}
