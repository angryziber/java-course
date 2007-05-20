package net.azib.java.students.t030632.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * PlaceCalculator
 *
 * @author Toni
 */
public class PlaceCalculator {
	private List<Integer> places;
	private SortedSet <Integer> placeSet; 
	public PlaceCalculator(List<Competitor> competitors){
		places = new ArrayList<Integer>();
		placeSet = new TreeSet<Integer>();
		//eliminate duplicates
		for(Competitor champ: competitors){
			placeSet.add(champ.getPoints());
		}
		// create Arraylist in order to acces elements faster
		for(int place: placeSet){
			places.add(place);
		}
		
	}
	public ArrayList<Integer> getPlaces(){
		return (ArrayList<Integer>) places;
	}
}
