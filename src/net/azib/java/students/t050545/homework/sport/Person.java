package net.azib.java.students.t050545.homework.sport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Name+country+birthday
 * 
 * @author libricon
 */
public class Person {

	/**
	 * Country should be two letters(but can be anyone
	 * 
	 * @param name person's name
	 * @param country country, where is from
	 * @param birthDay BirthDay
	 */
	public Person(String name, String country, Date birthDay) {
		this.name = name;
		this.country = country;
		this.birthDay = (Date) birthDay.clone();
	}

	/**
	 * @return name,birthday,country
	 */
	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		return (name + "\nBirthday is: " + df.format(birthDay.getTime()) + "\nfrom " + country + "\n");
	}

	/**
	 * @param other Sportsman
	 * @return <code>(this == other)? true:false</code>
	 */
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;
		Person p = (Person) other;
		return this.name.equals(p.getName()) && this.country.equals(p.getCountry()) && this.birthDay.equals(p.getBirthDay());
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return cloned object
	 */
	public Date getBirthDay() {
		return (Date) birthDay.clone();
	}

	/** name */
	private final String name;
	/** country */
	private final String country;
	/** birthDay */
	private final Date birthDay;

}