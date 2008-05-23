package net.azib.java.students.t030633.homework.model;

/**
 * Decathlon events and point calculations.
 * 
 * @author t030633
 */
public enum Event {

	R100M("100 m dash", 25.437D, 18.0D, 1.81D),
	LONGJ("Long jump", 0.14354D, 220D, 1.40D),
	SHOT("Shot put", 51.39D, 1.5D, 1.05D),
	HIGH("High jump", 0.8465D, 75D, 1.42D),
	R400M("400 m dash", 1.53775D, 82D, 1.81D),
	R110MH("110 m high hurdles", 5.74352D, 28.5D, 1.92D),
	DISCUS("Discus throw", 12.91D, 4.0D, 1.1D),
	POLE("Pole vault", 0.2797D, 100D, 1.35D),
	JAVELIN("Javelin throw", 10.14D, 7.0D, 1.08D),
	R1500M("1500 m run", 0.03768D, 480D, 1.85D);

	private final double A, B, C; // calculation constants
	private final String name;

	Event(String name, double A, double B, double C) {
		this.name = name;
		this.A = A;
		this.B = B;
		this.C = C;
	}

	/**
	 * @param performance -
	 *            double, performance in the event 
	 *            all distances in meters, all times in seconds
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
			// formula assumes cm units for three events, but all performances are in meters
			if(name().equals("LONGJ") || name().equals("HIGH") || name().equals("POLE")) 
				performance = performance * 100;
			// Points = A*(P-B)^C for Field Events
			return (int) Math.floor(A * Math.pow((performance - B), C));
	}

	/**
	 * @return String - nicely formatted event name
	 */
	public String getName() {
		return name;
	}

}