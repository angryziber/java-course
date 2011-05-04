package net.azib.java.students.t092877.homework;

import java.util.*;

public class Athlete implements Comparable<Athlete> {

	private String name;
	private String dateOfBirth;
	private String countryCode;
	private String place;

	private List<Result> results = new ArrayList<Result>();

	Athlete(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public int getTotalScore() {
		int totalScore = 0;
		for(Result result : results){
			totalScore += result.getScore();
		}
		return totalScore;
	}

	public int compareTo(Athlete other) {
		return other.getTotalScore() - this.getTotalScore();
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPlace() {
		return place;
	}
}
