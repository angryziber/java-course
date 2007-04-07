package net.azib.java.students.t050657.homework.src;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Athlet
 *
 * @author Boriss
 */
public class Athlet {
	
	private int id;
	private String name;
	private Date dateOfBirth;
	private String countryCode;
	
	Map<Competition, Results> participateIn = new HashMap<Competition, Results>();
	
	protected Athlet() {
		
	}
	
	public Athlet(int id, String name, Date dateOfBirth, String countryCode) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return name + " " + countryCode;
	} 

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	
}