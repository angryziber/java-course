package net.azib.java.students.t030633.homework.model;

import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

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

	public Map<Event, Double> getResults() {
		return results;
	}

	public int getScore() {
		return score;
	}

}
