package net.azib.java.students.t020632.homework;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestDatabaseInput is a test class for DatabaseInput
 *
 * @author Marek Soobik t020632
 */
public class TestDatabaseInput {

	DatabaseInput input;
	
	@Before
	public void setUp() throws Exception {
		input = new DatabaseInput(1, "jdbc:mysql://srv.azib.net:3306/decathlon");
	}
	
	@Test
	public void testname() throws Exception {
		List<AthleteResults> results;
		
		results = input.read();
		
		if(results == null)
			return;
		
		assertEquals(results.get(0).getName(), "Siim Susi");
		assertEquals(results.get(0).getEvent(0).getResult(), "14.15");
		assertEquals(results.get(1).getName(), "Erki Nool");
	}

	
	@After
	public void tearDown() throws Exception {
		input = null;
	}

}
