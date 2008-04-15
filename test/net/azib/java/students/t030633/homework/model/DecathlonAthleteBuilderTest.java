package net.azib.java.students.t030633.homework.model;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.EnumMap;

import org.junit.Test;

/**
 * DecathlonAthleteBuilderTest
 * 
 * @author t030633
 */
public class DecathlonAthleteBuilderTest {

	private static final String NAME = "Testname";
	private static final Date DATE = new Date();
	private static final String COUNTRY = "CZ";
	private static final int SCORE = 6;

	private static final EnumMap<Event, Double> EMPTY_RESULTS = new EnumMap<Event, Double>(Event.class);
	private static final EnumMap<Event, Double> RESULTS = new EnumMap<Event, Double>(Event.class);
	static {
		RESULTS.put(Event.DISCUS, 10D);
	}

	private Checker createMockChecker(EnumMap<Event, Double> results) {
		Checker mockChecker = createMock(Checker.class);
		expect(mockChecker.checkName(NAME)).andReturn(NAME);
		expect(mockChecker.checkDate(DATE)).andReturn(DATE);
		expect(mockChecker.checkCountry(COUNTRY)).andReturn(COUNTRY);
		expect(mockChecker.checkResults(results)).andReturn(results);
		replay(mockChecker);
		return mockChecker;
	}

	private Calculator createMockCalculator(EnumMap<Event, Double> results) {
		Calculator mockCalculator = createMock(Calculator.class);
		expect(mockCalculator.calculate(results)).andReturn(SCORE);
		replay(mockCalculator);
		return mockCalculator;
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonAthleteBuilder}.
	 */
	@Test
	public void basicBuildCompletes() {

		Calculator mockCalculator = createMockCalculator(EMPTY_RESULTS);
		Checker mockChecker = createMockChecker(EMPTY_RESULTS);
		AthleteBuilder builder = new DecathlonAthleteBuilder(mockChecker, mockCalculator);
		Athlete a = builder.name(NAME).date(DATE).country(COUNTRY).build();
		assertEquals(NAME, a.getName());
		assertEquals(DATE, a.getBirthDate());
		assertEquals(COUNTRY, a.getCountry());
		assertEquals(EMPTY_RESULTS, a.getResults());
		assertEquals(SCORE, a.getScore());
		verify(mockChecker);
		verify(mockCalculator);
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonAthleteBuilder}.
	 */
	@Test
	public void buildWithResultsCompletes() {

		Calculator mockCalculator = createMockCalculator(RESULTS);
		Checker mockChecker = createMockChecker(RESULTS);
		AthleteBuilder builder = new DecathlonAthleteBuilder(mockChecker, mockCalculator);
		Athlete a = builder.name(NAME).date(DATE).country(COUNTRY).addResult(Event.DISCUS, 10D).build();
		assertEquals(NAME, a.getName());
		assertEquals(DATE, a.getBirthDate());
		assertEquals(COUNTRY, a.getCountry());
		assertEquals(RESULTS, a.getResults());
		assertEquals(SCORE, a.getScore());
		verify(mockChecker);
		verify(mockCalculator);

	}

}
