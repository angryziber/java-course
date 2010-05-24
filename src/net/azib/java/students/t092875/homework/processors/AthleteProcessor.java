package net.azib.java.students.t092875.homework.processors;

import net.azib.java.students.t092875.homework.athletes.Athlete;
import net.azib.java.students.t092875.homework.competiotions.Competiotion;

import java.util.Collections;
import java.util.List;

/**
 * AthleteProcessor
 *
 * @author Mihhail
 */
public class AthleteProcessor {
	/**
	 * Sorts the given List of Athletes after assigned points for each event. After the sorting each Athlete is assigned a place in the decathlon.
	 * 
	 * @param athletes - an unsorted list of Athletes without points or places. If the athletes will have those properties set, they will be recalculated.
	 * 
	 */
	public void process(List<Athlete> athletes){
		setAllResults(athletes);
		Collections.sort(athletes);
		assignPlaces(athletes);
	}
	
	/**
	 * Sets the total results for each athlete depending on their individual results
	 * 
	 * @param athletes - a list of Athlete objects containing the athletes in the competition
	 */
	void setAllResults(List<Athlete> athletes){
		for (Athlete a : athletes) {
			setResult(a);
		}
	}
	
	/**
	 * Sets the results for one Athlete depending on his individul results in each event
	 * 
	 * @param athlete - an Athlete object
	 */
	void setResult(Athlete athlete){
		int points = 0;
		for (Competiotion comp : Competiotion.values()) {
			points += comp.points(athlete.getEventResult(comp.ordinal()));
		}
		athlete.setResult(points);
	}
	
	/**
	 * Assign individual places in the competition. The places should be assigned after the sorting
	 * has been complete. 
	 * 
	 * @param athletes - List object containing the athletes in the competition
	 */
	void assignPlaces(List<Athlete> athletes){
		Athlete athlete;
		int likeMeLeft = 0;
		boolean first = true;
		String specialPlace = "";
		for (int i=1; i<=athletes.size(); i++) {
			athlete = athletes.get(i-1);
			if(first){
				athlete.setPlace("1");
				first = false;
			}else{
				int likeMe = 0;
				if(likeMeLeft==0){
					likeMe = howManyLikeMe(athletes,athlete.getResult());
				}
				if(likeMe==1 && likeMeLeft==0){
					athlete.setPlace(i+"");
				}else{
					if(likeMeLeft==0){
						likeMeLeft = likeMe;
						specialPlace = getSpecialPlace(likeMe, i);
					}
					athlete.setPlace(specialPlace);
					likeMeLeft--;
				}
			}
		}
	}
	
	/**
	 * Checks and returns the number of athletes, who have the same result for a specific total score
	 * 
	 * @param athletes - a list of athletes
	 * @param result - the total result to check on
	 * @return an integer of how many athletes have the same total result
	 */
	int howManyLikeMe(List<Athlete> athletes,double result){
		int i = 0;
		for (Athlete athlete : athletes) {
			if(athlete.getResult()==result){
				i++;
			}
		}
		return i;
	}
	
	/**
	 * Generates a special place to assign to athlete. Only used if there are more than one competitor
	 * with the same result.
	 * 
	 * @param places - number of places shared between athletes
	 * @param curPlace -  the starting place to be shared
	 * @return a special string containing many places. Example: "4-5-6"  
	 */
	String getSpecialPlace(int places, int curPlace){
		String specialPlace = "";
		specialPlace = curPlace +"-"+(curPlace+places-1);
		return specialPlace;	
	}
}
