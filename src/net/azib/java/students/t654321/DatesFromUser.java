package net.azib.java.students.t654321;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

/**
 * DatesFromUser
 *
 * @author Karl
 */
public class DatesFromUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Locale locale = new Locale("us","EN");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter number of dates");
			int numberOfDates = sc.nextInt();
			DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,locale); 
			int i = 0;
			while(i < numberOfDates){
				System.out.println("Enter dates nr " + (i + 1));	
				System.out.println(df.parse(sc.next()));
				i++;
			}
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
}	