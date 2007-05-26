package net.azib.java.students.t050657.homework.src.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Competition class represents the real competition.
 * Each competition has title, country code and date.
 * In every competition participate any number of athlets.<br><br>
 * Class used for contain athlets, sort it and set places.  
 *
 * @author Boriss
 */

public class Competition {
	
	private Integer id;
	private String countryCode;
	private Date eventDate;
	private String description;
	
	private Set<Athlet> athlets = new TreeSet<Athlet>();

	/**
	 * Concstructs new instance of competition
	 */
	public Competition() {
		
	}
	
	/**
	 * Concstructs new instance of competition
	 * @param id is unique number of competition
	 * @param countryCode of country in organized competition
	 * @param eventDate of competiton
	 * @param description is a competition title
	 */
	public Competition(Integer id, String countryCode, Date eventDate, String description) {
		this.id = id;
		this.countryCode = countryCode;
		this.eventDate = eventDate;
		this.description = description;
	}
	
	/**
	 * Add athlet to a ThreeSet
	 * @param athlet to add
	 */
	public void addAthlet(Athlet athlet) {
		athlets.add(athlet);
	}
	
	/**
	 * Overrides Object's toString method.
	 * @return formatted competition string
	 */
	@Override
	public String toString() {
		return description + " at " + this.getFormattedEventDate()+ ", " + countryCode;
	}

	/**
	 * Two competitions are equals if it's countryCode, eventDate and description are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Competition))
			return false;
		
		Competition comp = (Competition) obj;
		
		if(!comp.countryCode.equals(this.countryCode))
			return false;
		if(!(comp.eventDate.getTime() == this.eventDate.getTime()))
			return false;
		if(!comp.description.equals(this.description))
			return false;
		
		return true;
	}
	
	/**
	 * Calculates scores and places for athlets participate in competition.
	 */
	public void calculateAndSetPlaces() {
		for(Athlet athlet : athlets) {
			athlet.setPlace(null);
		}
		int place = 1;
		for(Athlet a : athlets) {
			int tmp = 0;
			if(a.getPlace() == null) {
				List<Athlet> athletsWithERes = new ArrayList<Athlet>();
				for(Athlet athlet : athlets) {
					if(athlet.getFinalScore() == a.getFinalScore()) {
						athletsWithERes.add(athlet);
					}
				}
				this.setPlaces(place, athletsWithERes);
				tmp = athletsWithERes.size();
			}
			place += tmp;
		}
	}
	
	private void setPlaces(int place, List<Athlet> list) {
		if(list.size() == 1) {
			list.get(0).setPlace(place + "");
		}else {
			for(Athlet a : list) {
				a.setPlace(place + "-" + (place + list.size()-1));
			}
		}
	}
	
	public Set<Athlet> getAthlets(){
		return athlets;
	}
	
	/**
	 * Getter for countryCode
	 * @return countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Getter for description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Getter for eventDate
	 * @return eventDate
	 */
	public Date getEventDate() {
		return eventDate;
	}
	
	/**
	 * Setter for athlets
	 * @param Set of athlets to set 
	 */
	public void setAthlets(Set<Athlet> athlets) {
		this.athlets = athlets;
	}
	
	/**
	 * Setter for countryCode
	 * @param countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Setter for description
	 * @param description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Setter for eventDate
	 * @param eventDate to set
	 */
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	/**
	 * Getter for event date in format, used in DB.
	 * @return string representation of eventDate in format yyyy-mm-dd
	 */
	public String getFormattedEventDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(eventDate.getTime());
	}

}
