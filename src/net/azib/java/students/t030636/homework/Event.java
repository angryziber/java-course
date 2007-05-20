package net.azib.java.students.t030636.homework;

/**
 * Events - Decathlon events
 * This enum holds information about the decathlon events. Points calculation method is included
 * in the enum. 
 *
 * @author Martin
 */
public enum Event {
	HUNDREDMETERSDASH (25.437, 18, 1.81, "sec"),
	LONGJUMP (0.14354, 220, 1.40, "cm"),
	SHOTPUT (51.39, 1.5, 1.05, "m"),
	HIGHJUMP (0.8465, 75, 1.42, "cm"),
	FOURHUNDREDMETERS(1.53775, 82, 1.81, "sec"),
	HUNDREDANDTENHURDLES(5.74352, 28.5, 1.92, "sec"),
	DISCUSTHROW (12.91, 4, 1.1, "m"),
	POLEVAULT (0.2797, 100, 1.35, "cm"),
	JAVELINTHROW (10.14, 7, 1.08, "m"),
	FINALRUN (0.03768, 480, 1.85, "sec");
	
	private final double first;
	private final double second;
	private final double third;
	private final String unit;
	
	Event (double first, double second, double third, String unit) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.unit = unit;
	}
	
	/**
	 * Returns the first variable used in the points calculation formula
	 *
	 * 
	 */
	public double first() { return first; };
	public double second() { return second; };
	public double third() { return third; };
	public String unit() { return unit; };
	
	/**
	 * returnPointForTheEvent method returns an Integer value which is the points for the specified event. 
	 * @param result - the result for the event - in meters (shot put, discus throw, javelin throw)
	 * , centimeters (other filed events) or seconds (running events). 
	 *  
	 */
	public int returnPointsForTheEvent(double result) {
		if (this.ordinal() == 0 | this.ordinal() == 4 | this.ordinal() == 5 | this.ordinal() == 9) 
			return (int) (first *  Math.pow((second - result), third));
		else 
			return (int) (first *  Math.pow((result - second), third));
	}

}
