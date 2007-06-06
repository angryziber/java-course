package net.azib.java.students.t050657.homework.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Athlet class represents athlet, implements comparable. 
 * 
 * @author Boriss
 */
public class Athlet{
	
	private Integer id;
	private String name;
	private Date dateOfBirth;
	private String countryCode;

	/**
	 * Concstructs new instance of athlet
	 */
	public Athlet(){

	}
	
	/**
	 * Concstructs new instance of athlet
	 * @param id unique number of athlet
	 * @param name of athlet
	 * @param dateOfBirth represents date of athlets birth	
	 * @param countryCode which athlet represents
	 */
	public Athlet(final Integer id, final String name, final Date dateOfBirth, final String countryCode) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.countryCode = countryCode;
	}

	/**
	 * Overriding Object's toString method. Output athlet in standartized format
	 */
	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		StringBuilder athlet =  new StringBuilder();
		
		athlet.append(",\"" + name + "\"")
				.append("," + df.format(dateOfBirth.getTime()))
				.append(","+ countryCode);

		return athlet.toString();
	}
	
	/**
	 * Equals method overriding Object's equals method.
	 * Tho athlets are equal if it's names, dates of birth and country codes are equal. 
	 */
	@Override
	public boolean equals(final Object obj) {
		if(!(obj instanceof Athlet))
			return false;
		
		final Athlet athlet = (Athlet) obj;

		if(!athlet.name.equals(this.name))
			return false;
		if(!(athlet.dateOfBirth.getTime() == this.dateOfBirth.getTime()))
			return false;
		if(!athlet.countryCode.equals(this.countryCode))
			return false;
		
		return true;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setName(String name) {
		this.name = name;
	}

}