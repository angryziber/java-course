package net.azib.java.students.t030656;

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
 * @author t030656
 */
public class Formatting {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.GERMAN);
		NumberFormat nf = NumberFormat.getInstance();
		System.out.println(nf.format(56123.23));
		
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.set(2007, GregorianCalendar.NOVEMBER, 30);
		cal.add(Calendar.DAY_OF_MONTH, 5);
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(df.format(cal.getTime()));
		
		System.out.println(df.parse("Mittwoch, 5. Dezember 2007"));
		
		ChoiceFormat cf = new ChoiceFormat(new double[]{0,1,2},
				new String[]{"zero message", "one message", "many messages"});
		System.out.println("You have " + cf.format(2));
		
		DateFormat df2 = new SimpleDateFormat("dd.MM.yy");
		System.out.println(df2.format(new Date()));
	}

}
