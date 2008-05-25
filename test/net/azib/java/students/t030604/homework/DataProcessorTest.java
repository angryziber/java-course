package net.azib.java.students.t030604.homework;

import net.azib.java.students.t030604.homework.AthleteScore;

import static net.azib.java.students.t030604.homework.DataProcessor.process;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Test class for testing DataProcessor
 * @author Aleksandr Ivanov
 * <a href="mailto:aleksandr.ivanov@tietoenator.com">contact</a>
 */
public class DataProcessorTest extends TestCase {
	
	private List<AthleteScore> getTestData() {
		List<AthleteScore> result = new LinkedList<AthleteScore>();
		//looser 
		AthleteScore score = new AthleteScore("looser",new Date(), "ee", 12.61F, 5F, 9.22F, 1.5F, 60F, 16.43F, 21.60F, 2.6F, 35F, 300F);
		//winner
		AthleteScore score1 = new AthleteScore("winner", new Date(), "ru", 13F, 6F, 10F, 2F, 59F, 19F, 18F, 20F, 30F,100F);
		result.add(score);
		result.add(score1);
		return result;
	}
	
	private List<AthleteScore> getEqualData() {
		List<AthleteScore> result = new LinkedList<AthleteScore>();
		AthleteScore score = new AthleteScore("test",new Date(), "ee", 10F, 10F, 10F, 10F, 60F,20F, 30F,30F,80F,900F);
		result.add(score);
		score.setName("test1");
		result.add(score);
		return result;
	}
	
	/**
	 * tests correctness of DataProcessor in case of empty or invalid input
	 */
	@Test
	public void testDataProcessorEmpty() {
		assertTrue(process(null) == null);
		assertTrue(process(new LinkedList<AthleteScore>()).size() == 0);
		
	}
	
	/**
	 * tests correctness of processing simple ranks
	 */
	@Test
	public void testDataProcessorRank() {
		List<AthleteScore> tested = process(getTestData());
		assertTrue(tested.get(0).getName().equals("winner"));
		assertTrue(tested.get(1).getName().equals("looser"));
	}
	
	/**
	 * tests correctness of processing shared ranks 
	 */
	@Test
	public void testDataProcessorEqual() {
		List<AthleteScore> tested = process(getEqualData());
		assertTrue(tested.get(0).getSharedRank() == 2);
		assertTrue(tested.get(1).getSharedRank() == 2);
	}
}
