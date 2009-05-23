package net.azib.java.students.t050545.homework.loaders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * Parser
 * 
 * @author libricon
 */
public class DataChecker {
	/**
	 * @param day String with date in format "dd.MM.yyyy"
	 * @return the same gregorian calendar
	 * @throws ParseException in case problems with parsing, generate parse error
	 */
	public GregorianCalendar toParseBirthDay(String day) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		String birthDay = day;
		GregorianCalendar birthDate = new GregorianCalendar();
		birthDate.setTime(df.parse(birthDay));
		return birthDate;
	}

	/**
	 * Method check string, is string a date in format "dd.MM.yyyy"
	 * 
	 * @param birthDay gets string with a date
	 * @return true, if string can be parsed
	 */
	public boolean isValidDate(String birthDay) {

		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");

		/*
		 * if (birthDay.trim().length() != df.toPattern().length()){
		 * System.out.println("lenght is wrong"); return false; }
		 */

		df.setLenient(false);

		try {
			df.parse(birthDay);
			return true;
		}
		catch (ParseException ex) {
			return false;
		}

	}

	/**
	 * Method checkes string, if a coutry, strign chould be 2 characters
	 * 
	 * @param country sportman's country in competition
	 * @return true, if string contain 2 letters
	 */
	public boolean isValidCountry(String country) {
		return Pattern.matches("[a-zA-Z][a-zA-Z]", country);
	}

	/**
	 * Method return country in UPPER case
	 * 
	 * @param input country name
	 * @return country in UPPER case
	 */
	public String addCountry(String input) {
		return input.trim().toUpperCase(); // check, is trim needed
	}

	/** Method check result 
	 * @param result
	 * @return true if value > 0
	 */
	public boolean isCorrectResult(float result) {
		return (result > 0);
	}

	/**
	 * Main function
	 * 
	 * @param args comman arguments
	 */
	public static void main(String[] args) {
		DataChecker datachecker = new DataChecker();
		System.out.println(datachecker.isValidDate("29.04.1987"));
		System.out.println(datachecker.isValidDate("01.01.1984"));
		System.out.println(datachecker.isValidDate("29.02.1986"));
		System.out.println(datachecker.isValidDate("29.02.1985"));
		System.out.println(datachecker.isValidDate("29.02.1984"));
		System.out.println(datachecker.isCorrectResult(5f));
		System.exit(0);
	}
}
