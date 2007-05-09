package net.azib.java.students.t020632.homework;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals; 


/**
 * TestRunningEventCalculator is a test class for 
 * RunningEventCalculator.
 * 
 * Following world record results will be tested: 
 * 
 * Event	WR holder			WR		Points 
 * 100m 	Asafa Powell 		9,77 	1154 
 * 400m 	Michael Johnson		43,18 	1156 
 * 110mh 	Colin Jackson 		12,91 	1120 
 * 1500m 	Hicham El Guerrouj	3.26,00 1218 
 *
 * Also results which give 1 point for each event will
 * be tested:
 *
 * Event	Result	Score
 * 100m		17,83	1 
 * 400m		81,21	1
 * 110mh	28,09	1
 * 1500m	474,11	1
 *
 *
 * @author Marek Soobik
 */
public class TestRunningEventCalculator {
	
	RunningEventCalculator calc;
	EventInfo run100m;
	EventInfo run400m;
	EventInfo run110m;
	EventInfo run1500m;
	
	@Before
	public void setUp() throws Exception {
		calc 		= RunningEventCalculator.getCalculator();
		run100m 	= EventInfo.RUN_100M;
		run400m 	= EventInfo.RUN_400M;
		run110m 	= EventInfo.RUN_110M_HURDLES;
		run1500m 	= EventInfo.RUN_1500M;
		
	}
	
	
	@Test
	public void test100m() throws Exception {
		float result = 9.77F;
		
		assertEquals(calc.calculate(run100m, result), 1154);
		assertEquals(calc.calculate(run100m, 17.83F), 1);
		
	}
	
	
	@Test
	public void test400m() throws Exception {
		float result = 43.18F;
		
		assertEquals(calc.calculate(run400m, result), 1156);
		assertEquals(calc.calculate(run400m, 81.21F), 1);
	}
	
	@Test
	public void test110m() throws Exception {
		float result = 12.91F;
		
		assertEquals(calc.calculate(run110m, result), 1120);
		assertEquals(calc.calculate(run110m, 28.09F), 1);
		
	}
	
	@Test
	public void test1500m() throws Exception {
		float result = 206.0F;
		
		assertEquals(calc.calculate(run1500m, result), 1218);
		assertEquals(calc.calculate(run1500m, 474.11F), 1);
	}
	

	@After
	public void tearDown() throws Exception {
		calc 		= null;
		run100m 	= null;
		run400m 	= null;
		run110m 	= null;
		run1500m 	= null;
	}

}
