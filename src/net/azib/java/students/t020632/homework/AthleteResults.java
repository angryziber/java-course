package net.azib.java.students.t020632.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * AthleteResults
 *
 * @author Marek Soobik t020632
 */
public class AthleteResults implements Comparable{
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
	
	
	public void addEvent(Event event){
		events.add(event);
	}
	
	public Event createEvent(EventInfo eventInfo){
		Event event = null;
		
		event = eventFactory.createEvent(eventInfo);
		return event;
	}
	
	public int calculate(Event event){
		int score;
		
		score = event.calculate();
		return score;
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

	public int compareTo(Object o) throws ClassCastException{
		if(!(o instanceof AthleteResults))
			throw new ClassCastException();
		
		AthleteResults a = (AthleteResults)o;
		return this.getScore() - a.getScore();  
	}
	
	
	
}
