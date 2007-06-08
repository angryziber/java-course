package net.azib.java.students.t960644.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Athlete
 * 
 * A class for storing information about a single athlete.
 */
public class Athlete {
	private String name;
	private Date born;
	private String countryCode;
	private Integer id;
	protected final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

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
	 * @return date of birth
	 */
	public Date getBorn() {
		return born;
	}

	/**
	 * @param born the date of birth to set
	 */
	public void setBorn(Date born) {
		this.born = born;
	}
	/**
	 * Get date formatted as String
	 * @return Date formatted as dd.MM.yyyy
	 */
	public String getBirthDate() {
		if (born == null) {
			return "";
		}
		else {
			return DATE_FORMAT.format(born);
		}

	}
	
	/**
	 * Set date as String
	 * @param birthdate String in the format dd.MM.yyyy
	 * @throws ParseException
	 */
	public void setBirthDate(String birthdate) throws ParseException {
		setBorn(DATE_FORMAT.parse(birthdate));
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

}
