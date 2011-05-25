package net.azib.java.students.t103640.homework;

public enum Events {
    HUNDREDSPRINT (25.4347, 18, 1.81, -1),
	LONGJUMP (0.14354, 220, 1.4, 1),
	SHOTPUT (51.39, 1.5, 1.05, 1),
	HIGHJUMP (0.8465, 75, 1.42, 1),
	FOURHMSPRINT (1.53775, 82, 1.81, -1),
	HUNDREDANDTMHURDLES (5.74352, 28.5, 1.92, -1),
	DISCUSTHROW (12.91, 4, 1.1, 1),
	POLEVAULT (0.2797, 100, 1.35, 1),
	JAVELINTHROW (10.14, 7, 1.08, 1),
	KILOMETERANDHALF (0.03768, 480, 1.85, -1);

    private double A, B, C, trackOrThrow;

    Events(double A, double B, double C, double t) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.trackOrThrow = t;
    }

	/**
	 * This method calculates the given event score.
	 * @param result in the given event
	 * @return score in the given event
	 */
    public int eventScore(double result){
        return (int) (A * Math.pow((trackOrThrow *(result - B)), C));
    }

	/**
	 * This method returns the  ordinal of next event
	 * @return next events data
	 */
    	public Events next() {
		return values()[(ordinal() + 1) % values().length];
	}
}
