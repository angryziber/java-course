package net.azib.java.students.t090437.homework;

/**
 * Position
 * This class stores competitors position in the competition
 * based on the scores. If multiple competitors share the same
 * score, then the position range they share can be stored with
 * this class.
 * @author Ronald
 */
public class Position {
	private int highest_position;
	private int lowest_position;
	
	public Position() {		
	}
	
	/**
	 * Setting the object to represent a single position.
	 * @param position
	 */
	public void setPosition(int position) {
		highest_position = position;
		lowest_position = position;
	}
	
	/**
	 * Setting the object to represent a range of positions.
	 * For example, if 3 competitors had the same score, they would 
	 * share 3 positions(for example positions 4-7). In this case 
	 * highest_position = 4, lowest_position = 7 and toString() would 
	 * return "4-7".
	 * 
	 * @param highest_position
	 * @param lowest_position
	 */
	public void setPosition(int highest_position, int lowest_position) {
		this.highest_position = highest_position;
		this.lowest_position = lowest_position;
	}

	/**
	 * @return String what represents the competitors position 
	 * as a single digit(like "2") or a range of position(like "3-5")
	 * when these positions are shared by multiple competitors.
	 */
	public String toString() {
		if(highest_position == lowest_position) {
			return Integer.toString(highest_position);
		} else {
			return Integer.toString(highest_position) + "-" + 
				Integer.toString(lowest_position);
		}
	}
}
