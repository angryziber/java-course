package net.azib.java.students.t040750.homework.parser.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecathlonDataTypeTest {

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testProperties() throws Exception {
		DecathlonDataType decathlonDataType = new DecathlonDataType();
		
		assertEquals(null, decathlonDataType.athlete);
		assertEquals(null, decathlonDataType.result);
		assertEquals(0, decathlonDataType.totalPoints);
		assertEquals(null, decathlonDataType.position);
		
		decathlonDataType.setTotalPoints(1234);
		decathlonDataType.setPosition("-");
		
		assertEquals(1234, decathlonDataType.getTotalPoints());
		assertEquals("-", decathlonDataType.getPosition());
	}
}
