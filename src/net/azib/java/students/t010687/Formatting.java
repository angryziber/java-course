package net.azib.java.students.t010687;
import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Formatting
 *
 * @author t010687
 */
public class Formatting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(new Locale("et","EE"));
		NumberFormat df = NumberFormat.getCurrencyInstance();
		System.out.println(df.format(561275.25));
		
		Calendar cal = new GregorianCalendar();
		cal.setLenient(false); //ei saa illegaalseid kuup2evi toppida
		cal.set(2007, GregorianCalendar.NOVEMBER, 30);
		cal.add(Calendar.DAY_OF_MONTH, 5);
		
		System.out.println(cal.getTime());
		
		ChoiceFormat cf = new ChoiceFormat(new double[] {0,1,2,3}, new String [] {"zero", "one", "two", "many"});
		System.out.println("You have" + cf.format(2) + " messages");
		
	}

}
