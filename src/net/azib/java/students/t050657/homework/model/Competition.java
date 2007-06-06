package net.azib.java.students.t050657.homework.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
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
	
	private SortedSet<Result> results = new TreeSet<Result>();

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
	 * Constructor copies all competition parameters except athlets
	 * @param competition to be copied
	 */
	public Competition(Competition competition) {
		this.countryCode = competition.countryCode;
		this.description = competition.description;
		this.eventDate = competition.eventDate;
		this.id = competition.id;
	}

	/**
	 * Overrides Object's toString method.
	 * @return formatted competition string
	 */
	@Override
	public String toString() {
		return description + " at " + countryCode + ", " + eventDate;
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
	public void calculateAndSetPlaces() throws InsufficientResultsException{

		List<Result> resList = this.sortResultsByFinalScore();
		
		for(Result result : resList) {
			result.setPlace(null);
		}
		int place = 1;
		for(Result res : resList) {
			int tmp = 0;
			if(res.getPlace() == null) {
				List<Result> equalResultsList = new ArrayList<Result>();
				for(Result result : resList) {
					if(result.getFinalScore() == res.getFinalScore()) {
						equalResultsList.add(result);
					}
				}
				this.setPlaces(place, equalResultsList);
				tmp = equalResultsList.size();
			}
			place += tmp;
		}
		
		results.clear();
		results.addAll(resList);
	}
	
	private List<Result> sortResultsByFinalScore() throws InsufficientResultsException{
		List<Result> sortedList = new ArrayList<Result>();
		sortedList.addAll(results);
		Collections.sort(sortedList);
		return sortedList;
	}
	
	private void setPlaces(int place, List<Result> list) {
		if(list.size() == 1) {
			list.get(0).setPlace(place + "");
		}else {
			for(Result result : list) {
				result.setPlace(place + "-" + (place + list.size()-1));
			}
		}
	}

	public Integer getId() {
		return id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getDescription() {
		return description;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public SortedSet<Result> getResults() {
		return results;
	}

	public void setResults(SortedSet<Result> results) {
		this.results = results;
	}
	
	public void addResults(List<Result> resultList) {
		results.addAll(resultList);
	}
	
	public void addResult(Result result) {
		this.results.add(result);
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	
	

}
