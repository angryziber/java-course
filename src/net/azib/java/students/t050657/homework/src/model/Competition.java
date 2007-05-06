package net.azib.java.students.t050657.homework.src.model;

import java.util.Date;
import java.util.Set;

public class Competition {
	
	private int id;
	private String countryCode;
	private Date eventDate;
	private String description;
	
	private Set<Athlet> athlets;
	
	public Competition() {
		
	}
	
	public Competition(int id, String countryCode, Date eventDate, String description) {
		this.id = id;
		this.countryCode = countryCode;
		this.eventDate = eventDate;
		this.description = description;
	}
	
	public void addAthlet(Athlet athlet) {
		athlets.add(athlet);
	}
	
	@Override
	public String toString() {
		return eventDate + " " + countryCode + " " + description;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Competition))
			return false;
		
		Competition comp = (Competition) obj;
		
		if(!comp.countryCode.equals(this.countryCode))
			return false;
		if(!comp.eventDate.equals(this.eventDate))
			return false;
		
		return true;
	}
	
	

}
