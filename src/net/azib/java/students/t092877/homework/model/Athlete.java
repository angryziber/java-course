package net.azib.java.students.t092877.homework.model;

import java.util.*;

/**
 *  Athlete.java
 *  Purpose: models the athlete of decathlon competition
 *
 *  @author Artjom Kruglenkov / 092877
 *  @version 1.0 20.05.2011
 */
public class Athlete implements Comparable<Athlete> {

	private String name;                 // full name of an athlete
	private String dateOfBirth;          // date of birth in yyyy-mm-dd format
	private String countryCode;
	private String place;
	private List<Result> results = new ArrayList<Result>();


	/**
	 * Creates a new Athlete instance from a name string.
	 *
	 * @param name athlete's full name
	 */
	public Athlete(String name) {
		this.name = name;
	}

	/**
	 * Creates a new Athlete instance from name, date of birth and country code string.
	 *
	 * @param name athlete's full name
	 * @param dateOfBirth athlete's date of birth
	 * @param countryCode athlete's country code
	 */
	public Athlete(String name, String dateOfBirth, String countryCode) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.countryCode = countryCode;
	}

	/**
	 * Returns the full name of an athlete.
	 *
	 * @return athlete's full name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns athlete's date of birth.
	 *
	 * @return athlete's date of birth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets athlete's date of birth.
	 *
	 * @param dateOfBirth athlete's date of birth
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Returns a 2-letter country code for an athlete.
	 *
	 * @return athlete's 2-letter country code
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Sets 2-letter country code for an athlete.
	 *
	 * @param countryCode - athlete's 2-letter country code
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Returns athlete's place earned in the decathlon competition.
	 *
	 * @return the place earned by an athlete in the competition
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Sets athlete's place earned in the decathlon competition.
	 *
	 * @param place the place earned by an athlete in the competition
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * Returns a list with athlete's raw results for decathlon events.
	 *
	 * @return a list of athlete's raw results for decathlon events
	 */
	public List<Result> getResults() {
		return results;
	}

	/**
	 * Sets a list with athlete's raw results for decathlon events.
	 *
	 * @param results a list of athlete's raw results for decathlon events
	 */
	public void setResults(List<Result> results) {
		this.results = results;
	}

	/**
	 * Returns a total score of an athlete for decathlon events.
	 *
	 * @return athlete's total score in decathlon competition
	 */
	public int getTotalScore() {
		int totalScore = 0;
		for(Result result : results){
			totalScore += result.getScore();
		}
		return totalScore;
	}

	/**
	 * Compares this Athlete with specified Athlete for order.
	 *
	 * @param other the Athlete to be compared
	 * @return a positive integer, zero, or negative integer as this Athlete is less than, equal to, or greater than specified Athlete
	 */
	public int compareTo(Athlete other) {
		return other.getTotalScore() - this.getTotalScore();
	}
}