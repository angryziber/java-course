package net.azib.java.students.t030675;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Formating
 *
 * @author t030675
 */
public class Formating {
	public static void main(String[] args) {
		//Locale.setDefault(new Locale("et","EE"));
		Locale.setDefault(Locale.GERMANY);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println(nf.format(12543566.4324));
		
		
		//DateFormat df = DateFormat.getInstance();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(df.format(new Date()));
		
		
		//Calendar cal = Calendar.getInstance();
		Calendar cal = new GregorianCalendar(2007,GregorianCalendar.NOVEMBER,35);
		
		//cal.setLenient(false); // posle etogo ne prinimaet levie dati tipa 35 dekabrja
		
		//cal.set(2007,GregorianCalendar.NOVEMBER,35);
		cal.add(Calendar.MONTH, 2); // + 2 mesjaca
		System.out.println(cal.getTime());
		
		
		ChoiceFormat cf = new ChoiceFormat(new double[]{0,1,2},
						  new String[]{"zero messages","one message","many messages"});
		
		System.out.println("You have " + cf.format(5));
		
		DateFormat df2 = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println(df2.format(new Date()));
		
	}
}
