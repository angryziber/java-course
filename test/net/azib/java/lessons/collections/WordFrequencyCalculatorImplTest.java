package net.azib.java.lessons.collections;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * WordFrequencyCalculatorImplTest
 *
 * @author anton
 */
public class WordFrequencyCalculatorImplTest {
	private WordFrequencyCalculator calc = new WordFrequencyCalculatorImpl();
	
	@Test
	public void frequencyCalculationAndOrder() throws Exception {
		assertEquals("{hello=2, abc=3, xxx=1}", calc.calculateFrequenciesOf("hello hello abc abc abc xxx").toString());
	}

	@Test
	public void complexSymbols() throws Exception {
		assertEquals("{hello=2, abc=3, xxx=1}", calc.calculateFrequenciesOf("hello, hello! (abc) abc abc xxx.").toString());
	}

	@Test
	public void mixedCase() throws Exception {
		assertEquals("{hello=4}", calc.calculateFrequenciesOf("Hello HELLO Hello HeLlO").toString());
	}
}
