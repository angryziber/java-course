package net.azib.java.students.t030633.homework.model;

import java.util.Date;
import java.util.Map;

/**
 * Athlete participating in a competition.
 *
 * @author t030633
 */
public interface Athlete extends Comparable<Athlete> {

	/**
	 * Athletes are compared according to their score.
	 * 
	 * @param anotherAthlete
	 *            an Athlete to compare with
	 * @return negative, zero, or positive showing whether the current Athlete is greater,
	 *         equal, or weaker than anotherAthlete
	 * @throws NullPointerException
	 *             in case anotherAthlete is null
	 */
	public int compareTo(Athlete anotherAthlete);

	public String getName();

	public Date getBirthDate();

	public String getCountry();

	/**
	 * @return Map - competition results in a Map collection
	 */
	public Map<Event, Double> getResults();

	/**
	 * @return Integer - score calculated from performance(s)
	 */
	public int getScore();

}