package net.azib.java.students.t030655.homework;

/**
 * Decathlon - Enumeration for calculating points
 *
 * @version 1.0
 * @author Triin Nestor
 */
public enum Decathlon {
	SPRINT_100M (25.437, 18.0, 1.81),
	LONG_JUMP (0.14354, 220, 1.40),
	SHOT_PUT (51.39, 1.5, 1.05),
	HIGH_JUMP (0.8465, 75, 1.42),
	SPRINT_400M (1.53775, 82, 1.81),
	HURDLES_110M (5.74352, 28.5, 1.92),
	DISCUS_THROW (12.91, 4.0, 1.1),
	POLE_VAULT (0.2797, 100, 1.35),
	JAVELIN_THROW (10.14, 7.0, 1.08),
	RACE_1500M (0.03768, 480, 1.85);
	
	//numbers for calculation
	private final double A;
	private final double B;
	private final double C;
	
	Decathlon (double a, double b, double c){
		this.A = a;
		this.B = b;
		this.C = c;
	}
	
	/**calculation for Running Events according to the performance
	 * 
	 * @param performance - event result in seconds
	 * @return points for event
	 */
	private double calcRunning (double performance){
		return A*Math.pow((B-performance), C);
	}
	
	/**calculations for Field Events according to the performance
	 * 
	 * @param performance - event result in meters or centimeters depending on the event
	 * @return points for event
	 */
	private double calcField (double performance){
		return A*Math.pow((performance-B), C);
	}
		
	/**calculates the points for every branch of decathlon 
	*according to the results
	*
	* @param performance - event result in meters or seconds depending on the event
	* @return points for event
	*/
	public double points (double performance){
		switch (this){
		case SPRINT_100M : 		return calcRunning(performance);
		case SPRINT_400M : 		return calcRunning(performance); //needs performance in SEC
		case HURDLES_110M : 	return calcRunning(performance);
		case RACE_1500M : 		return calcRunning(performance); //needs performance in SEC
		case LONG_JUMP : 		return calcField(100*performance); //performance in centimeters
		case HIGH_JUMP : 		return calcField(100*performance); //performance in centimeters
		case POLE_VAULT : 		return calcField(100*performance); //performance in centimeters
		case SHOT_PUT : 		return calcField(performance);
		case DISCUS_THROW : 	return calcField(performance);
		case JAVELIN_THROW : 	return calcField(performance);
		default : 				return 0.00;
		}
	}
	

}

