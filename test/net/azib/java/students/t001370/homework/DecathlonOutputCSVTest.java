package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

/**
 * DecathlonOutputCSVTest
 *
 * @author maksim
 */
public class DecathlonOutputCSVTest {

 	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonOutputCSV#compileCSVLine(int, net.azib.java.students.t001370.homework.Athlete)}.
	 * @throws ParseException 
	 */
	@Test
	public void testCompileCSVLine() throws ParseException {
		
		
		Athlete a = new Athlete();
		a.setName("Siim Susi");
		//a.setBirthday(DateFormat.getDateInstance(DateFormat.SHORT).parse("1.01.1976"));
		a.setBirthday(new SimpleDateFormat("dd.MM.yyyy").parse("1.01.1976"));
		a.setCountryCode("EE");
		a.competitionResults.setResult100mRace((float)12.61);
		a.competitionResults.setResult110mHurdles((float)16.43);
		a.competitionResults.setResult1500mRace((float)325.72);
		a.competitionResults.setResult400mSprint((float)59.39);
		a.competitionResults.setResultDiscusThrow((float)21.60);
		a.competitionResults.setResultHighJump((float)1.50);
		a.competitionResults.setResultJavelinThrow((float)35.81);
		a.competitionResults.setResultLongJump((float)5.00);
		a.competitionResults.setResultPoleVault((float)2.60);
		a.competitionResults.setResultShotPut((float)9.22);
		
		DecathlonOutputCSV doc = new DecathlonOutputCSV();
		
		 // works on my pc . in cruise date formating does not work the same way	
		assertEquals("1,4234,\"Siim Susi\",01.01.1976,EE,12.61,5.0,9.22,1.5,59.39,16.43,21.6,2.6,35.81,325.72", doc.compileCSVLine(1, a));

	}

}
