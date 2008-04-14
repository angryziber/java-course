package net.azib.java.students.t030633.homework.model1;

import static org.junit.Assert.assertEquals;

import net.azib.java.students.t030633.homework.model1.AddingCalculator;
import net.azib.java.students.t030633.homework.model1.Event;

import java.util.EnumMap;
import org.junit.Test;

/**
 * AddingCalculatorTest
 * 
 * @author t030633
 */
public class AddingCalculatorTest {

	public static EnumMap<Event, Double> validResults() {
		EnumMap<Event, Double> map = new EnumMap<Event, Double>(Event.class);
		map.put(Event.SHOT, 8.3D); // 8.3m
		map.put(Event.DISCUS, 14.2D); // 14.2m
		map.put(Event.R1500M, 403D); // 6min 43sec
		return map;
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model1.AddingCalculator#calculate(EnumMap)}.
	 */
	@Test
	public void passesScoreFromOneEvent() {
		assertEquals(666D, new AddingCalculator().calculate(validResults()));
	}

}
