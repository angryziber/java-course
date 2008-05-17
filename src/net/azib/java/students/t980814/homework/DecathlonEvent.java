package net.azib.java.students.t980814.homework;

/**
 * Enum, that contains the information and some basic methods about all 10 decathlon events.
 *
 * @author Allan Berg
 */
public enum DecathlonEvent {

	RACE_100M     ("race_100m",     25.437,   18.0, 1.81, true,  1),
	LONG_JUMP     ("long_jump",     0.14354,   220, 1.40, false, 100),
	SHOT_PUT      ("shot_put",      51.39,    1.50, 1.05, false, 1),
	HIGH_JUMP     ("high_jump",     0.8465,     75, 1.42, false, 100),
	RACE_400M     ("race_400m",     1.53775,  82.0, 1.81, true,  1),
	HURDLES_110M  ("hurdles_110m",  5.74352,  28.5, 1.92, true,  1),
	DISCUS_THROW  ("discus_throw",  12.91,     4.0, 1.10, false, 1),
	POLE_VAULT    ("pole_vault",    0.2797,    100, 1.35, false, 100),
	JAVELIN_THROW ("javelin_throw", 10.14,     7.0, 1.08, false, 1),
	RACE_1500M    ("race_1500m",    0.03768, 480.0, 1.85, true,  1);

	public  final String  key;
	private final double  A;
	private final double  B;
	private final double  C;
	public  final boolean isRunningEvent;
	private final int     multiplier;

	/**
	 * @param databaseName - a key that is used to identify this event
	 * @param a - coef. in points calculation formula
	 * @param b - coef. in points calculation formula
	 * @param c - coef. in points calculation formula
	 * @param isRunningEvent - if this event is a running event
	 * @param multiplier - the input data is multiplied by this value when making calculations 
	 */
	private DecathlonEvent(String key,
						   double a, double b, double c,
						   boolean isRunningEvent,
						   int multiplier) {
		this.key = key;
		this.isRunningEvent = isRunningEvent;
		this.multiplier = multiplier;
		A = a;
		B = b;
		C = c;
	}

	/**
	 * Returns the next value in current enum
	 * @return DecathlonEvent
	 */
	public DecathlonEvent next() {
		return values()[(this.ordinal() + 1) % values().length];
	}

	/**
	 * Verifies if there is a next value present in current enum or are we aready on the last one
	 * @return boolean
	 */
	public boolean hasNext() {
		return (values().length > 0) && (this.ordinal() < (values().length - 1));
	}
	
	/**
	 * Returns list of all the <b>key</b>-s in this enum
	 * @return String[]
	 */
	public static String[] getAllKeys() {
		String[] names = new String[values().length];
		for (int i = 0; i < values().length; i++)
			names[i] = values()[i].key;
		return names;
	}
	
	/**
	 * Returns the enum value that matches the <b>key</b>
	 * @param key - key 
	 * @return DecathlonEvent or null if the key wasn't found in this enum
	 */
	public static DecathlonEvent getDecathlonEventByKey(String key) {
		for (DecathlonEvent e : values())
			if (e.key.equals(key))
				return e;
		return null;
	}
	
	/**
	 * Calculates and returns the points of this enum value
	 * @param d - the result of this event
	 * @return int
	 */
	public int calcPoints(double d) {
		if (isRunningEvent)
			return new Integer((int) (A * Math.pow((B - d*multiplier), C)));
		else
			return new Integer((int) (A * Math.pow((d*multiplier - B), C)));	
	}
}
