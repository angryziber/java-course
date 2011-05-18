package net.azib.java.students.t092855.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Athlete
 *
 * holds athlete data
 * @author t092855
 */

public class Athlete {
	private String name;
	private Date birthday;
	private String country;
	private DecathlonEvents decathlonEvents;

	/**
	 * Get athlete events
	 *
	 * @return decathlon events
	 */
	public DecathlonEvents getAthleteEvents() {
		return decathlonEvents;
	}

	/**
	 * Set decathlon events
	 *
	 * @param decathlonEvents decathlon events
	 */
	public void setDecathlonEvent(DecathlonEvents decathlonEvents) {
		this.decathlonEvents = decathlonEvents;
	}

	/**
	 * Get athlete name
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set athlete name
	 *
	 * @param name must comply with pattern: forename surname, start with a capital letter, no numbers allowed,
	 * many forenames and surnames are allowed. E.g. Siim Piim, Karl-Filipp Tamm
	 *
	 * @return true if name complies with pattern and name is set, else false
	 */
	public boolean setName(String name) {
		String n1 = "^[\\p{Lu}]{1}\'?[- \\p{L}]+";
		String n2 = "[\\p{Lu}]{1}\'?[- \\p{L}]+$";
		n1 = n1 + " " + n2;

		name = name.trim();
		if (name.matches(n1)) {
			this.name = name;
			return true;
		}
		else {
			this.name = null;
			return false;
		}
	}

	/**
	 * Get athlete birthday
	 *
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Set athlete birthday
	 *
	 * @param birthday must comply with DateFormat.MEDIUM pattern
	 *
	 * @return true if pattern was correct and date was set, else false
	 */
	public boolean setBirthday(String birthday) {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		try {
			this.birthday = dateFormat.parse(birthday);
		} catch (ParseException e) {
			this.birthday = null;
			return false;
		}
		return true;
	}

	/**
	 * Get country code
	 *
	 * @return country code with two capital letters.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Set country code
	 *
	 * @param country must comply to country pattern: two capital letters, e.g. EE
	 *
	 * @return true, if country code complies with pattern and is set, else false
	 */
	public boolean setCountry(String country) {
		String c = "^[A-Z]{2}$";
		if (country.matches(c)) {
			this.country = country;
			return true;
		}
		else {
			this.country = null;
			return false;
		}
	}
}
