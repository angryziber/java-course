package net.azib.java.students.t010687.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Athlete
 *
 * @author Matu
 */
public class Athlet {
	private int id;
	private String name;
	private Date dateOfBirth;
	private String country;
	
	public Athlet(){
		super();
	}
	/**
	 * @param name
	 * @param dateOfBirth
	 * @param country
	 */
	public Athlet(String name, String dateOfBirth, String country) {
		super();
		this.name = name;
		setDateOfBirth(dateOfBirth);
		this.country = country;
	}
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
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return DateFormat.getDateInstance(DateFormat.MEDIUM).format(dateOfBirth);
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		try {
			this.dateOfBirth = DateFormat.getDateInstance().parse(dateOfBirth);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
