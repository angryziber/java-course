package net.azib.java.students.t040750.homework.parser;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Scanner;

/**
 * {@link Helper} class providing various helper methods for parsing
 *
 * @author Karpz
 */
public class Helper {
	
	/**
	 * Check if country code is valid
	 * 
	 * @param country - country code
	 * @return true if ISO3 country code exists for the provided string
	 */
	public static boolean isValidCountry(String country) {
		try {
			new Locale("", country).getISO3Country();
			return true;
		}
		catch (MissingResourceException e) {
			return false;
		}
	}
	
	/**
	 * Display start message when parsing console input
	 */
	public static void displayCMDParseStartMessage() {
		System.out.println("Enter competition values, each on a separate line in the following order:");
		System.out.println("Name,Birthday,Nationality,100m,Long jump,Shot put,High jump," +
				"400m,110m h,Discus,Pole vault,Javelin,1500m\n");
	}
	
	/**
	 * Load the user response to a Y/N question
	 *  
	 * @param input - input source
	 * @param msg - message to be repeated on non-valid response
	 * @return - user response
	 */
	public static String loadResponce(Scanner input, String msg) {
		while (true) {
			try {
				System.out.println(msg);
				return input.next("[nyNY]\\r");
			}
			catch (InputMismatchException ie) {
				input.next();
			}
		}
	}
}
