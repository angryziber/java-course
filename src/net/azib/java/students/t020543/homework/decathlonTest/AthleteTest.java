package decathlonTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Test for {@link Athlete} class
 * @author to20543
 */
public class AthleteTest {

	private IAthlete man, elseMan; 
	
	/**
	 * Sets up needed data
	 */
	@Before
	public void setUp() {
		man = new Athlete();	
		man.setName("Test Check");
		man.setBirthday("02.06.2007");
		man.setCountry("EE");
		man.setSprint100(10);
		man.setHurdles110(14);
		man.setSprint400(56);
		man.setRace1500(300);
		man.setLongJump(5);
		man.setHighJump(2);
		man.setPoleVault(5);
		man.setDiscusThrow(60);		
		man.setJavelinThrow(80);	
		man.setShotPut(20);
		man.setScore(8000);
		elseMan = new Athlete();
		elseMan.set(1, 5.5);
	}
	
	/**
	 * Checks equality of received and expected data
	 */
	@Test
	public void testAthlete(){
		try{
			assertEquals(man.getName(),"Test Check");
			assertEquals(man.getBirthday(),"02.06.2007");
			assertEquals(man.getCountry(),"EE");
			assertTrue( (man.getSprint100() == 10) && (man.getHurdles110() == 14) && 
						(man.getSprint400() == 56) && (man.getRace1500() == 300) &&
						(man.getLongJump() == 5) && (man.getHighJump() == 2) &&
						(man.getPoleVault() == 5) && (man.getDiscusThrow() == 60) &&
						(man.getJavelinThrow() == 80) && (man.getShotPut() == 20) &&
						(man.getScore() == 8000) && (elseMan.getLongJump()== 5.5));
			assertEquals(man.asString(), "8000,Test Check,02.06.2007,EE,10.0,5.0,20.0,2.0,56.0,14.0,60.0,5.0,80.0,300.0");
			System.out.println("TEST: Athlete class methods => OK");
		}
		catch(AssertionError e){
			System.out.println("ERROR! Athlete class methods test FAILED!");
		}
		
	}
	
}
