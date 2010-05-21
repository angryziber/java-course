package net.azib.java.students.t092875.homework.athletes;

import java.util.Date;

/**
 * Athlete
 *
 * @author Mihhail
 */
public class Athlete implements Comparable<Athlete>{
	private String name;
	private String place;
	private int result;
	private Date dob;
	private String origin; 
	private String[] eventResults;
	
	/**
	 * Creates an Athlete with the set name, date of birth, origin and the results for each
	 * event in the decathlon.
	 * 
	 * @param name - name of the athlete
	 * @param dob - date of birth of the athlete
	 * @param origin - country code of the athlete
	 * @param er - event results during the decathlon competition 
	 */
	public Athlete(String name, Date dob,String origin,String[] er){
		this.name = name;
		this.dob = dob;
		this.origin = origin;
		this.eventResults = er;
	}
	
	/**
	 * Setter for Total Result
	 * 
	 * @param result - the total result of the athlete in the comptition
	 */
	public void setResult(int result){
		this.result = result;
	}
	
	/**
	 * Getter for Total Result
	 * 
	 * @return - returns the total result in points in the competition
	 */
	public int getResult(){
		return this.result; 
	}
	
	/**
	 * Getter for athletes name
	 * 
	 * @return returns the athletes name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Returns the event results for the athlete for a specific event
	 * 
	 * @param key - The event key.
	 * @return returns the result in meters or seconds for a specific result depending on the key
	 */
	public String getEventResult(int key){
		return eventResults[key];
	}
	
	/**
	 * Getter for the date of birth of the athlete
	 * 
	 * @return a Date object containing the date of birth of the athlete
	 * 	 */
	public Date getDateOfBirth(){
		return this.dob;
	}
	
	/**
	 * Getter of origin
	 * 
	 * @return a string with a two letter code of the athlete's origin
	 */
	public String getOrigin(){
		return this.origin;
	}
	
	/**
	 * Setter for the place of the athlete
	 * 
	 * @param place - the place in the competition
	 */
	public void setPlace(String place){
		this.place= place;
	}
	
	/**
	 * Getter for the place of the athlete
	 * 
	 * @return a string containing a place in the competition. May have a double place. 
	 * Example: "2-3"
	 */
	public String getPlace(){
		return this.place;
	}
	
	@Override
	public int compareTo(Athlete athlete) {
		if(this.result > athlete.getResult()){
			return -1;
		}else if(this.result < athlete.getResult()){
			return 1;
		}
		return 0;
	}
}
