package net.azib.java.students.t060401.homework.decathlon;

/**
 * DecathlonEventEnum
 * 
 * Enum for holding decathlon event constants
 *
 * @author t060401
 */
public enum DecathlonEventEnum {

	SPRINT_100M (25.437, 18.0, 1.81, "s", 1),
	LONG_JUMP (0.14354, 220, 1.40, "cm", 2),
	SHOT_PUT (51.39, 1.5, 1.05, "m", 3),
	HIGH_JUMP (0.8465, 75, 1.42, "cm", 4),
	SPRINT_400M (1.53775, 82, 1.81, "s", 5),
	HURDLES_110M (5.74352, 28.5, 1.92, "m", 6),
	DISCUS_THROW (12.91, 4.0, 1.1, "m", 7),
	POLE_VAULT (0.2797, 100, 1.35, "cm", 8),
	JAVELIN_THROW (10.14, 7.0, 1.08, "m", 9),
	RACE_1500M (0.03768, 480, 1.85, "s", 10);
	
    private final double a;
    private final double b;
    private final double c;
    private final String performanceUnit;
    private final int position;
    
    DecathlonEventEnum(double a, double b, double c, String unit, int position) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.performanceUnit = unit;
		this.position = position;
	}

    /**
	 * @return returns constant A value in decathlon points formula (A*(B-P)^C or A*(P-B)^C depending on the event type)
	 */
	public double getA() {
		return a;
	}
	
	/**
	 * @return returns constant B value in decathlon points formula (A*(B-P)^C or A*(P-B)^C depending on the event type)
	 */
	public double getB() {
		return b;
	}
	
	/**
	 * @return returns constant A value in decathlon points formula (A*(B-P)^C or A*(P-B)^C depending on the event type)
	 */
	public double getC() {
		return c;
	}
	
	/**
	 * @return returns SI base unit symbol of a performance which should be used in decathlon points formulas (A*(B-P)^C or A*(P-B)^C depending on the event type)
	 */
	public String getPerformanceUnit() {
		return performanceUnit;
	}
	
	/**
	 * @return returns the position of an event when ordering events
	 */
	public int getPosition() {
		return position;
	}
}
