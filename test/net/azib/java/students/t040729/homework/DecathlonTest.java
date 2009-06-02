package net.azib.java.students.t040729.homework;

import static org.easymock.EasyMock.*;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * DecathlonTest
 * 
 * @author ValleTon
 */
public class DecathlonTest {

	/**
	 * Test method for {@link net.azib.java.students.t040729.homework.DecathlonCalc#processCompetitionData(java.util.List, net.azib.java.students.t040729.homework.CompetitionDataIn, net.azib.java.students.t040729.homework.CompetitionDataOut)}.
	 * @throws Exception 
	 */
	@Test
	public void testCompetitionDataProcessing() throws Exception {
		String[] arrayOfAnswers = {"Szőrös Szűk","03.04.1972","HU","50.99","1.00","1.00","1.00","1:50.00","59.00","1.00","1.00","1.00","7:59.99","y",
								  "World Record","21.12.1999","WR","9.69","8.95","23.12","2.45","43.18","12.87","74.08","6.14","98.48","3:26","y",
								  "Ones õäöüšž ÕÄÖÜŠŽ","01.10.2001","OO","1.11","1.11","11.11","1.11","11.11","11.11","11.11","1.11","11.11","1:11.11","x"};
		StringBuilder sb = new StringBuilder();
		for (String s : arrayOfAnswers){
			sb.append(s).append(System.getProperty("line.separator"));
		}

		byte[] bytes = sb.toString().getBytes();

		System.setIn(new ByteArrayInputStream(bytes));

		List<Athlete> athletes = new ArrayList<Athlete>();
		
		CompetitionDataIn cdi = new ConsoleDataReader();
		CompetitionDataOut mockDataOut = createMock(CompetitionDataOut.class);
		
		athletes = DecathlonCalc.processCompetitionData(athletes, cdi, mockDataOut);
		
		assertEquals("World Record",athletes.get(0).getName());
		assertEquals("Ones õäöüšž ÕÄÖÜŠŽ",athletes.get(1).getName());
		assertEquals("Szőrös Szűk",athletes.get(2).getName());

	}
}
