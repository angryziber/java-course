package net.azib.java.students.t090437.homework;

import net.azib.java.students.t090437.homework.BadDataFormatException;
import net.azib.java.students.t090437.homework.DecimalResult;

import org.junit.Assert;
import org.junit.Test;


/**
 * MyDoubleTest
 *
 * @author Ronald
 */
public class MyDoubleTest {
	@Test
	public void testIfParsesFromStringCorrectly() throws BadDataFormatException {
		Assert.assertEquals(DecimalResult.parseDouble("1.00").getValue(), 1.00, 0.001);
		Assert.assertEquals(DecimalResult.parseDouble("1").getValue(), 1.00, 0.001);
		Assert.assertEquals(DecimalResult.parseDouble("1").getValue(), 1.00, 0.001);
	}

	@Test
	public void testIfDetectsIncorrectInputs() {
		boolean errorDetected = false;
		
		try {
			DecimalResult.parseDouble("1,00");
		}
		catch (BadDataFormatException e) {
			errorDetected = true;
		}
		Assert.assertTrue(errorDetected);
		
		errorDetected = false;
		try {
			DecimalResult.parseDouble("");
		}
		catch (BadDataFormatException e) {
			errorDetected = true;
		}
		Assert.assertTrue(errorDetected);
	}

	@Test
	public void testIfPrintsStringsCorrectly() throws BadDataFormatException {
		Assert.assertEquals(DecimalResult.createObj(1).toString(), "1.00");
		Assert.assertEquals(DecimalResult.createObj(0).toString(), "0.00");
	}
}
