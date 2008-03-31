package net.azib.java.students.t030633.homework;

import java.util.Date;
import java.util.Map;

/**
 * Athlete
 * 
 * @author t030633
 */
public class Athlete {

	private String name;
	private Date birthDate;
	private String country;
	private Map<Event, Double> results;
	private int score;

	Athlete(String name, Date date, String country, Map<Event, Double> results) {

		this.name = name;
		this.birthDate = date;
		this.country = country; //TODO check if country exists
		// try to create a locale?
		this.results = results; //TODO check for correctness?

		// iterate through events and calculate score
		for (Event e : Event.values()) {
			if (results.containsKey(e))
				score += e.points(results.get(e));
		}

	}

	// Access methods
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
