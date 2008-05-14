package net.azib.java.students.t030633.homework.view.in.hibernate.athletes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Hibernate Athlete
 *
 * @author t030633
 */
public class HibAthlete {
	
	@SuppressWarnings("unchecked") // Hibernate doesn't have generics
	private Set results = new HashSet();
	
	private int id;
	private String name;
	private Date dob;
	private String country;
	
	public HibAthlete() {}
	
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
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
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
