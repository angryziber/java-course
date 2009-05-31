package net.azib.java.students.t090437.homework.test;

import net.azib.java.students.t090437.homework.BadDataFormatException;
import net.azib.java.students.t090437.homework.MyDouble;

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
		Assert.assertEquals(MyDouble.parseDouble("1.00").getValue(), 1.00, 0.001);
		Assert.assertEquals(MyDouble.parseDouble("1").getValue(), 1.00, 0.001);
		Assert.assertEquals(MyDouble.parseDouble("1").getValue(), 1.00, 0.001);
	}

	@Test
	public void testIfDetectsIncorrectInputs() {
		boolean errorDetected = false;
		
		try {
			MyDouble.parseDouble("1,00");
		}
		catch (BadDataFormatException e) {
			errorDetected = true;
		}
		Assert.assertTrue(errorDetected);
		
		errorDetected = false;
		try {
			MyDouble.parseDouble("");
		}
		catch (BadDataFormatException e) {
			errorDetected = true;
		}
		Assert.assertTrue(errorDetected);
	}

	@Test
	public void testIfPrintsStringsCorrectly() throws BadDataFormatException {
		Assert.assertEquals(MyDouble.createObj(1).toString(), "1.00");
		Assert.assertEquals(MyDouble.createObj(0).toString(), "0.00");
	}
}
