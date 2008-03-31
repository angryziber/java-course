package net.azib.java.students.t030633.homework;

/**
 * Event
 * 
 * @author t030633
 */
public enum Event {

	M100(25.437D, 18.0D, 1.81D, true), 
	LONG(0.14354D, 220D, 1.40D, false), 
	SHOT(51.39D, 1.5D, 1.05D, false), 
	HIGH(0.8465D, 75D, 1.42D, false), 
	M400(1.53775D, 82D, 1.81D, true), 
	HURDLES(5.74352D, 28.5D, 1.92D, true), 
	DISCUS(12.91D, 4.0D, 1.1D, false), 
	POLE(0.2797D, 100D, 1.35D, false), 
	JAVELIN(10.14D, 7.0D, 1.08D, false), 
	M1500(0.03768D, 480D, 1.85D, true);

	private final double A, B, C; // calculation constants

	/*
	 * there are two types of events: running and field property running is true
	 * if event is a running event and false if event is a field event
	 */
	private final boolean running;

	Event(double A, double B, double C, boolean running) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.running = running;
	}

	int points(double performance) {
		if (performance == 0D)
			return 0;
		else if (running)
			// Points = A*(B-P)^C for Running Events
			return (int) Math.floor(A * Math.pow((B - performance), C));
		else
			// Points = A*(P-B)^C for Field Events
			return (int) Math.floor(A * Math.pow((performance - B), C));
	}

}
