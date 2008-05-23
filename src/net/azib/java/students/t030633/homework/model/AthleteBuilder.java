package net.azib.java.students.t030633.homework.model;

import java.util.Arrays;
import java.util.Date;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

/**
 * Builds athletes.
 *
 * @author t030633
 */
public class AthleteBuilder {

	private String name;
	private Date date;
	private String country;
	private EnumMap<Event, Double> results = new EnumMap<Event, Double>(Event.class);
	
	/**
	 * Sets athlete name.
	 * @param name - String, name for the athlete
	 * @return AthleteBuilder
	 */
	public AthleteBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * Sets athlete birth date.
	 * @param date - Date, birth date for the athlete
	 * @return AthleteBuilder
	 */
	public AthleteBuilder date(Date date) {
		this.date = date;
		return this;
	}
	
	/**
	 * Sets athlete country.
	 * @param country - String, country for the athlete
	 * @return AthleteBuilder
	 */
	public AthleteBuilder country(String country) {
		this.country = checkCountry(country);
		return this;
	}
	
	/**
	 * Adds a result to athlete.
	 * @param event - an event that the athlete participated in
	 * @param performance - performance in the event
	 * @return AthleteBuilder
	 */
	public AthleteBuilder addResult(Event event, Double performance) {
		this.results.put(event, performance);
		return this;
	}
	
	/**
	 * Returns an athlete and resets the builder.
	 * @return Athlete
	 */
	public Athlete build() {
		try { // Return a decathlon athlete
			return new Athlete(name, date, country, results, calculate(results));
		}
		finally { // Reset the builder
			this.results = new EnumMap<Event, Double>(Event.class);
			this.name = null;
			this.date = null;
			this.country = null;
		}
	}
	
	/**
	 * @param country -
	 *            String, country code
	 * @return String - country if valid according to ISO 3166-1 alpha-2, empty
	 *         string if not valid.
	 */
	String checkCountry(String country) {
		if (Arrays.binarySearch(Locale.getISOCountries(), country) > 0)
			return country;
		else
			return "";
	}

	/**
	 * Calculate final score by adding all points from single events.
	 * 
	 * @param results -
	 *            Map, results (event performances)
	 * @return int - integer score calculated from results
	 */
	int calculate(Map<Event, Double> results) {
		int score = 0;
		// iterate over events and add scores
		for (Event e : results.keySet()) {
			score += e.points(results.get(e));
		}
		return score;
	}	
	
}