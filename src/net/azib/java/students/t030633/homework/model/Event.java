package net.azib.java.students.t030633.homework.model;

/**
 * Decathlon events and point calculations.
 * 
 * @author t030633
 */
public enum Event {

	R100M("100 m dash", 25.437D, 18.0D, 1.81D), // 100 m dash
	LONG("Long jump", 0.14354D, 220D, 1.40D),  // long jump
	SHOT("Shot put", 51.39D, 1.5D, 1.05D),  // shot put
	HIGH("High jump", 0.8465D, 75D, 1.42D),  // high jump
	R400M("400 m dash", 1.53775D, 82D, 1.81D), // 400 m dash
	R110MH("110 m high hurdles", 5.74352D, 28.5D, 1.92D), // 110 m high hurdles
	DISCUS("Discus throw", 12.91D, 4.0D, 1.1D), // discus throw
	POLE("Pole vault", 0.2797D, 100D, 1.35D), // pole vault
	JAVELIN("Javelin throw", 10.14D, 7.0D, 1.08D), // javelin throw
	R1500M("1500 m run", 0.03768D, 480D, 1.85D); // 1500 m run

	private final double A, B, C; // calculation constants
	private final String name;
	
	Event(String name, double A, double B, double C) {
		this.name = name;
		this.A = A;
		this.B = B;
		this.C = C;
	}

	/**
	 * @param performance - double, performance in the event
	 * @return int - points gained from the performance
	 */
	public int points(double performance) {
		if (performance == 0D)
			return 0;
		// there are two types of decathlon events: running and field
		else if (name().startsWith("R"))
			// Points = A*(B-P)^C for Running Events
			return (int) Math.floor(A * Math.pow((B - performance), C));
		else
			// Points = A*(P-B)^C for Field Events
			return (int) Math.floor(A * Math.pow((performance - B), C));
	}

	/**
	 * @return String - event name
	 */
	public String getName() {
		return name;
	}

}