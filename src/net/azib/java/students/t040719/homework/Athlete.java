package net.azib.java.students.t040719.homework;

import net.azib.java.students.t040719.homework.io.InputParser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


/**
 * Athlete - a class to hold decathlon results of one athlete
 *
 * @version 1.1
 * @author Romi Agar
 */
public class Athlete implements Comparable<Athlete>{
	private static final Logger LOG = Logger.getLogger(Athlete.class.getSimpleName());
	
	private String name; 
	private Date birthday;
	private String country;

	private int decathlonPoints;
	private float[] results;
	
	/**
	 * Constructor for creating Athlete object
	 * @param name string name of the athlete
	 * @param birthday date of birth in date format
	 * @param country string country code in ISO 2-letter format
	 * @param rawResults decathlon result array of 10 events in the format of 0.00f
	 */
	public Athlete(String name, Date birthday, String country, float ... rawResults) {
		
		this.country = country;
		this.name = name;
		this.birthday = birthday;
		
		if (rawResults.length != 10){
			LOG.warning("Wrong number of raw results!");
			this.results = new float[10];
		}else
			this.results = rawResults;
		calculatePoints();
	}
	
	/**
	 * @return returns the name of the athlete
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * @return returns the ISO country code of the athlete
	 */
	public String getCountryCode(){
		return this.country;
	}
	
	/**
	 * @return returns the date of birth of the athlete
	 */
	public String getBirthdayString(){
		return new SimpleDateFormat(InputParser.DATE_FORMAT).format(this.birthday);
	}
	
	/**
	 * @return returns date of birth of the athlete as a date object
	 */
	public Date getBirthday(){
		return this.birthday;
	}
	
	/**
	 * @return returns decathlon results array (float)
	 */
	public float getDecathlonResult(int i){
		if (i<results.length)
			return this.results[i];
		else{
			LOG.warning("Decathlon results array index out of bounds [0..9]");
			return 0.0f;
		}
	}

	/**
	 * @return returns the decathlon points (final score)
	 */
	public int getDecathlonPoints(){
		return this.decathlonPoints;
	}
	
	/**
	 * Calculates decathlon points
	 */
	private void calculatePoints(){
		DecathlonConstants event = DecathlonConstants.getOrdinal(0);
		for(float f : results){
			this.decathlonPoints += (int)event.calculateEventPoints(f);
			event = event.next();
		}
	}

	/**
	 * Compares one athlete to an other by their decathlon points
	 * Needed for sorting
	 */
	public int compareTo(Athlete o) {
		return o.decathlonPoints - decathlonPoints;
	}
	
}
