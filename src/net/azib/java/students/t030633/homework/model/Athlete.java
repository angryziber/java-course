package net.azib.java.students.t030633.homework.model;

import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

/**
 * Athlete participating in a competition.
 * 
 * @author t030633
 */
public class Athlete implements Comparable<Athlete> {

	private String name;
	private Date birthDate;
	private String country;
	private EnumMap<Event, Double> results;
	private int score;

	
	/**
	 * Construct an athlete with given parameters.
	 * @param name
	 * @param date
	 * @param country
	 * @param results
	 * @param score
	 */
	Athlete(String name, Date date, String country, EnumMap<Event, Double> results, int score) {
		this.name = name;
		this.birthDate = date;
		this.country = country;
		this.results = results;
		this.score = score;
	}
	
	/**
	 * Athletes are compared according to their score.
	 * 
	 * @param anotherAthlete
	 *            an Athlete to compare with
	 * @return negative, zero, or positive showing whether the current Athlete
	 *         is greater, equal, or weaker than anotherAthlete
	 * @throws NullPointerException
	 *             in case anotherAthlete is null
	 */
	public int compareTo(Athlete anotherAthlete) {
		return anotherAthlete.getScore() - score;
	}
	
	/**
	 * @return String - name of Athlete.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return Date - birth date of Athlete.
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @return String - country code that the Athlete represents in ISO 3166-1
	 *         alpha-2 standard. Empty string if not available.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return Map - competition results in a Map collection.
	 */
	public Map<Event, Double> getResults() {
		return results;
	}

	/**
	 * @return Integer - score calculated from performance(s).
	 */
	public int getScore() {
		return score;
	}

}