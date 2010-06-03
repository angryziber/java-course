package net.azib.java.students.t073639.homework;

import java.math.BigDecimal;

/**
 * <p>Enumeration of possible events in decathlon.
 * <br>Calculates points for this event.
 * <br>BigDecimal is used for precise calculation.
 * @author t073639
 */
public enum Event {
	M100(25.4347, 18.0, 1.81), 
	LONGJUMP(0.14354, 220.0, 1.4), 
	SHOTPUT(51.39, 1.5, 1.05), 
	HIGHJUMP(0.8465, 75.0, 1.42), 
	M400(1.53775, 82.0, 1.81), 
	M110HURDLES(5.74352, 28.5, 1.92), 
	DISCUSTHROW(12.91, 4.0, 1.1), 
	POLEVAULT(0.2797, 100.0, 1.35), 
	JAVELINTHROW(10.14, 7.0, 1.08), 
	M1500(0.03768, 480.0, 1.85);

	private final BigDecimal a;
	private final BigDecimal b;
	private final BigDecimal c;

	Event(Double a, Double b, Double c) {
		this.a = new BigDecimal(a);
		this.b = new BigDecimal(b);
		this.c = new BigDecimal(c);
	}

	/**
	 * <p>Method calculates points for this event. 
	 * @param p - result of athlete in this event.
	 * @return Calculated points for this event.
	 */
	public BigDecimal getPoints(BigDecimal p) {
		if (b.doubleValue() - p.doubleValue() > 0)
			return a.multiply(new BigDecimal(Math.pow(b.doubleValue() - p.doubleValue(), c.doubleValue())));
		else
			return a.multiply(new BigDecimal(Math.pow(p.doubleValue() - b.doubleValue(), c.doubleValue())));
	}

	/**
	 * <p>Get next event.
	 * @return Next event.
	 */
	public Event next() {
		return values()[(ordinal() + 1) % values().length];
	}
}
