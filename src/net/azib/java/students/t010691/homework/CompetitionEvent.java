package net.azib.java.students.t010691.homework;

/**
 * CompetitionEvent
 * 
 * Contains definitions of decathlon competition events.
 * Each event has a subset of corresponding formula constants
 * for points calculation.
 *
 * @author Ilja Lutov
 */
enum CompetitionEvent {
	ONE_HUNDRED_METERS_SPRINT(25.437, 18.0, 1.81, 0.24),
	LONG_JUMP(0.14354, 220, 1.40, 0),
	SHOT_PUT(51.39, 1.5, 1.05, 0),
	HIGH_JUMP(0.8465, 75, 1.42, 0),
	FOUR_HUNDRED_METERS_SPRINT(1.53775, 82, 1.81, 0.14),
	ONE_HUNDRED_AND_TEN_METERS_HURDLES(5.74352, 28.5, 1.92, 0.24),
	DISCUS_THROW(12.91, 4.0, 1.1, 0),
	POLE_VAULT(0.2797, 100, 1.35, 0),
	JAVELIN_THROW(10.14, 7.0, 1.08, 0),
	ONE_THOUSAND_AND_FIVE_HUNDRED_METERS_RACE(0.03768, 480, 1.85, 0);
	
	/**
	 * Constructor
	 * 
	 * @param event a decathlon discipline
	 */
	CompetitionEvent(double a, double b, double c, double handTime) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.handTime = handTime;
	}

	/**
	 * Get 'A' constant for a given discipline
	 * 
	 * @return constant 'A' value
	 */
	public double A() {
		return a;
	}

	/**
	 * Get 'B' constant for a given discipline
	 * 
	 * @return constant 'B' value
	 */
	public double B() {
		return b;
	}

	/**
	 * Get 'C' constant for a given discipline
	 * 
	 * @return constant 'C' value
	 */
	public double C() {
		return c;
	}
	
	/**
	 * Get hand time for a given discipline
	 * 
	 * @return hand time
	 */
	public double handTime() {
		return handTime;
	}

	// Decathlon formula constants
	private double a;
	private double b;
	private double c;
	private double handTime;
}
