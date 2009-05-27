package net.azib.java.students.t030620.homework.beans;

import net.azib.java.students.t030620.homework.enums.Competition;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * DecathletScore
 * bean, containing athlete data and competition scores
 *
 * @author Maksim Konstantinov 030620
 */
public class DecathleteScore {

	private String name;
	private Timestamp date;
	private String countryCode;
	private Map<Competition, Double> scores = new HashMap<Competition, Double>();
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Timestamp getDate() {
		return date;
	}


	public void setDate(Timestamp date) {
		this.date = date;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public Map<Competition, Double> getScores() {
		return scores;
	}


	public void setScores(Map<Competition, Double> scores) {
		this.scores = scores;
	}
	
	

}
