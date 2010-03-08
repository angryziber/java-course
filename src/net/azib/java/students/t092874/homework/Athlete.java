package net.azib.java.students.t092874.homework;

import java.util.Date;

/**
 * Athlete
 * 
 * @author Aleksandr Gladki
 */
class Athlete {
	private String name;
	private Date birthday;
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
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthDate to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
