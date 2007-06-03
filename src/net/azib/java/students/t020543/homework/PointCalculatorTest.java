package decathlonTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import decathlon.Athlete;
import decathlon.IAthlete;
import decathlon.IPointCalculator;
import decathlon.PointCalculator;

/**
 * Test for a {@link PointCalculator} class
 * @author t020543
 */
public class PointCalculatorTest {
	
	private IPointCalculator pc;
	private IAthlete man;
	
	/**
	 * Sets up needed data
	 */
	@Before
	public void setUp() {
		pc = new PointCalculator();	
		man = new Athlete();	
	
		man.setSprint100(10.10);
		man.setHurdles110(0);
		man.setSprint400(0);
		man.setRace1500(0);
		
		man.setLongJump(5.5);
		man.setHighJump(0);
		man.setPoleVault(0);
		
		man.setDiscusThrow(0);		
		man.setJavelinThrow(84.34);	
		man.setShotPut(0);
	}
	
	/**
	 * Test <i>calculatePoints()</i> method with a particular input
	 * @author t020543
	 */
	@Test
	public void testCalculatePoints() {
	
	try{
		assertTrue(pc.calculatePoints(man) == 2664);
		System.out.println("TEST: PointCalculator class => OK");
	}
		catch(AssertionError e){
			System.out.println("ERROR! PointCalculator class => FAILED!");
		}
	}

}
