package net.azib.java.students.t011861.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * DataControl
 *
 * @author 011861
 */

public class DataControl {
	/**
	 * Read data from console.
	 * @param String comment - Recommendation to the client)
	 */
	static public String readConsole(String command) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String readAgain = "";
		System.out.println(command);
		try {
			readAgain = in.readLine();
			return readAgain;
		} catch (IOException e) {
			System.out.println("Problems with console! " + e);
		}
		return readAgain;
	}
	/**
	 * Checks date correctness. Asks correct date, if incorrect date is
	 * entered.
	 * @param String date - date of birth as string (example "yyyy-MM-dd")
	 */
	public String checkDate(String date) {
		boolean check = false;
		do {
			try {
				checkDateCorrectness(date);
				check = false;
			} catch (ParseException e) {
				System.out.println("Athlete's date of birth " + date+ " is not correct! " + e);
				date = DataControl.readConsole("Insert correct date example ('yyyy-MM-dd')! ");
				check = true;
			}
		} while (check);
		return date;
	}
	/**
	 * Checks date correctness
	 * @param String string - date as string
	 * @throws ParseException if date is not correct
	 */
	private void checkDateCorrectness(String string) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		String[] splitedDate = string.split("\\-");
		Integer day = Integer.valueOf((splitedDate[2]));
		Integer month = Integer.valueOf((splitedDate[1]));
		Integer year = Integer.valueOf((splitedDate[0]));
		if (year < 1900 || year > 2000) {
			throw new ParseException("Year is unreliable!",0);
		}
		if (month < 1 || month > 12) {
			throw new ParseException("Check the month!",0);
		}
		if (day < 0 || day > 31) {
			throw new ParseException("Check the day!",0);
		}
	}
	/**
	 * Checks if result is negative.
	 * @param String result - result as string.
	 */
	public boolean isNegativeCheck(String result) {
		Double d = Double.parseDouble(result);
		boolean neg = false;
		if (d < 0) 
		{
			neg = true;
			System.out.println("Result can not be negative");
		}
		return neg;
	}
}