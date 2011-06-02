package net.azib.java.students.t093759.homework;

import org.junit.Ignore;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author dionis
 *         6/1/114:40 PM
 */
@Ignore
public abstract class AthleteOutputTest {
	List<Athlete> setUpMockedAthletes() {
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

	Athlete mockedVasyaPupkin() {
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
		when(athlete.computePoints()).thenReturn(100);//NB! not real points
		return athlete;
	}

	Athlete mockedJoseMananaPerez() {
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
		when(athlete.computePoints()).thenReturn(200);//NB! not real points
		return athlete;
	}

	abstract String someBasicOutputString();
}
