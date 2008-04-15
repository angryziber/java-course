package net.azib.java.students.t030633.homework.model;

import static org.junit.Assert.assertEquals;

import net.azib.java.students.t030633.homework.model.AddingCalculator;
import net.azib.java.students.t030633.homework.model.Event;

import java.util.EnumMap;
import java.util.Map;

import org.junit.Test;

/**
 * AddingCalculatorTest. Depends on Event!
 * 
 * @author t030633
 */
public class AddingCalculatorTest {

	private Map<Event, Double> validResults() {
		EnumMap<Event, Double> map = new EnumMap<Event, Double>(Event.class);
		map.put(Event.SHOT, 8.3D); // 8.3m
		map.put(Event.DISCUS, 14.2D); // 14.2m
		map.put(Event.R1500M, 403D); // 6min 43sec
		return map;
	}
	
	private Map<Event, Double> zeroResults() {
		EnumMap<Event, Double> map = new EnumMap<Event, Double>(Event.class);
		map.put(Event.LONG, 0D);
		map.put(Event.HIGH, 0D);
		map.put(Event.POLE, 0D);
		return map;
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.AddingCalculator#calculate(Map)}.
	 */
	@Test
	public void addsValidResults() {
		assertEquals(666D, new AddingCalculator().calculate(validResults()));
	}
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.AddingCalculator#calculate(Map)}.
	 */
	@Test
	public void addsZeroResults() {
		assertEquals(0D, new AddingCalculator().calculate(zeroResults()));
	}

}
