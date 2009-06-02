package net.azib.java.students.t040729.homework;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.junit.Test;

/**
 * ConsoleDataReaderTest
 * 
 * @author ValleTon
 */
public class ConsoleDataReaderTest {

	@Test
	public void testConsoleInputHappyPath() throws Exception {
		String[] arrayOfAnswers = {"Szőrös Szűk","03.04.1972","HU","9.99","1.00","1.00","1.00","1.00","1.00","1.00","1.00","1.00","1:59.99","x"};
		StringBuilder sb = new StringBuilder();
		for (String s : arrayOfAnswers){
			sb.append(s).append(System.getProperty("line.separator"));
		}

		byte[] bytes = sb.toString().getBytes();

		System.setIn(new ByteArrayInputStream(bytes));

		CompetitionDataIn cdi = new ConsoleDataReader();
		List<Athlete> athletes = cdi.getCompetitionData();
		
		assertEquals(arrayOfAnswers[0],athletes.get(0).getName());
		assertEquals(arrayOfAnswers[1],athletes.get(0).getBirthDate());
		assertEquals(arrayOfAnswers[2],athletes.get(0).getCountryCode());
		
		for (Event evt : Event.values()){
			assertEquals(arrayOfAnswers[evt.ordinal()+3],athletes.get(0).getFormattedResult((byte) evt.ordinal()));
		}
	}
	
	@Test
	public void testIllegalConsoleInput(){
		String[] arrayOfAnswers = {"Szőrös Szűk","03.04.1972","United Counties of Arab","9.99","1.00","1.00","1.00","1.00","1.00","1.00","1.00","1.00","1:59.99","x"};
		StringBuilder sb = new StringBuilder();
		for (String s : arrayOfAnswers){
			sb.append(s).append(System.getProperty("line.separator"));
		}

		byte[] bytes = sb.toString().getBytes();

		System.setIn(new ByteArrayInputStream(bytes));

		CompetitionDataIn cdi = new ConsoleDataReader();
		try {
			cdi.getCompetitionData();
			fail("Test failed.");
		}
		catch (Exception e) {
		}
	}
}
