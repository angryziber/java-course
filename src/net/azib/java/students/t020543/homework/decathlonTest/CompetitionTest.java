package decathlonTest;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link Competition} class
 * @author to20543
 */
public class CompetitionTest {

	private ICompetition competition; 
	
	/**
	 * Sets up needed data
	 */
	@Before
	public void setUp(){
		competition = new Competition(0,"EE", "02-06-2007", "Test");
	}
	
	/**
	 * Checks equality of received and expected data
	 */
	@Test
	public void testCompetition(){
		try{
			assertEquals(competition.asString(), "(0) \"Test\" 02-06-2007 EE");
			System.out.println("TEST: Competition class methods => OK");
		}
		catch(AssertionError e){
			System.out.println("ERROR! Competition class methods test FAILED!");
		}
	}

}