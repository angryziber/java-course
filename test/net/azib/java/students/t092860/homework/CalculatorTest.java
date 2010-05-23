package net.azib.java.students.t092860.homework;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

/**
 * CalculatorTest
 */
public class CalculatorTest {

	private static Logger logger = Logger.getLogger("global");
	
    @Before
    public void setUp() {
		logger.setLevel(Level.OFF);
    }
    
	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Calculator#calcResults(java.util.List)}.
	 * @throws Exception 
	 */
	@Test
	public final void testCalcResults() throws Exception {
		Calculator testObj = new Calculator();
		assertNotNull(testObj);
		
		List<Input.Data> in = new ArrayList<Input.Data>();
		Input.Data data = new Input.Data();
		data.setName("name");
		data.setDate(new Date()); 
		data.setCountry("EE");
		data.addEvent(Events.RACE_100M, 9.30);
		in.add(data);
		List<Output.Data> out = testObj.calcResults(in);
		
		assertTrue(out.get(0).getPosition().compareTo("1") == 0);
		assertTrue(out.get(0).getScore() == 1276);
		assertTrue(out.get(0).getName().compareTo(in.get(0).getName()) == 0);
		assertTrue(out.get(0).getDate().compareTo(in.get(0).getDate()) == 0);
		assertTrue(out.get(0).getCountry().compareTo(in.get(0).getCountry()) == 0);
		assertTrue(out.get(0).getEventResult(Events.RACE_100M) == in.get(0).getEventResult(Events.RACE_100M));		
	}

}
