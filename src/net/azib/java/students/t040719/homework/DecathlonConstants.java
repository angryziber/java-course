package net.azib.java.students.t040719.homework;



/**
 * DecathlonConstant
 *
 * @author romi
 */
public enum DecathlonConstants {
	HUNDRED_M(25.437, 18.0, 1.81, 1, true, "100 m sprint"),
	LONG_JUMP(0.14354, 220, 1.40, 100, false, "Long jump"),
	SHOT_PUT(51.39, 1.5, 1.05, 1, false, "Shot put"),
	HIGH_JUMP(0.8465, 75, 1.42,	100, false, "High jump"),
	FOUR_HUNDRED_M(1.53775, 82, 1.81, 1, true, "400 m sprint"),
	HUNDRED_TEN_M_HURDLES(5.74352, 28.5, 1.92, 1, true, "110 m hurdles"),
	DISCUS_THROW(12.91, 4.0, 1.1, 1, false, "Discus throw"),
	POLE_VAULT(0.2797, 100, 1.35, 100, false, "Pole vault"),
	JAVELIN_THROW(10.14, 7.0, 1.08, 1, false, "Javelin throw"),
	FIFTEENHUNDRED_M(0.03768, 480, 1.85, 1, true, "1500 m race");
	
	private final double A;
    private final double B;
    private final double C;
    private final int multiplier;
    private final boolean runningEvent;
    private final String name;
    
    DecathlonConstants(double A, double B, double C, int multiplier, boolean runningEvent, String name) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.multiplier = multiplier;
		this.runningEvent = runningEvent;
		this.name = name;
    }
    
    public String getName(){
    	return toString();
    }

	@Override
	public String toString() {
		return name;
	}
    
	public DecathlonConstants next() {
		return values()[(this.ordinal() + 1) % values().length];
	}
    
	public float calculateEventPoints(float rawResults){
		if (runningEvent)
			return (float)(A*Math.pow(B-rawResults*multiplier, C));
		else
			return (float)(A*Math.pow(rawResults*multiplier-B, C));
	}
	
	public static DecathlonConstants getOrdinal(int i){
		i %= values().length;
		return values()[i];
	}
}
