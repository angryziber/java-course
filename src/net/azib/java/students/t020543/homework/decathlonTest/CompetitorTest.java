package decathlonTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


/**
 * Test for {@link Competitor} class
 * @author to20543
 */

public class CompetitorTest {
	
	private ICompetitor competitor1, competitor2; 
	private IAthlete man;
	
	/**
	 * Sets up needed data
	 */
	@Before
	public void setUp(){
		man = new Athlete();
		competitor1 = new Competitor(man);
		competitor1.setPlace(1);
		competitor2 = new Competitor(1,man);
	}
	
	/**
	 * Checks equality of received and expected data
	 */
	@Test
	public void testCompetition(){
		try{
			assertEquals(competitor1.getMan(), competitor2.getMan()); 
			assertTrue(competitor1.getPlace() == competitor2.getPlace()); 
			assertEquals(competitor1.asString(), competitor2.asString());
			System.out.println("TEST: Competitor class methods => OK");
		}
		catch(AssertionError e){
			System.out.println("ERROR! Competitor class methods test FAILED!");
		}
	}
	
}
