package net.azib.java.students.t072073.tasks;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * WordFrequencyCalculatorImplTest
 *
 * @author janika
 */
public class WordFrequencyCalculatorImplTest {
	@Test
	public void testFrequencyCalculator() throws Exception {
		WordFrequencyCalculatorImp wordFrequencies = new WordFrequencyCalculatorImp();
		assertEquals("{a=2, chuck=2, could=1, how=1, if=4, much=1, wood=2, woodchuck=2, would=1}",
				wordFrequencies.calculateFrequenciesOf("how much wood would a woodchuck chuck if a woodchuck could chuck wood if if if").toString());
	}
}
