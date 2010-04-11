package net.azib.java.students.t092875.homework.athletes;

import java.util.Date;
import java.util.Map;

/**
 * Athlete
 *
 * @author Mihhail
 */
public class Athlete implements Competeable, Comparable<Athlete>{
	private String name;
	private String place;
	private double result;
	private Date dob;
	private String origin; 
	private Map<String, String> eventResults;
	
	Athlete(String name, Date dob,String origin,Map<String,String> er){
		this.name = name;
		this.dob = dob;
		this.origin = origin;
		this.eventResults = er;
	}
	
	public void setResult(double result){
		this.result = result;
	}
	
	public double getResult(){
		return this.result; 
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getEventResult(String key){
		return (String) eventResults.get(key);
	}
	
	public Date getDateOfBirth(){
		return this.dob;
	}
	
	public String getOrigin(){
		return this.origin;
	}
	
	public void setPlace(String place){
		this.place= place;
	}
	
	public String getPlace(){
		return this.place;
	}

	@Override
	public int compareTo(Athlete athlete) {
		if(this.result > athlete.getResult()){
			return 1;
		}else if(this.result < athlete.getResult()){
			return -1;
		}
		return 0;
	}
}
