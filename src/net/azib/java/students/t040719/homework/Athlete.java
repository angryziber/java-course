package net.azib.java.students.t040719.homework;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;


/**
 * Athlete - a class to hold decathlon results of one athlete
 *
 * @version 1.0
 * @author Romi Agar
 * 
 */
public class Athlete implements Comparable<Athlete>{
	private static final Logger LOG = Logger.getLogger(Athlete.class.getSimpleName());
	
	private String name; 
	private Date birthday;
	private String country;

	private int decathlonPoints;
	private float[] results = new float[10];
	
	public Athlete(String name, Date birthday, String country, float ... rawResults) {
		
		this.country = country;
		this.name = name;
		this.birthday = birthday;
		
		if (rawResults.length != 10){
			LOG.severe("Wrong number of raw results!");
			throw new IllegalArgumentException("Wrong number of raw results!");
		}
		results = rawResults;
		calculatePoints();
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
	
	private void calculatePoints(){
		DecathlonConstants event = DecathlonConstants.getOrdinal(0);
		for(float f : results){
			this.decathlonPoints += (int)event.calculateEventPoints(f);
			event = event.next();
		}
	}

	public int compareTo(Athlete o) {
		return o.decathlonPoints - decathlonPoints;
		//return ((Integer)o.decathlonPoints).compareTo(decathlonPoints);
	}
	
}
