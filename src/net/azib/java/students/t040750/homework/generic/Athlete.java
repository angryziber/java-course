package net.azib.java.students.t040750.homework.generic;

import java.sql.Date;

/**
 * The {@link Athlete} class represents the person who is competing in
 * the decathlon.
 * 
 * @author Karpz
 *
 */
public class Athlete {
	String name;
	Date birthday;
	String nationality;
	
	/**
	 * Generates a new Athlete object with preset values.
	 * 
	 * @param name - athlete's name
	 * @param birthday - athlete's birthday
	 * @param nationality - athlete's nationality
	 */
	public Athlete(String name, Date birthday, String nationality) {
		this.name = name;
		this. birthday = birthday;
		this.nationality = nationality;
	}
	
	public Athlete() { }
	
	/**
	 * Overrides the default toString() method.
	 * @return - athlete's name
	 */
	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
