package net.azib.java.students.t030633.homework.view.in.hibernate.competitions;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * HibCompetition
 *
 * @author t030633
 */
public class HibCompetition {

	@SuppressWarnings("unchecked") // Hibernate doesn't have generics
	private Set results = new HashSet();
	
	private int id;
	private String country_code;
	private Date date;
	private String name;
	private String location;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	@SuppressWarnings("unused") // Only Hibernate will assign identifiers when an object is saved.
	private void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the country_code
	 */
	public String getCountry_code() {
		return country_code;
	}
	/**
	 * @param country_code the country_code to set
	 */
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the results
	 */
	@SuppressWarnings("unchecked") // Hibernate doesn't have generics
	public Set getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	@SuppressWarnings("unchecked") // Hibernate doesn't have generics
	public void setResults(Set results) {
		this.results = results;
	}
	
}
