package net.azib.java.students.t030630.homework.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import net.azib.java.students.t030630.homework.Athlete;

import org.junit.Test;

/**
 * AthleteTest
 * 
 * @author Sergei
 */
public class AthleteTest {

	@Test
	public void testCalculationOfPoints() throws Exception {
		assertEquals(3199, new Athlete(
				"\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76 ").getPoints());
	}

	@Test
	public void testDataFormatCorrectness() throws Exception {
		// data correct
		assertTrue(new Athlete("\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76 ")
				.isDataCorrect());
		// some data is missed(birthday)
		assertFalse(new Athlete("\"Beata Kana\",ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76 ").isDataCorrect());
		// incorrect format of birthday
		assertFalse(new Athlete("\"Beata Kana\",29021982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76 ")
				.isDataCorrect());
		// incorrect format of country
		assertFalse(new Athlete("\"Beata Kana\",29.02.1982,EEE,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76 ")
				.isDataCorrect());
		// incorrect format of competition results
		assertFalse(new Athlete("\"Beata Kana\",29.02.1982,ZA, infinity ,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76 ")
				.isDataCorrect());
	}

	@Test
	public void testAthleteInformation() throws Exception {
		// results for 1500m Race and 400m Sprint are converted to seconds
		assertEquals(
				"not defined,3199,Beata Kana,29.02.1982,South Africa,13.04,4.53,7.79,1.55,64.72,18.74,24.2,2.4,28.2,410.76",
				new Athlete("\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76 ")
						.getAthletePersonalInfoAndResults());

	}
}
