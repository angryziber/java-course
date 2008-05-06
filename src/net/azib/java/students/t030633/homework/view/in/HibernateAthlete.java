package net.azib.java.students.t030633.homework.view.in;

import java.sql.Date;

/**
 * HibernateAthlete
 *
 * @author t030633
 */
public class HibernateAthlete {
	
	int id;
	String name;
	Date dob;
	String country;
	
	public HibernateAthlete() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
