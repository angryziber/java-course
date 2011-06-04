package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static net.azib.java.students.t093759.homework.Athlete.Builder.ONE_DAY_IN_SECONDS;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * @author dionis
 *         5/15/11 11:55 AM
 */
public class AthleteTest {
	private static final String NAME = "Siim Susi";
	private static final Calendar DATE_OF_BIRTH = new GregorianCalendar(1976, 1, 1);
	private static final String COUNTRY_ISO_2_LETTER_CODE = "EE";
	private static final Double ONE_HUNDRED_METER_SPRINT_TIME_IN_SECONDS = 12.61;
	private static final Double LONG_JUMP_LENGTH_IN_METERS = 5.00;
	private static final Double SHOT_PUT_LENGTH_IN_METERS = 9.22;
	private static final Double HIGH_JUMP_HEIGHT_IN_METERS = 1.50;
	private static final Double FOUR_HUNDRED_METER_SPRINT_TIME_IN_SECONDS = 59.39;
	private static final Double ONE_HUNDRED_TEN_METER_HURDLES_TIME_IN_SECONDS = 16.43;
	private static final Double DISCUS_THROW_LENGTH_IN_METERS = 21.60;
	private static final Double POLE_VAULT_HEIGHT_IN_METERS = 2.60;
	private static final Double JAVELIN_THROW_LENGTH_IN_METERS = 35.81;
	private static final Double THOUSAND_FIVE_HUNDRED_METER_RACE_TIME_IN_SECONDS = 5 * 60 + 25.72;

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
		String[] names = {"József Fenyő", "Василий Пупкин", "Mąrtęn Kołobrźeg", "José Mañana Perez", "宗弘金子 (Munehiro Kaneko)"};
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

	@Test
	public void countryISO2LettersInLowerCaseAreAlsoAccepted() {
		new Athlete.Builder().setCountryISO2LetterCode("et");
	}

