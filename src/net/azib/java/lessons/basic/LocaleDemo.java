package net.azib.java.lessons.basic;

import java.math.BigDecimal;
import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
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
 * @author anton
 */
public class LocaleDemo {
	public static void main(String[] args) throws ParseException {
		Locale locale = new Locale("et", "EE");
		
		System.out.println(locale);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		
		System.out.println("please enter date (" + ((SimpleDateFormat)df).toPattern() + ")");
		String dateAsString = df.format(new Date());
		System.out.println(dateAsString);
		
		df.setLenient(false);
		System.out.println(df.parse("29.02.2008"));
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		System.out.println(nf.format(new BigDecimal("1238127381238917231273128378913912738172938712398127389127389")));
		
		ChoiceFormat cf = new ChoiceFormat(new double[] {0, 1, 2}, new String[] {"no files", "one file", "many files"});
		System.out.println("You have " + cf.format(10));
		
		MessageFormat mf = new MessageFormat("I have {0,number} apples");
		Object[] data = mf.parse("I have 10 apples");
		System.out.println(Arrays.toString(data));
		
		
	}
}
