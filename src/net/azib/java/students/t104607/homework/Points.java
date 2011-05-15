package net.azib.java.students.t104607.homework;

import static java.lang.Math.pow;

/**
 * @author 104607 IASM
 */

public enum Points {
	SPRINT100M  (25.4347, 18,   1.81, true, false),
	LONGJUMP    (0.14354, 220,  1.4,  false,true),
	SHOTPUT     (51.39,   1.5,  1.05, false,false),
	HIGHJUMP    (0.8465,  75,   1.42, false,true),
	SPRINT400M  (1.53775, 82,   1.81, true, false),
	HURDLES110M (5.74352, 28.5, 1.92, true, false),
	DISCUSTHROW (12.91,   4,    1.1,  false,false),
	POLEVAULT   (0.2797,  100,  1.35, false,true),
	JAVELINTHROW(10.14,   7,    1.08, false,false),
	RACE1500M   (0.03768, 480,  1.85, true, false);

	private final double a;
	private final double b;
	private final double c;
	private final boolean trackEvent;
	private final boolean jumping;

	Points (double a, double b, double c, boolean trackEvent, boolean jumping) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.trackEvent = trackEvent;
		this.jumping = jumping;
	}

	public int getPoints (double p) {
		int result;
		if (jumping) {
			p = p * 100;
		}
		if (trackEvent) {
			result = (int)(a * pow(b - p, c));
		} else {
			result = (int)(a * pow(p - b, c));
		}
		return result;
	}
}
