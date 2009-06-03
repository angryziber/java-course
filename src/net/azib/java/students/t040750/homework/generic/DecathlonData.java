package net.azib.java.students.t040750.homework.generic;

/**
 * The {@link DecathlonData} class represents one competitor's data in 
 * a decathlon. 
 * 
 * The position parameter will be calculated during output
 * processing of the results. It has {@link String} value due to
 * the possibility of equal amount of total points, in which case the
 * position parameter has to reflect the range of places. 
 *  
 * @author Karpz
 *
 */
public class DecathlonData implements Comparable<DecathlonData> {

	Athlete athlete;
	Result result;
	long totalPoints;
	String position;
	
	/**
	 * Generates a new DecathlonData object with preset values.
	 * 
	 * @param athlete - {@link Athlete} object containing the 
	 * 		competitor's personal data
	 * @param result - {@link Result} object containing the 
	 * 		competitor's results
	 * @param totalPoints - competitor's total points
	 */
	public DecathlonData(Athlete athlete, Result result, long totalPoints) {
		this.athlete = athlete;
		this.result = result;
		this.totalPoints = totalPoints;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	public long getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(long totalPoints) {
		this.totalPoints = totalPoints;
	}

	/**
	 * Overrides the default compareTo() method.
	 * @return - the total points difference of the 
	 * two compared competitor's data
	 */
	public int compareTo(DecathlonData o) throws ClassCastException {
		if (!(o instanceof DecathlonData)) 
			throw new ClassCastException("A Person object expected.");
	 
		long points = ((DecathlonData) o).getTotalPoints();  
	    return (int)(this.totalPoints - points);
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
