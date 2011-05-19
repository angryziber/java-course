package net.azib.java.students.t104607.homework;

import static java.lang.Math.pow;

/**
 * Enum that holds the decathlon formula and constants for calculating points
 * <p>
 * The 2001 IAAF points tables use the following formulae:
 * <li>Points = <b>INT(A*(B-P)<sup>C</sup>)</b> for track events</li>
 * <li>Points = <b>INT(A*(P-B)<sup>C</sup>)</b> for jumping and throwing events</li>
 * <p>
 * A, B and C are parameters that vary by discipline,
 * while P is the performance by the athlete,
 * measured in seconds (running), metres (throwing), or centimetres (jumping).
 *
 * @author 104607 IASM
 */
public enum Points {
	/**
	 * 100 metres sprint
	 * <p>
	 *     Contains:
	 * <li>values of A,B,C</li>
	 * <li>run - true</li>
	 * <li>jump - false</li>
	 */
	SPRINT100M  (25.4347, 18,   1.81, true, false),
	/**
	 * Long jump
	 * <p>
	 *     Contains:
	 * <li>values of A,B,C</li>
	 * <li>run - false</li>
	 * <li>jump - true</li>
	 */
	LONGJUMP    (0.14354, 220,  1.4,  false,true),
	/**
	 * Shot put
	 * <p>
	 *     Contains:
	 * <li>values of A,B,C</li>
	 * <li>run - false</li>
	 * <li>jump - false</li>
	 */
	SHOTPUT     (51.39,   1.5,  1.05, false,false),
	/**
	 * High jump
	 * <p>
	 *     Contains:
	 * <li>values of A,B,C</li>
	 * <li>run - false</li>
	 * <li>jump - true</li>
	 */
	HIGHJUMP    (0.8465,  75,   1.42, false,true),
	/**
	 * 400 metres sprint
	 * <p>
	 *     Contains:
	 * <li>values of A,B,C</li>
	 * <li>run - true</li>
	 * <li>jump - false</li>
	 */
	SPRINT400M  (1.53775, 82,   1.81, true, false),
	/**
	 * 110 metres hurdles
	 * <p>
	 *     Contains:
	 * <li>values of A,B,C</li>
	 * <li>run - true</li>
	 * <li>jump - false</li>
	 */
	HURDLES110M (5.74352, 28.5, 1.92, true, false),
	/**
	 * Discus throw
	 * <p>
	 *     Contains:
	 * <li>values of A,B,C</li>
	 * <li>run - false</li>
	 * <li>jump - false</li>
	 */
	DISCUSTHROW (12.91,   4,    1.1,  false,false),
	/**
	 * Pole vault
	 * <p>
	 *     Contains:
	 * <li>values of A,B,C</li>
	 * <li>run - false</li>
	 * <li>jump - true</li>
	 */
	POLEVAULT   (0.2797,  100,  1.35, false,true),
	/**
	 * Javelin throe
	 * <p>
	 *     Contains:
	 * <li>values of A,B,C</li>
	 * <li>run - false</li>
	 * <li>jump - false</li>
	 */
	JAVELINTHROW(10.14,   7,    1.08, false,false),
	/**
	 * 1500 metres run
	 * <p>
	 *     Contains:
	 * <li>values of A,B,C</li>
	 * <li>run - true</li>
	 * <li>jump - false</li>
	 */
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

	/**
	 * method for calculating decathlon points
	 * @param p raw result from race
	 * @return result of calculating
	 */
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
