package net.azib.java.students.t030633.homework;

/**
 * Event
 * 
 * @author t030633
 */
public enum Event {

	M100(25.437, 18.0, 1.81, true), 
	LONG(0.14354, 220, 1.40, false), 
	SHOT(51.39, 1.5, 1.05, false), 
	HIGH(0.8465, 75, 1.42, false), 
	M400(1.53775, 82, 1.81, true), 
	HURDLES(5.74352, 28.5, 1.92, true), 
	DISCUS(12.91, 4.0, 1.1, false), 
	POLE(0.2797, 100, 1.35, false), 
	JAVELIN(10.14, 7.0, 1.08, false), 
	M1500(0.03768, 480, 1.85, true);

	private final double A, B, C; // calculation constants
	
	/* 
	 * there are two types of events: running and field
	 * property running is true if event is a running event
	 * and false if event is a field event
	 */
	private final boolean running;

	Event(double A, double B, double C, boolean running) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.running = running;
	}

	double points(double performance) {
		if (running)
			// Points = A*(B-P)^C for Running Events
			return A * Math.pow((B - performance), C);
		else
			// Points = A*(P-B)^C for Field Events
			return A * Math.pow((performance - B), C);
	}
	
}
