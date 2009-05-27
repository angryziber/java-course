package net.azib.java.students.t030620.homework.enums;

/**
 * Competition
 *
 * @author Lord HellBunny
 */
public enum Competition {
	
	SPRINT_100(25.4347, 18, 1.81, CompetitionType.TRACK, "100 m sprint (sec)"),
	LONG_JUMP(0.14354,220,1.4,CompetitionType.FIELD, "Long jump (m)"),
	SHOT_PUT(51.39, 1.5, 1.05,CompetitionType.FIELD, "Shot put (m)"),
	HIGH_JUMP(0.8465,75,1.42,CompetitionType.FIELD, "High jump (m)"),
	SPRINT_400(1.53775,82,1.81,CompetitionType.TRACK, "400 m sprint (min:sec)"),
	HURDLES(5.74352,28.5,1.92,CompetitionType.TRACK, "110 m hurdles (sec)"),
	DISCUS_THROW(12.91,4,1.1,CompetitionType.FIELD, "Discus throw (m)"),
	POLE_VAULT(0.2797,100,1.35,CompetitionType.FIELD, "Pole vault (m)"),
	JAVELIN_THROW(10.14 ,7,1.08,CompetitionType.FIELD, "Javelin throw (m)"),
	RACE(0.03768,480,1.85,CompetitionType.TRACK, "1500 m race (min:sec)");

	private double a;
	private double b;
	private double c;
	private CompetitionType type;
	private String name;

	private Competition(double a, double b, double c, CompetitionType type, String name) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.type = type;
		this.name = name;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	public CompetitionType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

}
