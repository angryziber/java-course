package net.azib.java.students.t050545.homework.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * This class contain essential validation methods for checking inputdata
 * 
 * @author libricon
 */
public class DataChecker {
	
	/** Parse string by DataFormat
	 * @param day string
	 * @param df  dateformat
	 * @return birthday from string
	 * @throws ParseException
	 */
	public static Date toParseBirthDay(String day, DateFormat df) throws ParseException {
		String birthDay = day;
		Date birthDate = df.parse(birthDay);
		return birthDate;
	}

	/**
	 * @param birthDay gets string with a date
	 * @return true, if string can be parsed
	 */
	public static  boolean isValidDate(String birthDay, DateFormat df) {

		df.setLenient(false);   // the date should be valid! 

		try {
			df.parse(birthDay);
			return true;
		}
		catch (ParseException ex) {
			return false;
		}

	}

	/** Valid country name contain 2 letters
	 * @param country sportman's
	 * @return if 2 letters, true
	 */
	public boolean isValidCountry(String country) {
		return Pattern.matches("[a-zA-Z][a-zA-Z]", country);
	}

	/** Convert to uppercase
	 * @param country name
	 * @return <code>toUpper()</code>
	 */
	public String addCountry(String input) {
		return input.trim().toUpperCase();
	}

	/** Result should be >0 
	 * @param result
	 * @return <code>(res > 0) ? true:false</code>
	 */
	public boolean isCorrectResult(float result) {
		return (result > 0);
	}

}
