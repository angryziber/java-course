package net.azib.java.students.t093759.homework;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

/**
 * @author dionis
 *         5/15/11 11:51 AM
 */
public class Athlete implements Cloneable {
	private String name;
	private Calendar dateOfBirth;
	private String countryISO2LetterCode;
	private Double oneHundredMeterSprintInSeconds;
	private Double longJumpInMeters;
	private Double shotPutInMeters;
	private Double highJumpInMeters;
	private Double fourHundredMeterSprintInSeconds;
	private Double oneHundredTenMeterHurdlesInSeconds;
	private Double discusThrowInMeters;
	private Double poleVaultInMeters;
	private Double javelinThrowInMeter;
	private Double thousandFiveHundredMeterRaceInSeconds;

	private Athlete() {
	}

	public String getName() {
		return name;
	}

	public Calendar getDateOfBirth() {
		return (Calendar) dateOfBirth.clone();
	}

	public String getCountryISO2LetterCode() {
		return countryISO2LetterCode;
	}

	public Double getOneHundredMeterSprintInSeconds() {
		return oneHundredMeterSprintInSeconds;
	}

	public Double getLongJumpInMeters() {
		return longJumpInMeters;
	}

	public Double getShotPutInMeters() {
		return shotPutInMeters;
	}

	public Double getHighJumpInMeters() {
		return highJumpInMeters;
	}

	public Double getFourHundredMeterSprintInSeconds() {
		return fourHundredMeterSprintInSeconds;
	}

	public Double getOneHundredTenMeterHurdlesInSeconds() {
		return oneHundredTenMeterHurdlesInSeconds;
	}

	public Double getDiscusThrowInMeters() {
		return discusThrowInMeters;
	}

	public Double getPoleVaultInMeters() {
		return poleVaultInMeters;
	}

	public Double getJavelinThrowInMeter() {
		return javelinThrowInMeter;
	}

	public Double getThousandFiveHundredMeterRaceInSeconds() {
		return thousandFiveHundredMeterRaceInSeconds;
	}

	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Athlete athlete = (Athlete) o;

		if (!countryISO2LetterCode.equals(athlete.countryISO2LetterCode)) return false;
		if (!dateOfBirth.equals(athlete.dateOfBirth)) return false;
		if (discusThrowInMeters != null ? !discusThrowInMeters.equals(athlete.discusThrowInMeters) : athlete.discusThrowInMeters != null)
			return false;
		if (fourHundredMeterSprintInSeconds != null ? !fourHundredMeterSprintInSeconds.equals(athlete.fourHundredMeterSprintInSeconds) : athlete.fourHundredMeterSprintInSeconds != null)
			return false;
		if (highJumpInMeters != null ? !highJumpInMeters.equals(athlete.highJumpInMeters) : athlete.highJumpInMeters != null)
			return false;
		if (javelinThrowInMeter != null ? !javelinThrowInMeter.equals(athlete.javelinThrowInMeter) : athlete.javelinThrowInMeter != null)
			return false;
		if (longJumpInMeters != null ? !longJumpInMeters.equals(athlete.longJumpInMeters) : athlete.longJumpInMeters != null)
			return false;
		if (!name.equals(athlete.name)) return false;
		if (oneHundredMeterSprintInSeconds != null ? !oneHundredMeterSprintInSeconds.equals(athlete.oneHundredMeterSprintInSeconds) : athlete.oneHundredMeterSprintInSeconds != null)
			return false;
		if (oneHundredTenMeterHurdlesInSeconds != null ? !oneHundredTenMeterHurdlesInSeconds.equals(athlete.oneHundredTenMeterHurdlesInSeconds) : athlete.oneHundredTenMeterHurdlesInSeconds != null)
			return false;
		if (poleVaultInMeters != null ? !poleVaultInMeters.equals(athlete.poleVaultInMeters) : athlete.poleVaultInMeters != null)
			return false;
		if (shotPutInMeters != null ? !shotPutInMeters.equals(athlete.shotPutInMeters) : athlete.shotPutInMeters != null)
			return false;
		if (thousandFiveHundredMeterRaceInSeconds != null ? !thousandFiveHundredMeterRaceInSeconds.equals(athlete.thousandFiveHundredMeterRaceInSeconds) : athlete.thousandFiveHundredMeterRaceInSeconds != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + dateOfBirth.hashCode();
		result = 31 * result + countryISO2LetterCode.hashCode();
		result = 31 * result + (oneHundredMeterSprintInSeconds != null ? oneHundredMeterSprintInSeconds.hashCode() : 0);
		result = 31 * result + (longJumpInMeters != null ? longJumpInMeters.hashCode() : 0);
		result = 31 * result + (shotPutInMeters != null ? shotPutInMeters.hashCode() : 0);
		result = 31 * result + (highJumpInMeters != null ? highJumpInMeters.hashCode() : 0);
		result = 31 * result + (fourHundredMeterSprintInSeconds != null ? fourHundredMeterSprintInSeconds.hashCode() : 0);
		result = 31 * result + (oneHundredTenMeterHurdlesInSeconds != null ? oneHundredTenMeterHurdlesInSeconds.hashCode() : 0);
		result = 31 * result + (discusThrowInMeters != null ? discusThrowInMeters.hashCode() : 0);
		result = 31 * result + (poleVaultInMeters != null ? poleVaultInMeters.hashCode() : 0);
		result = 31 * result + (javelinThrowInMeter != null ? javelinThrowInMeter.hashCode() : 0);
		result = 31 * result + (thousandFiveHundredMeterRaceInSeconds != null ? thousandFiveHundredMeterRaceInSeconds.hashCode() : 0);
		return result;
	}

