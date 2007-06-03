package net.azib.java.students.t060401.homework.decathlon;

import net.azib.java.students.t060401.homework.util.Utils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Athlete
 * 
 * Holds data of an athlete like athlete's name, birth date, country and
 * decathlon result of a competition.
 * 
 * @author t060401
 */
public class Athlete implements Comparable {

	Logger log = Logger.getLogger(Athlete.class.getName());

	private long id;
	private String name = null;
	private Date birthTime = null;
	private String country = Locale.getISOCountries()[0];
	private DecathlonResults decathlonResults = new DecathlonResults();

	public Athlete() {
	}

	/**
	 * Initializes Athlete object with athlete's name, birth date and country.
	 * 
	 * @param name
	 * @param birthDate
	 * @param country
	 * @throws IllegalArgumentException
	 */
	public Athlete(String name, String birthDate, String country) throws IllegalArgumentException {
		setName(name);
		setCountry(country);
		setBirthTime(birthDate);
	}

	/**
	 * @param results
	 *            decathlon results object
	 * @throws IllegalArgumentException
	 */
	public void setDecathlonResults(DecathlonResults results) throws IllegalArgumentException {
		this.decathlonResults = results;
	}

	/**
	 * @return returns athlete's decathlon results
	 */
	public DecathlonResults getDecathlonResults() {
		return this.decathlonResults;
	}

	/**
	 * @return the birthTime
	 */
	public Date getBirthTime() {
		return birthTime;
	}

	/**
	 * @param birthDate
	 *            athlete's birth date
	 * @throws IllegalArgumentException
	 */
	public void setBirthTime(Date birthDate) throws IllegalArgumentException {
		this.birthTime = birthDate;
	}

	/**
	 * Parses and sets birth date. Date format must be 'dd.MM.yyyy'
	 * 
	 * @param birthDate
	 *            the birth time to set
	 * @throws IllegalArgumentException
	 *             if the birth date could not be parsed
	 */
	public void setBirthTime(String birthDate) throws IllegalArgumentException {
		this.birthTime = null;
		if (isValidBirthDate(birthDate)) {
			try {
				this.birthTime = Utils.getDate(birthDate);
			}
			catch (Exception e) {
				// This should never happen as birth date is already validated
				throw new IllegalArgumentException("Invalid birth date: " + birthDate);
			}
		}
		else
			throw new IllegalArgumentException("Invalid birth date");
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets and parses the country. Country must be an ISO 2-letter code
	 * 
	 * @param country
	 *            the country to set
	 * @throws IllegalArgumentException
	 */
	public void setCountry(String country) throws IllegalArgumentException {
		this.country = null;
		if (isValidCountry(country)) {
			this.country = country;
		}
		else
			throw new IllegalArgumentException("Invalid country");
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Validates and sets the athlete's name. Athlete's name should not contain
	 * numbers.
	 * 
	 * @param name
	 *            the name to set
	 * @throws IllegalArgumentException
	 */
	public void setName(String name) throws IllegalArgumentException {
		this.name = null;
		if (isValidName(name)) {
			this.name = name.replaceAll("\"", "");
		}
		else
			throw new IllegalArgumentException("Invalid athlete's name");
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param ID
	 */
	public void setId(long id) {
		this.id = id;
	}

	private boolean isValidName(String name) {
		boolean isValid = true;
		if (name != null && !"".equals(name)) {
			for (int j = 0; j < name.length(); j++) {
				if (Character.isDigit(name.charAt(j)) ) {
					log.log(Level.WARNING, "Name must contain only letters. Illegal character: " + name.charAt(j));
					isValid = false;
					break;
				}
			}
		}
		else
			isValid = false;
		return isValid;
	}

	private boolean isValidBirthDate(String date) {
		boolean isValid = true;
		if (date != null && !"".equals(date)) {
			try {
				Date birthDate = Utils.getDate(date);
				// System.out.println(birthDate);
				if (birthDate.after(new Date())) {
					log.log(Level.WARNING, "Birth date cannot be in future: " + date);
					isValid = false;
				}
			}
			catch (Exception e) {
				log.log(Level.WARNING, "Illegal date format: " + date + ". " + e);
				isValid = false;
			}
		}
		else {
			isValid = false;
		}
		return isValid;
	}

	private boolean isValidCountry(String country) {
		boolean isValid = true;
		if (country != null && country.length() == 2) {
			List<String> countries = Arrays.asList(Locale.getISOCountries());
			if (!countries.contains(country)) {
				log.log(Level.WARNING, "Countries list contains no such country: " + country);
				isValid = false;
			}
		}
		else {
			log.log(Level.WARNING, "Country code is empty or has inpropriate length: " + country);
			isValid = false;
		}
		return isValid;
	}

	public String toString() {
		String str = "";
		str += this.name + " (" + this.country + ", " + Utils.getDateAsString(this.birthTime) + ")\n";
		str += decathlonResults;
		return str;
	}

	/**
	 * @return the points calculated from decathlon results
	 */
	public int getPoints() {
		return decathlonResults.getPoints();
	}

	/**
	 * @return returns <code>true</code> if all the athlete's data is set (does not contain null values).
	 */
	public boolean isComplete() {
		System.out.println(this);
		return name != null && country != null && birthTime != null && decathlonResults.isComplete();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object athlete) throws ClassCastException {
		if (!(athlete instanceof Athlete))
			throw new ClassCastException("A Person object expected.");
		int points = ((Athlete) athlete).getPoints();
		return points - this.getPoints();
	}

	/**
	 * Converts Athlete object to a vector.
	 * 
	 * @return returns vector containing all the data of this athlete
	 */
	public Vector<Object> toVector() {
		Vector<Object> athleteVector = new Vector<Object>();
		athleteVector.add(getPoints());
		athleteVector.add(name);
		athleteVector.add(Utils.getDateAsString(birthTime));
		athleteVector.add(country);
		athleteVector.addAll(decathlonResults.toVector());
		return athleteVector;
	}
}
