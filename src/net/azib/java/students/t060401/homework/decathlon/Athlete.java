package net.azib.java.students.t060401.homework.decathlon;

import net.azib.java.students.t060401.homework.util.DateUtil;
import net.azib.java.students.t060401.homework.util.LanguageUtil;

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
 * Holds data of an athlete including athlete's name, birth date, country and
 * decathlon result of a competition.
 * 
 * @author t060401
 */
public class Athlete implements Comparable {

	Logger log = Logger.getLogger(Athlete.class.getName());

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
	 * @param results decathlon results object
	 */
	public void setDecathlonResults(DecathlonResults results) {
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
		try {
			validateBirthDate(birthDate);
		}
		catch (IllegalArgumentException e) {
			this.birthTime = null;
			throw e;
		}
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
			Date newBirthDate = DateUtil.getDate(birthDate);
			setBirthTime(newBirthDate);
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
		try {
			validateCountry(country);
		}
		catch (IllegalArgumentException e) {
			this.country = null;
			throw e;
		}
		this.country = country;
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
		try {
			validateName(name);
		}
		catch (IllegalArgumentException e) {
			this.name = null;
			throw e;
		}
		this.name = name.replaceAll("\"", "");
	}

	private void validateName(String name) throws IllegalArgumentException {
		if (name != null && !"".equals(name)) {
			for (int j = 0; j < name.length(); j++) {
				if (Character.isDigit(name.charAt(j))) {
					log.log(Level.WARNING, "Name must contain only letters. Illegal character: "+name.charAt(j));
					throw new IllegalArgumentException(LanguageUtil.getString("Athlete.IllegalName.ContainsNumbers")+name.charAt(j));
				}
			}
		}
		else
		{
			log.log(Level.WARNING, "Name cannot be empty");
			throw new IllegalArgumentException(LanguageUtil.getString("Athlete.IllegalName.Empty"));
		}
	}
	
	private void validateBirthDate(Date date) throws IllegalArgumentException {
		if (date != null) {
			if (date.after(new Date())) {
				throw new IllegalArgumentException(LanguageUtil.getString("Athlete.IllegalBirthDate.InFuture"));
			}
		}
		else {
			throw new IllegalArgumentException(LanguageUtil.getString("Athlete.IllegalBirthDate.Empty"));
		}
	}

	private void validateCountry(String country) throws IllegalArgumentException {
		if (country == null) {
			throw new IllegalArgumentException(LanguageUtil.getString("Athlete.IllegalCountry.Empty"));
		}
		if (country.length() != 2) {
			throw new IllegalArgumentException(LanguageUtil.getString("Athlete.IllegalCountry.Length"));
		}
		List<String> countries = Arrays.asList(Locale.getISOCountries());
		if (!countries.contains(country)) {
			throw new IllegalArgumentException(LanguageUtil.getString("Athlete.IllegalCountry.NotExisting"));
		}
	}

	public String toString() {
		String str = "";
		str += this.name + " (" + this.country + ", " + DateUtil.getDateAsString(this.birthTime) + ")\n";
		str += decathlonResults;
		return str;
	}

	/**
	 * @return returns the points calculated according to the decathlon results
	 */
	public int getPoints() {
		return decathlonResults.getPoints();
	}

	/**
	 * @return returns <code>true</code> if all the athlete's data is set
	 *         (does not contain null values).
	 */
	public boolean isComplete() {
		System.out.println(this);
		return name != null && country != null && birthTime != null && decathlonResults!=null && decathlonResults.isComplete();
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
	public Vector<String> toVector() {
		Vector<String> athleteVector = new Vector<String>();
		athleteVector.add(Integer.toString(getPoints()));
		athleteVector.add(name);
		athleteVector.add(DateUtil.getDateAsString(birthTime));
		athleteVector.add(country);
		athleteVector.addAll(decathlonResults.getResultsVector());
		return athleteVector;
	}
}
