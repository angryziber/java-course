package net.azib.java.students.t001370.lectures.lec5;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * ScannerDemo
 *
 * @author maksim
 */
public class ScannerDemo {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("et","EE"));
		int count = 0;
		System.out.println("How many date:");
		Scanner s = new Scanner(System.in);
		count = s.nextInt();
		Date[] dates = new Date[count];
		
		for (int i = 0; i < count; i++) {
			System.out.println("Enter date" + count + "(" + ((SimpleDateFormat)df).toPattern() + ")" );
			dates[i] = df.parse(s.next());
		}
		
		for (Date date : dates) {
			System.out.println(date);
		}
	}
}