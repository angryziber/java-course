package net.azib.java.students.t030520.homework.sportsman;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Object represents the sportsman's data and results at the competition.
 *
 * @author t030520
 */
public class SportsmanWithResults {

	/** name of the sportsman */
	private String name;

	/** birthDate of the sportsman */
	private Date birthDate;

	/** countryCode of the sportsman */
	private String countryCode;

	/** a list of all event results for the sportsman */
	private List<EventResult> results;

	/** place in the competition */
	private String place;

	/** points in the competition */
	private int points;

	/**
	 * Main constructor.
	 */
	public SportsmanWithResults() {
		this.results = new ArrayList<EventResult>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	 * @return the results
	 */
	public List<EventResult> getResults() {
		return results;
	}

	/**
	 * @return the number of points scored by the sportsman.
	 */
	public int getPoints() {
		return this.points;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(List<EventResult> results) {
		this.results = results;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}
}
