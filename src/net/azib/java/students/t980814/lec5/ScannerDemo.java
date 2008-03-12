package net.azib.java.students.t980814.lec5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * ScannerDemo
 *
 * @author dell
 */
public class ScannerDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter, how many dates you wish to enter: ");
		int n = sc.nextInt();
		
		Date[] dateBuffer = new Date[n];
		String tempStr;
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("et", "EE"));

		df.setLenient(false); // ei luba valesid kuupäevi ja ei teisenda ise õigeks 
		
		for (int i = 0; i < n; i++) {
			try {
				System.out.print("Enter " + (i+1) + ". date (" + ((SimpleDateFormat)df).toPattern() + "): ");
				tempStr = sc.next();
				dateBuffer[i] = df.parse(tempStr);
			}
			catch (Exception e) {
				System.out.println("Not a valid date.");
				i--;
			}
		}
		
		for (int i = 0; i < n; i++)
			System.out.println(dateBuffer[i]);
	}
}
