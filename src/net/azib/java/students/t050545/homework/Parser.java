package net.azib.java.students.t050545.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;


/**
 * Parser
 *
 * @author libricon
 */
public class Parser {
	public static GregorianCalendar toParseBirthDay(String day) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		String birthDay = day;
		GregorianCalendar birthDate = new GregorianCalendar();
		birthDate.setTime(df.parse(birthDay));
		return birthDate;
	}
	
	public static boolean isValidDate(String birthDay){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	    
	    if (birthDay.trim().length() != dateFormat.toPattern().length())
	      return false;

	    dateFormat.setLenient(false);
	    
	    try {
	      dateFormat.parse(birthDay.trim());
	    }
	    catch (ParseException pe) {
	      return false;
	    }
	    return true;
	  }
	
	public static boolean isValidCountry(String country){
		return Pattern.matches("[a-zA-Z][a-zA-Z]",country);
	}
	
	public static String addCountry(String input){
		return input.trim().toUpperCase(); //check, is trim needed
	}
	
	public static void main(String[] args) {
		System.out.println(Parser.isValidDate("29.04.1987"));
		System.out.println(Parser.isValidDate("29.02.1987"));
		System.out.println(Parser.isValidDate("29.02.1986"));
		System.out.println(Parser.isValidDate("29.02.1985"));
		System.out.println(Parser.isValidDate("29.02.1984"));
		System.exit(0);
	}
}
