package net.azib.java.students.t030632.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * PlaceCalculator calculates competitors places in the competition according to the results
 *
 * @author Toni
 */
public class PlaceCalculator {
	private List<Integer> places; //created from set, so contains no duplicate values
	private SortedSet <Integer> placeSet; 
	private TreeMap<Integer,String> placesMapWithDevider;
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
		// Map<points, how many athlets scored same points>
		Map<Integer,Integer> placesMap = new TreeMap<Integer,Integer>();
		for(Integer place:places){
			placesMap.put(place, 0);
		}
		
		for(Competitor champ: competitors){
			int devidePlaceFor = placesMap.get(champ.getPoints());
			placesMap.put(champ.getPoints(), ++devidePlaceFor);
		}
		//map <points, "x1-x2">
		//iterate points in descending order,
		placesMapWithDevider = new TreeMap<Integer,String>();
		int nextPlace = 1;
		for(int i = places.size()-1; i>=0;i--){
			if(placesMap.get(places.get(i))==1){
				placesMapWithDevider.put(places.get(i), String.valueOf(nextPlace));
				nextPlace = (nextPlace+placesMap.get(places.get(i)));
			}else{
				placesMapWithDevider.put(places.get(i), String.valueOf(nextPlace+"-"+(nextPlace+placesMap.get(places.get(i))-1)));
				nextPlace = (nextPlace+placesMap.get(places.get(i)));				
			}
			
		}
	}
	/**
	 * 
	 * @return map - key = points, value = place(s)  - if several athletes collected the same points they share places as "m-n"
	 */
	public Map<Integer,String> getPlaces(){
		return placesMapWithDevider;
	}
}
