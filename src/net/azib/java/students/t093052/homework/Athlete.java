package net.azib.java.students.t093052.homework;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Athlete class holds the data during the program
 * */
public class Athlete {
	private String name;
	private String dateOfBirth;
	private String country;
	private Map<CompetitionType, String> results = 
		new LinkedHashMap<CompetitionType, String>();
	private Double points = 0.0;
	
	/**
	 * @return the name of the athlete
	 * */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name.trim();
	}
	/**
	 * @return the birthday of the athlete
	 * */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the date of birth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth.trim();
	}
	/**
	 * @return the country of the athlete
	 * */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country.trim();
	}
	/**
	 * @return a map of all event results for the athlete
	 * */
	public Map<CompetitionType, String> getResults() {
		return results;
	}
	/**
	 * @param type the type of the competition to set
	 * @param result the result of the competition to set
	 */
	public void addResult(CompetitionType type, String result) {
		this.results.put(type, result.trim());
		points += type.calculatePoints(result);
	}
	/**
	 * @return the points in the competition
	 * */
	public Double getPoints() {
		return points;
	}
	/**
	 * @return the array of strings with all fields except results
	 * */
	public String[] getMainValues() {
		return new String[] { asString(getPoints()), asString(getName()), 
				asString(getDateOfBirth()), asString(getCountry())}; 
	}
	
	private String asString(Object value) {
		return String.valueOf(value);
	}
}
