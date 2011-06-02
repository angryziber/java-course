package net.azib.java.students.t100228.Homework;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Unit tests for the {@link ResultsCalculator} class
 * @author Martin
 */
public class ResultsCalculatorTest {

	/**
	 * Test for the method {@link ResultsCalculator#calculateResults(ArrayList)}. Lets the {@link ResultsCalculator}
	 * class calculate the score for an athlete based on 10 events.
	 */
	@Test
	public void calculateResults(){
		Record record = new Record("Siim Susi", 0, "01.01.1976", "EE", 12.61F, 5.00F, 9.22F, 1.5F, "59.39", 16.43F,
						21.60F, 2.60F, 35.81F, "5:25.72");

		ArrayList<Record> records = new ArrayList<Record>();

		records.add(record);

		try
		{
			ResultsCalculator.calculateResults(records);
		}
		catch (Exception ex)
		{
			fail("Exception thrown");
		}

		assertEquals((int)3199, (int)records.get(0).getScore());
	}

	/**
	 * Test for the method {@link ResultsCalculator#calculatePlaces(ArrayList)}
	 */
	@Test
	public void calculatePlaces(){
		Record[] records = new Record[7];

		for(int i = 0; i < records.length; i++)
		{
			records[i] = new Record();
		}

		records[0].setScore(4000);
		records[1].setScore(4000);
		records[2].setScore(4000);

		records[3].setScore(3000);
		records[4].setScore(3000);
		records[5].setScore(3000);

		records[6].setScore(0);

		ArrayList<Record> arrayListRecords = new ArrayList<Record>();

		for(Record rec : records)
		{
			arrayListRecords.add(rec);
		}

		try
		{
			ResultsCalculator.calculatePlaces(arrayListRecords);
		}
		catch (Exception ex)
		{
			fail("Exception thrown");
		}

		assertEquals("1-3", arrayListRecords.get(0).getPlace());
		assertEquals("1-3", arrayListRecords.get(1).getPlace());
		assertEquals("1-3", arrayListRecords.get(2).getPlace());
		assertEquals("4-6", arrayListRecords.get(3).getPlace());
		assertEquals("4-6", arrayListRecords.get(4).getPlace());
		assertEquals("4-6", arrayListRecords.get(5).getPlace());
		assertEquals("7", arrayListRecords.get(6).getPlace());
	}

	/**
	 * Test for the method {@link ResultsCalculator#calculateTrackScore(float, float, float, Float)}. Calculates
	 * the score of a 100 m run result of 12 seconds.
	 */
	@Test
	public void calculateTrackScore(){
		assertEquals(651, ResultsCalculator.calculateTrackScore(25.4347f, 18.00f, 1.81f, 12.0f));
	}

	/**
	 * Test for the method {@link ResultsCalculator#calculateJumpScore(float, float, float, Float)}. Calculates
	 * the score of a long jump of 8 meters.
	 */
	@Test
	public void calculateJumpScore(){
		assertEquals(1061, ResultsCalculator.calculateJumpScore(0.14354f, 220.00f, 1.4f, 800f));
	}

	/**
	 * Test for the method {@link ResultsCalculator#calculateThrowScore(float, float, float, Float)}. Calculates
	 * the score of a shot put result of 13 meters.
	 */
	@Test
	public void calculateThrowScore(){
		assertEquals(667, ResultsCalculator.calculateThrowScore(51.39f, 1.50f, 1.05f, 13f));
	}
}
