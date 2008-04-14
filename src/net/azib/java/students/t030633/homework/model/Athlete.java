package net.azib.java.students.t030633.homework.model;

import java.util.Date;
import java.util.EnumMap;

/**
 * Athlete interface.
 *
 * @author t030633
 */
public interface Athlete extends Comparable<Athlete> {

	/**
	 * Athletes are compared according to their score.
	 * 
	 * @param anotherAthlete
	 *            an Athlete to compare with
	 * @return -1, 0, or 1 showing whether the current Athlete is smaller,
	 *         equal, or greater than anotherAthlete
	 * @throws NullPointerException
	 *             in case anotherAthlete is null
	 */
	public abstract int compareTo(Athlete anotherAthlete);

	public abstract String getName();

	public abstract Date getBirthDate();

	public abstract String getCountry();

	public abstract EnumMap<Event, Double> getResults();

	public abstract int getScore();

}