package net.azib.java.students.t030656.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Competition
 *
 * @author sprot
 */
public class Competition{
	
	List<Participant> participants;
	int numberOfParticipants;
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
}
