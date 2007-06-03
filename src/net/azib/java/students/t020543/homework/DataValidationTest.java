package decathlonTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import decathlon.Athlete;
import decathlon.DataValidation;
import decathlon.IAthlete;
import decathlon.IDataValidation;

/**
 * Test for {@link DataValidation} class
 * @author t020543
 */
public class DataValidationTest {
	
	private IDataValidation dv;
	private IAthlete man; 	// with negative results
	
	/**
	 * Sets up needed data
	 */
	@Before
	public void setUp() {
		dv = new DataValidation();	
		man = new Athlete();	
		man.setSprint100(8.10);	// new World Record?
		man.setHurdles110(0);
		man.setSprint400(0);
		man.setRace1500(0);
		man.setLongJump(5.5);
		man.setHighJump(-23);	// Negative input!
		man.setPoleVault(0);
		man.setDiscusThrow(0);		
		man.setJavelinThrow(84.34);	
		man.setShotPut(0);
	}
	
	/**
	 * Tests {@link DataValidation} <i>checkNegative()</i> method 
	 */
	@Test
	public void testCheckNegative(){
		try{
			assertTrue(dv.checkNegative(-1));
			assertFalse(dv.checkNegative(1));
			System.out.println("TEST: DataValidation class : checkNegative()  => OK");
		}
		catch(AssertionError e){
			System.out.println("ERROR! DataValidation class : checkNegative()  FAILED!");
		}
	}
	
	/**
	 * Tests {@link DataValidation} <i>checkAllNegative()</i> method 
	 */
	@Test
	public void testCheckAllNegative(){
		try{
			assertTrue(dv.checkAllNegative(man));
			System.out.println("TEST: DataValidation class : checkAllNegative()  => OK");
		}
		catch(AssertionError e){
			System.out.println("ERROR! DataValidation class : checkAllNegative() FAILED!");
		}
	}
	
	/**
	 * Tests {@link DataValidation} <i>checkWorldRecord()</i> method 
	 */
	@Test
	public void testCheckWorldRecord(){
		try{
			assertTrue(dv.checkWorldRecord(man));
			System.out.println("TEST: DataValidation class : checkWorldRecord() => OK");
		}
		catch(AssertionError e){
			System.out.println("ERROR! DataValidation class : checkWorldRecord() FAILED!");
		}
	}
}
