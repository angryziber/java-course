package net.azib.java.students.t050657.Class;

import java.awt.Choice;
import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Formatting
 *
 * @author t050657
 */
public class Formatting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Locale.setDefault(Locale.GERMANY);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println(nf.format(1544.5));
		
		Calendar calendar = Calendar.getInstance();
		//calendar.setLenient(false);
		calendar = new GregorianCalendar(2007, 10, 25);
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(dateFormat.format(calendar.getTime()));
		
		ChoiceFormat cf = new ChoiceFormat(new double[] {1,2,3}, 
										   new String[] {"one message", "two messages", "many messages"} );
		
		System.out.println("You have " + cf.format(1));
		
		DateFormat df2 = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println(df2.format(new Date()));
		
	}

}
