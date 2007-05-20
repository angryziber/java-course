package net.azib.java.students.t030656.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Katsetamine
 *
 * @author Sprot
 */
public class Katsetamine {
	public static void main(String[] args) {
		String s = "34:56";
        DateFormat df = new SimpleDateFormat("mm:ss");
        Calendar cal = Calendar.getInstance();
        df.setLenient(false);
        
        try {
			cal.setTime(df.parse(s));
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
	}
}
