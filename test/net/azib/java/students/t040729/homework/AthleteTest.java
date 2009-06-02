package net.azib.java.students.t040729.homework;

import static org.junit.Assert.*;
import static org.easymock.classextension.EasyMock.*;

import org.junit.Test;


/**
 * AthleteTest
 * 
 * @author ValleTon
 */
public class AthleteTest {
	
	private Athlete makeAthlete() throws Exception {
		
		/*
		Name nameMock = createMock(Name.class);
		BirthDate bdMock = createMock(BirthDate.class);
		Country cMock = createMock(Country.class);

		expect(nameMock.toString()).andReturn("Beata Kana");
		expect(bdMock.toString()).andReturn("17.01.1980");
		expect(cMock.getCountryCode()).andReturn("EE");
		replay(nameMock);
		replay(bdMock);
		replay(cMock);
		
		Athlete a = new Athlete(nameMock,bdMock,cMock);
		verify(nameMock);
		verify(bdMock);
		verify(cMock);
		//Can't mock! noClassDefFoundError
		*/

		Athlete a = new Athlete(new Name("Beata Kana"), new BirthDate("17.01.1980","dd.MM.yyyy"), new Country("EE"));
		return a;
	}
	
	private void insertAthletesResults(Athlete a, float[] results) throws Exception{
		for (byte i=0; i<results.length; i++){
			a.insertEventResult(i, results[i]);
		}
	}
	
	@Test
	public void testTotalCalculatedPoints() throws Exception {
		Athlete a = makeAthlete();
		float[] records = {9.69f,8.95f,23.12f,2.45f,43.18f,12.87f,74.08f,6.14f,98.48f,206f};
		insertAthletesResults(a, records);
		a.calculateTotalPoints();
		assertEquals(12516,a.getTotalPoints());
	}
	
	@Test
	public void testNegativeResult() throws Exception{
		Athlete a = makeAthlete();
		float[] results = {9.69f,8.95f,23.12f,2.45f,43.18f,12.87f,74.08f,6.14f,98.48f,-206f};
		try {
			insertAthletesResults(a, results);
			fail("Negative result insertion was allowed.");
		}
		catch (Exception e) {
		}
	}
	
	@Test
	public void testNewAthleteObjectCreation() throws Exception{
		Athlete a = makeAthlete();
		assertEquals("Beata Kana",a.getName());
		assertEquals("17.01.1980",a.getBirthDate());
		assertEquals("EE",a.getCountryCode());
	}
	
	@Test
	public void testResultCorrectFormatting() throws Exception{
		Athlete a = makeAthlete();
		float[] results = {10.99f,3.95f,23.12f,2.45f,61.99f,12.87f,74.08f,6.14f,98.48f,206f};
		String[] expected = { "10.99","3.95","23.12","2.45","1:01.99","12.87","74.08","6.14","98.48","3:26.00"};
		insertAthletesResults(a, results);
		for (int i = 0; i < expected.length; i++){
			assertEquals(expected[i], a.getFormattedResult((byte) i));
		}
	}
	
	@Test
	public void testSetAndGetPlace() throws Exception{
		Athlete a = makeAthlete();
		a.setPlace("2-4");
		assertEquals("2-4",a.getPlace());
	}
	
	@Test
	public void testAthletesCompare() throws Exception{
		Athlete a = makeAthlete();
		Athlete b = makeAthlete();
		float[] recordsA = {9.69f,8.95f,23.12f,2.45f,43.18f,12.87f,74.08f,6.14f,98.48f,206f};
		float[] recordsB = {9.70f,8.95f,23.12f,2.45f,43.18f,12.87f,74.08f,6.14f,98.48f,206f};
		insertAthletesResults(a, recordsA);
		insertAthletesResults(b, recordsB);
		a.calculateTotalPoints();
		b.calculateTotalPoints();
		assertTrue(a.compareTo(b)<0);
	}
}
