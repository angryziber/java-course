package net.azib.java.students.t040719.homework;



/**
 * DecathlonConstant - enum for holdin constants needed for calculating event results
 *
 * @version 1.0
 * @author Romi Agar
 */
public enum DecathlonConstants {
	HUNDRED_M(25.437, 18.0, 1.81, 1, true, "100 m sprint","sec"),
	LONG_JUMP(0.14354, 220, 1.40, 100, false, "Long jump","m"),
	SHOT_PUT(51.39, 1.5, 1.05, 1, false, "Shot put","m"),
	HIGH_JUMP(0.8465, 75, 1.42,	100, false, "High jump","m"),
	FOUR_HUNDRED_M(1.53775, 82, 1.81, 1, true, "400 m sprint","min:sec"),
	HUNDRED_TEN_M_HURDLES(5.74352, 28.5, 1.92, 1, true, "110 m hurdles","sec"),
	DISCUS_THROW(12.91, 4.0, 1.1, 1, false, "Discus throw","m"),
	POLE_VAULT(0.2797, 100, 1.35, 100, false, "Pole vault","m"),
	JAVELIN_THROW(10.14, 7.0, 1.08, 1, false, "Javelin throw","m"),
	FIFTEENHUNDRED_M(0.03768, 480, 1.85, 1, true, "1500 m race","min:sec");
	
	private final double A;
    private final double B;
    private final double C;
    private final int multiplier;
    private final boolean runningEvent;
    private final String name;
	private final String unit;
    
    DecathlonConstants(double A, double B, double C, int multiplier, boolean runningEvent, String name, String unit) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.multiplier = multiplier;
		this.runningEvent = runningEvent;
		this.name = name;
		this.unit = unit;
    }
    
    /**
     * @return returns the name of the event
     */
    public String getName(){
    	return toString();
    }
    
    /**
     * @return returns the unit of the event
     */
    public String getUnit(){
    	return unit;
    }

	/**
	 * Overrides the default toString() method
	 * in order to get more human readable output
	 */
	@Override
	public String toString() {
		return name;
	}
    
	/**
	 * @return returns the next event
	 */
	public DecathlonConstants next() {
		return values()[(this.ordinal() + 1) % values().length];
	}
    
	/**
	 * Calculates event points for given event and results
	 * @param rawResults event results in the format of 0.00f
	 * @return returns the event points
	 */
	public float calculateEventPoints(float rawResults){
		if (runningEvent)
			return (float)(A*Math.pow(B-rawResults*multiplier, C));
		else
			return (float)(A*Math.pow(rawResults*multiplier-B, C));
	}
	
	/**
	 * Returns the event by its ordinal position
	 * @param i ordinal position (0...9)
	 * @return returns the event on position i
	 */
	public static DecathlonConstants getOrdinal(int i){
		i %= values().length;
		return values()[i];
	}
}
