package net.azib.java.students.t030633.homework.Model;

import java.util.Date;
import java.util.EnumMap;

/**
 * An athlete participating in a decathlon competition.
 * 
 * @author t030633
 */
public final class DecathlonAthlete implements Athlete {

	private String name;
	private Date birthDate;
	private String country;
	private EnumMap<Event, Double> results;
	private int score;

	DecathlonAthlete(String name, Date date, String country, EnumMap<Event, Double> results, int score) {
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
	 * @return -1, 0, or 1 showing whether the current Athlete is smaller,
	 *         equal, or greater than anotherAthlete
	 * @throws NullPointerException
	 *             in case anotherAthlete is null
	 */
	public int compareTo(Athlete anotherAthlete) {
		return score - anotherAthlete.getScore();
	}

	public String getName() {
		return name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getCountry() {
		return country;
	}

	public EnumMap<Event, Double> getResults() {
		return results;
	}

	public int getScore() {
		return score;
	}

}
