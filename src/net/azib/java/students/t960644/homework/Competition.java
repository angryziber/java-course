package net.azib.java.students.t960644.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Competition
 * 
 * A class for holding athletes and performance results of a single competition.
 */
public class Competition {
	private String countryCode;
	private Date date;
	private String description;
	private Integer id;
	private List<Athlete> athletes;
	private List<Result> results;
	protected final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

	public Competition() {
		athletes = new ArrayList<Athlete>();
		results = new ArrayList<Result>();
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Get formatted date
	 * @return date formatted as dd.MM.yyyy
	 */
	public String getStringDate() {
		if (date == null) {
			return "";
		}
		else {
			return DATE_FORMAT.format(date);
		}
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Set date by formatted string
	 * @param date
	 *            in format dd.MM.yyyy
	 * @throws ParseException
	 */
	public void setDate(String date) throws ParseException {
		this.date = DATE_FORMAT.parse(date);
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the competition id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the athletes
	 */
	public List<Athlete> getAthletes() {
		return athletes;
	}

	/**
	 * @param athlete the athlete to add
	 */
	public void addAthlete(Athlete athlete) {
		athletes.add(athlete);
	}

	/**
	 * @return the results
	 */
	public List<Result> getResults() {
		return results;
	}

	/**
	 * @param result the result to add
	 */
	public void addResult(Result result) {
		results.add(result);
	}

	/**
	 * Lookup athlete by id
	 * @param id athlete's id
	 * @return null when nothing found otherwise athlete
	 */

	public Athlete findAthleteById(int id) {
		Athlete result = null;
		for (Athlete a : athletes) {
			if (a.getId() == id) {
				result = a;
			}

		}
		return result;
	}
/*
	/**
	 * Lookup athlete by name, birthdate and country code. Planned to use this method for searching for duplicate athletes but that was never implemented.
	 * @param name name to compare
	 * @param born date of birth to compare
	 * @param countryCode country code to compare
	 * @return null when nothing found otherwise athlete
	 *
	public Athlete findAthleteByName(String name, Date born, String countryCode) {
		Athlete result = null;
		for (Athlete a : athletes) {
			if (a.getName().equals(name) & a.getBorn().equals(born) & a.getCountryCode().equals(countryCode)) {
				result = a;
			}
		}
		return result;
	} */
	
	/**
	 * Sorts list of results and assigns positions to each result.
	 *
	 */
	public void sortResults() {
		Collections.sort(results);
		Result result;
		for (int i = 0; i < results.size(); i++) {
			result = results.get(i);
			if (i > 0 && result.compareTo(results.get(i - 1)) == 0) {
				result.setPosition(results.get(i - 1).getPosition());
			}
			else {
				result.setPosition(Integer.toString(i + 1));
			}
		}
		for (int i = results.size() - 1; i >= 0; i--) {
			result = results.get(i);
			if (i < results.size() - 1 && result.compareTo(results.get(i + 1)) == 0) {
				result.setPosition(results.get(i + 1).getPosition());
			}
			else if (Integer.parseInt(result.getPosition()) != i + 1) {
				result.setPosition(result.getPosition() + "-" + Integer.toString(i + 1));
			}
		}
	}
}
