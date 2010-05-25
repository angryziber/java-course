package net.azib.java.students.t093052.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * MeasureTest
 *
 * @author Kostja
 */
public class MeasureTest {

	@Test
	public void testMeasures() throws Exception {
		double value = 1;
		assertEquals(60, Measure.SECONDS.convert(value), 0.1);
		assertEquals(100, Measure.CENTIMETRES.convert(value), 0.1);
		assertEquals(1, Measure.METRES.convert(value), 0.1);
	}
	
}
