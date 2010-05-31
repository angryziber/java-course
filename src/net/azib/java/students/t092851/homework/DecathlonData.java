package net.azib.java.students.t092851.homework;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * DecathlonData
 * 
 * Table of athletes data: personal particulars and 
 * results in specific competition.
 *
 * @author Lauri
 */
public class DecathlonData implements Iterable<Participant> {
	
	private LinkedList<Participant> athletes = new LinkedList<Participant>();
	
	
	/**
	 * Inserts new athlete data to the table in the correct (sorted) order.
	 * @param participant new participant for adding to competition
	 */
	public void insert(Participant participant) {
		ListIterator<Participant> iterator = athletes.listIterator(0);
		Participant athlete;
		
		while (iterator.hasNext()) {
			athlete = iterator.next();
			if (participant.getPoints() > athlete.getPoints()) {
				iterator.previous();
				break;
			}
		}
		iterator.add(participant);
	}

	
	/**
	 * Sets rank for each athlete inserted to data table according to score.
	 * If place is shared then it is marked accordingly.
	 */
	public void rankParticipants() {
		int  markStart, markEnd;
		long lastPoints = Long.MAX_VALUE;
		
		for (int i = 0; i < athletes.size(); i++) {
			if (lastPoints == athletes.get(i).getPoints()) {
				markStart = i - 1;
				for (i++; i < athletes.size(); i++)
					if (lastPoints != athletes.get(i).getPoints())
						break;
				markEnd = i - 1;
				for (i = markStart; i <= markEnd; i++)
					athletes.get(i).setPlace(String.valueOf(markStart + 1) + '-' + String.valueOf(markEnd + 1));
				i = markEnd;
			}
			else {
				athletes.get(i).setPlace(String.valueOf(i + 1));
				lastPoints = athletes.get(i).getPoints();
			}
		}
	}
	
	
	/**
	 * @return object for iterating over competition participants
	 */
	@Override
	public Iterator<Participant> iterator() {
		return athletes.iterator();
	}
	
	
	/**
	 * @return athletes data one by one
	 */
	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		
		for (Participant athlete : athletes) {
			strBuild.append(athlete.toString()).append("\n");
		}
		return strBuild.toString();
	}

	
	/**
	 * @param obj object to compare with 'this'
	 * @return true if all participants data in table is equal
	 *  (including order of participants in table)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		
		if ( !(obj instanceof DecathlonData) )
			return false;

		return ((DecathlonData)obj).athletes.equals(this.athletes);
	}

}
