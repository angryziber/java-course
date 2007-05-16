package net.azib.java.students.t020632.homework;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestCSVInput
 *
 * @author t020632
 */
public class TestCSVInput {
	
	List<AthleteResults> list = new ArrayList<AthleteResults>();
	CSVInput input;
	CSVOutput output;
	
	@Before
	public void setUp() throws Exception {
		input = new CSVInput("C:/Documents and Settings/Marek/Desktop/res.txt");
	}
	
	
	@Test
	public void testname() throws Exception {
		int i = 0;
		
		list = input.read();
		
		while(i < list.size()){
			list.get(i).calculateScore();
			i++;
		}
		
		output = new CSVOutput();
		output.write(list);
	}

	@After
	public void tearDown() throws Exception {
		input = null;
	}

}
