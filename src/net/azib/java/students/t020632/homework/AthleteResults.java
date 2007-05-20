package net.azib.java.students.t020632.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * AthleteResults represents decathlon event results for 
 * one athlete. Contains information about the athlete and
 * set of events representing the results and scores.
 *
 * @author Marek Soobik t020632
 */
public class AthleteResults implements Comparable<AthleteResults>{
	private EventFactory eventFactory;
	private List<Event> events;
	
	private String athleteName;
	private String dateOfBirth;
	private String country;
	private int totalScore;
	private int position;
	
	
	public AthleteResults(String name, String date, String country){
		eventFactory = new EventFactory();
		events = new ArrayList<Event>();
		
		athleteName = name;
		dateOfBirth = date;
		this.country = country;
	}
	
	/**
	 * Adds event to the list of results
	 * 
	 * @param event
	 */
	public void addEvent(Event event){
		events.add(event);
	}
	
	
	/**
	 * Creates new event object which holds information about
	 * the event and the result
	 * 
	 * @param eventInfo
	 * @return	created Event object
	 */
	public Event createEvent(EventInfo eventInfo){
		Event event = null;
		
		event = eventFactory.createEvent(eventInfo);
		return event;
	}
	
	/**
	 * Calculates score for all the events completed during the 
	 * competition
	 * 
	 * @return	Sum of the scores of all the events
	 */
	public int calculateScore(){
		int score = 0;
		int i = 0;
		Event event;
		
		while(i < events.size()){
			event = events.get(i);
			score = score + this.calculateEvent(event);
			i++;
		}
		
		totalScore = score;
		
		return score;
	}
	
	/**
	 * Calculates score for one specific event
	 * 
	 * @param event
	 * @return	Score of the event
	 */
	public int calculateEvent(Event event){
		int score;
		
		score = event.calculate();
		return score;
	}
	
	/**
	 * Prints results to the console
	 */
	public void printResults(){
		int i = 0;
		StringBuffer str = new StringBuffer();
		
		if(position != 0){
			str.append(position + " ");
		}
		if(totalScore != 0){
			str.append(totalScore + " ");
		}
		
		str.append(athleteName + " ");
		str.append(dateOfBirth + " ");
		str.append(country + " ");
		
		while(i < events.size()){
			str.append(events.get(i).getResult() + " ");
			i++;
		}
		
		System.out.println(str);
		
	}
	
	public String getName(){
		return athleteName;
	}
	
	public String getDateOfBirth(){
		return dateOfBirth;
	}
	
	public String getCountry(){
		return country;
	}
	
	public Event getEvent(int i){
		return events.get(i);
	}
	
	public int getScore(){
		return totalScore;
	}
	
	public int getPosition(){
		return position;
	}
	
	public void setScore(int score){
		this.totalScore = score;
	}
	
	public void setPosition(int pos){
		this.position = pos;
	}
	
	/**
	 * Compares two AthleteResults objects. Returns negative
	 * integer if this AthleteResults object has better score
	 * than compared AthleteResults object and positive integer 
	 * if this object has worse score. If both scores are equal
	 * number 0 is returned.
	 */
	public int compareTo(AthleteResults a) {
		return a.getScore() - this.getScore();  
	}
	
	
}
