package net.azib.java.students.t040771.lessons;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * DateAndFormat
 *
 * @author t040771
 */
public class DateAndFormat {
	public static void main(String[] args) throws ParseException{
		Scanner scanner = new Scanner(System.in);
		
		Locale locale = new Locale("et", "EE");
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		
		System.out.println("How many dates?");
		int n = scanner.nextInt();
		
		Date dArray[] = new Date[n];
		
		for(int i=0;i<n;i++) {
			System.out.println((i+1) + ". " + ((SimpleDateFormat)df).toPattern());
			dArray[i] = df.parse(scanner.next());
		}
		
		for(Date d: dArray) {
			System.out.println(df.format(d));	
		}
		
	}
}
