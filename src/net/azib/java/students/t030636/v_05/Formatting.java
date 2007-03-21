package net.azib.java.students.t030636.v_05;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Formatting
 *
 * @author Martin
 */
public class Formatting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Locale.setDefault(Locale.GERMANY);
		//Locale.setDefault(new Locale("et", "EE"));
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println(nf.format(72163.25));
		
		Calendar cal = new GregorianCalendar(2007, GregorianCalendar.NOVEMBER, 12);
		cal.setLenient(false);
		
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(df.format(cal.getTime()));
		
		ChoiceFormat cf = new ChoiceFormat(new double[] {0, 1, 2}, new String[] {"null asja", "yx asi", "palju asju"});
		System.out.println("Sul on: " + cf.format(0));
		
		DateFormat dff = new SimpleDateFormat("-dd-MM-yyyy-");
		System.out.println(dff.format(new Date()));

	}

}
