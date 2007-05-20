package net.azib.java.students.t020632.homework;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestCSVInput is a test class for CSVInput class
 *
 * @author t020632
 */
public class TestCSVInput {
	
	List<AthleteResults> list = new ArrayList<AthleteResults>();
	CSVInput input;
	CSVOutput output;
	String path = "C:/Documents and Settings/Marek/Desktop/res.csv";
	
	@Before
	public void setUp() throws Exception {
		input = new CSVInput(path);
	}
	
	
	/**
	 * Tests whether the correct information is read
	 * from file
	 * 
	 * @throws Exception
	 */
	@Test
	public void testname() throws Exception {
		int i = 0;
		
		if(input == null)
			return;
		
		list = input.read();
		
		assertEquals(list.get(0).getName(), "Bruno Lambese");
		
		while(i < list.size()){
			list.get(i).calculateScore();
			i++;
		}
		
		output = new CSVOutput("out.txt");
		
		if(output != null)
			output.write(list);
	}

	@After
	public void tearDown() throws Exception {
		input = null;
	}

}
