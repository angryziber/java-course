package net.azib.java.students.t030633.homework.model1;

import static org.easymock.EasyMock.*;

import net.azib.java.students.t030633.homework.model1.Athlete;
import net.azib.java.students.t030633.homework.model1.AthleteBuilder;
import net.azib.java.students.t030633.homework.model1.Calculator;
import net.azib.java.students.t030633.homework.model1.Checker;
import net.azib.java.students.t030633.homework.model1.DecathlonAthleteBuilder;
import net.azib.java.students.t030633.homework.model1.Event;

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
	private static final EnumMap<Event, Double> RESULTS = new EnumMap<Event, Double>(Event.class);
	private static final int SCORE = 6;

	private Checker createMockChecker() {
		Checker mockChecker = createMock(Checker.class);
		expect(mockChecker.checkName(NAME)).andReturn(NAME);
		expect(mockChecker.checkDate(DATE)).andReturn(DATE);
		expect(mockChecker.checkCountry(COUNTRY)).andReturn(COUNTRY);
		expect(mockChecker.checkResults(RESULTS)).andReturn(RESULTS);
		replay(mockChecker);
		return mockChecker;
	}
	
	private Calculator createMockCalculator() {
		Calculator mockCalculator = createMock(Calculator.class);
		expect(mockCalculator.calculate(RESULTS)).andReturn(SCORE);
		replay(mockCalculator);
		return mockCalculator;
	}
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model1.DecathlonAthleteBuilder}.
	 */
	@Test
	public void basicBuildCompletes() {
		
		Checker mockChecker = createMockChecker();
		Calculator mockCalculator = createMockCalculator();
		
		AthleteBuilder builder = new DecathlonAthleteBuilder(mockChecker, mockCalculator);
		Athlete a = builder.name(NAME).date(DATE).country(COUNTRY).results(RESULTS).build();
		assertEquals(NAME, a.getName());
		assertEquals(DATE, a.getBirthDate());
		assertEquals(COUNTRY, a.getCountry());
		assertEquals(RESULTS, a.getResults());
		assertEquals(SCORE, a.getScore());
		
		verify(mockChecker);
		verify(mockCalculator);
		
	}

}
