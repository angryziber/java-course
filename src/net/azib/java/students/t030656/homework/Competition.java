package net.azib.java.students.t030656.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Competition
 * Class that binds the contestants
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
	/**
	 * Add new participant to the competition
	 * After insertion the list is sorted
	 * @param Participant
	 */
	public void addParticipant(Participant pa){
		participants.add(pa);
		setNumberOfParticipants();
		Collections.sort(getParticipants());
	}
	/**
	 * @param name
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
