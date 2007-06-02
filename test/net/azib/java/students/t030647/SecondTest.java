package net.azib.java.students.t030647;

import net.azib.java.students.t030647.homework.Second;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * SecondTest
 *
 * @author Igor
 */
public class SecondTest {
 
	int min = 2;
	int sec = 3;
	float msec = 15;
	@Test
	public void testSecond() throws Exception {
		
		Second a = new Second("2:3.15");
		assertEquals(min, a.getMinutes());
		assertEquals(sec, a.getSeconds());
		assertEquals(msec, a.getMilliseconds());
	}
}
