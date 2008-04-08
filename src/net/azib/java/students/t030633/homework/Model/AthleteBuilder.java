package net.azib.java.students.t030633.homework.Model;

import java.util.Arrays;
import java.util.Date;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

/**
 * AthleteBuilder creates an instance of Athlete.
 * 
 * @author t030633
 */
public class AthleteBuilder {

	//TODO extract calculator and checker to separate classes?
	
	private String name;
	private Date date;
	private String country;
	private Map<Event, Double> results;

	public AthleteBuilder name(String name) {
		this.name = name;
		return this;
	}

	public AthleteBuilder date(Date date) {
		this.date = date;
		return this;
	}

	public AthleteBuilder country(String country) {
		this.country = country;
		return this;
	}

	public AthleteBuilder results(Map<Event, Double> results) {
		this.results = results;
		return this;
	}

	public Athlete build() {
		name = checkName(name);
		date = checkDate(date);
		country = checkCountry(country);
		results = checkResults(results);
		return new Athlete(name, date, country, results, calculateScore(results));
	}

	private String checkName(String name) {
		if (name == null)
			return "";
		else
			return name;
	}

	private Date checkDate(Date date) {
		if (date == null)
			return new Date();
		else
			return date;
	}

	private String checkCountry(String country) {
		if (country == null) return "";
		else if (Arrays.binarySearch(Locale.getISOCountries(), country) > 0)
			return country;
		else
			return "";
	}

	private Map<Event, Double> checkResults(Map<Event, Double> results) {
		if (results == null)
			return new EnumMap<Event, Double>(Event.class);
		else {
			for (Event e : results.keySet()) {
				Double result = results.get(e);
				switch (e) {
				case DISCUS: if (result > 100D) results.remove(e); break;
				case HIGH: if (result > 4D)	results.remove(e); break;
				case JAVELIN: if (result > 150D) results.remove(e);	break;
				case LONG: if (result > 15D) results.remove(e);	break;
				case POLE: if (result > 15D) results.remove(e);	break;
				case R100M:	if (result < 6D) results.remove(e);	break;
				case R110MH: if (result < 6D) results.remove(e); break;
				case R1500M: if (result < 150D)	results.remove(e); break;
				case R400M:	if (result < 30D) results.remove(e); break;
				case SHOT: if (result > 30D) results.remove(e);	break;
				}
			}
			return results;
		}
	}

	private int calculateScore(Map<Event, Double> results) {
		int score = 0;
		// iterate through events and calculate score
		for (Event e : Event.values()) {
			if (results.containsKey(e)) {
				score += e.points(results.get(e));
			}
		}
		return score;
	}

}
