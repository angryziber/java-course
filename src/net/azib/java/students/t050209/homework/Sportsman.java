package net.azib.java.students.t050209.homework;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Sportsman
 * 
 * Handles sportsman data 
 * @param name  - sportsman name
 * @param dateOfBirth - sportsman's date of birth
 * @param country - sportsman's country
 * @param overallResult - sportsman's final score
 *
 * @author Kaupo Laan
 */
public class Sportsman implements Comparable<Sportsman>{
	
	static Logger LOG = Logger.getLogger(Sportsman.class);
	
	String name = "";
	String dateOfBirth = "";
	String country = "";
	Integer overallResult = 0;

	List<Double> results = new LinkedList<Double>();

	/**
	 * Sets the name of current sportsman
	 */
	public void setSportsmanName(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of current sportsman
	 */
	public String getSportsmanName() {
		return name;
	}

	/**
	 * Sets the date of birth of current sportsman
	 */
	public void setSportsmanDayOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Returns the date of birth of current sportsman
	 */
	public String getSportsmanDayOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the country of current sportsman
	 */
	public void setSportsmanCountry(String counrty) {
		this.country = counrty;
		LOG.debug("Sportsman country is: " + country);
	}

	/**
	 * Returns the country of current sportsman
	 */
	public String getSportsmanCountry() {
		return country;
	}

	/**
	 * Sets the results of current sportsman
	 */
	public void setSportsmanResults(List<Double> results) {
		this.results = results;
	}

	/**
	 * Returns the results of current sportsman
	 */
	public List<Double> getSportsmanResults() {
		return results;
	}

	/**
	 * Calculates the overall result of current sportsman
	 */
	public void calculateAndStoreSportsmanScore() {	
		 {
			int overallResult = 0;			
			
			for (int i = 0; i < 10; i++){
				overallResult = overallResult + 
							DecathlonPoints.values()[i].eventPoints(this.results.get(i));
			}
			this.overallResult = overallResult;
		}
	}

	/**
	 * Returns overall result of current sportsman
	 */
	public int getSportsmanScore() {
		return overallResult;
	}
	
	public int compareTo(Sportsman comp) {
		return overallResult.compareTo(comp.overallResult);
	}
}

