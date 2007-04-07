package net.azib.java.students.t050657.homework.src;

import java.util.Date;

public class Competition {
	
	private int id;
	private String countryCode;
	private Date eventDate;
	private String description;
	
	public Competition() {
		
	}
	
	public Competition(int id, String countryCode, Date eventDate, String description) {
		this.id = id;
		this.countryCode = countryCode;
		this.eventDate = eventDate;
		this.description = description;
	}

	@Override
	public String toString() {
		return eventDate + " " + countryCode + " " + description;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