	@Test(expected = IllegalArgumentException.class)
	public void fourHundredMeterSprintTimeShouldBeZeroSecondsOrMore() {
		new Athlete.Builder().setFourHundredMeterSprintTime(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void fourHundredMeterSprintTimeShouldBeLessThan24Hours() {
		new Athlete.Builder().setFourHundredMeterSprintTime(ONE_DAY_IN_SECONDS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneHundredMeterSprintTimeShouldBeZeroSecondsOrMore() {
		new Athlete.Builder().setOneHundredMeterSprintTime(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneHundredMeterSprintTimeShouldBeLessThan24Hours() {
		new Athlete.Builder().setOneHundredMeterSprintTime(ONE_DAY_IN_SECONDS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void longJumpLengthShouldBeZeroOrMoreMeters() {
		new Athlete.Builder().setLongJumpLength(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void longJumpLengthShouldBeLessThan20Meters() {
		new Athlete.Builder().setLongJumpLength(20.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shotPutLengthShouldBeZeroOrMoreMeters() {
		new Athlete.Builder().setShotPutLength(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shotPutLengthShouldBeLessThan40Meters() {
		new Athlete.Builder().setShotPutLength(40.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneHundredTenMeterHurdlesTimeShouldBeZeroSecondsOrMore() {
		new Athlete.Builder().setOneHundredTenMeterHurdlesTime(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneHundredTenMeterHurdlesTomeShouldBeLessThan24Hours() {
		new Athlete.Builder().setOneHundredTenMeterHurdlesTime(ONE_DAY_IN_SECONDS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void discusThrowLengthShouldBeZeroOrMoreMeters() {
		new Athlete.Builder().setDiscusThrowLength(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void discusThrowLengthShouldBeLessThan200Meter() {
		new Athlete.Builder().setDiscusThrowLength(200.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void poleVaultHeightShouldBeZeroOrMoreMeters() {
		new Athlete.Builder().setPoleVaultHeight(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void poleVaultHeightLengthShouldBeLessThan20Meter() {
		new Athlete.Builder().setPoleVaultHeight(20.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void javelinThrowLengthShouldBeZeroOrMoreMeter() {
		new Athlete.Builder().setJavelinThrowLength(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void javelinThrowLengthShouldBeLessThan150Meter() {
		new Athlete.Builder().setJavelinThrowLength(150.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void thousandFiveHundredMeterRaceTimeShouldBeZeroSecondsOrMore() {
		new Athlete.Builder().setThousandFiveHundredMeterRaceTime(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void thousandFiveHundredMeterRaceTimeShouldBeLessThan24Hours() {
		new Athlete.Builder().setThousandFiveHundredMeterRaceTime(ONE_DAY_IN_SECONDS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void highJumpHeightShouldBeZeroOrMoreMeters() {
		new Athlete.Builder().setHighJumpHeight(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void highJumpHeightShouldBeLessThan5Meters() {
		new Athlete.Builder().setHighJumpHeight(5.0);
	}

	@Test
	public void athleteObjectShouldBeCreatedUsingHisBuilder() throws CloneNotSupportedException {
		assertThat(newSampleAthlete(), is(instanceOf(Athlete.class)));
	}

	@Test(expected = IllegalStateException.class)
	public void allFieldsAreNecessary() throws CloneNotSupportedException {
		new Athlete.Builder().build();
	}

	@Test
	public void athletesAreEqualIfAllTheDataIsTheSame() throws CloneNotSupportedException {
		Athlete athleteA = newSampleAthlete();
		Athlete athleteB = newSampleAthlete();
		assertFalse(athleteA == athleteB);
		assertThat(athleteA, is(athleteB));
	}

	@Test
	public void hashCodeOfTowAthletesIsEqualIfTwoAthletesAreEqual() throws CloneNotSupportedException {
		Athlete athleteA = newSampleAthlete();
		Athlete athleteB = newSampleAthlete();
		assertFalse(athleteA == athleteB);
		assertThat(athleteA, is(athleteB));
		assertThat(athleteA.hashCode(), equalTo(athleteB.hashCode()));
	}

	@Test
	public void athleteIsCloneable() throws CloneNotSupportedException {
		Athlete athleteA = newSampleAthlete();
		Athlete athleteClone = (Athlete) athleteA.clone();
		assertFalse(athleteA == athleteClone);
		assertThat(athleteA, is(athleteClone));
	}

	@Test
	public void itIsPossibleToUseSomeAthleteAsAPrototypeForABuilder() throws CloneNotSupportedException {
		Athlete prototypeAthlete = newSampleAthlete();
		Athlete builtAthlete = new Athlete.Builder(prototypeAthlete).build();
		assertFalse(prototypeAthlete == builtAthlete);
		assertThat(prototypeAthlete, is(builtAthlete));
	}

	@Test
	public void stringRepresentationOfAthleteIsJustHisNameAndCountry() throws CloneNotSupportedException {
		assertThat(newSampleAthlete().toString(), equalTo(NAME + ", " + COUNTRY_ISO_2_LETTER_CODE));
	}

	private Athlete newSampleAthlete() throws CloneNotSupportedException {
		return new Athlete.Builder()
				.name(NAME)
				.setDateOfBirth(DATE_OF_BIRTH)
				.setCountryISO2LetterCode(COUNTRY_ISO_2_LETTER_CODE)
				.setOneHundredMeterSprintTime(ONE_HUNDRED_METER_SPRINT_TIME_IN_SECONDS)
				.setLongJumpLength(LONG_JUMP_LENGTH_IN_METERS)
				.setShotPutLength(SHOT_PUT_LENGTH_IN_METERS)
				.setHighJumpHeight(HIGH_JUMP_HEIGHT_IN_METERS)
				.setFourHundredMeterSprintTime(FOUR_HUNDRED_METER_SPRINT_TIME_IN_SECONDS)
				.setOneHundredTenMeterHurdlesTime(ONE_HUNDRED_TEN_METER_HURDLES_TIME_IN_SECONDS)
				.setDiscusThrowLength(DISCUS_THROW_LENGTH_IN_METERS)
				.setPoleVaultHeight(POLE_VAULT_HEIGHT_IN_METERS)
				.setJavelinThrowLength(JAVELIN_THROW_LENGTH_IN_METERS)
				.setThousandFiveHundredMeterRaceTime(THOUSAND_FIVE_HUNDRED_METER_RACE_TIME_IN_SECONDS)
				.build();
	}
}
