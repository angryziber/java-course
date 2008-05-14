package net.azib.java.students.t980814.homework;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * DecaCalcExceptionTest
 *
 * @author dell
 */
public class DecaCalcExceptionTest {

	@Test
	public void testExceptionThrow() {
		final String testStr = "test exception";
		boolean exceptionWasCaught = false;
		try {
			throw new DecaCalcException(testStr);
		}
		catch (DecaCalcException e) {
			assertEquals(testStr, e.getMessage());
			exceptionWasCaught = true;
		}
		assertEquals("The exception was not caught", true, exceptionWasCaught);
	}

}
