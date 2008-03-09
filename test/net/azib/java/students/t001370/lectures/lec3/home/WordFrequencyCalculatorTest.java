package net.azib.java.students.t001370.lectures.lec3.home;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * WordFrequencyCalculatorTest
 *
 * @author maksim
 */
public class WordFrequencyCalculatorTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec3.home.WordFrequencyCalculatorImp#calculateFrequenciesOf(java.lang.String)}.
	 */
	@Test
	public void testCalculateFrequenciesOf() {
		String str = "package net.azib.java.students.t001370.lectures.lec3.home";
		WordFrequencyCalculatorImp c = new WordFrequencyCalculatorImp();
		assertEquals("!!!WordFrequencyCalculatorImp.calculateFrequenciesOf!!!",
				9, c.calculateFrequenciesOf(str).size());
	}

}
