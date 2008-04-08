package net.azib.java.students.t030633.homework.Model;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

import org.junit.Test;

/**
 * AthleteBuilderTest
 * 
 * @author t030633
 */
public class AthleteBuilderTest {

	private static final String NAME = "Some Name";
	private static final Date DATE = new Date();
	private static final String COUNTRY = "EE";
	private static final Map<Event, Double> RESULTS = new EnumMap<Event, Double>(Event.class);

	private AthleteBuilder builder = new AthleteBuilder();

	public static EnumMap<Event, Double> validResults() {
		EnumMap<Event, Double> map = new EnumMap<Event, Double>(Event.class);
		map.put(Event.SHOT, 8.3D); // 8.3m
		map.put(Event.DISCUS, 14.2D); // 14.2m
		map.put(Event.R1500M, 403D); // 6min 43sec
		return map;
	}
	
	private Map<Event, Double> invalidResults() {
		Map<Event, Double> results = new EnumMap<Event, Double>(Event.class);
		results.put(Event.R100M, 5D);
		results.put(Event.DISCUS, 500D);
		results.put(Event.HIGH, 5D);
		results.put(Event.JAVELIN, 500D);
		results.put(Event.LONG, 50D);
		results.put(Event.POLE, 50D);
		results.put(Event.R110MH, 5D);
		results.put(Event.R1500M, 100D);
		results.put(Event.R400M, 10D);
		results.put(Event.SHOT, 50D);
		return results;
	}
	
	@Test
	public void basicBuild() {
		Athlete a = builder.name(NAME).date(DATE).country(COUNTRY).results(RESULTS).build();
		assertEquals(NAME, a.getName());
		assertEquals(DATE, a.getBirthDate());
		assertEquals(COUNTRY, a.getCountry());
		assertEquals(RESULTS, a.getResults());
		assertEquals(0, a.getScore());
	}

	@Test
	public void nullCountryAvoided() {
		assertEquals("", builder.country(null).build().getCountry());
	}
	
	@Test
	public void existingCountryAccepted() {
		assertEquals("EE", builder.country("EE").build().getCountry());
	}

	@Test
	public void notExistingCountryRemoved() {
		assertEquals("", builder.country("PP").build().getCountry());
	}
	
	@Test
	public void nullResultsAvoided() {
		assertEquals(new EnumMap<Event, Double>(Event.class), builder.results(null).build().getResults());
	}
	
	@Test
	public void validResultsAccepted() {
		assertEquals(validResults(), builder.results(validResults()).build().getResults());
	}
	
	@Test
	public void invalidResultsRemoved() {
		assertEquals(new EnumMap<Event, Double>(Event.class), builder.results(invalidResults()).build().getResults());
	}
	
	@Test
	public void correctScoreIsCalculated() {
		assertEquals(666D, builder.results(validResults()).build().getScore());
	}
	
}
