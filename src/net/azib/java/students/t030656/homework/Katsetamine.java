package net.azib.java.students.t030656.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 * Katsetamine
 *
 * @author Sprot
 */
public class Katsetamine {
	public static void main(String[] args) {
		String s = "34:56.60";
        DateFormat df = new SimpleDateFormat("mm:ss.SS");
        Calendar cal = Calendar.getInstance(Locale.US);
        df.setLenient(false);
        
        try {
			cal.setTime(df.parse(s));
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		double a = cal.get(Calendar.MINUTE) * 60 + 
					cal.get(Calendar.SECOND) + 
					(double)cal.get(Calendar.MILLISECOND)/100;
		System.out.println(a);
		
		Scanner kbdIn = new Scanner(System.in);    //Instantiating a new Scanner object
		System.out.print("Enter your name: ");          //Printing out the prompt
		String name = kbdIn.nextLine();         //Reading a line of input (until the user hits enter) from the keyboard and putting it in a String variable called name
		System.out.println("Welcome, " + name); //Printing out welcome, followed by the user's name
	}
}
