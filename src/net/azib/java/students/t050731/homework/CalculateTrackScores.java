package net.azib.java.students.t050731.homework;

/**
 * CalculateTrackScores
 *
 *Calculates the scores of track events
 *
 * @author Raigo
 */
public enum CalculateTrackScores {
	SPRINT_100M(25.4347, 18, 1.81),
	SPRINT_400M(1.53775, 82, 1.81), 
	HURDLES(5.74352, 28.5, 1.92), 
	SPRINT_1500M(0.03768, 480, 1.85);

	private final double A, B, C;

	CalculateTrackScores(double A, double B, double C) {
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	/**
	 * This method does the actual calculation of track events
	 * 
	 * @param eventResult athlete's result
	 *          
	 * @return event score
	 */
	public int calculateTrackScore(double eventResult) {
		return (int)(A * Math.pow((B - eventResult), C));
	}
}