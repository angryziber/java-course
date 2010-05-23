package net.azib.java.students.t050724.homework;

/**
 * Event <p>
 * 
 * Holds the parameters for each event.
 * 
 * @author xom
 */
public enum Event {
	
	HM (25.4347, 18, 1.81, -1),
	LONGJUMP (0.14354, 220, 1.4, 1),
	SHOTPUT (51.39, 1.5, 1.05, 1),
	HIGHJUMP (0.8465, 75, 1.42, 1),
	FHM (1.53775, 82, 1.81, -1),
	HTMHURDLES (5.74352, 28.5, 1.92, -1),
	DISCUSTHROW (12.91, 4, 1.1, 1),
	POLEVAULT (0.2797, 100, 1.35, 1),
	JAVELINTHROW (10.14, 7, 1.08, 1),
	TFHM (0.03768, 480, 1.85, -1);
	
	private final double A, B, C, type;
	
	Event(double A, double B, double C, double type){
		this.A = A;
		this.B = B;
		this.C = C;
		this.type = type;
	}
	
//	public double A() {return A; }
//	public double B() {return B; }
//	public double C() {return C; }
	
	/**
	 *Returns the score according to result.
	 *Parameter 'type' is used to make the formula uniform for field and track events.
	 *
	 * @param result The result of the event.
	 * 
	 * @return Score of the event without commas.
	 */
	protected int eventScore(double result){
		return (int) (A * Math.pow((type * (result - B)), C));
	}

}
