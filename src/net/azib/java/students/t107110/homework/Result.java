package net.azib.java.students.t107110.homework;

import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eduard Shustrov
 */
public class Result {
	private static final MessageLoader MESSAGES = new MessageLoader(Result.class);
	private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

	private static final String NO_NAME_ID = "no_name";
	private static final String NO_BIRTHDAY_ID = "no_birthday";
	private static final String NO_COUNTRY_ID = "no_country";
	private static final String NOT_ISO2_COUNTRY_ID = "not_iso2_country";
	private static final String NO_SPRINT_100M_RESULT_ID = "no_sprint_100m";
	private static final String NO_LONG_JUMP_RESULT_ID = "no_long_jump";
	private static final String NO_SHOT_PUT_RESULT_ID = "no_shot_put";
	private static final String NO_HIGH_JUMP_RESULT_ID = "no_high_jump";
	private static final String NO_SPRINT_400M_RESULT_ID = "no_sprint_400m";
	private static final String NO_HURDLES_110M_RESULT_ID = "no_hurdles_110m";
	private static final String NO_DISCUS_THROW_RESULT_ID = "no_discus_throw";
	private static final String NO_POLE_VAULT_RESULT_ID = "no_pole_vault";
	private static final String NO_JAVELIN_THROW_RESULT_ID = "no_javelin_throw";
	private static final String NO_RACE_1500M_RESULT_ID = "no_race_1500m";

	private static final String SPRINT_100M_KEY = "sprint_100m";
	private static final String LONG_JUMP_KEY = "long_jump";
	private static final String SHOT_PUT_KEY = "shot_put";
	private static final String HIGH_JUMP_KEY = "high_jump";
	private static final String SPRINT_400M_KEY = "sprint_400m";
	private static final String HURDLES_110M_KEY = "hurdles_110m";
	private static final String DISCUS_THROW_KEY = "discus_throw";
	private static final String POLE_VAULT_KEY = "pole_vault";
	private static final String JAVELIN_THROW_KEY = "javelin_throw";
	private static final String RACE_1500M_KEY = "race_1500m";

	private static final Map<String, Coefficient> COEFFICIENT_MAP =
			Collections.unmodifiableMap(new HashMap<String, Coefficient>() {{
				put(SPRINT_100M_KEY, new Coefficient(25.4347, 18.0, 1.81));
				put(LONG_JUMP_KEY, new Coefficient(0.14354, 220.0, 1.4));
				put(SHOT_PUT_KEY, new Coefficient(51.39, 1.5, 1.05));
				put(HIGH_JUMP_KEY, new Coefficient(0.8465, 75.0, 1.42));
				put(SPRINT_400M_KEY, new Coefficient(1.53775, 82.0, 1.81));
				put(HURDLES_110M_KEY, new Coefficient(5.74352, 28.5, 1.92));
				put(DISCUS_THROW_KEY, new Coefficient(12.91, 4.0, 1.1));
				put(POLE_VAULT_KEY, new Coefficient(0.2797, 100.0, 1.35));
				put(JAVELIN_THROW_KEY, new Coefficient(10.14, 7.0, 1.08));
				put(RACE_1500M_KEY, new Coefficient(0.03768, 480.0, 1.85));
			}});

	private final String name;
	private final Date birthDay;
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

	public Result(final String name, final Date birthDay, final String country,
	              final double sprint100m, final double longJump, final double shotPut, final double highJump,
	              final double sprint400m, final double hurdles110m, final double discusThrow,
	              final double poleVault, final double javelinThrow, final double race1500m) {
		this.name = normalizeString(name);
		this.birthDay = birthDay;
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
				"name='" + name + "', " +
				"birthDay=" + (birthDay == null ? birthDay : DATE_FORMAT.format(birthDay)) + ", " +
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
				"race1500m=" + race1500m +
				'}';
	}

	public String getName() {
		return name;
	}

	public Date getBirthDay() {
		return birthDay;
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

	private void checkProperties() {
		checkStringNotEmpty(name, NO_NAME_ID);
		checkDate();
		checkCountry();
		checkNumberNotZero(sprint100m, NO_SPRINT_100M_RESULT_ID);
		checkNumberNotZero(longJump, NO_LONG_JUMP_RESULT_ID);
		checkNumberNotZero(shotPut, NO_SHOT_PUT_RESULT_ID);
		checkNumberNotZero(highJump, NO_HIGH_JUMP_RESULT_ID);
		checkNumberNotZero(sprint400m, NO_SPRINT_400M_RESULT_ID);
		checkNumberNotZero(hurdles110m, NO_HURDLES_110M_RESULT_ID);
		checkNumberNotZero(discusThrow, NO_DISCUS_THROW_RESULT_ID);
		checkNumberNotZero(poleVault, NO_POLE_VAULT_RESULT_ID);
		checkNumberNotZero(javelinThrow, NO_JAVELIN_THROW_RESULT_ID);
		checkNumberNotZero(race1500m, NO_RACE_1500M_RESULT_ID);
	}

	private void checkStringNotEmpty(final String string, final String errorMessageID) {
		if (string.isEmpty()) throw MESSAGES.argumentException(errorMessageID, toString());
	}

	private void checkDate() {
		if (birthDay == null) throw MESSAGES.argumentException(NO_BIRTHDAY_ID, toString());
	}

	private void checkCountry() {
		checkStringNotEmpty(country, NO_COUNTRY_ID);
		if (country.length() != 2) throw MESSAGES.argumentException(NOT_ISO2_COUNTRY_ID, toString());
	}

	private void checkNumberNotZero(final double number, final String errorMessageID) {
		if (number == 0.0) throw MESSAGES.argumentException(errorMessageID, toString());
	}

	private int calculatePoints() {
		return runningPoints(SPRINT_100M_KEY, sprint100m) + jumpingPoints(LONG_JUMP_KEY, longJump) +
				throwingPoints(SHOT_PUT_KEY, shotPut) + jumpingPoints(HIGH_JUMP_KEY, highJump) +
				runningPoints(SPRINT_400M_KEY, sprint400m) + runningPoints(HURDLES_110M_KEY, hurdles110m) +
				throwingPoints(DISCUS_THROW_KEY, discusThrow) + jumpingPoints(POLE_VAULT_KEY, poleVault) +
				throwingPoints(JAVELIN_THROW_KEY, javelinThrow) + runningPoints(RACE_1500M_KEY, race1500m);
	}

	private int runningPoints(final String key, final double result) {
		final Coefficient coefficient = COEFFICIENT_MAP.get(key);
		return points(coefficient, coefficient.b - result);
	}

	private int throwingPoints(final String key, final double result) {
		final Coefficient coefficient = COEFFICIENT_MAP.get(key);
		return points(coefficient, result - coefficient.b);
	}

	private int jumpingPoints(final String key, final double result) {
		final Coefficient coefficient = COEFFICIENT_MAP.get(key);
		return points(coefficient, 100.0 * result - coefficient.b);
	}

	private int points(final Coefficient coefficient, final double delta) {
		return (int) (coefficient.a * Math.pow(delta, coefficient.c));
	}
}
