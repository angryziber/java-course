package net.azib.java.students.t654321.hometasks;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * WordFrequencyCalculatorImplTest
 *
 * @author Karl
 */
public class WordFrequencyCalculatorImplTest {
	private WordFrequencyCalculatorImpl wfci = new WordFrequencyCalculatorImpl();
	private String testString = "kirjutasin testitavat programmi väga väga väga väga kaua";
	
	// Verifies that method calculateFrequenciesOf return null in case of empty string as parameter;
	@Test	
	public void calculateFrequenciesOfEmptyString(){
		assertEquals("Expected and actual results are not identical!", null, wfci.calculateFrequenciesOf(""));
	}
	
	// Verifies that method calculateFrequenciesOf returns sorted map of strings and frequencies;
	@Test	
	public void calculateFrequenciesOfString(){
		assertEquals("Expected and actual results are not identical!", "{kaua=1, kirjutasin=1, programmi=1, testitavat=1, väga=4}", wfci.calculateFrequenciesOf(testString).toString());
	}
}
