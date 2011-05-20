package net.azib.java.students.t110013.homework.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Stores all the data about the particular Athlete. In order to be properly used, after instantiation following fields
 * should be set: name, date of birth, country and a list of 10 performance results in the original order of decathlon events.
 * @author Vadim
 */
public class Athlete implements Comparable<Athlete> {
	public static final SimpleDateFormat DEFAULT_DATE_FORMAT = (SimpleDateFormat) DateFormat.getDateInstance();

	private String name;
	private Date dateOfBirth;
	private String country;
	private int totalScore;
	private String place;
	private List<Double> performanceResults = new ArrayList<Double>();

	/**
	 * Athletes are compared according to their total score.
	 * @param anotherAthlete an Athlete to compare with
	 * @return -1, 0, or 1 showing whether the current Athlete has smaller, equal, or greater total score than another Athlete
	 * @throws NullPointerException in case another Athlete is null
	 */
	public int compareTo(Athlete anotherAthlete) {
		return ((Integer) totalScore).compareTo(anotherAthlete.totalScore);
	}

	/**
	 * Two athletes are equal if their total scores are equal.
	 * @param o an Object to compare this Athlete against
	 * @return true if athletes are equal, false if not
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Athlete))
			return false;
		return totalScore == ((Athlete) o).totalScore;
	}

	/**
	 * The hash code for an Athlete is its total score.
	 * @return a hash code value for this Athlete
	 */
	@Override
	public int hashCode() {
		return totalScore;
	}

	/**
	 * Sets a name for this Athlete.
	 * @param name a String representation of the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets a date of birth for this Athlete.
	 * @param dateOfBirth a Date instance
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Sets a country for this Athlete. The country is an ISO 2-letter code, e.g., US.
	 * @param country a String representation of the country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Sets a total score for this Athlete.
	 * @param totalScore an int value of the total score
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	/**
	 * Sets a place in decathlon competition for this Athlete. The place in most cases is just an index in the final
	 * ordered list of athletes, however, if there are two or more athletes with equal score, they are said to share
	 * same places, e.g. three athletes with the same score can share place range 2-4, in case there exists only one
	 * athlete with higher score (place 1).
	 * @param place a String representation of the place
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * Appends the specified performance result to the end of the list of performance results of this Athlete. The
	 * performance result is expected to be either a distance in meters or time in seconds. The method is intended to
	 * be used when the order of results is known to be correct.
	 * @param result a double representation of the performance result
	 */
	public void setPerformanceResult(double result) {
		this.performanceResults.add(result);
	}

	/**
	 * Inserts the specified performance result at the specified position in the list of performance results of this Athlete.
	 * Shifts the performance result currently at that position (if any) and any subsequent performance results to
	 * the right (adds one to their indices). The performance result is expected to be either a distance in meters or
	 * time in seconds. The method is intended to be used when the order of results does not correspond to the original
	 * order of decathlon events.
	 * @param index at which the specified performance result is to be inserted
	 * @param result a double representation of the performance result to be inserted
	 */
	public void setPerformanceResult(int index, double result) {
		this.performanceResults.add(index, result);
	}

	/**
	 * Returns the name of this Athlete.
	 * @return a String representation of the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the date of birth of this Athlete. The date is in the default formatting style for the current locale.
	 * @return a String representation of the Date instance in the default formatting style for the current locale
	 */
	public String getDateOfBirth() {
		return DEFAULT_DATE_FORMAT.format(dateOfBirth);
	}

	/**
	 * Returns the country of this Athlete. The country is an ISO 2-letter code.
	 * @return a String representation of the country code
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Returns the total score of this Athlete.
	 * @return an int value of the total score
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * Returns the place of this Athlete in decathlon competition. The place in most cases is just an index in the final
	 * ordered list of athletes, however, if there are two or more athletes with equal score, they are said to share
	 * same places, e.g. three athletes with the same score can share place range 2-4, in case there exists only one
	 * athlete with higher score (place 1).
	 * @return a String representation of the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Returns the performance result at the specified position in the list of performance results of this Athlete.
	 * @param index of the performance result to return
	 * @return the performance result at the specified position in the list
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	public Double getPerformanceResult(int index) {
		return performanceResults.get(index);
	}
}
