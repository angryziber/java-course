package net.azib.java.students.t010588.homework;

import java.util.Date;

/**
 * Basic athlete class holding common athlete information, competition results
 * and final standings.
 *
 * @author Vjatseslav Rosin, 010588
 *
 */
public class Athlete {

	private String name;

	private Date birhday;

	private char[] country;

	private int firstPlace;

	private int lastPlace;

	private Result[] results;

	private int score;

	/**
	 * @return the top place athlete holds (in a case of shared place)
	 */
	public int getFirstPlace() {
		return firstPlace;
	}

	/**
	 * @param firstPlace
	 *            top place athlete holds (in a case of shared place)
	 */
	public void setFirstPlace(int firstPlace) {
		this.firstPlace = firstPlace;
	}

	/**
	 * @return the bottom place athlete holds (in a case of shared place)
	 */
	public int getLastPlace() {
		return lastPlace;
	}

	/**
	 * @param lastPlace
	 *            the bottom place athlete holds (in a case of shared place)
	 */
	public void setLastPlace(int lastPlace) {
		this.lastPlace = lastPlace;
	}

	/**
	 * @return athlete name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            of athlete
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return athlete birthday
	 */
	public Date getBirhday() {
		return birhday;
	}

	/**
	 * @param birhday
	 *            of athlete
	 */
	public void setBirhday(Date birhday) {
		this.birhday = birhday;
	}

	/**
	 * @return athlete country code
	 */
	public char[] getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            code of athlete
	 */
	public void setCountry(char[] country) {
		this.country = country;
	}

	/**
	 * @return array of athlete results
	 */
	public Result[] getResults() {
		return results;
	}

	/**
	 * @param results
	 *            array of athlete
	 */
	public void setResults(Result[] results) {
		this.results = results;
	}

	/**
	 * @return athlete total score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            of athlete
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
