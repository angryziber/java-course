package net.azib.java.students.t100228.Homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Unit test for the {@link Utils} class
 * @author Martin
 */
public class UtilsTest {
	/**
	 * Test for the method {@link Utils#minutesToSeconds(String)}
	 */
	@Test
	public void minutesToSeconds(){
		assertEquals(305.12, Utils.minutesToSeconds("5:05.12"), 0.01);
	}
}
