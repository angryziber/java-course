package net.azib.java.students.t092860.homework;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Class containing athlete info
 */
public class Athlete {
	
	/**
	 * Sets the name of this athlete. 
	 *
	 * @param  name  athletes name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Sets the birthdate of this athlete. 
	 *
	 * @param  date  athletes birthdate
	 */
	public void setDate(Date date){
		this.birthdate = date;
	}
	
	/**
	 * Sets the country of this athlete. 
	 *
	 * @param  country  athletes country
	 * @throws Exception if input data is invalid
	 */
	public void setCountry(String country) throws Exception{
	    String c[] = Locale.getISOCountries();
	    if (Arrays.binarySearch(c, country) < 0)
	    	throw new Exception("Input data is invalid: country="+country+". ");

	    this.country = country;
	}
	
	/**
	 * Adds an event to this athlete. 
	 *
	 * @param  event  athletes event from Events enum
	 * @param  performance  athletes performance
	 */
	public void addEvent(Events event, Double performance){
		if(this.events == null)
			this.events = new LinkedHashMap<Events, Double>();

		this.events.put(event, performance);
	}
	
	/**
	 * Gets the name of this athlete. 
	 *
	 * @return  the name of this athlete.
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Gets the birthdate of this athlete. 
	 *
	 * @return  the birthdate of this athlete.
	 */
	public Date getDate(){
		return this.birthdate;	
	}
	
	/**
	 * Gets the country of this athlete. 
	 *
	 * @return  the country of this athlete.
	 */
	public String getCountry(){
		return this.country;
	}
	
	/**
	 * Gets the performance of particular event of this athlete. 
	 *
	 * @param  event  athletes event from Events enum
	 * @return        the performance of this athlete.
	 */
	public double getEventResult(Events event){
		return this.events.get(event);	
	}
	
	/**
	 * Gets list of events of this athlete. 
	 *
	 * @return  list of events of this athlete
	 */
	public Collection<Events> getEvents(){
		return this.events.keySet();	
	}
	
	protected String name;
	protected Date birthdate;
	protected String country;
	protected Map<Events, Double> events;
}
