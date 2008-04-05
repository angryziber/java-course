package net.azib.java.students.t040719.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;


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
	private static final String REGEX = "([1-9]+:|)([0-5]|)[0-9]\\.[0-9]{2}";
	private static final String SPLIT = ":";
	
	//Results 
	/*
	private float hundredMeterSprint;
	private float longJump;
	private float shotPut;
	private float highJump;
	private float fourHundredMeterSprint;	//In seconds
	private float hundredAndTenMeterHurdles;
	private float discusThrow;
	private float poleVault;
	private float javelinThrow;
	private float fifteenHundredMeterRace; //In seconds	*/
	private int decathlonPoints;
	private float[] results = new float[10];
	
	public Athlete(String name, String birthday, String country, String ... rawResults) {
		if (!isValidName(name))
			throw new IllegalArgumentException("Name is not valid!");
		if (!ISOCountry.isValidCountryCode(country))
			throw new IllegalArgumentException("Country code is not valid!");

		this.country = country;
		this.name = name;
		
		try {
			this.birthday = parseDateString(birthday);
		}
		catch (Exception e) {
			throw new IllegalArgumentException("Birthday date is not valid!");
		}
		if (rawResults.length != 10)
			throw new IllegalArgumentException("Wrong number of raw results!");
		//this.hundredMeterSprint = Float.valueOf(rawResults[0]);
		for(int i=0; i<10; i++){
			if (i==4 || i==9)
				if(!rawResults[i].matches(REGEX))
					throw new IllegalArgumentException("110 m hurdles parameter in wrong format!");
				else
					this.results[i] = parseLongTime(rawResults[i]);
			else
				this.results[i] = Float.parseFloat(rawResults[i]);
		}
		/*
		try {
			this.hundredMeterSprint = Float.parseFloat(rawResults[0]);
			this.longJump = Float.parseFloat(rawResults[1]);			
			this.shotPut = Float.parseFloat(rawResults[2]);			
			this.highJump = Float.parseFloat(rawResults[3]);			
			if(!rawResults[4].matches(REGEX))
				throw new IllegalArgumentException("110 m hurdles parameter in wrong format!");
			this.fourHundredMeterSprint = parseLongTime(rawResults[4]);
			this.hundredAndTenMeterHurdles = Float.parseFloat(rawResults[5]);			
			this.discusThrow = Float.parseFloat(rawResults[6]);			
			this.poleVault = Float.parseFloat(rawResults[7]);			
			this.javelinThrow = Float.parseFloat(rawResults[8]);			
			if(!rawResults[9].matches(REGEX))
				throw new IllegalArgumentException("1500 m race in wrong format!");
			this.fifteenHundredMeterRace = parseLongTime(rawResults[9]);			
		}catch(NumberFormatException e){
			throw new NumberFormatException();
		}*/
		calculatePoints();
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
		return ISOCountry.getCountryName(this.country);
	}
	
	public String getBirthdayString(){
		Locale locale = new Locale(System.getProperty("user.language"));
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		return df.format(this.birthday);
	}
	
	public Date getBirthday(){
		return this.birthday;
	}

	public int getDecathlonPoints(){
		return this.decathlonPoints;
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
	
	private float parseLongTime(String time){
		float resultTime = 0;
		Pattern p = Pattern.compile(SPLIT);
        String[] items = p.split(time);
        if (items.length == 1)
        	resultTime = Float.parseFloat(items[0]);
        else{
        	resultTime = Float.parseFloat(items[0])*60;
        	resultTime += Float.parseFloat(items[1]);
        }
		return resultTime;
	}
	
	private void calculatePoints(){
		DecathlonConstants event = DecathlonConstants.getOrdinal(0);
		for(float f : results){
			this.decathlonPoints += (int)event.calculateEventPoints(f);
			event = event.next();
		}
	}
	
}
