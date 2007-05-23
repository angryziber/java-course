package net.azib.java.students.t030657.homework;

/*
For a given performance, the point score (P) is calculated using one of the
following equations:

Track events	P=a*(b - T)**c	[where T is Time in seconds; e.g. 10.43 for 100 metres]
Jumps			P=a*(M - b)**c	[where M is Measurement in centimetres; e.g. 808 for "LJ".]
Throws			P=a*(D - b)**c	[where D is Distance in metres; e.g. 16.69 for Shot]

a, b and c are parameters whose values are listed below.
 
PARAMETERS (constants for each event)
MEN'S EVENTS	a			b			c
100m (auto)		25.4347		18.00		1.81
200m (auto)		5.8425		38.00		1.81
400m (auto)		1.53775		82.00		1.81
1500m			0.03768		480.00		1.85
110mH (auto)	5.74352		28.50		1.92
High Jump		0.8465		75.00		1.42
Pole Vault		0.2797		100.00		1.35
Long Jump		0.14354		220.00		1.40
Shot			51.39		1.50		1.05
Discus			12.91		4.00		1.10
Javelin			10.14		7.00		1.08

Note: The value of P (points) must be rounded down to a whole number after
	calculation (e.g. 123.999 becomes 123).
 */

/**
 * @author Karina
 * public enum Event
 * All decathlon events are enumerated and processed
 *
 */

public enum Event {
	race100m(	true,	25.4347,	18.00,	1.81),
	longJump(	false,	0.14354,	220.00,	1.40, 100.0),
	shotPut(	false,	51.39,		1.50,	1.05),
	highJump(	false,	0.8465,		75.00,	1.42, 100.0),
	race400m(	true,	1.53775,	82.00,	1.81),
	hurdles110m(true,	5.74352,	28.50,	1.92),
	discusThrow(false,	12.91,		4.00,	1.10),
	poleVault(	false,	0.2797,		100.00,	1.35, 100.0),
	javelinThrow(false,	10.14,		7.00,	1.08),
	race1500m(	true,	0.03768,	480.00,	1.85);

	private double multiplier, minValue, exponent, scale;
	private boolean lessIsBetter;

	Event(boolean lessIsBetter, double multiplier, double minValue, double exponent, double scale) {
		this.lessIsBetter = lessIsBetter;
		this.multiplier = multiplier;
		this.minValue = minValue;
		this.exponent = exponent;
		this.scale = scale;
	}

	Event(boolean lessIsBetter, double multiplier, double minValue, double exponent) {
		this(lessIsBetter, multiplier, minValue, exponent, 1.0);
	}

	double getMinValue() {
		return (minValue);
	}

	long getScore(double value) {
		if (lessIsBetter){
			if (value*scale > minValue) return 0L;
		} else {
			if (value*scale < minValue) return 0L;
		}
		return (long)(multiplier * Math.pow(Math.abs(value*scale-minValue),exponent));
	}
}
