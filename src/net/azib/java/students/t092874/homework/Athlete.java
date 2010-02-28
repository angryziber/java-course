package net.azib.java.students.t092874.homework;

import java.util.Date;

/**
 * Athlete
 * 
 * @author Aleksandr Gladki
 */
class Athlete {
	private String name;
	private Date birthDate;
	private String CountryCode;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return CountryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
}
