package net.azib.java.students.t050545.homework.sport;


/**
 * This Class hold place in competition and sportman's data ( stores, name and
 * data )
 * 
 * @author libricon
 */
public class Places {
	
	/** Place is a string, usually like 1-2 ( braces [] added automat.)
	 * @param place Place in competition
	 * @param sportman Sportman's data
	 */
	public Places(String place, Sportman sportman) {
		placeNum = place;
		this.sportman = sportman;
	}

	/**
	 * ToString method, return place and all sportmans data
	 * @return <code>place + \n + sportman.toString()</code>
	 */
	@Override
	public String toString() {
		return "["+placeNum+"]" + "\n" + sportman;
	}

	/**
	 * @return the placeNum
	 */
	public String getPlaceNum() {
		return placeNum;
	}

	/**
	 * @return the sportman
	 */
	public Sportman getSportman() {
		return sportman;
	}

	/** sportman's place */
	private String placeNum;
	/** sportman */
	private Sportman sportman;

}
