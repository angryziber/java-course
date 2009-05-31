package net.azib.java.students.t090437.homework;

import java.util.Iterator;
import java.util.SortedSet;

/**
 * PositionCalculator
 *
 * @author Ronald
 */
public class PositionCalculator {
	/**
	 * Calculates the position for each competitor based on the score.
	 * If two or more competitors have the same score then they will 
	 * share a range of positions.
	 * @param competitors
	 */
	public static void calcPositions(SortedSet<Competitor> competitors) {
		Iterator<Competitor> iterator = competitors.iterator();
		Position pos;
		int highest_pos = 1, lowest_pos = 1;
		Competitor comp1, comp2;
		
		if(!iterator.hasNext()) {
			return;
		}
		
		comp1 = iterator.next();
		pos = new Position();
		pos.setPosition(highest_pos);
		comp1.setPosition(pos);
		
		while(iterator.hasNext()) {
			comp2 = comp1;
			comp1 = iterator.next();
			lowest_pos++;
			if(comp1.getScore() == comp2.getScore()) {
				pos.setPosition(highest_pos, lowest_pos);
				comp1.setPosition(pos);
			} else {
				pos = new Position();
				highest_pos = lowest_pos;
				pos.setPosition(highest_pos);
				comp1.setPosition(pos);
			}
		}
	}
}
