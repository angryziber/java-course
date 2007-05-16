package net.azib.java.students.t030636.homework;


/**
 * Competitor
 * @author Martin
 * @version 1.0
 * This class describes a decathlon competitor. Implmenets the Comparable interface.
 * 
 */
public class Competitor implements Comparable<Object> {
	public String name;
	public Integer score;
	public  String [] results = new String[10] ;
	public int [] resultsAsPoints = new int[10];
	public String nationality;
	public String born;
	
//	/**
//	 * Gets the competitors name
//	 * 
//	 */
//	public String getName() {
//		return name;
//	}
//	/**
//	 * Sets the competitors name
//	 * @param name decathlete's name
//	 */
//	public void setName(String name) {
//		this.name = name;
//	}
	/**
	 * Gets the competitors score
	 * 
	 */
	public Integer getScore() {
		return score;
	}
//	/**
//	 * Sets the competitors name
//	 * @param score score for the decathlon
//	 */
//	public void setScore(Integer score) {
//		this.score = score;
//	}
//	/**
//	 * Gets the competitors results for the 10 events
//	 * 
//	 */
//	public String[] getResults() {
//		return results;
//	}
//	/**
//	 * Sets the competitors results for the 10 events
//	 * 
//	 */
//	public void setResults(String[] results) {
//		this.results = results;
//	}
//	public int[] getResultsAsPoints() {
//		return resultsAsPoints;
//	}
//	public void setResultsAsPoints(int[] resultsAsPoints) {
//		this.resultsAsPoints = resultsAsPoints;
//	}
//	public String getNationality() {
//		return nationality;
//	}
//	public void setNationality(String nationality) {
//		this.nationality = nationality;
//	}
//	public String getBorn() {
//		return born;
//	}
//	public void setBorn(String born) {
//		this.born = born;
//	}
	/**
	 * Compares the decathletes score to another decathlete
	 * Returns pos. value if other competitors score is greater, and neg. value otherwise
	 * @param anotherCompetitor decathlete to which the method compares
	 */
	@Override
	public int compareTo(Object anotherCompetitor) {
		if(!(anotherCompetitor instanceof Competitor))
			throw new ClassCastException("Another Competitor object expected.");
		int score = ((Competitor) anotherCompetitor).getScore();
		return score - this.getScore();
	}
	/**
	 * Checks if another competitor has the same score
	 * Returns true, if equal - otherwise false
	 * @param o Object (expected another competitor)
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Competitor) {
			Competitor compareComp = (Competitor) o;
			return compareComp.score == this.score;
		}
		else
			return false;
	}
	/**
	 * Hascode for the Competitor is the competitors score
	 *
	 */
	@Override
	public int hashCode() {
		return score;
	}
	/**
	 * Returns a string in the format:
	 * "[name]",[date-of-birth],[nationality],[100m_result],[longjump_result],.....(all 10 events)
	 * all results in the format [m.cm] or [min:sec] - leaving out the minute if under 60 sec
	 */	
	@Override
	public String toString() {
		String s = this.score + " points for: " +this.name +","+this.born+","+this.nationality;
		for (String event: this.results)
			s = s + "," + event;
		return s;
	}
}
