package net.azib.java.students.t030633.lessons;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * LocaleDemo
 * 
 * @author t030633
 */
public class LocaleDemo {
	public static void main(String[] args) throws ParseException {
		Locale locale = new Locale("et", "EE");
		System.out.println(locale);

		DateFormat dfDate = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		DateFormat dfTime = DateFormat.getTimeInstance(DateFormat.SHORT, locale);
		// tip: FULL, LONG, SHORT
		String dateAsString = dfDate.format(new Date());
		String timeAsString = dfTime.format(new Date());
		System.out.println(dateAsString + ' ' + timeAsString);
		System.out.println(dfDate.parse("11.02.2008"));

		double d = 11155418432.23423d;
		NumberFormat nf = NumberFormat.getInstance(locale);
		// tip: getCurrencyInstance, getXxxInstance
		System.out.println(nf.format(d));

		NumberFormat decimalFormat = new DecimalFormat("#0.00");
		System.out.println(decimalFormat.format(d));

		ChoiceFormat cf = new ChoiceFormat(new double[] { 1, 2, 3 }, new String[] { "no files", "one file", "many files" });
		System.out.println("You have " + cf.format(10));

		MessageFormat mf = new MessageFormat("I have {0,number} apples");
		Object[] data = mf.parse("I have 10 apples");
		System.out.println(Arrays.toString(data));
	}
}
