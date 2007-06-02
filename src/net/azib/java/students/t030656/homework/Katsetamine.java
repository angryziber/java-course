package net.azib.java.students.t030656.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Katsetamine
 *
 * @author Sprot
 */
public class Katsetamine {
	public static void main(String[] args) {
		String s = "5:25.72";
        DateFormat df = new SimpleDateFormat("mm:ss.SS");
        DateFormat df2 = new SimpleDateFormat("ss.SS");
        Calendar cal = new GregorianCalendar();
        df.setLenient(false);
        
       	try {
    			cal.setTime(df.parse(s));
   		}
   		catch (ParseException e) {
   			try {
   				cal.setTime(df2.parse(s));
   			}
   			catch (ParseException e1) {
   				System.out.println("Unsuported time format.");
   			}
   		}
   		
		double a = cal.get(Calendar.MINUTE) * 60 + 
					cal.get(Calendar.SECOND) + 
					(double)cal.get(Calendar.MILLISECOND)/100;
		System.out.println(a);
	}
}
