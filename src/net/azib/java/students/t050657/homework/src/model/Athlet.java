package net.azib.java.students.t050657.homework.src.model;

import java.util.Date;

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
	
	private Result result;
	
	public Athlet(){
		
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
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Athlet))
			return false;
		
		Athlet athlet = (Athlet) obj;
		
		if(!athlet.name.equals(this.name))
			return false;
		if(!athlet.dateOfBirth.equals(this.dateOfBirth))
			return false;
		if(!athlet.countryCode.equals(this.countryCode))
			return false;
		
		return true;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	public Result getResult() {
		return result;
	}
	
	

	
}