package net.azib.java.students.t030656.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Competition
 *
 * @author sprot
 */
public class Competition{
	
	private List<Participant> participants;
	private int numberOfParticipants;
	private String name;
	/**
	 * constructor 
	 */
	public Competition() {
		participants = new ArrayList<Participant>();
	}
	
	/**
	 * @param numberOfParticipants the numberOfParticipants to set
	 */
	private void setNumberOfParticipants() {
		numberOfParticipants = participants.size();
	}
	
	public void addParticipant(Participant pa){
		participants.add(pa);
		setNumberOfParticipants();
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the participants
	 */
	public List<Participant> getParticipants() {
		return participants;
	}
	/**
	 * @return the numberOfParticipants
	 */
	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}
}
