package net.azib.java.students.t093759.homework;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author dionis
 *         5/31/1112:56 AM
 */
public class CSVOutputTest {

	@Test(expected = IllegalArgumentException.class)
	public void exactlyOneAdditionalParamShouldBeProvided() {
		new CSVOutput().output(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void additionalParamShouldBeString() {
		new CSVOutput().output(null, 12);
	}

	@Test
	public void builtStringExample() {
		List<Athlete> athletes = setUpMockedAthletes();
		assertThat(athletes.size(), is(2));
		String result = new CSVOutput().buildStringForAllAthletes(athletes);
		assertThat(result, is(someBasicOutputString()));
	}

	@Test
	public void csvExample() throws IOException {
		List<Athlete> athletes = setUpMockedAthletes();
		assertThat(athletes.size(), is(2));
		File tempFile = tempFile();

		new CSVOutput().output(athletes,tempFile.getCanonicalPath());
		assertThat(FileUtils.readFileToString(tempFile),equalTo(someBasicOutputString()));
	}

	private String someBasicOutputString() {
		return "\"José Mañana Perez\",3.04.1972,ES,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75"
				+ System.getProperty("line.separator") +
				"\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01";
	}

	private List<Athlete> setUpMockedAthletes() {
		List<Athlete> athletes = new ArrayList<Athlete>();
		Athlete athlete0 = mockedVasyaPupkin();
		Athlete athlete1 = mockedJoseMananaPerez();
		when(athlete0.compareTo(athlete1)).thenCallRealMethod();
		when(athlete1.compareTo(athlete0)).thenCallRealMethod();
		when(athlete1.compareTo(athlete1)).thenCallRealMethod();
		when(athlete0.compareTo(athlete0)).thenCallRealMethod();
		athletes.add(athlete0);
		athletes.add(athlete1);

		return athletes;
	}

	private File tempFile() throws IOException {
		File temp = File.createTempFile("temp", ".tmp");
		temp.deleteOnExit();
		return temp;
	}

	private Athlete mockedVasyaPupkin() {
		Athlete athlete = mock(Athlete.class);
		when(athlete.getName()).thenReturn("Василий Пупкин");
		when(athlete.getDateOfBirth()).thenReturn(new GregorianCalendar(1980, 9, 21));
		when(athlete.getCountryISO2LetterCode()).thenReturn("UA");
		when(athlete.get(DecathlonEvent.ONE_HUNDRED_METER_SPRINT)).thenReturn(13.43);
		when(athlete.get(DecathlonEvent.LONG_JUMP)).thenReturn(4.35);
		when(athlete.get(DecathlonEvent.SHOT_PUT)).thenReturn(8.64);
		when(athlete.get(DecathlonEvent.HIGH_JUMP)).thenReturn(1.50);
		when(athlete.get(DecathlonEvent.FOUR_HUNDRED_METER_SPRINT)).thenReturn(66.06);
		when(athlete.get(DecathlonEvent.ONE_HUNDRED_TEN_METER_HURDLES)).thenReturn(19.05);
		when(athlete.get(DecathlonEvent.DISCUS_THROW)).thenReturn(24.89);
		when(athlete.get(DecathlonEvent.POLE_VAULT)).thenReturn(2.20);
		when(athlete.get(DecathlonEvent.JAVELIN_THROW)).thenReturn(33.48);
		when(athlete.get(DecathlonEvent.THOUSAND_FIVE_HUNDRED_METER_SPRINT)).thenReturn(411.01);
		when(athlete.computePoints()).thenReturn(100.0);//NB! not real points
		return athlete;
	}

	private Athlete mockedJoseMananaPerez() {
		Athlete athlete = mock(Athlete.class);
		when(athlete.getName()).thenReturn("José Mañana Perez");
		when(athlete.getDateOfBirth()).thenReturn(new GregorianCalendar(1972, 3, 3));
		when(athlete.getCountryISO2LetterCode()).thenReturn("ES");
		when(athlete.get(DecathlonEvent.ONE_HUNDRED_METER_SPRINT)).thenReturn(13.75);
		when(athlete.get(DecathlonEvent.LONG_JUMP)).thenReturn(4.84);
		when(athlete.get(DecathlonEvent.SHOT_PUT)).thenReturn(10.12);
		when(athlete.get(DecathlonEvent.HIGH_JUMP)).thenReturn(1.50);
		when(athlete.get(DecathlonEvent.FOUR_HUNDRED_METER_SPRINT)).thenReturn(68.44);
		when(athlete.get(DecathlonEvent.ONE_HUNDRED_TEN_METER_HURDLES)).thenReturn(19.18);
		when(athlete.get(DecathlonEvent.DISCUS_THROW)).thenReturn(30.85);
		when(athlete.get(DecathlonEvent.POLE_VAULT)).thenReturn(2.80);
		when(athlete.get(DecathlonEvent.JAVELIN_THROW)).thenReturn(33.88);
		when(athlete.get(DecathlonEvent.THOUSAND_FIVE_HUNDRED_METER_SPRINT)).thenReturn(382.75);
		when(athlete.computePoints()).thenReturn(200.0);//NB! not real points
		return athlete;
	}
}
