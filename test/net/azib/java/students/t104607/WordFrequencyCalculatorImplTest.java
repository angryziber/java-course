package net.azib.java.students.t104607;
// @author 104607 IASM

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class WordFrequencyCalculatorImplTest {
	@Test
	public void calculateFrequenciesOf() throws Exception {
		String longText = new String (
			"I am trying to see\n" +
			"I am trying to believe\n" +
			"this is not where I should be\n" +
			"I am trying to believe"
		);

		WordFrequencyCalculatorImpl textFreq = new WordFrequencyCalculatorImpl();
		Map<String,Integer> result = textFreq.calculateFrequenciesOf(longText);
		assertEquals(12,result.size());
	}
}
