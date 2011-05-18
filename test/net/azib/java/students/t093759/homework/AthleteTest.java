package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.util.Calendar;

import static net.azib.java.students.t093759.homework.Athlete.Builder.ONE_DAY_IN_SECONDS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author dionis
 *         5/15/11 11:55 AM
 */
public class AthleteTest {
	@Test
	public void oneDayInSeconds() {
		assertThat(ONE_DAY_IN_SECONDS, equalTo(24.0 * 60.0 * 60.0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void athleteNameShouldConsistOnlyFromCharacters() {
		new Athlete.Builder().name("Param Pam 123");
	}

	@Test
	public void goodNamesExamples() {
		String[] names = {"József Fenyő", "Василий Пупкин", "Mąrtęn Kołobrźeg", "José Mañana Perez"};
		for (String name : names) {
			new Athlete.Builder().name(name);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void dateOfBirthCanNotBeInFuture() {
		Calendar futureDate = Calendar.getInstance();
		futureDate.add(Calendar.DAY_OF_YEAR, 1);
		new Athlete.Builder().setDateOfBirth(futureDate);
	}

	@Test(expected = IllegalArgumentException.class)
	public void peopleDoNotLiveMoreThan120Years() {
		Calendar dateInPast = Calendar.getInstance();
		dateInPast.add(Calendar.YEAR, -121);
		new Athlete.Builder().setDateOfBirth(dateInPast);
	}

	@Test(expected = IllegalArgumentException.class)
	public void countryISO2LetterIsChecked() {
		new Athlete.Builder().setCountryISO2LetterCode("WTF");
	}

	@Test(expected = IllegalArgumentException.class)
	public void fourHundredMeterSprintTimeLengthShouldBeZeroOrMore() {
		new Athlete.Builder().setFourHundredMeterSprint(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void fourHundredMeterSprintTimeLengthShouldBeLessThan24Hours() {
		new Athlete.Builder().setFourHundredMeterSprint(ONE_DAY_IN_SECONDS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneHundredMeterSprintInSecondsShouldBeZeroOrMore() {
		new Athlete.Builder().setOneHundredMeterSprint(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneHundredMeterSprintTimeLengthShouldBeLessThan24Hours() {
		new Athlete.Builder().setOneHundredMeterSprint(ONE_DAY_IN_SECONDS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void longJumpShouldBeZeroOrMoreMetersLength() {
		new Athlete.Builder().setLongJump(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void longJumpShouldBeLessThan20MetersLength() {
		new Athlete.Builder().setLongJump(20.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shotPutShouldBeZeroOrMoreMetersLength() {
		new Athlete.Builder().setShotPut(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shotPutShouldBeLessThan40MetersLength() {
		new Athlete.Builder().setShotPut(40.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneHundredTenMeterHurdlesShouldBeZeroSecondsOrMore() {
		new Athlete.Builder().setOneHundredMeterHurdles(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneHundredTenMeterHurdlesShouldBeLessThan24Hours() {
		new Athlete.Builder().setOneHundredMeterHurdles(ONE_DAY_IN_SECONDS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void discusThrowShouldBeZeroOrMoreMeters() {
		new Athlete.Builder().setDiscusThrow(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void discusThrowShouldBeLessThan200Meter() {
		new Athlete.Builder().setDiscusThrow(200.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void poleVaultHeightShouldBeZeroOrMoreMeters() {
		new Athlete.Builder().setPoleVault(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void poleVaultHeightShouldBeLessThan20Meter() {
		new Athlete.Builder().setPoleVault(20.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void javelinThrowShouldBeZeroOrMoreMeter() {
		new Athlete.Builder().setJavelinThrow(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void javelinThrowShouldBeLessThan150Meter() {
		new Athlete.Builder().setJavelinThrow(150.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void thousandFiveHundredMeterRaceTimeShouldBeZeroSecondsOrMore() {
		new Athlete.Builder().setThousandFiveHundredMeterRace(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void thousandFiveHundredMeterRaceTimeShouldBeLessThan24Hours() {
		new Athlete.Builder().setThousandFiveHundredMeterRace(ONE_DAY_IN_SECONDS);
	}
}
