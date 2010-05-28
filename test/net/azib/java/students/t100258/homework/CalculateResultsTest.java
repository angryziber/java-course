package net.azib.java.students.t100258.homework;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

/**
 * CalculateResultsTest
 *
 * @author mihkel
 */
public class CalculateResultsTest {

	/**
	 * Test method for {@link net.azib.java.students.t100258.homework.CalculateResults#CalculateResults(java.util.ArrayList)}.
	 */
	@Test
	public void testCalculateResults() {
		
		ArrayList <Object> results = new ArrayList <Object>();
		Result result= new Result("Nimi" ,"0000-00-00" ,"EE" ,14.15f ,3.98f ,10.0f ,1.45f ,"70.12" ,18.65f ,29.15f ,2.15f ,32.67f ,"466.6", 0, 0);
		results.add(result);
		result=new Result("Nimi2" ,"0000-00-01" ,"EN" ,14.15f ,3.98f ,10.0f ,1.45f ,"70.12" ,18.65f ,29.10f ,2.15f ,32.71f ,"466.6", 0, 0);
		CalculateResults calculateResultsObject = new CalculateResults();
		results.add(result);
		results=calculateResultsObject.getCalculatedResults(results);
	assertEquals("Calculated result wrong!", 2165,((Result)results.get(0)).sum);
	assertEquals("Calculated result wrong!", 2165,((Result)results.get(1)).sum);
	assertEquals("Place wrong!", 1,((Result)results.get(0)).place);
	assertEquals("Place wrong!", 1,((Result)results.get(1)).place);
	
		
	}

}



