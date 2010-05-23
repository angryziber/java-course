package net.azib.java.students.t050731.homework;

/**
 * CalculateFieldScores
 * 
 * Calculates the scores of field events
 * 
 * @author Raigo
 */
public enum CalculateFieldScores {
	LONG_JUMP(0.14354, 220, 1.4), 
	SHOT_PUT(51.39, 1.5, 1.05), 
	HIGH_JUMP(0.8465, 75, 1.42), 
	DISCUS_THROW(12.91, 4, 1.1), 
	POLE_VAULT(0.2797, 100, 1.35), 
	JAVELIN_THROW(10.14, 7, 1.08);

	private final double A, B, C;

	CalculateFieldScores(double A, double B, double C) {
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	/**
	 * This method does the actual calculation of field events
	 * 
	 * @param eventResult athlete's result
	 *          
	 * @return event score
	 */
	public int calculateFieldScore(double eventResult) {
		return (int)(A * Math.pow((eventResult - B), C));
	}
}