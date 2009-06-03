package net.azib.java.students.t040750.homework.parser.xml;

import static org.junit.Assert.assertEquals;

import javax.xml.datatype.DatatypeFactory;

import org.junit.Test;

public class AthleteTypeTest {

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testProperties() throws Exception {
		AthleteType athleteType = new AthleteType();
		
		assertEquals(null, athleteType.getName());
		assertEquals(null, athleteType.getBirthday());
		assertEquals(null, athleteType.getNationality());
		
		athleteType.setName("Василий Пупкин");
		athleteType.setBirthday(DatatypeFactory.newInstance().newXMLGregorianCalendar("1980-10-21"));
		athleteType.setNationality("UA");
		
		assertEquals("Василий Пупкин", athleteType.getName());
		assertEquals("1980-10-21", athleteType.getBirthday().toString());
		assertEquals("UA", athleteType.getNationality());
	}
}
