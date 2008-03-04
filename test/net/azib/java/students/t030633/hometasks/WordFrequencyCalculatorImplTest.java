package net.azib.java.students.t030633.hometasks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * WordFrequencyCalculatorImplTest
 * 
 * @author t030633
 */
public class WordFrequencyCalculatorImplTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.WordFrequencyCalculatorImpl#calculateFrequenciesOf(java.lang.String)}.
	 */
	@Test
	public void testCalculateFrequenciesOf() {

		WordFrequencyCalculatorImpl freqCalc = new WordFrequencyCalculatorImpl();
		String textIn = "Steve Ballmer Developers Developers Developers Developers Developers Developers Developers "
				+ "Developers Developers Developers Developers Developers Developers Developers Developers";
		String resultOut = "{Ballmer=1, Developers=15, Steve=1}";
		
		assertEquals(resultOut, freqCalc.calculateFrequenciesOf(textIn).toString());

	}

}
