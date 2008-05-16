package net.azib.java.students.t980814.homework;

/**
 * Event
 *
 * @author dell
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
	 * @param databaseName
	 * @param a
	 * @param b
	 * @param c
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
	 * @return
	 */
	public DecathlonEvent next() {
		return values()[(this.ordinal() + 1) % values().length];
	}

	/**
	 * @return
	 */
	public boolean hasNext() {
		return (values().length > 0) && (this.ordinal() < (values().length - 1));
	}
	
	/**
	 * @return
	 */
	public static String[] getAllKeys() {
		String[] names = new String[values().length];
		for (int i = 0; i < values().length; i++)
			names[i] = values()[i].key;
		return names;
	}
	
	/**
	 * @param key
	 * @return
	 */
	public static DecathlonEvent getDecathlonEventByKey(String key) {
		for (DecathlonEvent e : values())
			if (e.key.equals(key))
				return e;
		return null;
	}
	
	/**
	 * @param d
	 * @return
	 */
	public int calcPoints(double d) {
		if (isRunningEvent)
			return new Integer((int) (A * Math.pow((B - d*multiplier), C)));
		else
			return new Integer((int) (A * Math.pow((d*multiplier - B), C)));	
	}
}
