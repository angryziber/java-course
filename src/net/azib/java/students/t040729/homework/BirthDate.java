package net.azib.java.students.t040729.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * BirthDate
 * Empty date is allowed (e.g. from MySQL 0000-00-00),
 * but malformed date is not allowed and an exception is thrown.
 *
 * @author ValleTon
 */
public class BirthDate {
	private Date birthDate;
	private SimpleDateFormat dateFormat;
	
	/**
	 * @param dateString String which contains a date
	 * @param dateFormatString String which contains the expected date format
	 * @throws Exception If date string cannot be parsed
	 */
	public BirthDate(String dateString, String dateFormatString) throws Exception{

		if ("".equals(dateString)){
			dateString = null;			
		}
		
		try{
			dateFormat = new SimpleDateFormat(dateFormatString);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Given date format string is is invalid.");
		}
		
		try{
			birthDate = dateFormat.parse(dateString);
		}catch (ParseException e) {
			throw new Exception("Cannot parse date string \""+dateString+"\".");
		}catch (NullPointerException e){
			//and date stays null
		}
	}

	/**
	 * @return Formatted string with birth date or empty string
	 * if date was not being set for some reason.
	 */
	@Override
	public String toString() {
		return (birthDate!=null)?(dateFormat.format(birthDate)):"";
	}
	
	/**
	 * @return Date with custom formatting
	 * @throws Exception 
	 */
	public String getCustomDate(String dateFormatString) throws Exception {
		SimpleDateFormat customDateFormat = null;
		try{
			customDateFormat = new SimpleDateFormat(dateFormatString);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Given date format string is is invalid.");
		}
		return (birthDate!=null)?(customDateFormat.format(birthDate)):"";
	}
}
