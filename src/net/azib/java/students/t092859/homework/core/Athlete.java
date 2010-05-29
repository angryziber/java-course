package net.azib.java.students.t092859.homework.core;

import java.util.Date;
import java.util.Locale;

/**
 * Athlete
 *
 * @author konstantin
 */
public class Athlete {
	private String name;
	private Date birthday;
	private Locale countryLocale;
	
	/**
	 * Athlete constructor
	 * @param name - Name of athlete
	 * @param birthday - Date of birth of athlete
	 * @param countryLocale - Locale of athlete country (with language
	 * if it matched provided date of birth)
	 */
	public Athlete(String name, Date birthday, Locale countryLocale) {
		this.name = name;
		this.birthday = birthday;
		this.countryLocale = countryLocale;
	}

	/**
	 * @return Name of athlete
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Date of birth of athlete
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @return Locale for athlete country which
	 * has matched to athlete date of birth format
	 */
	public Locale getCountryLocale() {
		return countryLocale;
	}
}
