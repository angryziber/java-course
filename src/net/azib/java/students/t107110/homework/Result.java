package net.azib.java.students.t107110.homework;

import java.text.DateFormat;
import java.util.*;

import static net.azib.java.students.t107110.homework.DecathlonException.decathlonException;

/**
 * @author Eduard Shustrov
 */
public class Result {
	private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);

	private static enum Competition {
		SPRINT_100M, LONG_JUMP, SHOT_PUT, HIGH_JUMP, SPRINT_400M,
		HURDLES_110M, DISCUS_THROW, POLE_VAULT, JAVELIN_THROW, RACE_1500M
	}

	private static final Map<Competition, Coefficient> COEFFICIENT_MAP =
			Collections.unmodifiableMap(new EnumMap<Competition, Coefficient>(Competition.class) {{
				put(Competition.SPRINT_100M, new Coefficient(25.4347, 18.0, 1.81));
				put(Competition.LONG_JUMP, new Coefficient(0.14354, 220.0, 1.4));
				put(Competition.SHOT_PUT, new Coefficient(51.39, 1.5, 1.05));
				put(Competition.HIGH_JUMP, new Coefficient(0.8465, 75.0, 1.42));
				put(Competition.SPRINT_400M, new Coefficient(1.53775, 82.0, 1.81));
				put(Competition.HURDLES_110M, new Coefficient(5.74352, 28.5, 1.92));
				put(Competition.DISCUS_THROW, new Coefficient(12.91, 4.0, 1.1));
				put(Competition.POLE_VAULT, new Coefficient(0.2797, 100.0, 1.35));
				put(Competition.JAVELIN_THROW, new Coefficient(10.14, 7.0, 1.08));
				put(Competition.RACE_1500M, new Coefficient(0.03768, 480.0, 1.85));
			}});

	private final String athleteName;
	private final Date birthday;
	private final String country;
	private final double sprint100m;
	private final double longJump;
	private final double shotPut;
	private final double highJump;
	private final double sprint400m;
	private final double hurdles110m;
	private final double discusThrow;
	private final double poleVault;
	private final double javelinThrow;
	private final double race1500m;
	private final int points;

	private static class Coefficient {
		public final double a;
		public final double b;
		public final double c;

		public Coefficient(final double a, final double b, final double c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public Result(final String athleteName, final Date birthday, final String country,
	              final double sprint100m, final double longJump, final double shotPut, final double highJump,
	              final double sprint400m, final double hurdles110m, final double discusThrow,
	              final double poleVault, final double javelinThrow, final double race1500m) throws DecathlonException {
		this.athleteName = normalizeString(athleteName);
		this.birthday = birthday;
		this.country = normalizeCountry(country);
		this.sprint100m = sprint100m;
		this.longJump = longJump;
		this.shotPut = shotPut;
		this.highJump = highJump;
		this.sprint400m = sprint400m;
		this.hurdles110m = hurdles110m;
		this.discusThrow = discusThrow;
		this.poleVault = poleVault;
		this.javelinThrow = javelinThrow;
		this.race1500m = race1500m;

		checkProperties();
		this.points = calculatePoints();
	}

	@Override
	public String toString() {
		return "Result{" +
				"athleteName='" + athleteName + "', " +
				"birthday='" + (birthday == null ? birthday : DATE_FORMAT.format(birthday)) + "', " +
				"country='" + country + "', " +
				"sprint100m=" + sprint100m + ", " +
				"longJump=" + longJump + ", " +
				"shotPut=" + shotPut + ", " +
				"highJump=" + highJump + ", " +
				"sprint400m=" + sprint400m + ", " +
				"hurdles110m=" + hurdles110m + ", " +
				"discusThrow=" + discusThrow + ", " +
				"poleVault=" + poleVault + ", " +
				"javelinThrow=" + javelinThrow + ", " +
				"race1500m=" + race1500m + ", " +
				"points=" + points +
				'}';
	}

	public String getAthleteName() {
		return athleteName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getCountry() {
		return country;
	}

	public double getSprint100m() {
		return sprint100m;
	}

	public double getLongJump() {
		return longJump;
	}

	public double getShotPut() {
		return shotPut;
	}

	public double getHighJump() {
		return highJump;
	}

	public double getSprint400m() {
		return sprint400m;
	}

	public double getHurdles110m() {
		return hurdles110m;
	}

	public double getDiscusThrow() {
		return discusThrow;
	}

	public double getPoleVault() {
		return poleVault;
	}

	public double getJavelinThrow() {
		return javelinThrow;
	}

	public double getRace1500m() {
		return race1500m;
	}

	public int getPoints() {
		return points;
	}

	private String normalizeString(final String string) {
		return string.trim().replaceAll("\\s+", " ");
	}

	private String normalizeCountry(final String country) {
		return normalizeString(country).toUpperCase();
	}

	private void checkProperties() throws DecathlonException {
		checkStringNotEmpty(athleteName, Message.NO_ATHLETE_NAME);
		checkDate();
		checkCountry();
		checkNumberNotZero(sprint100m, Message.NO_SPRINT_100M);
		checkNumberNotZero(longJump, Message.NO_LONG_JUMP);
		checkNumberNotZero(shotPut, Message.NO_SHOT_PUT);
		checkNumberNotZero(highJump, Message.NO_HIGH_JUMP);
		checkNumberNotZero(sprint400m, Message.NO_SPRINT_400M);
		checkNumberNotZero(hurdles110m, Message.NO_HURDLES_110M);
		checkNumberNotZero(discusThrow, Message.NO_DISCUS_THROW);
		checkNumberNotZero(poleVault, Message.NO_POLE_VAULT);
		checkNumberNotZero(javelinThrow, Message.NO_JAVELIN_THROW);
		checkNumberNotZero(race1500m, Message.NO_RACE_1500M);
	}

	private void checkStringNotEmpty(final String string, final Message errorMessageID) throws DecathlonException {
		if (string.isEmpty()) throw decathlonException(errorMessageID, toString());
	}

	private void checkDate() throws DecathlonException {
		if (birthday == null) throw decathlonException(Message.NO_BIRTHDAY, toString());
	}

	private void checkCountry() throws DecathlonException {
		checkStringNotEmpty(country, Message.NO_COUNTRY);
		if (country.length() != 2) throw decathlonException(Message.NOT_ISO2_COUNTRY, toString());
	}

	private void checkNumberNotZero(final double number, final Message errorMessageID) throws DecathlonException {
		if (number == 0.0) throw decathlonException(errorMessageID, toString());
	}

	private int calculatePoints() {
		return runningPoints(Competition.SPRINT_100M, sprint100m) +
				jumpingPoints(Competition.LONG_JUMP, longJump) +
				throwingPoints(Competition.SHOT_PUT, shotPut) +
				jumpingPoints(Competition.HIGH_JUMP, highJump) +
				runningPoints(Competition.SPRINT_400M, sprint400m) +
				runningPoints(Competition.HURDLES_110M, hurdles110m) +
				throwingPoints(Competition.DISCUS_THROW, discusThrow) +
				jumpingPoints(Competition.POLE_VAULT, poleVault) +
				throwingPoints(Competition.JAVELIN_THROW, javelinThrow) +
				runningPoints(Competition.RACE_1500M, race1500m);
	}

	private int runningPoints(final Competition competition, final double result) {
		final Coefficient coefficient = COEFFICIENT_MAP.get(competition);
		return points(coefficient, coefficient.b - result);
	}

	private int throwingPoints(final Competition competition, final double result) {
		final Coefficient coefficient = COEFFICIENT_MAP.get(competition);
		return points(coefficient, result - coefficient.b);
	}

	private int jumpingPoints(final Competition competition, final double result) {
		final Coefficient coefficient = COEFFICIENT_MAP.get(competition);
		return points(coefficient, 100.0 * result - coefficient.b);
	}

	private int points(final Coefficient coefficient, final double delta) {
		return (int) (coefficient.a * Math.pow(delta, coefficient.c));
	}
}
