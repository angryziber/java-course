package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import net.azib.java.students.t001370.homework.DecathlonCalculator;
import net.azib.java.students.t001370.homework.Errors;

import org.junit.Test;

/**
 * DecathlonCalculatorTest
 *
 * @author maksim
 */
public class DecathlonCalculatorTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonCalculator#calculate()}.
	 */
	@Test
	public void testCalculate() {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		new DecathlonCalculator(null, null, new PrintStream(out)).calculate();
		
		assertEquals(out.toString(), Errors.ERROR_0028.getErrorText() + System.getProperties().getProperty("line.separator"));
	}

}
