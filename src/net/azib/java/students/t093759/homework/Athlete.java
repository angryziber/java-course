package net.azib.java.students.t093759.homework;

import java.util.Calendar;
import java.util.Date;

/**
 * @author dionis
 *         5/15/11 11:51 AM
 */
public class Athlete {
	private String name;
	private Calendar dateOfBirth;
	private String countryISO2LetterCode;
	private Long oneHundredMeterSprintInSeconds;
	private Long longJumpInMeter;
	private Long shotPutInMeter;
	private Long fourHundredMeterSprintInSeconds;
	private Long oneHundredTenMeterHurdlesInSeconds;
	private Long discussThrowInMeter;
	private Long poleVaultInMeter;
	private Long javelinThrowInMeter;
	private Long thousandFiveHundredMeterRaceInSeconds;

	public static class Builder {
		public Builder name(String name) {
			for (char c : name.toCharArray()) {
				if (!Character.isLetter(c) && !Character.isSpaceChar(c))
					throw new IllegalArgumentException("Name should consist only from characters and spaces.");
			}
			return this;
		}

		public Builder setDateOfBirth(Calendar dateOfBirth) {
			if(!dateOfBirth.before(Calendar.getInstance()))
				throw new IllegalArgumentException("Date of birth can not be equal or more than today's date.");
			return this;
		}
	}
}
