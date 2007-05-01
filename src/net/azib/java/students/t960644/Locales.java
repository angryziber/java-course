package net.azib.java.students.t960644;

/**
 * Locales
 *
 * @author Lembit
 */
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Locales {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
//		System.out.println(Locale.getDefault().getDisplayLanguage());
		Locale.setDefault(new Locale("en","EE"));
//		System.out.println(Locale.getDefault());
/*		long t1=System.nanoTime();
		String s ="";
		for (int i=1;i<=1000;i++){
			s+=i+" ";
		}
//		System.out.println(s);
		
		long t2=System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for (int i=1;i<=1000;i++){
			sb.append(i).append(" ");
		}
//		System.out.println(sb);
		long t3=System.nanoTime();
		System.out.println((t3-t2)+" "+(t2-t1));
*/
		NumberFormat nf=NumberFormat.getCurrencyInstance();
		System.out.println(nf.format(35612.23));

		Calendar cal = new GregorianCalendar();
		cal.setLenient(false);
		cal.set(2007, GregorianCalendar.NOVEMBER, 30);
		cal.add(Calendar.MONTH, 5);
		
//		DateFormat df = DateFormat.getInstance();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
//		System.out.println(df.format(new Date()));
		System.out.println(df.format(cal.getTime()));
//		System.out.println(df.parse("10. December 2007"));
		
//		ChoiceFormat cf = new ChoiceFormat(new double[] {0,1,2},
//				new String[] {"null teadet","yks teade","palju teateid"});
//		System.out.println("Sulle on "+cf.format(-100));
		
		DateFormat df2 = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println(df2.format(new Date()));
		
	}

}
