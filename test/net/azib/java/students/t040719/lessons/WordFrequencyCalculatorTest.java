package net.azib.java.students.t040719.lessons;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

/**
 * WordFrequencyCalculatorTest
 *
 * @author Administrator
 */
public class WordFrequencyCalculatorTest {

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.WordFrequencyCalculator#calculateFrequenciesOf(java.lang.String)}.
	 */
	@Test
	public void testCalculateFrequenciesOf() {
		Map<String,Integer> map = WordFrequencyCalculator.calculateFrequenciesOf("test case for WFC test test case for WFC test test");
		String s = "{WFC=2, case=2, for=2, test=5}";
		assertEquals(s, map.toString());
	}

}
