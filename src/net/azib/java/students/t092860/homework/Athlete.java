package net.azib.java.students.t092860.homework;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Athlete
 *
 * @author scythe
 */
class Athlete {
	
	public void setName(String name){
		athleteName = name;
	}
	
	public void setDate(Date date){
		athleteBirthdate = date;
	}
	
	public void setCountry(String country) throws Exception{
	    String c[] = Locale.getISOCountries();
	    if (Arrays.binarySearch(c, country) < 0)
	    	throw new Exception("Input data is invalid: country="+country+". ");

		athleteCountry = country;
	}
	
	public void addEvent(Events event, Double performance){
		if(athleteEvents == null)
			athleteEvents = new HashMap<Events, Double>();

		athleteEvents.put(event, performance);
	}
	
	public String getName(){
		return athleteName;
	}
	
	public Date getDate(){
		return athleteBirthdate;	
	}
	
	public String getCountry(){
		return athleteCountry;
	}
	
	public double getEventResult(Events event){
		return athleteEvents.get(event);	
	}
	
	public Collection<Double> getEventResults(){
		return athleteEvents.values();	
	}
	
	public Collection<Events> getEvents(){
		return athleteEvents.keySet();	
	}
	
	protected String athleteName;
	protected Date athleteBirthdate;
	protected String athleteCountry;
	protected Map<Events, Double> athleteEvents;
}
