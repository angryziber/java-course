package net.azib.java.students.t030630.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * MinSecHolderTest
 * 
 * @author Sergei
 */
public class MinSecHolderTest {

	@Test
	public void testMinSecConverterToSec() throws Exception {

		assertEquals(1, new MinSecHolder("1:04.56").getMin());
		assertEquals(4.56f, new MinSecHolder("1:04.56").getSec());
		assertEquals(64.56f, new MinSecHolder("1:04.56").getInsec());

		assertEquals(0, new MinSecHolder("0:08.11").getMin());
		assertEquals(8.11f, new MinSecHolder("0:08.11").getSec());
		assertEquals(8.11f, new MinSecHolder("0:08.11").getInsec());

		assertEquals(0, new MinSecHolder("09.99").getMin());
		assertEquals(9.99f, new MinSecHolder("09.99").getSec());
		assertEquals(9.99f, new MinSecHolder("09.99").getInsec());
	}
}
