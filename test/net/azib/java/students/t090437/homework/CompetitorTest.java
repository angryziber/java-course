package net.azib.java.students.t090437.homework;

import net.azib.java.students.t090437.homework.BadDataFormatException;
import net.azib.java.students.t090437.homework.Competitor;
import net.azib.java.students.t090437.homework.DecimalResult;
import net.azib.java.students.t090437.homework.TimeResult;

import org.junit.*;


/**
 * CompetitorTest
 *
 * @author Ronald
 */
public class CompetitorTest {
	private Competitor olympics2000ErkiNool() throws BadDataFormatException {
		Competitor comp = new Competitor();
		int score = 0;
		
		comp.setSprint_100m_s(TimeResult.createObj("10.68"));
		comp.calcScore();
		score = comp.getScore();
		
		comp.setLong_jump_m(DecimalResult.createObj(7.76));
		comp.calcScore();
		score = comp.getScore();
		
		comp.setShot_put_m(DecimalResult.createObj(15.11));
		comp.calcScore();
		score = comp.getScore();
		
		comp.setHigh_jump_m(DecimalResult.createObj(2.00));
		comp.calcScore();
		score = comp.getScore();
		
		comp.setSprint_400m_m_s(TimeResult.createObj("0:46.71"));
		comp.calcScore();
		score = comp.getScore();
		
		comp.setHurdles_s(TimeResult.createObj("14.48"));
		comp.calcScore();
		score = comp.getScore();
		Assert.assertTrue(score == 5418);
		
		// Here the resulting score differs from wiki but wiki is wrong not me
		comp.setDiscus(DecimalResult.createObj(43.66));
		comp.calcScore();
		score = comp.getScore();
		
		comp.setPole_vault(DecimalResult.createObj(5.00));
		comp.calcScore();
		score = comp.getScore();
		
		comp.setJavelin_throw(DecimalResult.createObj(65.82));
		comp.calcScore();
		score = comp.getScore();
		
		comp.setRace_1500m_m_s(TimeResult.createObj("4:29.48"));
		comp.calcScore();
		score = comp.getScore();
		
		return comp;
	}
	
	/**
	 * Tests if the Competitor.calcScore() method calculates decathlon 
	 * scores correctly. Scores and comparison values are from 
	 * http://et.wikipedia.org/wiki/Erki_Nool#Ateena_2004
	 * @throws BadDataFormatException
	 */
	@Test
	public void testIfCompetitionScoreIsCalculatedCorrectly() throws BadDataFormatException {
		Competitor erkiNool = olympics2000ErkiNool();
		Assert.assertTrue(erkiNool.getScore() == 8641);
	}

	public void testIfCompetitorCompareByScoreWorks() throws BadDataFormatException {
		Competitor comp1 = olympics2000ErkiNool(), comp2 = olympics2000ErkiNool();
		
		Assert.assertTrue(comp1.compareTo(comp2) == 0);
		
		comp1.setSprint_100m_s(TimeResult.createObj("10.60"));
		comp1.calcScore();
		
		Assert.assertTrue(comp1.compareTo(comp2) < 0);
	}
}
