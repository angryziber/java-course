package net.azib.java.students.t030632;

import java.text.ChoiceFormat;
import java.text.NumberFormat;
import java.text.DateFormat;
import java.util.*;
import java.util.Locale;

/**
 * Formatting
 *
 * @author t020632
 */
public class Formatting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale.setDefault(new Locale("et", "EE"));
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println(nf.format(123.25));
		
		Calendar cal = new GregorianCalendar(2007, GregorianCalendar.NOVEMBER, 23);
		
		DateFormat df = DateFormat.getInstance();
		System.out.println(df.format(cal.getTime()));
		
		ChoiceFormat cf = new ChoiceFormat(new double [] {0, 1, 2}, new String [] {"one", "two", "three"});
		
		System.out.println("You have " + cf.format(5) + " message");
		
		
	}

}
