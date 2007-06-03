package net.azib.java.students.t030636.homework;

import java.util.ArrayList;


/**
 * PlacesForDecathletes
 * Class for calculating correct places for decathletes
 *
 * @author Martin
 */
public class PlacesForDecathletes {
	/**
	 * returnArrayOfPlaces method outputs a String array that corresponds
	 * to the places of the decathletes in the input ArrayList.
	 * 
	 * @version 1.0
	 * @param list - sorted ArrayList of competitors for witch places are returned 
	 */
	
	public String [] returnArrayOfPlaces(ArrayList<Competitor> list) {
		Integer offset = 0;
		Integer index = 0;
		Integer prevScore = Integer.MAX_VALUE;
		String [] places = new String [list.size()];

		for (Competitor c : list) {
			if (c.score<prevScore){
				index = list.indexOf(c) + 1;
				places[index - 1] = index.toString();
				offset = 0;
			}
			else {
				++offset;
				index = list.indexOf(c) + 1;
				for(int i = 0; i<=offset; i++) {
					places[index - 1 - offset + i] = ((Integer)(index - offset)).toString()+ "-" + index.toString();
				}
			}
			prevScore = c.score;
		}
		return places;
	}
}


