package net.azib.java.students.t020632.homework;

import static org.junit.Assert.*; 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestFieldEventCalculator is a test class for 
 * FieldEventCalculator
 * 
 * Following world record results will be tested:
 * 
 * Event 			WR holder 			WR 		Points 
 * Long Jump 		Mike Powell 		8.95 	1312 
 * Shot Put			Randy Barnes 		23.12 	1295 
 * High Jump 		Javier Sotomayor	2.45 	1244 
 * Discus Throw		Jürgen Schult		74.08 	1383 
 * Pole Vault		Sergey Bubka 		6.15 	1281 
 * Javelin Throw	Jan Zelezny 		98.48 	1331 
 * 
 * 
 * Also results which give 1 point for each event will
 * be tested:
 * 
 * Event			Result		Points
 * Long Jump		2,25		1
 * Shot Put			1,53		1
 * High Jump		0,77		2
 * Discus Throw		4,10		1
 * Pole Vault		1,03		1
 * Javelin Throw	7,12		1
 * 
 *
 * @author Marek Soobik
 */
public class TestFieldEventCalculator {

	FieldEventCalculator calc;
	EventInfo longJump;
	EventInfo shotPut;
	EventInfo highJump;
	EventInfo discusThrow;
	EventInfo poleVault;
	EventInfo javelinThrow;
	
	
	@Before
	public void setUp() throws Exception {
		calc 		= FieldEventCalculator.getCalculator();
		longJump 	= EventInfo.LONG_JUMP;
		shotPut 	= EventInfo.SHOT_PUT;
		highJump 	= EventInfo.HIGH_JUMP;
		discusThrow = EventInfo.DISCUS_THROW;
		poleVault 	= EventInfo.POLE_VAULT;
		javelinThrow = EventInfo.JAVELIN_THROW;
	}
	
	
	@Test
	public void testLongJump() throws Exception {
		float result = 895F;
		
		assertEquals(calc.calculate(longJump, result), 1312);
		assertEquals(calc.calculate(longJump, 225F), 1);
	}
	
	
	@Test
	public void testShotPut() throws Exception {
		assertEquals(calc.calculate(shotPut, 23.12F), 1295);
		assertEquals(calc.calculate(shotPut, 1.53F), 1);
	}
	
	
	@Test
	public void testHighJump() throws Exception {
		assertEquals(calc.calculate(highJump, 245F), 1244);
		assertEquals(calc.calculate(highJump, 77F), 2);
	}
	
	
	@Test
	public void testDiscusThrow() throws Exception {
		assertEquals(calc.calculate(discusThrow, 74.08F), 1383);
		assertEquals(calc.calculate(discusThrow, 4.10F), 1);
	}
	
	
	@Test
	public void testPoleVault() throws Exception {
		assertEquals(calc.calculate(poleVault, 615F), 1281);
		assertEquals(calc.calculate(poleVault, 103F), 1);
	}
	
	
	@Test
	public void testJavelinThrow() throws Exception {
		assertEquals(calc.calculate(javelinThrow, 98.48F), 1331);
		assertEquals(calc.calculate(javelinThrow, 7.12F), 1);
	}
	
	
	@After
	public void tearDown() throws Exception {
		calc 		= null;
		longJump 	= null;
		shotPut 	= null;
		highJump 	= null;
		discusThrow = null;
		poleVault 	= null;
	}

}
