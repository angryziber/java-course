package net.azib.java.students.t030657.homework;

/**
 * @author Karina
 *
 * public class Athlete with such private variables:
 *  id, name, dob, countryCode
 * In this class data for new athlete is written down
 */

public class Athlete {
	private int id;
	private String name;
	private String dob;
	private String countryCode;
	
	Athlete() {
	}

	Athlete(String name, String dob, String countryCode) {
		this.name=name;
		this.dob=dob;
		this.countryCode=countryCode;
	}
	
	int getId() {
		return id;
	}
	void setId(int id) {
		this.id = id;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getDob() {
		return dob;
	}
	void setDob(String dob) {
		this.dob = dob;
	}
	String getCountryCode() {
		return countryCode;
	}
	void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
