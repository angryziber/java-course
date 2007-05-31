package net.azib.java.students.t960644.homework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Competition
 * 
 * @author Lembit
 */
public class Competition {
	private String countryCode;
	private Date date;
	private String description;
	private Integer id;
	private List<Athlete> athletes;
	private List<Result> results;

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
	 * @param countryCode
	 *            the countryCode to set
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
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
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
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the athletes
	 */
	/**
	 * @return the athletes
	 */
	public List<Athlete> getAthletes() {
		return athletes;
	}

	/**
	 * @param athlete
	 *            the athletes to add
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
	 * @param result
	 *            the result to add
	 */
	public void addResult(Result result) {
		results.add(result);
	}

	/**
	 * 
	 * @param id
	 *            Athlete's id
	 * @return when nothing was found then null otherwise Athlete
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

	/**
	 * 
	 * @param name name to compare
	 * @param born date of birth to compare
	 * @param countryCode country code to compare
	 * @return if nothing found then null else Athlete
	 */
	public Athlete findAthleteByName(String name, Date born, String countryCode) {
		Athlete result = null;
		for (Athlete a : athletes) {
			if (a.getName().equals(name) & a.getBorn().equals(born) & a.getCountryCode().equals(countryCode)) {
				result = a;
			}
		}
		return result;
	}
}
