package net.azib.java.students.t030682.homework;

import java.util.regex.*;

/**
 * DataChecker
 * 
 * @author aplotn
 */
public class DataChecker {

	public boolean checkName(String name) {
		return (Pattern.compile("[A-Z][a-z]+(\\s[A-Z][a-z]+)+").matcher(name).matches());
	}

	public boolean checkCountry(String country) {
		return (Pattern.compile("[A-Z][A-Z]").matcher(country).matches());
	}

	public boolean checkDateOfBirth(String date) {
		return (Pattern.compile("[0-3]?[0-9].[0-1]?[0-9].[1-2][0-9][0-9][0-9]").matcher(date).matches());
	}

	public boolean checkTimeOrDistance(String decimal) {
		return (Pattern.compile("[0-9]+.?[0-9]?[0-9]?").matcher(decimal).matches());
	};

	public String checkMinutesAndConvertToSeconds(String res){
		if (res.indexOf(':')!=-1) {
		String[] splitted = res.split(":");
		res = Double.toString(60*Double.parseDouble(splitted[0])+Double.parseDouble(splitted[1]));
		}
		return res;
	}
	
	public boolean checkStringRecord(String checking){
		
		
		return true;
		
	}
	
	public static void main(String[] args) {
		DataChecker check = new DataChecker();
		System.out.println(check.checkName("John John"));
		System.out.println(check.checkCountry("EE"));
		System.out.println(check.checkDateOfBirth("07.06.1985"));
		System.out.println(check.checkTimeOrDistance("65.04"));
		System.out.println(check.checkMinutesAndConvertToSeconds("2:38.32"));

	}

}
