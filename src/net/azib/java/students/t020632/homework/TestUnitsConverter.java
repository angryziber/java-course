package net.azib.java.students.t020632.homework;

import static org.junit.Assert.*; 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestUnitsConverter
 * 
 * 12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72
 * 
 * @author Marek
 */
public class TestUnitsConverter {
	
	private UnitsConverter converter;
	private String [] results;
	private float [] fResults;

	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		results = new String [] {"12.61","5.00","9.22","1.50","59.39","16.43","21.60","2.60","35.81","5:25.72"};
		fResults = new float [] {12.61F, 5.00F, 9.22F, 1.50F, 59.39F, 16.43F, 21.60F, 2.60F, 35.81F, 325.72F};
		converter = UnitsConverter.getUnitsConverter();
	
	}
	
	@Test
	public void testname() throws Exception {
		int i = 0;
		EventInfo [] ei = EventInfo.values();
		
		for(EventInfo e : EventInfo.values()){
			System.out.println(e.name()+ " " + e.getType());
		}
		
		for(i = 0; i < ei.length; i++){
			assertEquals(converter.convert(ei[i], results[i]), fResults[i]);
		}
		
		EventInfo info = EventInfo.RUN_1500M;
		assertEquals(converter.convert(info, "12:00.65"), 720.65F);
		
	}
	

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

}
