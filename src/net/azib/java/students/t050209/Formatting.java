package net.azib.java.students.t050209;

import java.text.DateFormat;
import java.text.NumberFormat;
//import java.util.Locale;
import java.util.Calendar;
import java.util.Date;

/**
 * Formatting
 *
 * @author t050209
 */
public class Formatting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Locale.setDefault(Locale.GERMANY);
		//Locale.setDefault(new Locale("et", "EE"));
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println(nf.format(10123.25));
		
		Calendar cal = Calendar.getInstance();
		
		DateFormat df = DateFormat.getInstance(); //getTime Instance
		//DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(df.format(new Date()));
		System.out.println(df.format(cal.getTime()));

	}

}
