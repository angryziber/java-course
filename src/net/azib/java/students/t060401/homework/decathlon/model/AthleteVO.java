package net.azib.java.students.t060401.homework.decathlon.model;

import net.azib.java.students.t060401.homework.util.DateUtil;

import java.util.Date;

/**
 * @hibernate.class table="ATHLETES"
 */
public class AthleteVO {

	/**
	 * @hibernate.property column ="ID"
	 */
	private long id;
	/**
	 * @hibernate.property column ="NAME"
	 */
	private String name;
	/**
	 * @hibernate.property column ="DOB"
	 */
	private Date birthDate;
	/**
	 * @hibernate.property column ="COUNTRY_CODE"
	 */
	private String country;

	/**
	 * @return returns athlete's birth date
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate athlete's birth date to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return returns ISO code of the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country ISO code of the country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return returns athlete's ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id athlete's ID to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return returns athlete's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name athlete's name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		String str = "Name="+this.name + ", country=" + this.country + ", date of birth=" + DateUtil.getDateAsString(this.birthDate);
		return str;
	}
}
