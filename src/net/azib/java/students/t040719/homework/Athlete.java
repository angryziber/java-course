package net.azib.java.students.t040719.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Athlete
 *
 * @author romi
 */
public class Athlete {
	private static final String DATE_FORMAT = "dd.MM.yyyy"; 
	private String name; 
	private Date birthday;
	private String country;
	/*
	//Results 
	private float hundredMeterSprint;
	private float longJump;
	private float shotPut;
	private float highJump;
	private float fourHundredMeterSprint;	//In seconds
	private float hundredAndTenMeterHurdles;
	private float discusThrow;
	private float poleVault;
	private float javelinThrow;
	private float fifteenHundredMeterRace; //In seconds	
	*/
	public Athlete(String name, String birthday, String country, float[] rawResults) {
		if (!isValidName(name))
			throw new IllegalArgumentException("Name is not valid!");
		if (!Country.isValidCountryCode(country))
			throw new IllegalArgumentException("Country code is not valid!");

		this.country = country;
		this.name = name;
		
		try {
			this.birthday = parseDateString(birthday);
		}
		catch (Exception e) {
			throw new IllegalArgumentException("Birthday date is not valid!");
		}
	}
	
	public static boolean isValidName(String name){
		return name.matches("\\w+ \\w+.*");
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getCountryCode(){
		return this.country;
	}
	
	public String getCountryName(){
		return Country.getCountryName(this.country);
	}
	
	public String getBirthdayString(){
		Locale locale = new Locale(System.getProperty("user.language"));
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		return df.format(this.birthday);
	}
	
	public Date getBirthday(){
		return this.birthday;
	}

	
	private Date parseDateString(String dateString) throws Exception{
		//Locale locale = new Locale(System.getProperty("user.language"));
		//DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		Date d = null;
		try {
			d = new SimpleDateFormat(DATE_FORMAT).parse(dateString);
		}
		catch (ParseException e) {
			System.err.println("Error parsing date");
			throw new Exception();
		}
		return d;
	}
}
