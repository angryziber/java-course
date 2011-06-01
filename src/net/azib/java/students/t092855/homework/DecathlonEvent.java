package net.azib.java.students.t092855.homework;


import static java.lang.Math.pow;

/**
 * DecathlonEvent
 *
 * Holds all different decathlon events with descriptive name and is able to calculate score from results
 *
 * @author t092855
 */
public enum DecathlonEvent {
	EVENT_100M(25.4347, 18.0, 1.81, "100 m"),
   	EVENT_LONG_JUMP(0.14354, 220.0, 1.4, "Long jump"),
	EVENT_SHOT_PUT(51.39, 1.5, 1.05, "Shot put"),
	EVENT_HIGH_JUMP(0.8465, 75.0, 1.42, "High jump"),
	EVENT_400M(1.53775, 82.0, 1.81, "400 m"),
	EVENT_110M_HURDLES(5.74352, 28.5, 1.92, "110 m hurdles"),
	EVENT_DISCUS_THROW(12.91, 4.0, 1.1, "Discus throw"),
	EVENT_POLE_VAULT(0.2797, 100.0,	1.35, "Pole vault"),
	EVENT_JAVELIN_THROW(10.14, 7.0, 1.08, "Javelin throw"),
	EVENT_1500M(0.03768, 480.0, 1.85, "Event 1500 m");

	private final double aCoefficient;
	private final double bCoefficient;
	private final double cCoefficient;
	private final String name;

	/**
	 * DecathlonEvent
	 * Constructor for enumeration. Coefficients for score calculation for evert event are initialized.
	 * Name of the event is initialized.
	 *
	 * @param a coefficient
	 *
	 * @param b coefficient
	 *
	 * @param c coefficient
	 *
	 * @param name user friendly name of the event
	 */
	DecathlonEvent(double a, double b, double c, String name) {
		this.aCoefficient = a;
		this.bCoefficient = b;
		this.cCoefficient = c;
		this.name = name;
	}

	/**
	 * Decathlon event's points calculator
	 * The following formulas are used: <br>
	 * Points = INT(A*(B-result)C) for track events <br>
	 * Points = INT(A*(result-B)C) for throwing events  <br>
	 * Points = INT(A*(result*100-B)C) for jumping events
	 *
	 * @param result of the event.
	 *          In seconds for track events.
	 *          In metres for jumping and throwing events
	 *
	 * @return points for the even
	 */
	public int calculatePoints(double result) {
		if (result < 0.0)
			return 0;
		int returnValue = 0;
		switch (this) {
			case EVENT_100M:
			case EVENT_110M_HURDLES:
			case EVENT_400M:
			case EVENT_1500M:
				returnValue = (int)(aCoefficient * pow((bCoefficient - result), cCoefficient));
			break;
			case EVENT_HIGH_JUMP:
			case EVENT_LONG_JUMP:
			case EVENT_POLE_VAULT:
				returnValue = (int)(aCoefficient * pow((result * 100 - bCoefficient), cCoefficient));
			break;
			case EVENT_DISCUS_THROW:
			case EVENT_JAVELIN_THROW:
			case EVENT_SHOT_PUT:
				returnValue = (int)(aCoefficient * pow((result - bCoefficient), cCoefficient));
			break;
		}
		return returnValue;
	}

	/**
	 * User friendly name of the event
	 *
	 * @return name the event
	 */
	@Override
	public String toString() {
		return name;
	}
}
