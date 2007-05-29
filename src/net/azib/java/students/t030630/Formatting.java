package net.azib.java.students.t030630;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Formatting
 *
 * @author Kasutaja
 */
public class Formatting {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.GERMANY);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println(nf.format(56123.25));
		
		Calendar cal = new GregorianCalendar();
		cal.setLenient(false);
		cal.set(2007, GregorianCalendar.NOVEMBER, 30);
		cal.add(Calendar.DAY_OF_MONTH, 5);
		
//		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
//		System.out.println(df.format(cal.getTime()));
//		
		//System.out.println(df.parse("Mittwoch, 5. December 2007"));
		
		ChoiceFormat cf = new ChoiceFormat(new double[] {0, 1, 2}, 
											new String[] {"zero", "one", "many"});
		
		System.out.println("You have " + cf.format(100)+ " messages");
		
//		DateFormat df2= new DateFormat("dd.MM.yyyy");
//		System.out.println(df2.format(new Date()));
		
		
	}

}