	public static class Builder {
		private Athlete athlete;

		public final static double ONE_DAY_IN_SECONDS = 24.0 * 60.0 * 60.0;

		public Builder(Athlete prototypeAthlete) {
			athlete = (Athlete) prototypeAthlete.clone();
		}

		public Builder() {
			athlete = new Athlete();
		}

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
			countryISO2LetterCode = countryISO2LetterCode.toUpperCase();
			if (!Arrays.asList(Locale.getISOCountries()).contains(countryISO2LetterCode))
				throw new IllegalArgumentException("It's not a country ISO2 letter code.");//TODO move to messages
			athlete.countryISO2LetterCode = countryISO2LetterCode;
			return this;
		}

		public Builder setFourHundredMeterSprintTime(double timeInSeconds) {
			if (timeInSeconds < 0.0 || timeInSeconds >= ONE_DAY_IN_SECONDS)
				throw new IllegalArgumentException("400 meter sprint time length should be 0 or more seconds and less than 24 hours.");//TODO move to messages
			athlete.fourHundredMeterSprintInSeconds = timeInSeconds;
			return this;
		}

		public Builder setOneHundredMeterSprintTime(double timeInSeconds) {
			if (timeInSeconds < 0.0 || timeInSeconds >= ONE_DAY_IN_SECONDS)
				throw new IllegalArgumentException("100 meter sprint time length should be 0 or more seconds and less than 24 hours.");//TODO move to messages
			athlete.oneHundredMeterSprintInSeconds = timeInSeconds;
			return this;
		}

		public Builder setLongJumpLength(double lengthInMeter) {
			if (lengthInMeter < 0.0 || lengthInMeter >= 20.0)
				throw new IllegalArgumentException("Long jump should be 0 or more meters and less than 20 meters in length.");//TODO move to messages
			athlete.longJumpInMeters = lengthInMeter;
			return this;
		}

		public Builder setShotPutLength(double lengthInMeter) {
			if (lengthInMeter < 0.0 || lengthInMeter >= 40.0)
				throw new IllegalArgumentException("Shot put should be 0 or more meters and less than 20 meters in length.");//TODO move to messages
			athlete.shotPutInMeters = lengthInMeter;
			return this;
		}

		public Builder setOneHundredTenMeterHurdlesTime(double timeInSeconds) {
			if (timeInSeconds < 0.0 || timeInSeconds >= ONE_DAY_IN_SECONDS)
				throw new IllegalArgumentException("110 m hurdles should be 0 or more seconds and less than 24 hours.");//TODO move to messages
			athlete.oneHundredTenMeterHurdlesInSeconds = timeInSeconds;
			return this;
		}

		public Builder setDiscusThrowLength(double lengthInMeters) {
			if (lengthInMeters < 0.0 || lengthInMeters >= 200.0)
				throw new IllegalArgumentException("Discus throw should be zero or more meter length and less than 200 meter length.");//TODO move to messages
			athlete.discusThrowInMeters = lengthInMeters;
			return this;
		}

		public Builder setPoleVaultHeight(double heightInMeters) {
			if (heightInMeters < 0.0 || heightInMeters >= 20.0)
				throw new IllegalArgumentException("Pole vault should be zero or more meter in height and less than 20 meter in height.");//TODO move to messages
			athlete.poleVaultInMeters = heightInMeters;
			return this;
		}

		public Builder setJavelinThrowLength(double lengthInMeters) {
			if (lengthInMeters < 0.0 || lengthInMeters >= 150.0)
				throw new IllegalArgumentException("Javelin throw should be zero or more meter length and less than 150 meter length.");//TODO move to messages
			athlete.javelinThrowInMeter = lengthInMeters;
			return this;
		}

		public Builder setThousandFiveHundredMeterRaceTime(double timeInSeconds) {
			if (timeInSeconds < 0.0 || timeInSeconds >= ONE_DAY_IN_SECONDS)
				throw new IllegalArgumentException("1500 m race time should be 0 or more seconds and less than 24 hours.");//TODO move to messages
			athlete.thousandFiveHundredMeterRaceInSeconds = timeInSeconds;
			return this;
		}

		public Builder setHighJumpHeight(double heightInMeters) {
			if (heightInMeters < 0.0 || heightInMeters >= 5.0)
				throw new IllegalArgumentException("High jump should be zero or more meter in height and less than 20 meter in height.");//TODO move to messages
			athlete.highJumpInMeters = heightInMeters;
			return this;
		}

		public Athlete build() {
			if (athlete.name == null) throw new IllegalStateException("Athlete's name should be set.");
			if (athlete.dateOfBirth == null)
				throw new IllegalStateException("Athlete's date of birthday should be set.");
			if (athlete.countryISO2LetterCode == null)
				throw new IllegalStateException("Athlete's country ISO 2 letter code should be set.");
			return (Athlete) athlete.clone();
		}
	}
}