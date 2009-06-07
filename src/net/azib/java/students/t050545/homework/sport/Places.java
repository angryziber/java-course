package net.azib.java.students.t050545.homework.sport;

/**
 * Hold Athlete data and place in competition
 * 
 * @author libricon
 */
public class Places {

	/** sportman's place */
	private String placeNum;
	/** athlete */
	private AthleteScore athlete;

	/** Place is a string, like 1-2 */
	public Places(String place, AthleteScore sportman) {
		placeNum = place;
		this.athlete = sportman;
	}

	/**
	 * @return <code>place + \n + sportman.toString()</code>
	 */
	@Override
	public String toString() {
		return "[" + placeNum + "]" + "\n" + athlete;
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
	public AthleteScore getSportman() {
		return athlete;
	}

}
