package net.azib.java.students.t092860.homework;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

/**
 * CalculatorTest
 *
 * @author armin
 */
public class CalculatorTest {

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Calculator#calcResults(java.util.List)}.
	 */
	@Test
	public final void testCalcResults() {
		Calculator testObj = new Calculator();
		assertNotNull(testObj);
		
		List<Input.Data> in = new ArrayList<Input.Data>();
		Input.Data data = new Input.Data();
		data.setName("name");
		data.setDate(new Date()); 
		try {
			data.setCountry("EE");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
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
