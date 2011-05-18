package net.azib.java.students.t093759.homework;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

/**
 * @author dionis
 *         5/15/11 11:51 AM
 */
public class Athlete {
	private String name;
	private Calendar dateOfBirth;
	private String countryISO2LetterCode;
	private Double oneHundredMeterSprintInSeconds;
	private Double longJumpInMeter;
	private Double shotPutInMeter;
	private Double fourHundredMeterSprintInSeconds;
	private Double oneHundredTenMeterHurdlesInSeconds;
	private Double discusThrowInMeter;
	private Double poleVaultInMeter;
	private Double javelinThrowInMeter;
	private Double thousandFiveHundredMeterRaceInSeconds;

	private Athlete() {
	}

	public static class Builder {
		private Athlete athlete = new Athlete();
		public final static double ONE_DAY_IN_SECONDS = 24.0 * 60.0 * 60.0;

		public Builder name(String name) {
			for (char c : name.toCharArray()) {
				if (!Character.isLetter(c) && !Character.isSpaceChar(c))
					throw new IllegalArgumentException("Name should consist only from characters and spaces.");//TODO move to messages
			}
			athlete.name = name;
			return this;
		}

		public Builder setDateOfBirth(Calendar dateOfBirth) {
			dateOfBirth = (Calendar) dateOfBirth.clone();

			Calendar oneHundredTwentyYearsAgo = Calendar.getInstance();
			oneHundredTwentyYearsAgo.add(Calendar.YEAR, -120);

			Calendar today = Calendar.getInstance();

			if (dateOfBirth.before(oneHundredTwentyYearsAgo) || dateOfBirth.after(today))
				throw new IllegalArgumentException("Date of birth should be between today - 120 years and today.");

			athlete.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder setCountryISO2LetterCode(String countryISO2LetterCode) {
			if (!Arrays.asList(Locale.getISOCountries()).contains(countryISO2LetterCode))
				throw new IllegalArgumentException("It's not a country ISO2 letter code.");//TODO move to messages
			athlete.countryISO2LetterCode = countryISO2LetterCode;
			return this;
		}

		public Builder setFourHundredMeterSprint(double timeInSeconds) {
			if (timeInSeconds < 0.0 || timeInSeconds >= ONE_DAY_IN_SECONDS)
				throw new IllegalArgumentException("400 meter sprint time length should be 0 or more seconds and less than 24 hours.");//TODO move to messages
			athlete.fourHundredMeterSprintInSeconds = timeInSeconds;
			return this;
		}

		public Builder setOneHundredMeterSprint(double timeInSeconds) {
			if (timeInSeconds < 0.0 || timeInSeconds >= ONE_DAY_IN_SECONDS)
				throw new IllegalArgumentException("100 meter sprint time length should be 0 or more seconds and less than 24 hours.");//TODO move to messages
			athlete.oneHundredMeterSprintInSeconds = timeInSeconds;
			return this;
		}

		public Builder setLongJump(double lengthInMeter) {
			if (lengthInMeter < 0.0 || lengthInMeter >= 20.0)
				throw new IllegalArgumentException("Long jump should be 0 or more meters and less than 20 meters in length.");//TODO move to messages
			athlete.longJumpInMeter = lengthInMeter;
			return this;
		}

		public Builder setShotPut(double lengthInMeter) {
			if (lengthInMeter < 0.0 || lengthInMeter >= 40.0)
				throw new IllegalArgumentException("Shot put should be 0 or more meters and less than 20 meters in length.");//TODO move to messages
			athlete.shotPutInMeter = lengthInMeter;
			return this;
		}

		public Builder setOneHundredMeterHurdles(double timeInSeconds) {
			if (timeInSeconds < 0.0 || timeInSeconds >= ONE_DAY_IN_SECONDS)
				throw new IllegalArgumentException("110 m hurdles should be 0 or more seconds and less than 24 hours.");//TODO move to messages
			athlete.oneHundredTenMeterHurdlesInSeconds = timeInSeconds;
			return this;
		}

		public Builder setDiscusThrow(double lengthInMeters) {
			if (lengthInMeters < 0.0 || lengthInMeters >= 200.0)
				throw new IllegalArgumentException("Discus throw should be zero or more meter length and less than 200 meter length.");//TODO move to messages
			athlete.discusThrowInMeter = lengthInMeters;
			return this;
		}

		public Builder setPoleVault(double heightInMeters) {
			if (heightInMeters < 0.0 || heightInMeters >= 20.0)
				throw new IllegalArgumentException("Pole vault should be zero or more meter in height and less than 20 meter in height.");//TODO move to messages
			athlete.poleVaultInMeter = heightInMeters;
			return this;
		}

		public Builder setJavelinThrow(double lengthInMeters) {
			if (lengthInMeters < 0.0 || lengthInMeters >= 150.0)
				throw new IllegalArgumentException("Javelin throw should be zero or more meter length and less than 150 meter length.");//TODO move to messages
			athlete.javelinThrowInMeter = lengthInMeters;
			return this;
		}

		public Builder setThousandFiveHundredMeterRace(double timeInSeconds) {
			if (timeInSeconds < 0.0 || timeInSeconds >= ONE_DAY_IN_SECONDS)
				throw new IllegalArgumentException("1500 m race time should be 0 or more seconds and less than 24 hours.");//TODO move to messages
			athlete.thousandFiveHundredMeterRaceInSeconds = timeInSeconds;
			return this;
		}
	}
}