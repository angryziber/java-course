package net.azib.java.students.t107110.homework;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Eduard Shustrov
 */
public class Result {
	private static final MessageLoader MESSAGES = new MessageLoader(Result.class);
	private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

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
	}

	@Override
	public String toString() {
		return "Result{" +
				"name='" + name + '\'' +
				", birthDay=" + DATE_FORMAT.format(birthDay) +
				", country='" + country + '\'' +
				", sprint100m=" + sprint100m +
				", longJump=" + longJump +
				", shotPut=" + shotPut +
				", highJump=" + highJump +
				", sprint400m=" + sprint400m +
				", hurdles110m=" + hurdles110m +
				", discusThrow=" + discusThrow +
				", poleVault=" + poleVault +
				", javelinThrow=" + javelinThrow +
				", race1500m=" + race1500m +
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

	private String normalizeString(final String string) {
		return string.trim().replaceAll("\\s+", " ");
	}

	private String normalizeCountry(final String country) {
		return normalizeString(country).toUpperCase();
	}

	private void checkProperties() {
		checkString(name, "no_name");
		checkCountry();
	}

	private void checkString(final String string, final String errorMessageID) {
		if (string.isEmpty()) throw new IllegalArgumentException(MESSAGES.getMessage(errorMessageID, toString()));
	}

	private void checkCountry() {
		checkString(country, "no_country");
		if (country.length() != 2)
			throw new IllegalArgumentException(MESSAGES.getMessage("not_iso2_country", country, toString()));
	}
}
