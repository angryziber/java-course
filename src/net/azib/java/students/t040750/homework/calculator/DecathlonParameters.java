package net.azib.java.students.t040750.homework.calculator;

/**
 * The {@link DecathlonParameters} enum contains methods for
 * calculating the points for decathlon events according to 
 * the formula used in the sport.
 * 
 * @author Karpz
 *
 */
public enum DecathlonParameters {
	RUN_100M 		(25.4347, 	18, 	1.81),
	LONG_JUMP 		(0.14354, 	220, 	1.4),
	SHOT_PUT 		(51.39, 	1.5, 	1.05),
	HIGH_JUMP 		(0.8465, 	75, 	1.42),
	RUN_400M 		(1.53775, 	82, 	1.81),
	HURDLES_110M 	(5.74352, 	28.5, 	1.92),
	DISCUS 			(12.91, 	4, 		1.1),
	POLE_VAULT 		(0.2797, 	100, 	1.35),
	JAVELIN 		(10.14, 	7, 		1.08),
	RUN_1500M 		(0.03768, 	480, 	1.85);
	
	private final double a;
	private final double b;
	private final double c;
	
	DecathlonParameters(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
	 * Calculates points for track event
	 * 
	 * @param p - result of the respective event
	 * @return the points calculated using the track event formula
	 */
	public long trackPoints(float p) {
		if (p != 0) return (long)(a*Math.pow((b-p),c));
		else return 0;
	}
	
	/**
	 * Calculates points for field event
	 * 
	 * @param p - result of the respective event
	 * @return the points calculated using the field event formula
	 */
	public long fieldPoints(float p) {
		if (p != 0) return (long)(a*Math.pow((p-b),c));
		else return 0;
	}
}
